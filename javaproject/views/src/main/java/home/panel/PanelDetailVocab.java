package home.panel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.BookmarkDAO;
import dao.UserDAO;
import dao.impl.BookmarkDAOImpl;
import dao.impl.CategoryDAOImpl;
import dao.impl.MeaningDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.Bookmark;
import entity.Category;
import entity.Example;
import entity.Meaning;
import entity.RelativeWord;
import entity.Vocabulary;
import helper.IconImage;
import helper.ImageUtils;
import helper.StringUtils;
import jaco.mp3.player.MP3Player;
import service.Authorization;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

public class PanelDetailVocab extends JPanel {

	private JPanel contentPane;

	private JLabel lblRelatives;
	private JLabel lblImage;
	private JLabel lblPronunciation;
	private JToggleButton tglbtnNewToggleButton;
	private JLabel lblWord;
	private JLabel lblWordType;
	private JTextArea textArea;
	private JLabel lblCategory;
	private BookmarkDAO bmDAO;
	private UserDAO userDAO;

	private JPanel panel;

	private JScrollPane scroll;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;

	public PanelDetailVocab(Vocabulary vocab) {
		
		bmDAO = new BookmarkDAOImpl();
		userDAO = new UserDAOImpl();
		initComponent(vocab);
		lblWord.setText(StringUtils.toCapitalize(vocab.getWord()));
		lblWordType.setText(new WordTypeDAOImpl().get(vocab.getWordTypeId()));
		
	
		
		
		Category cate = new CategoryDAOImpl().select(vocab.getCategoryId());
		if (cate != null) {
			lblCategory.setText("Thể loại: " + cate.getName());
		}

		bookmarkFeature(vocab);
		loadData(vocab);
	}

	private void loadData(Vocabulary vocab) {
		List<Meaning> meanings = new VocabularyDAOImpl().selectAllMeaningByVocabId(vocab.getId());
		StringBuffer txt = new StringBuffer();
		for (Meaning mn : meanings) {
			txt.append(mn.getContent() + "\n    ");
			if (!mn.getContent().isEmpty()) {
				List<Example> examples = new MeaningDAOImpl().selectAllExampleByMeaningId(mn.getId());
				for (Example ex : examples) {
					if (!ex.getContent().isEmpty()) {
						txt.append(ex.getContent() + "\n    ");
						txt.append("=>" + ex.getMeaning());
					}
				}
				txt.append("\n");
			}
		}

		String relativesStr = "";
		List<RelativeWord> relatives = new VocabularyDAOImpl().selectAllRelativesByVocabId(vocab.getId());
		relativesStr = relatives.stream().map(rel -> rel.getWord().toString()).collect(Collectors.joining("\n    "));
		if (!relativesStr.equals("")) {
			txt.append("\nCác từ liên quan\n    ");
			txt.append(relativesStr);
			txt.append("\n\n\n");
		}
		textArea.setText(txt.toString());
	}

	private void bookmarkFeature(Vocabulary vocab) {
		IconImage icon = new IconImage();
		// set Icon
		try {
			if (new BookmarkDAOImpl().checkExistBookmarkInDb(userDAO.selectIdByUserEmail(Authorization.email),
					vocab.getId()) == null) {
				tglbtnNewToggleButton.setIcon((new ImageIcon(icon.getStarAltImg())));
			} else {
				tglbtnNewToggleButton.setIcon(new ImageIcon(icon.getStarImg()));
			}

		} catch (Exception e2) {
		}

		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JToggleButton) e.getSource()).isSelected() == true) {
					if (Authorization.email != null) {
						if (bmDAO.checkExistBookmark(
								userDAO.selectIdByUserEmail(Authorization.email), vocab.getId()) == null) {
							bmDAO.insert(new Bookmark(vocab.getId(),userDAO.selectIdByUserEmail(Authorization.email)));
						}
						tglbtnNewToggleButton.setIcon(new ImageIcon(icon.getStarImg()));
					}
				} else if (((JToggleButton) e.getSource()).isSelected() == false) {
					if (Authorization.email != null) {
						List<Bookmark> x = bmDAO.checkExistBookmark(
								userDAO.selectIdByUserEmail(Authorization.email), vocab.getId());
						if (x != null) {
							x.forEach(y -> bmDAO.delete(y));
						}
						tglbtnNewToggleButton.setIcon((new ImageIcon(icon.getStarAltImg())));

					}
				}

			}
		});
	}

	private void initComponent(Vocabulary vocab) {
		setBounds(0, 0, 892, 609);
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		

		lblWord = new JLabel("x");
		lblWord.setFont(new Font("Arial", Font.BOLD, 25));
		lblWord.setBackground(new Color(255, 255, 255));
		lblWord.setBounds(93, 5, 129, 30);
		add(lblWord);
		
		lblWordType = new JLabel();
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 16));
		lblWordType.setBounds(227, 10, 76, 19);
		add(lblWordType);
		
		lblRelatives = new JLabel("");
		lblRelatives.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRelatives.setBounds(308, 20, 0, 0);
		add(lblRelatives);
		
		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon());
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblImage.setBounds(313, 20, 0, 0);
		 add(lblImage);
		final int ROW_HEIGHT = 180;
		lblImage.setIcon(ImageUtils.getImageByURL("vocabulary", vocab.getImage(), ROW_HEIGHT));
		
		lblPronunciation = new JLabel("");
		lblPronunciation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (vocab.getPronunciation() != null) {
					try {
						String url = System.getProperty("user.dir") + "/src/main/resources/pronunciation/"
								+ vocab.getPronunciation();
						MP3Player mp3 = new MP3Player(new File(url));
						mp3.play();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy file phát âm");
					}
				}
			}
		});
		lblPronunciation.setIcon(new ImageIcon(
				PanelDetailVocab.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		lblPronunciation.setBounds(318, 12, 16, 16);
		 add(lblPronunciation);
			
		tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setBorderPainted(false);
		tglbtnNewToggleButton.setContentAreaFilled(false);
		tglbtnNewToggleButton.setBorder(null);
		tglbtnNewToggleButton.setBounds(355, 10, 48, 25);
		add(tglbtnNewToggleButton);

		 
		 
		lblCategory = new JLabel();
		lblCategory.setText((String) null);
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategory.setBounds(345, 20, 0, 0);
		 add(lblCategory);

		 panel = new JPanel();
		panel.setBounds(100, 100, 767, 391);
		 add(panel);
		 panel.setLayout(new GridLayout(1, 0, 0, 0));

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setDisabledTextColor(new Color(0, 0, 0));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setEditable(false);

		 scroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 scroll.setViewportView(textArea);
		panel.add(scroll);
	}
	public static void main(String[] args) {
		
	}
}
