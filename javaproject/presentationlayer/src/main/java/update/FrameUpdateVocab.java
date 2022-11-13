package update;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.impl.CategoryDAOImpl;
import dao.impl.MeaningDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.Category;
import entity.Example;
import entity.Meaning;
import entity.Relatives;
import entity.Vocabulary;
import helper.ErrorMessage;
import item.ItemVocab;
import jaco.mp3.player.MP3Player;
import service.CategoryService;
import service.UserService;
import service.VocabularyService;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.DebugGraphics;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;

public class FrameUpdateVocab extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextArea textExample3;
	private JTextArea textExample1;
	private JTextArea textExample2;
	private JLabel lblNewLabel;
	private JLabel lblWord;
	private JButton btnAdd;
	private JLabel lblWordType;
	private JComboBox<String> comboWordType;
	private JPanel panel;
	private JLabel lblPronunciation;
	private JLabel lblImage;
	private JButton btnImage;
	private JButton btnPronunciation;
	private Panel panelMeaning1;
	private Panel panelMeaning2;
	private Panel panelMeaning3;
	private Panel panelExample1;
	private Panel panelExample2;
	private Panel panelExample3;
	private JLabel lblMeaning1;
	private JLabel lblMeaning2;
	private JLabel lblMeaning3;
	private JLabel lblExample1;
	private JLabel lblIExample2;
	private JLabel lblExample3;
	private JPanel panelShowImage;
	private JLabel lblShowImage;
	
	private static String pronunciationURL = null;
	private static MP3Player mp3 = null;
	private VocabularyService vocabService;
	private VocabularyDAOImpl vocabDao;
	private static Map<String, String> data;

	private static FrameUpdateVocab myInstance;
	private JTextField textRelatives;
	private JLabel lblRelatives;
	private JLabel lblCategory;
	private JComboBox<String> comboCategory;
	private JTextField textMeaning1;
	private JTextField textMeaning2;
	private JTextField textMeaning3;
	private JButton btnPlaySound;
	private JPanel panel_1;
	private JButton btnStopSound;


	public FrameUpdateVocab(Vocabulary vocab) {
		initComponent();
		data = new HashMap<>();
		data.put("id", Integer.toString(vocab.getId()));
		vocabService = new VocabularyService();
		vocabDao = new VocabularyDAOImpl();
		textWord.setText(vocab.getWord());
		comboWordType.setSelectedIndex(vocab.getWordTypeId() - 1);
		Category cate = new CategoryDAOImpl().select(vocab.getCategoryId());
		if( cate != null) {
			comboCategory.setSelectedItem(toCapitalize(cate.getName().toString()));
		}
		List<Relatives> relatives = vocabDao.selectAllRelativesByVocabId(vocab.getId());
		if(relatives != null) {
			String relativesStr = relatives.stream()
					.map(rel -> rel.getWord().toString())
					.collect(Collectors.joining(";"));
			textRelatives.setText(relativesStr);
		}
		
		List<Meaning> meanings = vocabDao.selectAllMeaningByVocabId(vocab.getId());
		if(meanings != null) {
			switch (meanings.size()) {
			case 3: 
				textMeaning3.setText(meanings.get(2).getContent());
				List<Example> examples = new MeaningDAOImpl().selectAllExampleByMeaningId(meanings.get(2).getId());
				if(examples!= null) {
					StringBuffer str = new StringBuffer();
					for(Example ex : examples) {
						if(!ex.getContent().equals("")) {
							str.append(ex.getContent() + ";" + ex.getMeaning() + "\n");
						}
					}				
					textExample3.setText(str.toString());
				}
			
			case 2: 
				textMeaning2.setText(meanings.get(1).getContent());
				List<Example> examples1 = new MeaningDAOImpl().selectAllExampleByMeaningId(meanings.get(1).getId());
				if(examples1!= null) {
					StringBuffer str = new StringBuffer();
					for(Example ex : examples1) {
						if(!ex.getContent().equals("")) {
							str.append(ex.getContent() + ";" + ex.getMeaning() + "\n");
						}					}				
					textExample2.setText(str.toString());
				}
			
			case 1: 
				textMeaning1.setText(meanings.get(0).getContent());
				List<Example> examples11 = new MeaningDAOImpl().selectAllExampleByMeaningId(meanings.get(0).getId());
				if(examples11!= null) {
					StringBuffer str = new StringBuffer();
					for(Example ex : examples11) {
						if(!ex.getContent().equals("")) {
							str.append(ex.getContent() + ";" + ex.getMeaning() + "\n");
						}					}				
					textExample1.setText(str.toString());
				}
			}
		}
		
		if(vocab.getImage() != null) {
			lblShowImage.setIcon(getImageByURL(vocab.getImage()));
		}
		
		if(vocab.getPronunciation() != null) {
			pronunciationURL = System.getProperty("user.dir") + "/src/main/resources/pronunciation/" + vocab.getPronunciation();
		}
		
		
	}

	public static FrameUpdateVocab getMyInstance(Vocabulary vocab) {
		if (myInstance == null) {
			myInstance = new FrameUpdateVocab(vocab);
		}
		return myInstance;
	}

	private void initComponent() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1129, 822);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Thêm từ vựng");
		lblNewLabel.setBounds(20, 11, 219, 34);
		lblNewLabel.setForeground(new Color(37, 57, 111));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel);

		lblWord = new JLabel("Từ vựng");
		lblWord.setBounds(32, 99, 84, 21);
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblWord);

		btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(485, 725, 150, 44);
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnAdd);

		lblWordType = new JLabel("Loại từ");
		lblWordType.setBounds(351, 90, 96, 21);
		lblWordType.setForeground(Color.BLACK);
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblWordType);

		comboWordType = new JComboBox<>();
		comboWordType.setBounds(446, 90, 173, 38);
		comboWordType.setBackground(new Color(255, 255, 255));
		comboWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(comboWordType);
		WordTypeDAOImpl daoTypeWord = new WordTypeDAOImpl();
		daoTypeWord.selectAll().forEach(pro -> comboWordType.addItem(pro.getType()));
		textWord = new JTextField();
		textWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textWord.setBounds(138, 90, 175, 37);
		contentPane.add(textWord);
		textWord.setColumns(10);

		panel = new JPanel();
		panel.setBounds(0, 0, 1120, 62);
		panel.setBackground(new Color(242, 247, 255));
		contentPane.add(panel);

		lblPronunciation = new JLabel("Phát âm");
		lblPronunciation.setBounds(32, 152, 96, 21);
		lblPronunciation.setForeground(Color.BLACK);
		lblPronunciation.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblPronunciation);

		lblImage = new JLabel("Hình ảnh");
		lblImage.setBounds(351, 152, 96, 21);
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblImage);

		btnImage = new JButton("Tải ảnh lên");
		btnImage.setBounds(446, 152, 175, 37);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnImage_actionPerformed(e);
			}
		});
		btnImage.setForeground(new Color(0, 0, 0));
		btnImage.setFont(new Font("Arial", Font.BOLD, 14));
		btnImage.setBackground(new Color(242, 247, 255));
		contentPane.add(btnImage);

		btnPronunciation = new JButton(" Tải âm thanh lên");
		btnPronunciation.setBounds(138, 152, 175, 37);
		btnPronunciation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPronunciation_actionPerformed(e);
			}
		});
		btnPronunciation.setForeground(new Color(0, 0, 0));
		btnPronunciation.setFont(new Font("Arial", Font.BOLD, 14));
		btnPronunciation.setBackground(new Color(242, 247, 255));
		contentPane.add(btnPronunciation);

		panelMeaning1 = new Panel();
		panelMeaning1.setLayout(null);
		panelMeaning1.setBackground(Color.BLACK);
		panelMeaning1.setBounds(138, 338, 362, 42);
		contentPane.add(panelMeaning1);

		textMeaning1 = new JTextField();
		textMeaning1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMeaning1.setColumns(10);
		textMeaning1.setBounds(0, 0, 362, 42);
		panelMeaning1.add(textMeaning1);

		panelMeaning2 = new Panel();
		panelMeaning2.setLayout(null);
		panelMeaning2.setBackground(Color.BLACK);
		panelMeaning2.setBounds(138, 463, 362, 42);
		contentPane.add(panelMeaning2);

		textMeaning2 = new JTextField();
		textMeaning2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMeaning2.setColumns(10);
		textMeaning2.setBounds(0, 0, 362, 42);
		panelMeaning2.add(textMeaning2);

		Panel panelMeaning3 = new Panel();
		panelMeaning3.setLayout(null);
		panelMeaning3.setBackground(Color.BLACK);
		panelMeaning3.setBounds(138, 588, 362, 42);
		contentPane.add(panelMeaning3);

		textMeaning3 = new JTextField();
		textMeaning3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMeaning3.setColumns(10);
		textMeaning3.setBounds(0, 0, 362, 42);
		panelMeaning3.add(textMeaning3);

		Panel panelExample1 = new Panel();
		panelExample1.setBackground(Color.BLACK);
		panelExample1.setBounds(624, 338, 462, 119);
		contentPane.add(panelExample1);
		panelExample1.setLayout(new BorderLayout(0, 0));

		textExample1 = new JTextArea();
		textExample1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample1.setBackground(Color.WHITE);
		panelExample1.add(textExample1);

		JScrollPane jspEx1 = new JScrollPane(textExample1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelExample1.add(jspEx1, BorderLayout.CENTER);
		
		panelExample2 = new Panel();
		panelExample2.setBackground(Color.BLACK);
		panelExample2.setBounds(624, 463, 462, 119);
		contentPane.add(panelExample2);
		panelExample2.setLayout(new BorderLayout(0, 0));

		textExample2 = new JTextArea();
		textExample2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample2.setBackground(Color.WHITE);
		panelExample2.add(textExample2);

		JScrollPane jspEx2 = new JScrollPane(textExample2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelExample2.add(jspEx2);
		
		panelExample3 = new Panel();
		panelExample3.setBackground(Color.BLACK);
		panelExample3.setBounds(624, 588, 462, 119);
		contentPane.add(panelExample3);
		panelExample3.setLayout(new BorderLayout(0, 0));

		textExample3 = new JTextArea();
		textExample3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample3.setBackground(Color.WHITE);
		panelExample3.add(textExample3);

		JScrollPane jspEx3 = new JScrollPane(textExample3, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelExample3.add(jspEx3);
		
		lblMeaning1 = new JLabel("Ý nghĩa 1:");
		lblMeaning1.setForeground(Color.BLACK);
		lblMeaning1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning1.setBounds(32, 348, 74, 21);
		contentPane.add(lblMeaning1);

		lblMeaning2 = new JLabel("Ý nghĩa 2:");
		lblMeaning2.setForeground(Color.BLACK);
		lblMeaning2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning2.setBounds(32, 473, 74, 21);
		contentPane.add(lblMeaning2);

		lblMeaning3 = new JLabel("Ý nghĩa 3:");
		lblMeaning3.setForeground(Color.BLACK);
		lblMeaning3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning3.setBounds(32, 598, 74, 21);
		contentPane.add(lblMeaning3);

		lblExample1 = new JLabel("Ví dụ 1");
		lblExample1.setForeground(Color.BLACK);
		lblExample1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample1.setBounds(538, 338, 96, 21);
		contentPane.add(lblExample1);

		lblIExample2 = new JLabel("Ví dụ 2");
		lblIExample2.setForeground(Color.BLACK);
		lblIExample2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIExample2.setBounds(538, 463, 96, 21);
		contentPane.add(lblIExample2);

		lblExample3 = new JLabel("Ví dụ 3");
		lblExample3.setForeground(Color.BLACK);
		lblExample3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample3.setBounds(538, 588, 96, 21);
		contentPane.add(lblExample3);

		panelShowImage = new JPanel();
		panelShowImage.setBackground(new Color(255, 255, 255));
		panelShowImage.setBounds(673, 143, 412, 170);
		contentPane.add(panelShowImage);
		panelShowImage.setLayout(new BorderLayout(0, 0));

		lblShowImage = new JLabel("");
		lblShowImage.setHorizontalAlignment(SwingConstants.CENTER);
		panelShowImage.add(lblShowImage);
		
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		lblShowImage.setBorder(border);

		textRelatives = new JTextField();
		textRelatives.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textRelatives.setColumns(10);
		textRelatives.setBounds(138, 276, 481, 37);
		contentPane.add(textRelatives);

		lblRelatives = new JLabel("Từ liên quan");
		lblRelatives.setForeground(Color.BLACK);
		lblRelatives.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRelatives.setBounds(32, 275, 108, 34);
		contentPane.add(lblRelatives);

		lblCategory = new JLabel("Thể loại");
		lblCategory.setForeground(Color.BLACK);
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCategory.setBounds(32, 215, 108, 37);
		contentPane.add(lblCategory);

		comboCategory = new JComboBox<String>();
		CategoryDAOImpl cateDao = new CategoryDAOImpl();
		comboCategory.addItem(null);
		cateDao.selectAll().forEach(
				pro -> comboCategory.addItem(pro.getName().substring(0, 1).toUpperCase() + pro.getName().substring(1)));
		comboCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		comboCategory.setBackground(Color.WHITE);
		comboCategory.setBounds(140, 214, 479, 38);
		contentPane.add(comboCategory);
		
		panel_1 = new JPanel();
		panel_1.setBounds(673, 89, 412, 39);
		contentPane.add(panel_1);
		
		btnPlaySound = new JButton("Play Sound");
		btnPlaySound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlaySoundActionPerformed(e);
			}
		});
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		panel_1.add(btnPlaySound);
		
		btnStopSound = new JButton("Stop Sound");
		btnStopSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStopSoundActionPerformed(e);
			}
		});
		panel_1.add(btnStopSound);
	}

	protected void do_btnImage_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser("desktop://");
		chooser.setDialogTitle("Hình ảnh");
		chooser.setFileFilter(new FileNameExtensionFilter("image(jpg, png, gif)", "jpg", "png", "gif"));
		chooser.setAcceptAllFileFilterUsed(false);

		int result = chooser.showOpenDialog(null);
		File f = null;
		if (result == chooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			lblShowImage.setIcon(getImageByURL(f));
			data.put("image", f.toPath().toString());
		}
	}

	protected void do_btnPronunciation_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser("desktop://");
		chooser.setDialogTitle("Âm thanh");
		chooser.setFileFilter(new FileNameExtensionFilter("Sound (mp3)", "mp3"));
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		File f = null;
		if (result == chooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			this.pronunciationURL = f.getAbsolutePath();
			System.out.println(pronunciationURL);
			data.put("pronunciation", f.getAbsolutePath());
		}
	}
	
	private ImageIcon getImageByURL(File f) {
		if (f != null) {
			try {
				final int ROW_HEIGHT = 170;
				BufferedImage bimg = ImageIO.read(f);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(rowWidth,
						ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = getClass().getResource("/vocabulary/" + imageName);
//		System.out.println(imageUrl);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 171;
				BufferedImage bimg = ImageIO.read(imageUrl);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(
						new ImageIcon(imageUrl).getImage().getScaledInstance(rowWidth, ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
	
	protected void btnPlaySoundActionPerformed(ActionEvent e) {
		if(pronunciationURL == null) {
			JOptionPane.showMessageDialog(this, "Bạn chưa upload file phát âm");
		} else {
			mp3 = new MP3Player(new File(pronunciationURL));
			mp3.play();
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		data.put("word", textWord.getText());
		data.put("type", Integer.toString(comboWordType.getSelectedIndex() + 1));
		data.put("category", comboCategory.getSelectedItem() == null ? "" : comboCategory.getSelectedItem().toString());
		data.put("relatives", textRelatives.getText());
		data.put("meaning1", textMeaning1.getText());
		data.put("meaning2", textMeaning2.getText());
		data.put("meaning3", textMeaning3.getText());
		data.put("example1", textExample1.getText());
		data.put("example2", textExample2.getText());
		data.put("example3", textExample3.getText());
		if (vocabService.update(data)) {
			JOptionPane.showMessageDialog(this, "Cập nhật từ vựng thành công");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, ErrorMessage.ERROR_MESSAGES);
		}

	}
	
	protected void btnStopSoundActionPerformed(ActionEvent e) {
		if(pronunciationURL == null) {
			JOptionPane.showMessageDialog(this, "Bạn chưa upload file phát âm");
		} else {
			mp3.stop();
		}
	}
	
	private static String toCapitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
