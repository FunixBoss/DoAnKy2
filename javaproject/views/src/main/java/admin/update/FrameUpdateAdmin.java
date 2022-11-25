package admin.update;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.User;
import helper.ErrorMessage;
import helper.FrameUtils;
import service.UserService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class FrameUpdateAdmin extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	
	private JPasswordField passwordFieldPassword;
	private JLabel lblAddMember;
	private JLabel lblEmail;
	private JLabel lblPassword ;
	private JLabel lblLevel;
	private JTextField textEmail;
	private JTextField txtLevel;
	private JButton btnUpdate;	
	
	private static User user;
	private UserService userService;
	private Map<String, String> data;
	private static FrameUpdateMember myInstance;
	
	public static FrameUpdateMember getMyInstance(User user) {
		if (myInstance == null) {
			myInstance = new FrameUpdateMember(user);
		}
		return myInstance;
	}
	
	public FrameUpdateAdmin(User user) {
		initComponent(); 
		FrameUtils.alignFrameScreenCenter(this);
		
		this.user = user;
		userService = new UserService();
		textEmail.setText(user.getEmail());
	}
	

	
	private void initComponent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 390);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddMember = new JLabel("Sửa thông tin thành viên");
		lblAddMember.setForeground(new Color(37, 57, 111));
		lblAddMember.setFont(new Font("Arial", Font.BOLD, 20));
		lblAddMember.setBounds(20, 11, 219, 34);
		contentPane.add(lblAddMember);
		
//		EMAIL
		lblEmail = new JLabel("Email ");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(32, 103, 102, 21);
		contentPane.add(lblEmail);
		panel.setBackground(new Color(242, 247, 255));
		panel.setBounds(0, 0, 869, 62);
		contentPane.add(panel);
		
		textEmail = new JTextField();
		textEmail.setFocusTraversalPolicyProvider(true);
		textEmail.setMargin(new Insets(2, 6, 2, 2));
		textEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBackground(Color.WHITE);
		textEmail.setBounds(186, 94, 239, 38);
		textEmail.setEditable(false);;
		contentPane.add(textEmail);
		
//		PASSWORD
		lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(32, 165, 102, 21);
		contentPane.add(lblPassword);
		
//		LEVEL
		lblLevel = new JLabel("Chức vụ");
		lblLevel.setForeground(Color.BLACK);
		lblLevel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLevel.setBounds(32, 229, 102, 21);
		contentPane.add(lblLevel);
		
		
		
		btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e, user.getId());
			}
		});
		btnUpdate.setBackground(new Color(67, 98, 190));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdate.setBounds(362, 284, 150, 44);
		contentPane.add(btnUpdate);
		
		txtLevel = new JTextField();
		txtLevel.setEditable(false);
		txtLevel.setText("Quản trị viên");
		txtLevel.setMargin(new Insets(2, 6, 2, 2));
		txtLevel.setHorizontalAlignment(SwingConstants.LEFT);
		txtLevel.setFont(new Font("Arial", Font.PLAIN, 14));
		txtLevel.setColumns(10);
		txtLevel.setBackground(Color.WHITE);
		txtLevel.setBounds(186, 221, 239, 38);
		contentPane.add(txtLevel);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(186, 156, 239, 38);
		contentPane.add(passwordFieldPassword);
	}
	protected void btnUpdateActionPerformed(ActionEvent e, Integer userId) {
		data = new HashMap<>();
		data.put("id", Integer.toString(userId));
		data.put("password", new String(passwordFieldPassword.getPassword()));
		data.put("level", "2");
		
		if(userService.update(data)) {
			JOptionPane.showMessageDialog(this, "Cập nhật quản trị viên thành công");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, ErrorMessage.ERROR_MESSAGES);
		}
		
	}
}
