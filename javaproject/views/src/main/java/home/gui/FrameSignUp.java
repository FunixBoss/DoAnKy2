package home.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import dao.impl.UserDAOImpl;
import entity.User;
import helper.ValidateRegister;
import helper.RegexPattern;
import service.Register;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;
	private JPasswordField textFieldPasswordConfirm;

	/**
	 * Create the frame.
	 */
	public FrameSignUp() {
		setResizable(false);
		setTitle("Đăng ký");
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(45, 200, 102, 21);
		contentPane.add(lblPassword);

		JLabel lblResetPassword = new JLabel("Nhập lại mật khẩu");
		lblResetPassword.setForeground(Color.BLACK);
		lblResetPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResetPassword.setBounds(45, 279, 130, 21);
		contentPane.add(lblResetPassword);

		JLabel lbl = new JLabel("Email");
		lbl.setForeground(Color.BLACK);
		lbl.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl.setBounds(45, 133, 102, 21);
		contentPane.add(lbl);

		textFieldEmail = new JTextField();
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				StringBuilder s = new StringBuilder();
				Register.checkColorText(RegexPattern.EMAIL, textFieldEmail, s, "email");
			}
		});
		lbl.setLabelFor(textFieldEmail);
		textFieldEmail.setMargin(new Insets(2, 6, 2, 2));
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setBounds(194, 116, 239, 38);
		contentPane.add(textFieldEmail);

		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acction_SignUp(e);
			}
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
		btnSignUp.setBackground(new Color(37, 57, 111));
		btnSignUp.setBounds(45, 340, 389, 44);
		contentPane.add(btnSignUp);

		JLabel lblText = new JLabel("Đã có tài khoản?");
		lblText.setFont(new Font("Arial", Font.PLAIN, 14));
		lblText.setBounds(126, 410, 117, 21);
		contentPane.add(lblText);

		JButton btnSignIn = new JButton("Đăng nhập");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSignIn_actionPerformed(e);
			}
		});
		btnSignIn.setForeground(new Color(37, 57, 111));
		btnSignIn.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(Color.WHITE);
		btnSignIn.setBounds(276, 409, 92, 23);
		contentPane.add(btnSignIn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 486, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setBounds(188, 23, 116, 36);
		panel.add(lblSignUp);
		lblSignUp.setForeground(new Color(37, 57, 111));
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 30));
		lblSignUp.setBackground(new Color(62, 115, 255));

		textFieldPassword = new JPasswordField();
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				StringBuilder s = new StringBuilder();
				Register.checkColorText(RegexPattern.PASSWORD, textFieldPassword, s, "password");
			}
		});
		textFieldPassword.setBounds(194, 192, 239, 38);
		contentPane.add(textFieldPassword);

		textFieldPasswordConfirm = new JPasswordField();
		textFieldPasswordConfirm.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				StringBuilder s = new StringBuilder();
				Register.checkPasswordConfirm(textFieldPassword, textFieldPasswordConfirm, s);
			}
		});
		textFieldPasswordConfirm.setBounds(194, 260, 239, 38);
		contentPane.add(textFieldPasswordConfirm);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	protected void do_btnSignIn_actionPerformed(ActionEvent e) {
		dispose();
		FrameSignIn siginIn = new FrameSignIn();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		siginIn.setLocation(dim.width/2-siginIn.getSize().width/2, dim.height/2-siginIn.getSize().height/2);
		
		siginIn.setVisible(true);
	}

	private void acction_SignUp(ActionEvent e) {
		String email = textFieldEmail.getText();
		String password = textFieldPassword.getText();
		StringBuilder s = new StringBuilder();
		try {
			if (ValidateRegister.checkAll(textFieldEmail, textFieldPassword, textFieldPasswordConfirm, s)) {
				User user = new User(email, password, User.getUserLevel());
				if (new UserDAOImpl().insert(user) == 1) {
					JOptionPane.showMessageDialog(null, "Bạn Đã Đăng Kí Thành Công");
				}

			} else {
				JOptionPane.showMessageDialog(null,
						s.length() <= 0 ? "vui lòng nhập chính xác dữ liệu!!" + s.toString() : s.toString());
			}
		} catch (Exception e2) {
			e2.printStackTrace();

		}
	};
}
