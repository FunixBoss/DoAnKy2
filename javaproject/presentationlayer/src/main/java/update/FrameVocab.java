package update;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.impl.WordTypeDAOImpl;
import entity.Vocabulary;

public class FrameVocab extends JFrame {

	private JPanel contentPane;
	private JTextArea textMeaning3;
	private JTextArea textExample1;
	private JTextArea textExample2;
	private JTextArea textExample3;
	private JTextArea textMeaning1;
	private JTextArea textMeaning2;
	private JTextField textWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vocabulary vocab = new Vocabulary();
					FrameVocab frame = new FrameVocab(vocab);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameVocab( Vocabulary vocab) {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1129, 779);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa từ vựng");
		lblNewLabel.setBounds(20, 11, 219, 34);
		lblNewLabel.setForeground(new Color(37, 57, 111));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setBounds(32, 97, 84, 21);
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblWord);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(334, 665, 150, 44);
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Xóa");
		btnReset.setBounds(567, 665, 150, 44);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBackground(new Color(67, 98, 190));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnReset);
		
		JLabel lblWordType = new JLabel("Loại từ");
		lblWordType.setBounds(578, 99, 96, 21);
		lblWordType.setForeground(Color.BLACK);
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblWordType);
		
		JComboBox<String> comboWordType = new JComboBox<>();
		comboWordType.setBounds(673, 88, 173, 38);
		comboWordType.setBackground(new Color(255, 255, 255));
		comboWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(comboWordType);
		WordTypeDAOImpl daoTypeWord = new WordTypeDAOImpl();
		daoTypeWord.selectAll().forEach(pro -> comboWordType.addItem(pro.getType()));
		textWord = new JTextField();
		textWord.setBounds(122, 90, 175, 37);
		contentPane.add(textWord);
		textWord.setColumns(10);
		textWord.setText(vocab.getWord());
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1120, 62);
		panel.setBackground(new Color(242, 247, 255));
		contentPane.add(panel);
		
		JLabel lblPronunciation = new JLabel("Phát âm");
		lblPronunciation.setBounds(32, 164, 96, 21);
		lblPronunciation.setForeground(Color.BLACK);
		lblPronunciation.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblPronunciation);
		
		JLabel lblImage = new JLabel("Hình ảnh");
		lblImage.setBounds(578, 166, 96, 21);
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblImage);
		
		JButton btnImage = new JButton("Tải ảnh lên");
		btnImage.setBounds(673, 156, 175, 37);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnImage_actionPerformed(e);
			}
		});
		btnImage.setForeground(new Color(0, 0, 0));
		btnImage.setFont(new Font("Arial", Font.BOLD, 14));
		btnImage.setBackground(new Color(242, 247, 255));
		contentPane.add(btnImage);
		
		JButton btnPronunciation = new JButton(" Tải âm thanh lên");
		btnPronunciation.setBounds(122, 156, 175, 37);
		btnPronunciation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPronunciation_actionPerformed(e);
			}
		});
		btnPronunciation.setForeground(new Color(0, 0, 0));
		btnPronunciation.setFont(new Font("Arial", Font.BOLD, 14));
		btnPronunciation.setBackground(new Color(242, 247, 255));
		contentPane.add(btnPronunciation);
		
		Panel panelExample1_1 = new Panel();
		panelExample1_1.setLayout(null);
		panelExample1_1.setBackground(Color.BLACK);
		panelExample1_1.setBounds(122, 230, 362, 102);
		contentPane.add(panelExample1_1);
		
		textMeaning1 = new JTextArea();
		textMeaning1.setBackground(Color.WHITE);
		textMeaning1.setBounds(1, 1, 360, 100);
		panelExample1_1.add(textMeaning1);
		
		Panel panelExample1_1_1 = new Panel();
		panelExample1_1_1.setLayout(null);
		panelExample1_1_1.setBackground(Color.BLACK);
		panelExample1_1_1.setBounds(122, 369, 362, 102);
		contentPane.add(panelExample1_1_1);
		
		textMeaning2 = new JTextArea();
		textMeaning2.setBackground(Color.WHITE);
		textMeaning2.setBounds(1, 1, 360, 100);
		panelExample1_1_1.add(textMeaning2);
		
		Panel panelExample1_1_2 = new Panel();
		panelExample1_1_2.setLayout(null);
		panelExample1_1_2.setBackground(Color.BLACK);
		panelExample1_1_2.setBounds(122, 509, 362, 102);
		contentPane.add(panelExample1_1_2);
		
		textMeaning3 = new JTextArea();
		textMeaning3.setBackground(Color.WHITE);
		textMeaning3.setBounds(1, 1, 360, 100);
		panelExample1_1_2.add(textMeaning3);
		
		Panel panelExample1_1_3 = new Panel();
		panelExample1_1_3.setLayout(null);
		panelExample1_1_3.setBackground(Color.BLACK);
		panelExample1_1_3.setBounds(673, 230, 362, 102);
		contentPane.add(panelExample1_1_3);
		
		textExample1 = new JTextArea();
		textExample1.setBackground(Color.WHITE);
		textExample1.setBounds(1, 1, 360, 100);
		panelExample1_1_3.add(textExample1);
		
		Panel panelExample1_1_4 = new Panel();
		panelExample1_1_4.setLayout(null);
		panelExample1_1_4.setBackground(Color.BLACK);
		panelExample1_1_4.setBounds(673, 369, 362, 102);
		contentPane.add(panelExample1_1_4);
		
		textExample2 = new JTextArea();
		textExample2.setBackground(Color.WHITE);
		textExample2.setBounds(1, 1, 360, 100);
		panelExample1_1_4.add(textExample2);
		
		Panel panelExample1_1_5 = new Panel();
		panelExample1_1_5.setLayout(null);
		panelExample1_1_5.setBackground(Color.BLACK);
		panelExample1_1_5.setBounds(673, 509, 362, 102);
		contentPane.add(panelExample1_1_5);
		
		textExample3 = new JTextArea();
		textExample3.setBackground(Color.WHITE);
		textExample3.setBounds(1, 1, 360, 100);
		panelExample1_1_5.add(textExample3);
		
		JLabel lblMeaning1 = new JLabel("Ý nghĩa 1:");
		lblMeaning1.setForeground(Color.BLACK);
		lblMeaning1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning1.setBounds(32, 230, 74, 21);
		contentPane.add(lblMeaning1);
		
		JLabel lblMeaning2 = new JLabel("Ý nghĩa 2:");
		lblMeaning2.setForeground(Color.BLACK);
		lblMeaning2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning2.setBounds(32, 369, 74, 21);
		contentPane.add(lblMeaning2);
		
		JLabel lblMeaning3 = new JLabel("Ý nghĩa 3:");
		lblMeaning3.setForeground(Color.BLACK);
		lblMeaning3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning3.setBounds(32, 509, 74, 21);
		contentPane.add(lblMeaning3);
		
		JLabel lblExample1 = new JLabel("Ví dụ 1:");
		lblExample1.setForeground(Color.BLACK);
		lblExample1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample1.setBounds(578, 230, 96, 21);
		contentPane.add(lblExample1);
		
		JLabel lblIExample2 = new JLabel("Ví dụ 2:");
		lblIExample2.setForeground(Color.BLACK);
		lblIExample2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblIExample2.setBounds(578, 369, 96, 21);
		contentPane.add(lblIExample2);
		
		JLabel lblExample3 = new JLabel("Ví dụ 3:");
		lblExample3.setForeground(Color.BLACK);
		lblExample3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample3.setBounds(578, 509, 96, 21);
		contentPane.add(lblExample3);
	}

	protected void do_btnImage_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser("c://");
		chooser.setDialogTitle("Hình ảnh");
		chooser.setFileFilter(
					new FileNameExtensionFilter("image(jpg, png, gif)","jpg","png","gif" )
				);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		if(result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
	}
	
	protected void do_btnPronunciation_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser("c://");
		chooser.setDialogTitle("Âm thanh");
		chooser.setFileFilter(
					new FileNameExtensionFilter("mp3")
				);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		if(result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		textWord.setText("");
		textExample1.setText("");
		textMeaning1.setText("");
		textExample2.setText("");
		textMeaning2.setText("");
		textExample3.setText("");
		textMeaning3.setText("");
	}
}
