package frame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import panel.PanelAdmin;
import panel.PanelCategory;
import panel.PanelDashboard;
import panel.PanelMember;
import panel.PanelVocab;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrameDashboard extends JFrame {

	private JPanel contentPane;
	private Image logoImg = new ImageIcon(getClass().getResource("/image/dictionary-icon.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image memberImg = new ImageIcon(getClass().getResource("/image/member.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image adminImg = new ImageIcon(getClass().getResource("/image/admin.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image vocabImg = new ImageIcon(getClass().getResource("/image/vocab.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image homeImg = new ImageIcon(getClass().getResource("/image/home.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image dashboardImg = new ImageIcon(getClass().getResource("/image/dashboard.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
	private Image topicImg = new ImageIcon(getClass().getResource("/image/topic.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
	private PanelMember jpMember;
	private PanelVocab jpVocab;
	private PanelAdmin jpAdmin;
	private JLabel lblMember;
	private JLabel lblAdmin;
	private JPanel panelAdmin;
	private JPanel panelMember;
	private JLabel lblVocab;
	private JPanel panelVocab;
	private PanelDashboard jpDashboard;
	private JLabel lblDashboard;
	private JPanel panelDashboard;
	private PanelCategory jpCategory;
	private JLabel lblCategory;
	private JPanel panelCategory;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDashboard frame = new FrameDashboard();
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
	public FrameDashboard() {
		setResizable(false);
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameDashboard.class.getResource("/image/dictionary-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1318, 816);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpMember = new PanelMember();
		jpVocab = new PanelVocab();
		jpAdmin = new PanelAdmin();
		jpDashboard = new PanelDashboard();
		jpDashboard.setBounds(0, 0, 1085, 729);
		jpCategory = new PanelCategory();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 217, 777);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panelVocab = new JPanel();
		panelVocab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelVocab_mouseClicked(e);
			}
		});
		panelVocab.setBackground(new Color(255, 255, 255));
		panelVocab.setBounds(0, 218, 217, 70);
		panel.add(panelVocab);
		panelVocab.setLayout(null);
		
		JLabel lblIconVocab = new JLabel("");
		lblIconVocab.setBackground(new Color(255, 255, 255));
		lblIconVocab.setForeground(new Color(255, 255, 255));
		lblIconVocab.setBounds(30, 16, 29, 31);
		panelVocab.add(lblIconVocab);
		lblIconVocab.setIcon(new ImageIcon(vocabImg));
		
		lblVocab = new JLabel("Từ vựng");
		lblVocab.setFont(new Font("Arial", Font.BOLD, 16));
		lblVocab.setForeground(new Color(37, 57, 143));
		lblVocab.setBounds(78, 25, 94, 20);
		panelVocab.add(lblVocab);
		
		panelMember = new JPanel();
		panelMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelMember_mouseClicked(e);
			}
		});
		panelMember.setBackground(new Color(255, 255, 255));
		panelMember.setBounds(0, 358, 217, 70);
		panel.add(panelMember);
		panelMember.setLayout(null);
		
		lblMember = new JLabel("Thành viên");
		lblMember.setBounds(75, 25, 87, 19);
		panelMember.add(lblMember);
		lblMember.setForeground(new Color(37, 57, 111));
		lblMember.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblIconMember = new JLabel("");
		lblIconMember.setBounds(30, 16, 35, 28);
		panelMember.add(lblIconMember);
		lblIconMember.setIcon(new ImageIcon(memberImg));
		
		panelAdmin = new JPanel();
		panelAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelAdmin_mouseClicked(e);
			}
		});
		panelAdmin.setBackground(new Color(255, 255, 255));
		panelAdmin.setBounds(0, 427, 217, 70);
		panel.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		lblAdmin = new JLabel("Quản trị viên");
		lblAdmin.setForeground(new Color(37, 57, 143));
		lblAdmin.setFont(new Font("Arial", Font.BOLD, 16));
		lblAdmin.setBounds(78, 25, 128, 19);
		panelAdmin.add(lblAdmin);
		
		JLabel lblIconAdmin = new JLabel("");
		lblIconAdmin.setBounds(30, 16, 46, 24);
		panelAdmin.add(lblIconAdmin);
		lblIconAdmin.setIcon(new ImageIcon(adminImg));
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(255, 255, 255));
		panelLogo.setLayout(null);
		panelLogo.setBounds(0, 0, 217, 78);
		panel.add(panelLogo);
		
		JLabel lblLogo = new JLabel("EV Dictionary");
		lblLogo.setForeground(new Color(37, 57, 111));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogo.setBounds(73, 16, 134, 39);
		panelLogo.add(lblLogo);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(20, 11, 55, 50);
		panelLogo.add(lblIconLogo);
		lblIconLogo.setBackground(new Color(0, 0, 0));
		lblIconLogo.setIcon(new ImageIcon(logoImg));
		
		panelDashboard = new JPanel();
		panelDashboard.setBorder(null);
		panelDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelDashboard_mouseClicked(e);
			}
		});
		panelDashboard.setLayout(null);
		panelDashboard.setBackground(new Color(37, 57, 111));
		panelDashboard.setBounds(0, 148, 217, 70);
		panel.add(panelDashboard);
		
		lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 16));
		lblDashboard.setBounds(78, 25, 94, 20);
		panelDashboard.add(lblDashboard);
		
		JLabel lblIconDashboard = new JLabel("");
		lblIconDashboard.setBounds(30, 18, 46, 29);
		panelDashboard.add(lblIconDashboard);
		lblIconDashboard.setIcon(new ImageIcon(dashboardImg));
		
		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelHome_mouseClicked(e);
			}
		});
		panelHome.setLayout(null);
		panelHome.setBackground(Color.WHITE);
		panelHome.setBounds(0, 78, 217, 70);
		panel.add(panelHome);
		
		JLabel lblHome = new JLabel("Trang chủ");
		lblHome.setForeground(new Color(37, 57, 143));
		lblHome.setFont(new Font("Arial", Font.BOLD, 16));
		lblHome.setBounds(78, 25, 129, 20);
		panelHome.add(lblHome);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setBounds(30, 18, 46, 29);
		panelHome.add(lblIconHome);
		lblIconHome.setIcon(new ImageIcon(homeImg));
		panelCategory = new JPanel();
		panelCategory.setLayout(null);
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(0, 288, 217, 70);
		panelCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelCategory_mouseClicked(e);
			}
		});
		panel.add(panelCategory);
		
		JLabel lblIconCategory = new JLabel("");
		lblIconCategory.setForeground(Color.WHITE);
		lblIconCategory.setBackground(Color.WHITE);
		lblIconCategory.setBounds(30, 16, 29, 31);
		panelCategory.add(lblIconCategory);
		lblIconCategory.setIcon(new ImageIcon(topicImg));
		
		lblCategory = new JLabel("Chủ đề");
		lblCategory.setForeground(new Color(37, 57, 143));
		lblCategory.setFont(new Font("Arial", Font.BOLD, 16));
		lblCategory.setBounds(78, 25, 94, 20);
		panelCategory.add(lblCategory);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(242, 247, 255));
		panelMain.setBounds(217, 50, 1085, 729);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		panelMain.add(jpAdmin);
		
		panelMain.add(jpAdmin);
		panelMain.add(jpMember);
		panelMain.add(jpVocab);
		panelMain.add(jpDashboard);
		panelMain.add(jpCategory);
		menuClicked(jpDashboard);
		
		JLabel lblBreadcrumb = new JLabel("Trang chủ /");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(908, 88, 134, 14);
		panelMain.add(lblBreadcrumb);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 1085, 50);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(242, 247, 255));
		panel_1.setLayout(null);
		
	}
	public void menuClicked(JPanel panel) {
		jpMember.setVisible(false);
		jpVocab.setVisible(false);
		jpAdmin.setVisible(false);
		jpCategory.setVisible(false);
		jpDashboard.setVisible(false);
		panel.setVisible(true);
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
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
	}
	protected void do_panelVocab_mouseClicked(MouseEvent e) {
		menuClicked(jpVocab);
		menuChanged(panelVocab,lblVocab);
	}
	
	protected void do_panelMember_mouseClicked(MouseEvent e) {
		menuClicked(jpMember);	
		menuChanged(panelMember,lblMember);
	}
	protected void do_panelAdmin_mouseClicked(MouseEvent e) {
		menuClicked(jpAdmin);	
		menuChanged(panelAdmin,lblAdmin);
	}
	protected void do_panelDashboard_mouseClicked(MouseEvent e) {
		menuClicked(jpDashboard);	
		menuChanged(panelDashboard,lblDashboard);
	}
	protected void do_panelHome_mouseClicked(MouseEvent e) {
		FrameDashboard fr = new FrameDashboard();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameHome frame = new FrameHome();
		frame.setVisible(true);
	}
	protected void do_panelCategory_mouseClicked(MouseEvent e) {
		menuClicked(jpCategory);
		menuChanged(panelCategory,lblCategory);
	}
}
