package home.panel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import admin.item.ItemVocab;
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
import helper.FrameUtils;
import helper.IconImage;
import helper.ImageUtils;
import helper.StringUtils;
import jaco.mp3.player.MP3Player;
import service.Authorization;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

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

		lblWord = new JLabel();
		lblWord.setFont(new Font("Arial", Font.BOLD, 25));
		lblWord.setBackground(new Color(255, 255, 255));
		lblWord.setBounds(35, 25, 236, 66);
		contentPane.add(lblWord);

		lblWordType = new JLabel();
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 16));
		lblWordType.setBounds(35, 97, 87, 27);
		contentPane.add(lblWordType);

		lblRelatives = new JLabel("");
		lblRelatives.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRelatives.setBounds(35, 135, 344, 27);
		contentPane.add(lblRelatives);

		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon());
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblImage.setBounds(526, 25, 273, 180);
		contentPane.add(lblImage);
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
		lblPronunciation.setBounds(202, 97, 31, 27);
		contentPane.add(lblPronunciation);

		tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setBorderPainted(false);
		tglbtnNewToggleButton.setContentAreaFilled(false);
		tglbtnNewToggleButton.setBorder(null);
		tglbtnNewToggleButton.setBounds(797, 11, 65, 61);
		contentPane.add(tglbtnNewToggleButton);

		lblCategory = new JLabel();
		lblCategory.setText((String) null);
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategory.setBounds(35, 146, 333, 27);
		contentPane.add(lblCategory);

		JPanel panel = new JPanel();
		panel.setBounds(35, 203, 805, 356);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setDisabledTextColor(new Color(0, 0, 0));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setEditable(false);
		panel.add(textArea);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scroll);
	}
}
