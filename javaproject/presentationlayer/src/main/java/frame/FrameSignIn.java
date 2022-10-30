package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.ComponentOrientation;
import javax.swing.JPasswordField;

public class FrameSignIn extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JDesktopPane desktop;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FrameSignIn() {
		setResizable(false);
		setForeground(new Color(62, 115, 255));
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		JLabel lblSignIn = new JLabel("Đăng nhập");
		lblSignIn.setBackground(new Color(255, 255, 255));
		lblSignIn.setBounds(230, 0, 172, 84);
		lblSignIn.setForeground(new Color(37, 57, 111));
		lblSignIn.setFont(new Font("Arial", Font.BOLD, 30));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(117, 125, 102, 21);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setLabelFor(lblPassword);
		lblPassword.setBounds(117, 194, 102, 26);
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textFieldEmail = new JTextField();
		lblEmail.setLabelFor(textFieldEmail);
		textFieldEmail.setMargin(new Insets(2, 6, 2, 2));
		textFieldEmail.setBounds(245, 118, 239, 38);
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setBackground(UIManager.getColor("Button.highlight"));
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		
		JButton btnSignIn = new JButton("Đăng nhập");
		btnSignIn.setBounds(117, 263, 367, 44);
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setBackground(new Color(37, 57, 111));
		btnSignIn.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.setLayout(null);
		contentPane.add(lblSignIn);
		contentPane.add(lblPassword);
		contentPane.add(lblEmail);
		contentPane.add(textFieldEmail);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("Chưa có tài khoản?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(193, 336, 131, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSignUp_actionPerformed(e);
			}
		});
		btnSignUp.setBorder(null);
		btnSignUp.setForeground(new Color(37, 57, 111));
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignUp.setBackground(new Color(255, 255, 255));
		
		btnSignUp.setBounds(328, 335, 70, 23);
		contentPane.add(btnSignUp);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 596, 84);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		passwordField.setMargin(new Insets(2, 6, 2, 2));
		passwordField.setBounds(245, 189, 239, 38);
		contentPane.add(passwordField);
	}
	
	protected void do_btnSignUp_actionPerformed(ActionEvent e) {
		desktop = new JDesktopPane();
		FrameSignUp signUp = new FrameSignUp();
		signUp.setVisible(true);
		desktop.add(signUp);
	}
}
