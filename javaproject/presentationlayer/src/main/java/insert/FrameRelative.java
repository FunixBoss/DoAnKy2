package insert;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameRelative extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRelative frame = new FrameRelative();
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
	public FrameRelative() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thêm từ liên quan");
		lblTitle.setForeground(new Color(37, 57, 111));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBounds(20, 11, 219, 34);
		contentPane.add(lblTitle);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(79, 97, 84, 21);
		contentPane.add(lblWord);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdd.setBounds(182, 261, 150, 44);
		contentPane.add(btnAdd);
		
		JComboBox comboWordType = new JComboBox();
		comboWordType.setBackground(new Color(255, 255, 255));
		comboWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		comboWordType.setModel(new DefaultComboBoxModel(new String[] {"Account", "Accountant", "Accounting"}));
		comboWordType.setBounds(220, 88, 199, 38);
		contentPane.add(comboWordType);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 869, 62);
		contentPane.add(panel);
		
		JLabel lblRelative = new JLabel("Từ liên quan");
		lblRelative.setForeground(Color.BLACK);
		lblRelative.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRelative.setBounds(79, 183, 84, 21);
		contentPane.add(lblRelative);
		
		JComboBox comboWordType_1 = new JComboBox();
		comboWordType_1.setModel(new DefaultComboBoxModel(new String[] {"Accounting", "Accountant", "Business"}));
		comboWordType_1.setFont(new Font("Arial", Font.PLAIN, 14));
		comboWordType_1.setBackground(Color.WHITE);
		comboWordType_1.setBounds(220, 174, 199, 38);
		contentPane.add(comboWordType_1);
	}

}
