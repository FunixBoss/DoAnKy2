package insert;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FrameVocab extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextArea textExample;
	private JTextArea textMeaning;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVocab frame = new FrameVocab();
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
	public FrameVocab() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 990, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm từ vựng");
		lblNewLabel.setForeground(new Color(37, 57, 111));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 219, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(32, 97, 84, 21);
		contentPane.add(lblWord);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdd.setBounds(296, 547, 150, 44);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Xóa");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBackground(new Color(67, 98, 190));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Arial", Font.BOLD, 16));
		btnReset.setBounds(546, 547, 150, 44);
		contentPane.add(btnReset);
		
		JLabel lblWordType = new JLabel("Loại từ");
		lblWordType.setForeground(Color.BLACK);
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWordType.setBounds(32, 184, 96, 21);
		contentPane.add(lblWordType);
		
		
		JLabel lblTopic = new JLabel("Chủ đề");
		lblTopic.setForeground(Color.BLACK);
		lblTopic.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTopic.setBounds(32, 274, 96, 21);
		contentPane.add(lblTopic);
		
		JComboBox comboBoxTopic = new JComboBox();
		comboBoxTopic.setBackground(new Color(255, 255, 255));
		comboBoxTopic.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBoxTopic.setModel(new DefaultComboBoxModel(new String[] {"Du lịch", "Ăn uống", "Công việc"}));
		comboBoxTopic.setBounds(138, 265, 173, 38);
		contentPane.add(comboBoxTopic);
		
		JComboBox comboWordType = new JComboBox();
		comboWordType.setBackground(new Color(255, 255, 255));
		comboWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		comboWordType.setModel(new DefaultComboBoxModel(new String[] {"Danh từ", "Động từ", "Trạng từ"}));
		comboWordType.setBounds(138, 175, 173, 38);
		contentPane.add(comboWordType);
		
		textWord = new JTextField();
		textWord.setBounds(136, 90, 175, 37);
		contentPane.add(textWord);
		textWord.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 974, 62);
		contentPane.add(panel);
		
		JLabel lblPronunciation = new JLabel("Phát âm");
		lblPronunciation.setForeground(Color.BLACK);
		lblPronunciation.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPronunciation.setBounds(32, 371, 96, 21);
		contentPane.add(lblPronunciation);
		
		JLabel lblImage = new JLabel("Hình ảnh");
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblImage.setBounds(32, 448, 96, 21);
		contentPane.add(lblImage);
		
		JButton btnImage = new JButton("Tải ảnh lên");
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnImage_actionPerformed(e);
			}
		});
		btnImage.setForeground(new Color(0, 0, 0));
		btnImage.setFont(new Font("Arial", Font.BOLD, 14));
		btnImage.setBounds(138, 440, 175, 37);
		btnImage.setBackground(new Color(242, 247, 255));
		contentPane.add(btnImage);
		
		JButton btnPronunciation = new JButton(" Tải âm thanh lên");
		btnPronunciation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPronunciation_actionPerformed(e);
			}
		});
		btnPronunciation.setForeground(new Color(0, 0, 0));
		btnPronunciation.setFont(new Font("Arial", Font.BOLD, 14));
		btnPronunciation.setBounds(136, 355, 175, 37);
		btnPronunciation.setBackground(new Color(242, 247, 255));
		contentPane.add(btnPronunciation);
		
		JLabel lblExample = new JLabel("Ví dụ");
		lblExample.setForeground(Color.BLACK);
		lblExample.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample.setBounds(368, 97, 70, 21);
		contentPane.add(lblExample);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(458, 90, 482, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textExample = new JTextArea();
		textExample.setBounds(1, 1, 480, 179);
		panel_1.add(textExample);
		textExample.setBackground(new Color(255, 255, 255));
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(458, 296, 482, 181);
		contentPane.add(panel_1_1);
		
		textMeaning = new JTextArea();
		textMeaning.setBackground(Color.WHITE);
		textMeaning.setBounds(1, 1, 480, 179);
		panel_1_1.add(textMeaning);
		
		JLabel lblMeaning = new JLabel("Ý nghĩa");
		lblMeaning.setForeground(Color.BLACK);
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning.setBounds(368, 307, 70, 21);
		contentPane.add(lblMeaning);
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
		textExample.setText("");
		textMeaning.setText("");
		
	}
}
