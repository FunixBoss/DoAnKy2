package insert;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameTopic extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTopic frame = new FrameTopic();
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
	public FrameTopic() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 327);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thêm chủ đề");
		lblTitle.setForeground(new Color(37, 57, 111));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(20, 11, 219, 34);
		contentPane.add(lblTitle);
		
		JLabel lblWord = new JLabel("Chủ đề");
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(59, 120, 84, 21);
		contentPane.add(lblWord);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setBounds(477, 82, 337, 127);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 869, 62);
		contentPane.add(panel);

		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setBounds(59, 208, 150, 44);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Xóa");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Arial", Font.BOLD, 16));
		btnReset.setBackground(new Color(67, 98, 190));
		btnReset.setBounds(267, 208, 150, 44);
		contentPane.add(btnReset);
		
		JTextField textField = new JTextField();
		textField.setMargin(new Insets(2, 6, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(178, 111, 239, 38);
		contentPane.add(textField);
	}

}
