package insert;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMember extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textDob;
	private JTextField txtLevel;
	private JPasswordField passwordFieldPassword;
	private JPasswordField passwordResetPassword;


	/**
	 * Create the frame.
	 */
	public FrameMember() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm thành viên");
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
		lblPhone.setBounds(466, 102, 102, 21);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setMargin(new Insets(2, 6, 2, 2));
		textPhone.setHorizontalAlignment(SwingConstants.LEFT);
		textPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		textPhone.setColumns(10);
		textPhone.setBackground(Color.WHITE);
		textPhone.setBounds(589, 93, 239, 38);
		contentPane.add(textPhone);
		
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
		
		JLabel lblLevel = new JLabel("Chức vụ");
		lblLevel.setForeground(Color.BLACK);
		lblLevel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLevel.setBounds(466, 228, 102, 21);
		contentPane.add(lblLevel);
		
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
		
		txtLevel = new JTextField();
		txtLevel.setEditable(false);
		txtLevel.setText("Thành viên");
		txtLevel.setMargin(new Insets(2, 6, 2, 2));
		txtLevel.setHorizontalAlignment(SwingConstants.LEFT);
		txtLevel.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLevel.setColumns(10);
		txtLevel.setBackground(Color.WHITE);
		txtLevel.setBounds(589, 220, 239, 38);
		contentPane.add(txtLevel);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(186, 156, 239, 38);
		contentPane.add(passwordFieldPassword);
		
		passwordResetPassword = new JPasswordField();
		passwordResetPassword.setBounds(186, 220, 239, 38);
		contentPane.add(passwordResetPassword);
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		textEmail.setText("");
		textPhone.setText("");
		textDob.setText("");
		passwordFieldPassword.setText(""); 
		passwordResetPassword.setText("");
	}
}
