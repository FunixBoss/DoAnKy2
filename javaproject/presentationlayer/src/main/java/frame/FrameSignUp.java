package frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameSignUp extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldFullname;
	private JTextField textFieldPassword;
	private JTextField textFieldResetPassword;
	private JTextField textField4;
	private JTextField textFieldDob;
	private JTextField textField;
	private JDesktopPane desktop;

	/**
	 * Create the frame.
	 */
	public FrameSignUp() {
		setResizable(false);
		setTitle("Đăng ký");
		setDefaultCloseOperation( JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 946, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Họ và tên");
		lblEmail.setLabelFor(lblEmail);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(45, 116, 102, 21);
		contentPane.add(lblEmail);
		
		textFieldFullname = new JTextField();
		textFieldFullname.setMargin(new Insets(2, 6, 2, 2));
		textFieldFullname.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldFullname.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldFullname.setColumns(10);
		textFieldFullname.setBackground(Color.WHITE);
		textFieldFullname.setBounds(194, 107, 239, 38);
		contentPane.add(textFieldFullname);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setMargin(new Insets(2, 6, 2, 2));
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBackground(Color.WHITE);
		textFieldPassword.setBounds(194, 183, 239, 38);
		contentPane.add(textFieldPassword);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setLabelFor(textFieldPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(45, 192, 102, 21);
		contentPane.add(lblPassword);
		
		JLabel lblResetPassword = new JLabel("Nhập lại mật khẩu");
		lblResetPassword.setForeground(Color.BLACK);
		lblResetPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResetPassword.setBounds(45, 271, 130, 21);
		contentPane.add(lblResetPassword);
		
		textFieldResetPassword = new JTextField();
		lblResetPassword.setLabelFor(textFieldResetPassword);
		textFieldResetPassword.setMargin(new Insets(2, 6, 2, 2));
		textFieldResetPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldResetPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldResetPassword.setColumns(10);
		textFieldResetPassword.setBackground(Color.WHITE);
		textFieldResetPassword.setBounds(194, 262, 239, 38);
		contentPane.add(textFieldResetPassword);
		
		JLabel lbl = new JLabel("Email");
		lbl.setForeground(Color.BLACK);
		lbl.setFont(new Font("Arial", Font.PLAIN, 14));
		lbl.setBounds(505, 192, 102, 21);
		contentPane.add(lbl);
		
		textField4 = new JTextField();
		lbl.setLabelFor(textField4);
		textField4.setMargin(new Insets(2, 6, 2, 2));
		textField4.setHorizontalAlignment(SwingConstants.LEFT);
		textField4.setFont(new Font("Arial", Font.PLAIN, 16));
		textField4.setColumns(10);
		textField4.setBackground(Color.WHITE);
		textField4.setBounds(640, 183, 239, 38);
		contentPane.add(textField4);
		
		JLabel lblDob = new JLabel("Ngày sinh");
		lblDob.setForeground(Color.BLACK);
		lblDob.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDob.setBounds(505, 116, 102, 21);
		contentPane.add(lblDob);
		
		textFieldDob = new JTextField();
		lblDob.setLabelFor(textFieldDob);
		textFieldDob.setMargin(new Insets(2, 6, 2, 2));
		textFieldDob.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDob.setFont(new Font("Arial", Font.PLAIN, 16));
		textFieldDob.setColumns(10);
		textFieldDob.setBackground(Color.WHITE);
		textFieldDob.setBounds(640, 107, 239, 38);
		contentPane.add(textFieldDob);
		
		JButton btnSignUp = new JButton("Đăng ký");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
		btnSignUp.setBackground(new Color(37, 57, 111));
		btnSignUp.setBounds(289, 344, 389, 44);
		contentPane.add(btnSignUp);
		
		JLabel lblText = new JLabel("Đã có tài khoản?");
		lblText.setFont(new Font("Arial", Font.PLAIN, 14));
		lblText.setBounds(357, 410, 117, 21);
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
		btnSignIn.setBounds(484, 409, 92, 23);
		contentPane.add(btnSignIn);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 937, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setBounds(418, 22, 116, 36);
		panel.add(lblSignUp);
		lblSignUp.setForeground(new Color(37, 57, 111));
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 30));
		lblSignUp.setBackground(new Color(62, 115, 255));
		
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhone.setBounds(505, 271, 102, 21);
		contentPane.add(lblPhone);
		
		textField = new JTextField();
		textField.setMargin(new Insets(2, 6, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(640, 262, 239, 38);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel("(*)");
		lblNewLabel.setForeground(new Color(204, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(443, 103, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(*)");
		lblNewLabel_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(443, 176, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(*)");
		lblNewLabel_2.setForeground(new Color(204, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(443, 255, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(*)");
		lblNewLabel_3.setForeground(new Color(204, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(792, 450, 35, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblBtBuc = new JLabel("Bắt buộc");
		lblBtBuc.setForeground(new Color(204, 0, 0));
		lblBtBuc.setFont(new Font("Arial", Font.BOLD, 14));
		lblBtBuc.setBounds(818, 448, 102, 21);
		contentPane.add(lblBtBuc);
	}
	protected void do_btnSignIn_actionPerformed(ActionEvent e) {
		desktop = new JDesktopPane();
		FrameSignUp signUp = new FrameSignUp();
		signUp.setVisible(true);
		desktop.add(signUp);
	}
}
