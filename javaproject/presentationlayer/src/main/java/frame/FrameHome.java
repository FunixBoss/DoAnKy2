package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.impl.UserDAOImpl;
import entity.History;
import home.PanelBookmark;
import home.PanelCategory;
import home.PanelHistory;
import home.PanelHome;
import home.PanelVocab;
import service.Authorization;
import update.FrameUpdateMember;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameHome extends JFrame {
	public FrameSignIn frOut;
	public FrameSignIn frIn;
	public static String flag = "PanelVocab";
	private JPanel contentPane;
	private JTextField txtFieldSearch;
	private Image logoImg = new ImageIcon(getClass().getResource("/image/dictionary-icon.png")).getImage()
			.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image searchImg = new ImageIcon(getClass().getResource("/image/search.png")).getImage()
			.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	private JPanel panelMain;
	private PanelHome jpHome;
	private PanelCategory jpCategory;
	private PanelHistory jpHistory;
	private PanelVocab jpVocab;
	private PanelBookmark jpBookmark;
	private JPanel panelVocab;
	private JPanel panelCategory;
	private JPanel panelBookmark;
	private JPanel panelHistory;
	private JPanel fieldAuthor;
	private JLabel lblSignIn;
	private JLabel lblVocab;
	private JLabel lblBookmark;
	private JLabel lblHistory;
	private JLabel lblCategory;
	private JPanel btnLogout;
	private JLabel lblLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHome frame = new FrameHome();
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
	public FrameHome() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		setTitle("EV Dictionary");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FrameDashboard.class.getResource("/image/dictionary-icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1318, 816);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 1085, 77);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(37, 57, 111));
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(searchImg));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(67, 98, 190));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(450, 19, 35, 35);
		panel_1.add(btnNewButton);

		txtFieldSearch = new JTextField();
		txtFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtFieldSearchKeyReleased(e);
			}
		});
		txtFieldSearch.setMargin(new Insets(2, 10, 2, 2));
		txtFieldSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFieldSearch.setBorder(null);
		txtFieldSearch.setBounds(32, 18, 408, 36);
		panel_1.add(txtFieldSearch);
		txtFieldSearch.setColumns(10);

		panelVocab = new JPanel();
		panelVocab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelVocab_mouseClicked(e);
			}
		});
		panelVocab.setBackground(new Color(255, 255, 255));
		panelVocab.setBounds(527, 32, 93, 45);
		panel_1.add(panelVocab);
		panelVocab.setLayout(null);

		lblVocab = new JLabel("Từ vựng");
		lblVocab.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocab.setFont(new Font("Arial", Font.BOLD, 14));
		lblVocab.setBounds(10, 11, 73, 23);
		panelVocab.add(lblVocab);

		panelCategory = new JPanel();
		panelCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelCategory_mouseClicked(e);
			}
		});
		panelCategory.setLayout(null);
		panelCategory.setBackground(Color.WHITE);
		panelCategory.setBounds(618, 32, 93, 45);
		panel_1.add(panelCategory);

		lblCategory = new JLabel("Chủ đề");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(10, 11, 73, 23);
		panelCategory.add(lblCategory);

		panelBookmark = new JPanel();
		panelBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelBookmark_mouseClicked(e);
			}
		});
		panelBookmark.setLayout(null);
		panelBookmark.setBackground(Color.WHITE);
		panelBookmark.setBounds(802, 32, 93, 45);
		panel_1.add(panelBookmark);

		lblBookmark = new JLabel("Ưu thích");
		lblBookmark.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookmark.setFont(new Font("Arial", Font.BOLD, 14));
		lblBookmark.setBounds(10, 11, 73, 23);
		panelBookmark.add(lblBookmark);

		if (Authorization.email == null) {
			lblSignIn = new JLabel("Đăng nhập");

		} else {
			lblSignIn = new JLabel("Thông Tin");
		}
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignIn.setBounds(6, 11, 83, 23);
		
				panelHistory = new JPanel();
				panelHistory.setBounds(710, 32, 93, 45);
				panel_1.add(panelHistory);
				panelHistory.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						do_panelHistory_mouseClicked(e);
					}
				});
				panelHistory.setLayout(null);
				panelHistory.setBackground(Color.WHITE);
				
						lblHistory = new JLabel("Lịch sử");
						lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
						lblHistory.setFont(new Font("Arial", Font.BOLD, 14));
						lblHistory.setBounds(10, 11, 73, 23);
						panelHistory.add(lblHistory);
						
								fieldAuthor = new JPanel();
								fieldAuthor.setBounds(893, 32, 93, 45);
								panel_1.add(fieldAuthor);
								fieldAuthor.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										if (Authorization.email == null) {
											do_panelLogIn_mouseClicked(e);
										} else {
											do_panelLogOut_mouseClicked(e);
										}
									}
								});
								fieldAuthor.setLayout(null);
								fieldAuthor.setBackground(Color.WHITE);
								fieldAuthor.add(lblSignIn);
								
								btnLogout = new JPanel();
								btnLogout.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										btnLogoutMouseClicked(e);
									}
								});
								btnLogout.setBounds(982, 32, 93, 45);
								if(Authorization.email!=null) {
									panel_1.add(btnLogout);
								}
								btnLogout.setLayout(null);
								btnLogout.setBackground(Color.WHITE);
								
								lblLogout = new JLabel("Đăng Xuất");
								lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
								lblLogout.setFont(new Font("Arial", Font.BOLD, 14));
								lblLogout.setBounds(10, 11, 73, 23);
								btnLogout.add(lblLogout);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 57, 111));
		panel.setBounds(0, 0, 217, 77);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelLogo = new JPanel();
		panelLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelLogo_mouseClicked(e);
			}
		});
		panelLogo.setBackground(new Color(37, 57, 111));
		panelLogo.setLayout(null);
		panelLogo.setBounds(0, 0, 217, 77);
		panel.add(panelLogo);

		JLabel lblLogo = new JLabel("EV Dictionary");
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogo.setBackground(new Color(255, 255, 255));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogo.setBounds(80, 16, 134, 39);
		panelLogo.add(lblLogo);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(20, 12, 55, 50);
		panelLogo.add(lblIconLogo);
		lblIconLogo.setBackground(new Color(0, 0, 0));
		lblIconLogo.setIcon(new ImageIcon(logoImg));

		jpHome = new PanelHome();
		jpHome.setBackground(new Color(37, 57, 111));
		jpCategory = new PanelCategory();
		jpHistory = new PanelHistory();
		jpVocab = new PanelVocab();
		jpBookmark = new PanelBookmark();

		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBounds(0, 77, 1302, 702);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		panelMain.add(jpHome);
		panelMain.add(jpCategory);
		panelMain.add(jpHistory);
		panelMain.add(jpBookmark);
		panelMain.add(jpVocab);
		menuClicked(jpHome);
	}

	public void menuClicked(JPanel panel) {
		if (panel.getClass().getName().equals("home.PanelHistory")) {
			flag = "PanelHistory";
			jpHistory.initConstructor();
		} else if (panel.getClass().getName().equals("home.PanelCategory")) {
			flag = "PanelCategory";
			jpCategory.initConstructor();
		} else if (panel.getClass().getName().equals("home.PanelVocab")) {
			flag = "PanelVocab";
			jpVocab.initConstructor();
		} else if (panel.getClass().getName().equals("home.PanelBookmark")) {
			flag = "PanelBookmark";
			jpBookmark.initConstructor();
		}
		jpHistory.setVisible(false);
		jpVocab.setVisible(false);
		jpCategory.setVisible(false);
		jpBookmark.setVisible(false);
		jpHome.setVisible(false);

		panel.setVisible(true);
	}

	public void menuChanged(JPanel panel, JLabel label) {
		lblVocab.setForeground(new Color(37, 57, 111));
		panelVocab.setBackground(new Color(255, 255, 255));
		lblHistory.setForeground(new Color(37, 57, 111));
		panelHistory.setBackground(new Color(255, 255, 255));
		lblCategory.setForeground(new Color(37, 57, 111));
		panelCategory.setBackground(new Color(255, 255, 255));
		lblBookmark.setForeground(new Color(37, 57, 111));
		panelBookmark.setBackground(new Color(255, 255, 255));
		label.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(37, 57, 111));

	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {

	}

	protected void do_panelLogo_mouseClicked(MouseEvent e) {
		if(Authorization.loggedrole == 2) {
			dispose();
			FrameHome dh = new FrameHome();
			dh.setVisible(true);
		}else {
			dispose();
			FrameDashboard dh = new FrameDashboard();
			dh.setVisible(true);
		}
	}

	protected void do_panelVocab_mouseClicked(MouseEvent e) {
		menuClicked(jpVocab);
		menuChanged(panelVocab, lblVocab);
	}

	protected void do_panelCategory_mouseClicked(MouseEvent e) {
		menuClicked(jpCategory);
		menuChanged(panelCategory, lblCategory);
	}

	protected void do_panelBookmark_mouseClicked(MouseEvent e) {
		menuClicked(jpBookmark);
		menuChanged(panelBookmark, lblBookmark);
	}

	protected void do_panelHistory_mouseClicked(MouseEvent e) {
		menuClicked(jpHistory);
		menuChanged(panelHistory, lblHistory);
	}

	protected void do_panelLogIn_mouseClicked(MouseEvent e) {
		dispose();
		frIn = new FrameSignIn();
		frIn.setVisible(true);
		frIn.setLocation(400, 300);
	}

	protected void do_panelLogOut_mouseClicked(MouseEvent e) {
		if(Authorization.email != null) {
			UserDAOImpl userDao = new UserDAOImpl();
			int id = UserDAOImpl.getIdFromDbByAccount(Authorization.email);
			FrameUpdateMember updateMem = new FrameUpdateMember(userDao.select(id));
			updateMem.setVisible(true);
		}else {
			FrameSignIn login = new FrameSignIn();
			login.setVisible(true);
		}
	}

	protected void txtFieldSearchKeyReleased(KeyEvent e) {
		if (flag == "PanelVocab") {
			jpVocab.initConstructor(txtFieldSearch.getText());
		}

	}
	protected void btnLogoutMouseClicked(MouseEvent e) {
		dispose();
		dispose();
		Authorization.setNull();
		frOut = new FrameSignIn();
		frOut.setLocation(400, 300);
		frOut.setVisible(true);
	}
}
