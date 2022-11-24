package home.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import img.IconImage;
import javax.swing.SwingConstants;

public class PanelProfileBar extends JPanel {

	private JPanel panelDashboard;
	private JLabel lblDashboard;
	private JPanel panelVocab;
	private JLabel lblVocab;
	private JPanel panelCategory;
	private JLabel lblCategory;
	private JPanel panelMember;
	private JLabel lblMember;
	private JPanel panelAdmin;
	private JLabel lblAdmin;

	/**
	 * Create the panel.
	 */
	public PanelProfileBar() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 240, 691);
		
		// Icon Image
		IconImage icon = new IconImage();
		
		// Logo Panel
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		panelLogo.setLayout(null);
		panelLogo.setBounds(0, 0, 217, 78);
		add(panelLogo);
		JLabel lblLogo = new JLabel("Thông tin cá nhân");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(new Color(37, 57, 111));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogo.setBounds(0, 0, 217, 78);
		panelLogo.add(lblLogo);
		
		// Home Panel
		JPanel panelHome = new JPanel();
		panelHome.setLayout(null);
		panelHome.setBackground(Color.WHITE);
		panelHome.setBounds(0, 78, 217, 70);
		add(panelHome);
		JLabel lblHome = new JLabel("Trang chủ");
		lblHome.setForeground(new Color(37, 57, 143));
		lblHome.setFont(new Font("Arial", Font.BOLD, 16));
		lblHome.setBounds(78, 25, 129, 20);
		panelHome.add(lblHome);
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setBounds(30, 18, 46, 29);
		panelHome.add(lblIconHome);
		lblIconHome.setIcon(new ImageIcon(icon.getHomeImg()));
		
		// Dashboard Panel
		panelDashboard = new JPanel();
		panelDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelDashboard_mouseClicked(e);
			}
		});
		panelDashboard.setBorder(null);
		panelDashboard.setLayout(null);
		panelDashboard.setBackground(new Color(37, 57, 111));
		panelDashboard.setBounds(0, 148, 217, 70);
		add(panelDashboard);
		lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 16));
		lblDashboard.setBounds(78, 25, 94, 20);
		panelDashboard.add(lblDashboard);
		JLabel lblIconDashboard = new JLabel("");
		lblIconDashboard.setBounds(30, 18, 46, 29);
		panelDashboard.add(lblIconDashboard);
		lblIconDashboard.setIcon(new ImageIcon(icon.getDashboardImg()));
		
		// Vocab Panel
		panelVocab = new JPanel();
		panelVocab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelVocab_mouseClicked(e);
			}
		});
		panelVocab.setBackground(new Color(255, 255, 255));
		panelVocab.setBounds(0, 218, 217, 70);
		add(panelVocab);
		panelVocab.setLayout(null);
		JLabel lblIconVocab = new JLabel("");
		lblIconVocab.setBackground(new Color(255, 255, 255));
		lblIconVocab.setForeground(new Color(255, 255, 255));
		lblIconVocab.setBounds(30, 16, 29, 31);
		panelVocab.add(lblIconVocab);
		lblIconVocab.setIcon(new ImageIcon(icon.getVocabImg()));
		lblVocab = new JLabel("Từ vựng");
		lblVocab.setFont(new Font("Arial", Font.BOLD, 16));
		lblVocab.setForeground(new Color(37, 57, 143));
		lblVocab.setBounds(78, 25, 94, 20);
		panelVocab.add(lblVocab);
		
		// Category Panel
		panelCategory = new JPanel();
		panelCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelCategory_mouseClicked(e);
			}
		});
		panelCategory.setLayout(null);
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(0, 288, 217, 70);
		add(panelCategory);
		JLabel lblIconCategory = new JLabel("");
		lblIconCategory.setForeground(Color.WHITE);
		lblIconCategory.setBackground(Color.WHITE);
		lblIconCategory.setBounds(30, 16, 29, 31);
		panelCategory.add(lblIconCategory);
		lblIconCategory.setIcon(new ImageIcon(icon.getTopicImg()));
		lblCategory = new JLabel("Chủ đề");
		lblCategory.setForeground(new Color(37, 57, 143));
		lblCategory.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategory.setBounds(78, 25, 94, 20);
		panelCategory.add(lblCategory);
		
		
		// Member Panel
		panelMember = new JPanel();
		panelMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelMember_mouseClicked(e);
			}
		});
		panelMember.setBackground(new Color(255, 255, 255));
		panelMember.setBounds(0, 358, 217, 70);
		panelMember.setLayout(null);
		add(panelMember);
		lblMember = new JLabel("Thành viên");
		lblMember.setBounds(75, 25, 87, 19);
		panelMember.add(lblMember);
		lblMember.setForeground(new Color(37, 57, 111));
		lblMember.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lblIconMember = new JLabel("");
		lblIconMember.setBounds(30, 16, 35, 28);
		panelMember.add(lblIconMember);
		lblIconMember.setIcon(new ImageIcon(icon.getMemberImg()));
		

		// Admin Panel
		panelAdmin = new JPanel();
		panelAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelAdmin_mouseClicked(e);
			}
		});
		panelAdmin.setBackground(new Color(255, 255, 255));
		panelAdmin.setBounds(0, 427, 217, 70);
		panelAdmin.setLayout(null);
		add(panelAdmin);
		lblAdmin = new JLabel("Quản trị viên");
		lblAdmin.setForeground(new Color(37, 57, 143));
		lblAdmin.setFont(new Font("Arial", Font.BOLD, 16));
		lblAdmin.setBounds(78, 25, 128, 19);
		panelAdmin.add(lblAdmin);
		JLabel lblIconAdmin = new JLabel("");
		lblIconAdmin.setBounds(30, 16, 46, 24);
		panelAdmin.add(lblIconAdmin);
		lblIconAdmin.setIcon(new ImageIcon(icon.getAdminImg()));

	}
	public void menuChanged(JPanel panel, JLabel label) {
		lblVocab.setForeground(new Color(37, 57, 111));
		panelVocab.setBackground(new Color(255, 255, 255));
		lblMember.setForeground(new Color(37, 57, 111));
		panelMember.setBackground(new Color(255, 255, 255));
		lblAdmin.setForeground(new Color(37, 57, 111));
		panelAdmin.setBackground(new Color(255, 255, 255));
		lblDashboard.setForeground(new Color(37, 57, 111));
		panelDashboard.setBackground(new Color(255, 255, 255));
		lblCategory.setForeground(new Color(37, 57, 111));
		panelCategory.setBackground(new Color(255, 255, 255));
		label.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(37, 57, 111));
	}
	protected void do_panelDashboard_mouseClicked(MouseEvent e) {
	}
	protected void do_panelVocab_mouseClicked(MouseEvent e) {
	}
	protected void do_panelCategory_mouseClicked(MouseEvent e) {
	}
	protected void do_panelMember_mouseClicked(MouseEvent e) {
	}
	protected void do_panelAdmin_mouseClicked(MouseEvent e) {
	}

}
