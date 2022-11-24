package home.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import admin.gui.FrameDashboard;
import dao.impl.UserDAOImpl;
import entity.User;
import helper.ValidateLogin;
import helper.RegexPattern;
import service.Authorization;
import service.Login;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPasswordField;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameSignIn extends JFrame {
	private FrameSignIn jfSignIn;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSignIn frame = new FrameSignIn();
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
	public FrameSignIn() {
		setResizable(false);
		
		setForeground(new Color(62, 115, 255));
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 247, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(462, 125, 102, 21);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setBounds(462, 192, 102, 26);
		lblPassword.setLabelFor(lblPassword);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(558, 117, 239, 38);
		textFieldEmail.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				textFieldEmailKeyReleased(e);
			}
		});
		// textFieldEmail.setBorder(new LineBorder(Color.red, 2));
		textFieldEmail.setCaretColor(new Color(0, 0, 0));
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setMargin(new Insets(2, 6, 2, 2));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setBackground(UIManager.getColor("Button.highlight"));
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblPassword);
		contentPane.add(lblEmail);
		contentPane.add(textFieldEmail);

		JLabel lblNewLabel = new JLabel("Chưa có tài khoản?");
		lblNewLabel.setBounds(506, 335, 131, 21);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);

		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.setBounds(641, 334, 70, 23);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSignUp_actionPerformed(e);
			}
		});
		btnSignUp.setBorder(null);
		btnSignUp.setForeground(new Color(37, 57, 111));
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignUp.setBackground(new Color(255, 255, 255));
		contentPane.add(btnSignUp);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(558, 188, 239, 38);
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				StringBuilder s = new StringBuilder();
				Login.checkColorText(RegexPattern.PASSWORD, textFieldPassword, s, "password");
			}
		});
		textFieldPassword.setMargin(new Insets(2, 6, 2, 2));
		contentPane.add(textFieldPassword);

		JLabel textMess1 = new JLabel("");
		textMess1.setBounds(495, 117, 57, 38);
		textMess1.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(textMess1);

		JLabel textmess2 = new JLabel("");
		textmess2.setBounds(494, 189, 57, 38);
		textmess2.setAlignmentX(0.5f);
		contentPane.add(textmess2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(37, 57, 111));
		panel_1.setBounds(0, 0, 415, 532);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(427, 0, 415, 532);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
						
								JButton btnSignIn = new JButton("Đăng nhập");
								btnSignIn.setBounds(25, 262, 367, 44);
								panel_2.add(btnSignIn);
								btnSignIn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										String account = textFieldEmail.getText();
										String password = textFieldPassword.getText();
										StringBuilder s = new StringBuilder();
										try {
											if (ValidateLogin.checkAll(textFieldEmail, textFieldPassword, s)) {
												User user = new User(account, password, 1);
												if (UserDAOImpl.loginDb(user)) {
													Authorization authInfoUser = new Authorization(account, password, user.getRoleId());
													dispose();
													if(Authorization.loggedrole==1) {
														FrameDashboard frame = new FrameDashboard();
														Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
														frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
														frame.setVisible(true);
														
													}else {
														FrameHome frame = new FrameHome();
														Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
														frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
														frame.setVisible(true);
													}
												}
											} else {
												JOptionPane.showMessageDialog(null,
														s.length() <= 0 ? "Vui Lòng Kiểm Tra Lại Dữ Liệu" : s.toString());
											}
										} catch (Exception e2) {
											e2.printStackTrace();

										}
									}
								});
								btnSignIn.setForeground(new Color(255, 255, 255));
								btnSignIn.setBackground(new Color(37, 57, 111));
								btnSignIn.setFont(new Font("Arial", Font.BOLD, 18));
		

	}

	protected void do_btnSignUp_actionPerformed(ActionEvent e) {
//		desktop = new JDesktopPane();
		dispose();
		FrameSignUp signUp = new FrameSignUp();
		signUp.setVisible(true);
//		desktop.add(signUp);
	}
	protected void textFieldEmailKeyReleased(KeyEvent e) {
		StringBuilder s = new StringBuilder();
		Login.checkColorText(RegexPattern.EMAIL, textFieldEmail, s, "email");
	}

	

	public FrameSignIn getJfSignIn() {
		return jfSignIn;
	}

	public void setJfSignIn(FrameSignIn jfSignIn) {
		this.jfSignIn = jfSignIn;
	}
}
