package home.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import img.IconImage;
import service.Register;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class FrameSignUp extends JFrame {

	private JPanel contentPane;
	private JPasswordField textFieldPasswordConfirm;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;
	private JComponent panelMain;
	private JComponent panelResetPassword;
	private JButton btnSignUp;
	private JButton btnSignIn;
	private IconImage icon;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSignUp frame = new FrameSignUp();
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
	public FrameSignUp() {
		initComponent();
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acction_SignUp(e);
			}
		});
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSignIn_actionPerformed(e);
			}
		});
		textFieldPasswordConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				StringBuilder s = new StringBuilder();
				Register.checkPasswordConfirm(textFieldPassword, textFieldPasswordConfirm, s);
			}
		});
		
		
	}
	private void initComponent() {
		setResizable(false);
		setTitle("Đăng ký");
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 247, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		icon = new IconImage();
		
		// Panel 
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(37, 57, 111));
		panel.setBounds(0, 0, 415, 532);
		contentPane.add(panel);
		
		// Panel Main
		panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBounds(427, 0, 415, 532);
		contentPane.add(panelMain);
		JLabel lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 22));
		lblSignUp.setBounds(137, 45, 131, 32);
		panelMain.add(lblSignUp);
		
		// Email
		JPanel panelEmail = new JPanel();
		panelEmail.setLayout(null);
		panelEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEmail.setBackground(new Color(242, 247, 255));
		panelEmail.setBounds(52, 133, 314, 45);
		panelMain.add(panelEmail);
		
		JLabel lblIconEmail = new JLabel("");
		lblIconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmail.setBounds(269, 0, 45, 45);
		panelEmail.add(lblIconEmail);
		lblIconEmail.setIcon(new ImageIcon(icon.getEmailImg()));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setCaretColor(Color.BLACK);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(Color.WHITE);
		textFieldEmail.setBounds(1, 1, 267, 43);
		panelEmail.add(textFieldEmail);
		
		// Password
		JPanel panelPassword = new JPanel();
		panelPassword.setLayout(null);
		panelPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelPassword.setBackground(new Color(242, 247, 255));
		panelPassword.setBounds(52, 217, 314, 45);
		panelMain.add(panelPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBackground(new Color(242, 247, 255));
		lblIconPassword.setBounds(270, 0, 44, 45);
		panelPassword.add(lblIconPassword);
		lblIconPassword.setIcon(new ImageIcon(icon.getPasswordImg()));
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBorder(null);
		textFieldPassword.setBounds(1, 1, 267, 43);
		panelPassword.add(textFieldPassword);
		
		// Reset Password
		panelResetPassword = new JPanel();
		panelResetPassword.setLayout(null);
		panelResetPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelResetPassword.setBackground(new Color(242, 247, 255));
		panelResetPassword.setBounds(52, 306, 314, 45);
		panelMain.add(panelResetPassword);
		
		JLabel lblIconResetPassword = new JLabel("");
		lblIconResetPassword.setBackground(new Color(242, 247, 255));
		lblIconResetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconResetPassword.setBounds(270, 0, 44, 45);
		panelResetPassword.add(lblIconResetPassword);
		lblIconResetPassword.setIcon(new ImageIcon(icon.getPasswordImg()));
		
		textFieldPasswordConfirm = new JPasswordField();
		textFieldPasswordConfirm.setBorder(null);
		textFieldPasswordConfirm.setBounds(1, 1, 267, 43);
		panelResetPassword.add(textFieldPasswordConfirm);
		
		// btn Sign Up
		btnSignUp = new JButton("Đăng ký");
		btnSignUp.setBounds(52, 393, 314, 44);
		panelMain.add(btnSignUp);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
		btnSignUp.setBackground(new Color(37, 57, 111));
		
		JLabel lblText = new JLabel("Đã có tài khoản?");
		lblText.setBounds(108, 501, 117, 21);
		panelMain.add(lblText);
		lblText.setFont(new Font("Arial", Font.PLAIN, 14));
		
		// btn Sign In
		btnSignIn = new JButton("Đăng nhập");
		btnSignIn.setBounds(226, 500, 92, 23);
		panelMain.add(btnSignIn);
		btnSignIn.setForeground(new Color(37, 57, 111));
		btnSignIn.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignIn.setBorder(null);
		btnSignIn.setBackground(Color.WHITE);
		
		
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
				User user = new User(email, password, User.USER_ROLE);
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
	}
}
