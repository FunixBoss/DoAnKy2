package update;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.User;

public class FrameMember extends JFrame {
	

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textDob;
	private JPasswordField passwordFieldPassword;
	private JPasswordField passwordResetPassword;
	private JTextField textFullname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user = new User();
					FrameMember frame = new FrameMember(user);
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
	public FrameMember(User user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sửa thành viên");
		lblNewLabel.setForeground(new Color(37, 57, 111));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 219, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(32, 103, 102, 21);
		contentPane.add(lblEmail);
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 869, 62);
		contentPane.add(panel);
		
		textEmail = new JTextField();
		textEmail.setMargin(new Insets(2, 6, 2, 2));
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBackground(Color.WHITE);
		textEmail.setBounds(186, 94, 239, 38);
		contentPane.add(textEmail);
		textEmail.setText(user.getEmail());
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(32, 165, 102, 21);
		contentPane.add(lblPassword);
		
		JLabel lblResetPassword = new JLabel("Nhập lại mật khẩu");
		lblResetPassword.setForeground(Color.BLACK);
		lblResetPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblResetPassword.setBounds(32, 229, 130, 21);
		contentPane.add(lblResetPassword);
		
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhone.setBounds(466, 229, 102, 21);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setMargin(new Insets(2, 6, 2, 2));
		textPhone.setHorizontalAlignment(SwingConstants.LEFT);
		textPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		textPhone.setColumns(10);
		textPhone.setBackground(Color.WHITE);
		textPhone.setBounds(589, 221, 239, 38);
		contentPane.add(textPhone);
		textPhone.setText(user.getPhoneNumber());
		
		JLabel lblDob = new JLabel("Ngày sinh");
		lblDob.setForeground(Color.BLACK);
		lblDob.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDob.setBounds(466, 164, 102, 21);
		contentPane.add(lblDob);
		
		
		textDob = new JTextField();
		textDob.setMargin(new Insets(2, 6, 2, 2));
		textDob.setHorizontalAlignment(SwingConstants.LEFT);
		textDob.setFont(new Font("Arial", Font.PLAIN, 14));
		textDob.setColumns(10);
		textDob.setBackground(Color.WHITE);
		textDob.setBounds(589, 155, 239, 38);
		contentPane.add(textDob);
		textDob.setText(user.getDateOfBirth() != null ? user.getDateOfBirth().toString() : null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		btnAdd.setBounds(275, 308, 150, 44);
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
		btnReset.setBounds(466, 308, 150, 44);
		contentPane.add(btnReset);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(186, 156, 239, 38);
		contentPane.add(passwordFieldPassword);
		
		passwordResetPassword = new JPasswordField();
		passwordResetPassword.setBounds(186, 220, 239, 38);
		contentPane.add(passwordResetPassword);
		
		JLabel lblFullname = new JLabel("Họ và tên");
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFullname.setBounds(466, 103, 102, 21);
		contentPane.add(lblFullname);
		
		textFullname = new JTextField();
		textFullname.setMargin(new Insets(2, 6, 2, 2));
		textFullname.setHorizontalAlignment(SwingConstants.LEFT);
		textFullname.setFont(new Font("Arial", Font.PLAIN, 14));
		textFullname.setColumns(10);
		textFullname.setBackground(Color.WHITE);
		textFullname.setBounds(589, 94, 239, 38);
		contentPane.add(textFullname);
		textFullname.setText(user.getFullname());
	}

	protected void do_btnReset_actionPerformed(ActionEvent e) {
		textEmail.setText("");
		textPhone.setText("");
		textDob.setText("");
		textFullname.setText("");
		passwordFieldPassword.setText(""); 
		passwordResetPassword.setText("");
	}
}
