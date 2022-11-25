package admin.insert;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import admin.item.ItemMeaning;
import dao.impl.CategoryDAOImpl;
import dao.impl.WordTypeDAOImpl;
import helper.ErrorMessage;
import jaco.mp3.player.MP3Player;
import service.VocabularyService;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FrameInsertVocab extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextArea textExample;
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
	private Panel panelMeaning;
	private JLabel lblMeaning;
	private JLabel lblExample1;
	private JPanel panelShowImage;
	private JLabel lblShowImage;
	private static String pronunciationURL = null;
	private static MP3Player mp3 = null;
	private VocabularyService vocabService;
	Map<String, String> data;
	private static FrameInsertMember myInstance;
	private JTextField textRelatives;
	private JLabel lblRelatives;
	private JLabel lblCategory;
	private JComboBox<String> comboCategory;
	private JTextField textMeaning;
	private JButton btnPlaySound;
	private JPanel panel_1;
	private JButton btnStopSound;
	private JButton btnPlus;
	private int i = 150;
	private int y = 450;
	private int h = 517;
	public FrameInsertVocab() {
		initComponent();
		vocabService = new VocabularyService();
		data = new HashMap<>();
	}

	public static FrameInsertMember getMyInstance() {
		if (myInstance == null) {
			myInstance = new FrameInsertMember();
		}
		return myInstance;
	}

	private void initComponent() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1303, 517);
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
		btnAdd.setBounds(1118, 86, 150, 44);
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
		panel.setBounds(0, 0, 1289, 62);
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

		panelMeaning = new Panel();
		panelMeaning.setLayout(null);
		panelMeaning.setBackground(Color.BLACK);
		panelMeaning.setBounds(138, 338, 362, 42);
		contentPane.add(panelMeaning);

		textMeaning = new JTextField();
		textMeaning.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMeaning.setColumns(10);
		textMeaning.setBounds(0, 0, 362, 42);
		panelMeaning.add(textMeaning);

		Panel panelExample = new Panel();
		panelExample.setBackground(Color.BLACK);
		panelExample.setBounds(624, 338, 462, 102);
		contentPane.add(panelExample);
		panelExample.setLayout(new BorderLayout(0, 0));

		textExample = new JTextArea();
		textExample.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample.setBackground(Color.WHITE);
		panelExample.add(textExample);
		
		JScrollPane jspEx1 = new JScrollPane(textExample, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelExample.add(jspEx1);

		lblMeaning = new JLabel("Ý nghĩa:");
		lblMeaning.setForeground(Color.BLACK);
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning.setBounds(32, 348, 74, 21);
		contentPane.add(lblMeaning);


		lblExample1 = new JLabel("Ví dụ ");
		lblExample1.setForeground(Color.BLACK);
		lblExample1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample1.setBounds(538, 338, 96, 21);
		contentPane.add(lblExample1);

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
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPlus_actionPerformed(e);
			}
		});
		btnPlus.setForeground(Color.WHITE);
		btnPlus.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlus.setBackground(new Color(67, 98, 190));
		btnPlus.setBounds(1118, 336, 44, 44);
		contentPane.add(btnPlus);
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
		data.put("meaning", textMeaning.getText());
		data.put("example", textExample.getText());
		if (vocabService.add(data)) {
			JOptionPane.showMessageDialog(this, "Thêm từ vựng thành công");
			dispose();
		} else {
			System.out.println(ErrorMessage.ERROR_MESSAGES);

		}

	}
	
	protected void btnStopSoundActionPerformed(ActionEvent e) {
		if(pronunciationURL == null) {
			JOptionPane.showMessageDialog(this, "Bạn chưa upload file phát âm");
		} else {
			mp3.stop();
		}
	}
	protected void do_btnPlus_actionPerformed(ActionEvent e) {
		ItemMeaning item = new ItemMeaning(y);
		contentPane.add(item);
		h = h + i;
		setBounds(100, 100, 1303, h);
		y = y + i;
	}
}
