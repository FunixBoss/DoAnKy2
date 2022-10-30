package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import panel.PanelDictionary;
import panel.PanelHome;

import javax.swing.JTabbedPane;

public class FrameHome extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldSearch;
	private Image logoImg = new ImageIcon(getClass().getResource("/image/dictionary-icon.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image searchImg = new ImageIcon(getClass().getResource("/image/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private JPanel panelMain;
	private PanelDictionary jpDictionary;
	private PanelHome jpHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome frame = new FrameHome();
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
	public FrameHome() {
		setResizable(false);
		setTitle("EV Dictionary");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameDashboard.class.getResource("/image/dictionary-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,  1318, 816);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 217, 777);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		panelLogo.setLayout(null);
		panelLogo.setBounds(0, 0, 217, 77);
		panel.add(panelLogo);
		
		JLabel lblLogo = new JLabel("EV Dictionary");
		lblLogo.setForeground(new Color(37, 57, 111));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogo.setBounds(73, 16, 134, 39);
		panelLogo.add(lblLogo);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(12, 11, 55, 50);
		panelLogo.add(lblIconLogo);
		lblIconLogo.setBackground(new Color(0, 0, 0));
		lblIconLogo.setIcon(new ImageIcon(logoImg));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane_1.setBorder(null);
		scrollPane_1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(0, 77, 217, 702);
		panel.add(scrollPane_1);
		
		jpDictionary = new PanelDictionary("account","noun");
		jpHome = new PanelHome();
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBounds(217, 77, 1085, 702);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		panelMain.add(jpDictionary);
		panelMain.add(jpHome);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 1085, 77);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(242, 247, 255));
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(searchImg));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(67, 98, 190));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(334, 22, 38, 36);
		panel_1.add(btnNewButton);
		
		txtFieldSearch = new JTextField();
		txtFieldSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFieldSearch.setBorder(null);
		txtFieldSearch.setBounds(47, 22, 273, 36);
		panel_1.add(txtFieldSearch);
		txtFieldSearch.setColumns(10);
		
		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSignUp_actionPerformed(e);
			}
		});
		
				btnSignUp.setForeground(new Color(255, 255, 255));
				btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
				btnSignUp.setBorder(null);
				btnSignUp.setBackground(new Color(67, 98, 190));
				btnSignUp.setBounds(806, 22, 102, 36);
				panel_1.add(btnSignUp);
				
				JButton btnSignIn = new JButton("Đăng nhập");
				btnSignIn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_btnSignIn_actionPerformed(e);
					}
				});
				btnSignIn.setForeground(new Color(255, 255, 255));
				btnSignIn.setFont(new Font("Arial", Font.BOLD, 14));
				btnSignIn.setBorder(null);
				btnSignIn.setBackground(new Color(67, 98, 190));
				btnSignIn.setBounds(930, 22, 102, 36);
				panel_1.add(btnSignIn);
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
	}
	protected void do_btnSignUp_actionPerformed(ActionEvent e) {
		FrameSignUp frame = new FrameSignUp();
		frame.setLocation(250,250);
		frame.setVisible(true);
	}
	protected void do_btnSignIn_actionPerformed(ActionEvent e) {
		FrameSignIn frame = new FrameSignIn();
		frame.setLocation(400,300);
		frame.setVisible(true);
	}
}
