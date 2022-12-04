package home.update;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.mindrot.jbcrypt.BCrypt;

import dao.impl.UserDAOImpl;
import entity.User;
import helper.RegexPattern;
import service.Authorization;
import service.Register;

import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUpdateMember extends JPanel {
	private JPasswordField textPassword;
	private JPasswordField PasswordConfirm;
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
		setBounds(0, 0, 1200, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 34, 1004, 647);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(133, 159, 102, 21);
		panel.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(322, 151, 306, 38);
		panel.add(textPassword);
		
		JLabel lblResetPassword = new JLabel("Nhập lại mật khẩu");
		lblResetPassword.setForeground(Color.BLACK);
		lblResetPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResetPassword.setBounds(134, 318, 130, 21);
		panel.add(lblResetPassword);
		
		PasswordConfirm = new JPasswordField();
		PasswordConfirm.setBounds(322, 300, 306, 38);
		panel.add(PasswordConfirm);
		
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
		lblNewPassword.setBounds(133, 247, 102, 21);
		panel.add(lblNewPassword);
		
		newPassword = new JPasswordField();
		newPassword.setBounds(322, 230, 306, 38);
		panel.add(newPassword);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDAOImpl user = new UserDAOImpl();
				Integer id =  user.getIdFromDbByAccount(Authorization.email);
				StringBuilder s = new StringBuilder();
				boolean pass = BCrypt.checkpw(textPassword.getText(), user.getPassFromDbByAccount(Authorization.email));
				boolean checkPassword= Register.checkRegexRegister(RegexPattern.PASSWORD, newPassword, s,"password");
				boolean checkPasswordConfirm= Register.checkPasswordConfirm( newPassword,PasswordConfirm, s);
				if((checkPassword&&checkPasswordConfirm&&pass) != true) {
					JOptionPane.showMessageDialog(null, "vui lòng kiểm tra lại dữ liệu!!");
				}else {
					User newU = new User(id,Authorization.email,newPassword.getText(),Authorization.loggedrole);
					user.updatePassword(newU);
					JOptionPane.showMessageDialog(null, "Đã cập nhật thành công");
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(67, 98, 190));
		btnUpdate.setBounds(322, 384, 150, 44);
		panel.add(btnUpdate);
		
	}
}
