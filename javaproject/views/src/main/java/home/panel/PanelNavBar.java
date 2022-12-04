package home.panel;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

import service.Authorization;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelNavBar extends JPanel {
	private JPanel panelVocab;
	private JLabel lblVocab;
	private JPanel panelCategory;
	private JLabel lblCategory;
	private JPanel panelProfile;
	private JLabel lblProfile;
	private JPanel panelLesson;
	private JLabel lblLesson;
	private JLabel lblHome;
	private JPanel panelHome;
	private JPanel panelSignUp;
	private JLabel lblSignUp;
	private JPanel panelSignIn;
	private JLabel lblSignIn;
	private JLabel lblLogOut;
	private JPanel panelLogOut;
	public JPanel getPanelVocab() {
		return panelVocab;
	}
	public void setPanelVocab(JPanel panelVocab) {
		this.panelVocab = panelVocab;
	}
	public JLabel getLblVocab() {
		return lblVocab;
	}
	public void setLblVocab(JLabel lblVocab) {
		this.lblVocab = lblVocab;
	}
	public JPanel getPanelCategory() {
		return panelCategory;
	}
	public void setPanelCategory(JPanel panelCategory) {
		this.panelCategory = panelCategory;
	}
	public JLabel getLblCategory() {
		return lblCategory;
	}
	public void setLblCategory(JLabel lblCategory) {
		this.lblCategory = lblCategory;
	}
	public JPanel getPanelProfile() {
		return panelProfile;
	}
	public void setPanelProfile(JPanel panelProfile) {
		this.panelProfile = panelProfile;
	}
	public JLabel getLblProfile() {
		return lblProfile;
	}
	public void setLblProfile(JLabel lblProfile) {
		this.lblProfile = lblProfile;
	}
	public JPanel getPanelLesson() {
		return panelLesson;
	}
	public void setPanelLesson(JPanel panelLesson) {
		this.panelLesson = panelLesson;
	}
	public JLabel getLblLesson() {
		return lblLesson;
	}
	public void setLblLesson(JLabel lblLesson) {
		this.lblLesson = lblLesson;
	}
	public JLabel getLblHome() {
		return lblHome;
	}
	public void setLblHome(JLabel lblHome) {
		this.lblHome = lblHome;
	}
	public JPanel getPanelHome() {
		return panelHome;
	}
	public void setPanelHome(JPanel panelHome) {
		this.panelHome = panelHome;
	}
	public JPanel getPanelSignUp() {
		return panelSignUp;
	}
	public void setPanelSignUp(JPanel panelSignUp) {
		this.panelSignUp = panelSignUp;
	}
	public JLabel getLblSignUp() {
		return lblSignUp;
	}
	public void setLblSignUp(JLabel lblSignUp) {
		this.lblSignUp = lblSignUp;
	}
	public JPanel getPanelSignIn() {
		return panelSignIn;
	}
	public void setPanelSignIn(JPanel panelSignIn) {
		this.panelSignIn = panelSignIn;
	}
	public JLabel getLblSignIn() {
		return lblSignIn;
	}
	public void setLblSignIn(JLabel lblSignIn) {
		this.lblSignIn = lblSignIn;
	}
	public PanelNavBar() {
		initComponent();
			if (Authorization.email == null) {
				panelProfile.setVisible(false);
				panelLogOut.setVisible(false);
			} else {
				panelSignUp.setVisible(false);
				panelSignIn.setVisible(false);
			}
	}
	private void initComponent() {
		setBounds(0, 0, 1052, 77);
		setBackground(new Color(37, 57, 111));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(37, 57, 111));
		panel.setBounds(0, 0, 1052, 77);
		add(panel);
		
		// Vocab Panel
		panelVocab = new JPanel();
		panelVocab.setBorder(null);
		panelVocab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelVocab_mouseClicked(e);
			}
		});
		
		panelVocab.setLayout(null);
		panelVocab.setBackground(Color.WHITE);
		panelVocab.setBounds(469, 27, 115, 50);
		panel.add(panelVocab);
		
		lblVocab = new JLabel("Từ vựng");
		lblVocab.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocab.setFont(new Font("Arial", Font.BOLD, 14));
		lblVocab.setBounds(0, 0, 115, 50);
		panelVocab.add(lblVocab);
		
		// SignUp Panel
		panelSignUp = new JPanel();
		panelSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelSignUp_mouseClicked(e);
			}
		});
		panelSignUp.setLayout(null);
		panelSignUp.setBorder(null);
		panelSignUp.setBackground(Color.WHITE);
		panelSignUp.setBounds(927, 27, 115, 50);
		panel.add(panelSignUp);
		
		lblSignUp = new JLabel("Đăng ký");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignUp.setBounds(0, 0, 115, 50);
		panelSignUp.add(lblSignUp);
		
		// SingIn Panel
		panelSignIn = new JPanel();
		panelSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelSignIn_mouseClicked(e);
			}
		});
		panelSignIn.setLayout(null);
		panelSignIn.setBorder(null);
		panelSignIn.setBackground(Color.WHITE);
		panelSignIn.setBounds(812, 27, 115, 50);
		panel.add(panelSignIn);
		
		lblSignIn = new JLabel("Đăng nhập");
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignIn.setBounds(0, 0, 115, 50);
		panelSignIn.add(lblSignIn);
		
		// Category Panel
		panelCategory = new JPanel();
		panelCategory.setBorder(null);
		panelCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelCategory_mouseClicked(e);
			}
		});
		panelCategory.setLayout(null);
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(584, 27, 115, 50);
		panel.add(panelCategory);
		
		lblCategory = new JLabel("Chủ đề");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(0, 0, 115, 50);
		panelCategory.add(lblCategory);
		
		// Logout Panel
		panelLogOut = new JPanel();
		panelLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelLogOut_mouseClicked(e);
			}
		});
		panelLogOut.setLayout(null);
		panelLogOut.setBackground(Color.WHITE);
		panelLogOut.setBounds(926, 27, 115, 50);
		panel.add(panelLogOut);
		
		lblLogOut = new JLabel("Đăng xuất");
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogOut.setBounds(0, 0, 115, 50);
		panelLogOut.add(lblLogOut);
		
		// Lesson Panel
		panelLesson = new JPanel();
		panelLesson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelLesson_mouseClicked(e);
			}
		});
		panelLesson.setLayout(null);
		panelLesson.setBorder(null);
		panelLesson.setBackground(Color.WHITE);
		panelLesson.setBounds(697, 27, 115, 50);
		panel.add(panelLesson);
		
		lblLesson = new JLabel("Bài học");
		lblLesson.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesson.setFont(new Font("Arial", Font.BOLD, 14));
		lblLesson.setBounds(0, 0, 115, 50);
		panelLesson.add(lblLesson);
		
		// Profile Panel
		panelProfile = new JPanel();
		panelProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelProfile_mouseClicked(e);
			}
		});
		panelProfile.setLayout(null);
		panelProfile.setBorder(null);
		panelProfile.setBackground(Color.WHITE);
		panelProfile.setBounds(811, 27, 115, 50);
		panel.add(panelProfile);
		
		lblProfile = new JLabel("Thông tin");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Arial", Font.BOLD, 14));
		lblProfile.setBounds(0, 0, 115, 50);
		panelProfile.add(lblProfile);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelHome_mouseClicked(e);
			}
		});
		panelHome.setLayout(null);
		panelHome.setBorder(null);
		panelHome.setBackground(new Color(37, 57, 111));
		panelHome.setBounds(354, 27, 115, 50);
		panel.add(panelHome);
		
		lblHome = new JLabel("Trang chủ");
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Arial", Font.BOLD, 14));
		lblHome.setBounds(0, 0, 115, 50);
		panelHome.add(lblHome);
		
	}

	public void menuChanged(JPanel panel, JLabel label) {
		lblVocab.setForeground(new Color(37, 57, 111));
		panelVocab.setBackground(new Color(255, 255, 255));
		lblCategory.setForeground(new Color(37, 57, 111));
		panelCategory.setBackground(new Color(255, 255, 255));
		lblProfile.setForeground(new Color(37, 57, 111));
		panelProfile.setBackground(new Color(255, 255, 255));
		lblLesson.setForeground(new Color(37, 57, 111));
		panelLesson.setBackground(new Color(255, 255, 255));
		lblHome.setForeground(new Color(37, 57, 111));
		panelHome.setBackground(new Color(255, 255, 255));
		lblSignIn.setForeground(new Color(37, 57, 111));
		panelSignIn.setBackground(new Color(255, 255, 255));
		lblSignUp.setForeground(new Color(37, 57, 111));
		panelSignUp.setBackground(new Color(255, 255, 255));
		lblLogOut.setForeground(new Color(37, 57, 111));
		panelLogOut.setBackground(new Color(255, 255, 255));
		label.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(37, 57, 111));
	}
	
	protected void do_panelVocab_mouseClicked(MouseEvent e) {
		
	}
	protected void do_panelCategory_mouseClicked(MouseEvent e) {
	}
	protected void do_panelProfile_mouseClicked(MouseEvent e) {
	}
	protected void do_panelLesson_mouseClicked(MouseEvent e) {
	}
	protected void do_panelHome_mouseClicked(MouseEvent e) {
	}
	protected void do_panelSignUp_mouseClicked(MouseEvent e) {
	}
	protected void do_panelSignIn_mouseClicked(MouseEvent e) {
	}
	protected void do_panelLogOut_mouseClicked(MouseEvent e) {
	}
}
