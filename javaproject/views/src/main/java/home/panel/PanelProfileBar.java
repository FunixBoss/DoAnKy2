package home.panel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helper.IconImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelProfileBar extends JPanel {

	private JPanel panelGeneral;
	private JLabel lblGeneral;
	private JPanel panelVocab;
	private JLabel lblVocab;
	private JPanel panelBookmark;
	private JLabel lblBookmark;
	private JPanel panelHistory;
	private JLabel lblHistory;
	private JLabel lblFeedback;
	private JPanel panelFeedback;
	private JPanel panelMember;
	private JLabel lblMember;
	private JLabel lblIconLogOut;
	private JPanel panelLogOut;
	private JLabel lblLogOut;

	
	public JPanel getPanelGeneral() {
		return panelGeneral;
	}
	public void setPanelGeneral(JPanel panelGeneral) {
		this.panelGeneral = panelGeneral;
	}
	public JLabel getLblGeneral() {
		return lblGeneral;
	}
	public void setLblGeneral(JLabel lblGeneral) {
		this.lblGeneral = lblGeneral;
	}
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
	public JPanel getPanelBookmark() {
		return panelBookmark;
	}
	public void setPanelBookmark(JPanel panelBookmark) {
		this.panelBookmark = panelBookmark;
	}
	public JLabel getLblBookmark() {
		return lblBookmark;
	}
	public void setLblBookmark(JLabel lblBookmark) {
		this.lblBookmark = lblBookmark;
	}
	public JPanel getPanelHistory() {
		return panelHistory;
	}
	public void setPanelHistory(JPanel panelHistory) {
		this.panelHistory = panelHistory;
	}
	public JLabel getLblHistory() {
		return lblHistory;
	}
	public void setLblHistory(JLabel lblHistory) {
		this.lblHistory = lblHistory;
	}
	public JLabel getLblFeedback() {
		return lblFeedback;
	}
	public void setLblFeedback(JLabel lblFeedback) {
		this.lblFeedback = lblFeedback;
	}
	public JPanel getPanelFeedback() {
		return panelFeedback;
	}
	public void setPanelFeedback(JPanel panelFeedback) {
		this.panelFeedback = panelFeedback;
	}
	public JPanel getPanelMember() {
		return panelMember;
	}
	public void setPanelMember(JPanel panelMember) {
		this.panelMember = panelMember;
	}
	public JLabel getLblMember() {
		return lblMember;
	}
	public void setLblMember(JLabel lblMember) {
		this.lblMember = lblMember;
	}
	public JPanel getPanelLogOut() {
		return panelLogOut;
	}
	public void setPanelLogOut(JPanel panelLogOut) {
		this.panelLogOut = panelLogOut;
	}
	public JLabel getLblLogOut() {
		return lblLogOut;
	}
	public void setLblLogOut(JLabel lblLogOut) {
		this.lblLogOut = lblLogOut;
	}
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
		panelLogo.setBounds(0, 0, 240, 149);
		add(panelLogo);
		
		// Member Panel
		panelMember = new JPanel();
		panelMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelMember_mouseClicked(e);
			}
		});
		panelMember.setLayout(null);
		panelMember.setBackground(Color.WHITE);
		panelMember.setBounds(0, 219, 240, 70);
		add(panelMember);
		lblMember = new JLabel("Thông tin tài khoản");
		lblMember.setForeground(new Color(37, 57, 143));
		lblMember.setFont(new Font("Arial", Font.BOLD, 16));
		lblMember.setBounds(78, 25, 152, 20);
		panelMember.add(lblMember);
		JLabel lblIconMember = new JLabel("");
		lblIconMember.setBounds(30, 20, 46, 29);
		panelMember.add(lblIconMember);
		lblIconMember.setIcon(new ImageIcon(icon.getMemberImg()));
		
		// Vocab Panel
		panelVocab = new JPanel();
		panelVocab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelVocab_mouseClicked(e);
			}
		});
		panelVocab.setBackground(new Color(255, 255, 255));
		panelVocab.setBounds(0, 428, 240, 70);
		add(panelVocab);
		panelVocab.setLayout(null);
		JLabel lblIconVocab = new JLabel("");
		lblIconVocab.setBackground(new Color(255, 255, 255));
		lblIconVocab.setForeground(new Color(255, 255, 255));
		lblIconVocab.setBounds(30, 20, 29, 31);
		panelVocab.add(lblIconVocab);
		lblIconVocab.setIcon(new ImageIcon(icon.getVocabImg()));
		lblVocab = new JLabel("Góp ý từ vựng");
		lblVocab.setFont(new Font("Arial", Font.BOLD, 16));
		lblVocab.setForeground(new Color(37, 57, 143));
		lblVocab.setBounds(78, 25, 152, 20);
		panelVocab.add(lblVocab);
		
		// Bookmark Panel
		panelBookmark = new JPanel();
		panelBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelBookmark_mouseClicked(e);
			}
		});
		panelBookmark.setLayout(null);
		panelBookmark.setBackground(Color.WHITE);
		panelBookmark.setBounds(0, 288, 240, 70);
		add(panelBookmark);
		JLabel lblIconBookmark = new JLabel("");
		lblIconBookmark.setForeground(Color.WHITE);
		lblIconBookmark.setBackground(Color.WHITE);
		lblIconBookmark.setBounds(30, 20, 29, 31);
		panelBookmark.add(lblIconBookmark);
		lblIconBookmark.setIcon(new ImageIcon(icon.getBookmarkImg()));
		lblBookmark = new JLabel("Yêu thích");
		lblBookmark.setForeground(new Color(37, 57, 143));
		lblBookmark.setFont(new Font("Arial", Font.BOLD, 16));
		lblBookmark.setBounds(78, 25, 94, 20);
		panelBookmark.add(lblBookmark);
		
		
		// History Panel
		panelHistory = new JPanel();
		panelHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelHistory_mouseClicked(e);
			}
		});
		panelHistory.setBackground(new Color(255, 255, 255));
		panelHistory.setBounds(0, 358, 240, 70);
		panelHistory.setLayout(null);
		add(panelHistory);
		lblHistory = new JLabel("Lịch sử");
		lblHistory.setBounds(78, 25, 87, 19);
		panelHistory.add(lblHistory);
		lblHistory.setForeground(new Color(37, 57, 111));
		lblHistory.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lblIconHistory = new JLabel("");
		lblIconHistory.setBounds(30, 20, 35, 28);
		panelHistory.add(lblIconHistory);
		lblIconHistory.setIcon(new ImageIcon(icon.getHistoryImg()));
		
		// Profile Panel
		panelGeneral = new JPanel();
		panelGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelGeneral_mouseClicked(e);
			}
		});
		panelGeneral.setBounds(0, 149, 240, 70);
		add(panelGeneral);
		panelGeneral.setBorder(null);
		panelGeneral.setLayout(null);
		panelGeneral.setBackground(new Color(37, 57, 111));
		lblGeneral = new JLabel("Thông tin chung");
		lblGeneral.setForeground(new Color(255, 255, 255));
		lblGeneral.setFont(new Font("Arial", Font.BOLD, 16));
		lblGeneral.setBounds(78, 25, 141, 20);
		panelGeneral.add(lblGeneral);
		JLabel lblIconGeneral = new JLabel("");
		lblIconGeneral.setBounds(30, 20, 46, 29);
		panelGeneral.add(lblIconGeneral);
		lblIconGeneral.setIcon(new ImageIcon(icon.getGeneralImg()));
		
		// Feedback Panel
		panelFeedback = new JPanel();
		panelFeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_panelFeedback_mouseClicked(e);
			}
		});
		panelFeedback.setLayout(null);
		panelFeedback.setBackground(Color.WHITE);
		panelFeedback.setBounds(0, 497, 240, 70);
		add(panelFeedback);
		JLabel lblIconFeedback = new JLabel("");
		lblIconFeedback.setForeground(Color.WHITE);
		lblIconFeedback.setBackground(Color.WHITE);
		lblIconFeedback.setBounds(30, 20, 29, 31);
		panelFeedback.add(lblIconFeedback);
		lblIconFeedback.setIcon(new ImageIcon(icon.getFeedbackImg()));
		lblFeedback = new JLabel("Đánh giá");
		lblFeedback.setForeground(new Color(37, 57, 143));
		lblFeedback.setFont(new Font("Arial", Font.BOLD, 16));
		lblFeedback.setBounds(78, 25, 152, 20);
		panelFeedback.add(lblFeedback);
		
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
		panelLogOut.setBounds(0, 567, 240, 70);
		add(panelLogOut);
		
		lblLogOut = new JLabel("Đăng xuất");
		lblLogOut.setForeground(new Color(37, 57, 143));
		lblLogOut.setFont(new Font("Arial", Font.BOLD, 16));
		lblLogOut.setBounds(78, 25, 152, 20);
		panelLogOut.add(lblLogOut);
		
		lblIconLogOut = new JLabel("");
		lblIconLogOut.setForeground(Color.WHITE);
		lblIconLogOut.setBackground(Color.WHITE);
		lblIconLogOut.setBounds(30, 20, 29, 31);
		panelLogOut.add(lblIconLogOut);
		lblIconLogOut.setIcon(new ImageIcon(icon.getLogoutImg()));
		
	}
	public void menuChanged(JPanel panel, JLabel label) {
		lblVocab.setForeground(new Color(37, 57, 111));
		panelVocab.setBackground(new Color(255, 255, 255));
		lblHistory.setForeground(new Color(37, 57, 111));
		panelHistory.setBackground(new Color(255, 255, 255));
		lblGeneral.setForeground(new Color(37, 57, 111));
		panelGeneral.setBackground(new Color(255, 255, 255));
		lblBookmark.setForeground(new Color(37, 57, 111));
		panelBookmark.setBackground(new Color(255, 255, 255));
		lblMember.setForeground(new Color(37, 57, 111));
		panelMember.setBackground(new Color(255, 255, 255));
		lblFeedback.setForeground(new Color(37, 57, 111));
		panelFeedback.setBackground(new Color(255, 255, 255));
		lblLogOut.setForeground(new Color(37, 57, 111));
		panelLogOut.setBackground(new Color(255, 255, 255));
		label.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(37, 57, 111));
	}

	protected void do_panelMember_mouseClicked(MouseEvent e) {
	}
	protected void do_panelBookmark_mouseClicked(MouseEvent e) {
	}
	protected void do_panelHistory_mouseClicked(MouseEvent e) {
	}
	protected void do_panelVocab_mouseClicked(MouseEvent e) {
	}
	protected void do_panelFeedback_mouseClicked(MouseEvent e) {
	}
	protected void do_panelLogOut_mouseClicked(MouseEvent e) {
	}
	protected void do_panelGeneral_mouseClicked(MouseEvent e) {
	}
}
