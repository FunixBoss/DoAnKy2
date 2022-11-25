package home.update;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PanelUpdateMember extends JPanel {
	private JTextField textField;
	private JPasswordField password;
	private JPasswordField resetPassword;
	private JPasswordField newPassword;

	/**
	 * Create the panel.
	 */
	public PanelUpdateMember() {
		initComponent();
	}

	private void initComponent() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1282, 691);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1262, 671);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(132, 175, 102, 21);
		panel.add(lblEmail);
		
		textField = new JTextField();
		textField.setMargin(new Insets(2, 6, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setFocusTraversalPolicyProvider(true);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(333, 166, 306, 38);
		panel.add(textField);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(132, 247, 102, 21);
		panel.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(333, 240, 306, 38);
		panel.add(password);
		
		JLabel lblResetPassword = new JLabel("Nhập lại mật khẩu");
		lblResetPassword.setForeground(Color.BLACK);
		lblResetPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResetPassword.setBounds(133, 395, 130, 21);
		panel.add(lblResetPassword);
		
		resetPassword = new JPasswordField();
		resetPassword.setBounds(333, 388, 306, 38);
		panel.add(resetPassword);
		
		JLabel lblHeader = new JLabel("THÔNG TIN CÁ NHÂN");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		lblHeader.setBounds(50, 30, 339, 50);
		panel.add(lblHeader);
		
		JLabel lblNewLabel = new JLabel("Cập nhật thông tin tài khoản");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 82, 233, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewPassword = new JLabel("Mật khẩu mới");
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewPassword.setBounds(132, 322, 102, 21);
		panel.add(lblNewPassword);
		
		newPassword = new JPasswordField();
		newPassword.setBounds(333, 315, 306, 38);
		panel.add(newPassword);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(67, 98, 190));
		btnUpdate.setBounds(333, 500, 150, 44);
		panel.add(btnUpdate);
		
	}
}
