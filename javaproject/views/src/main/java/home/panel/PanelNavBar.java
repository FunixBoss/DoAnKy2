package home.panel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class PanelNavBar extends JPanel {
	private JPanel panelVocab;
	private JLabel lblVocab;
	private JPanel panelCategory;
	private JLabel lblCategory;
	private JPanel panelProfile;
	private JLabel lblProfile;
	private JPanel panelLesson;
	private JLabel lblLesson;
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
	
	public PanelNavBar() {
		setBounds(0, 0, 1052, 77);
		setBackground(new Color(37, 57, 111));
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(37, 57, 111));
		panel_1.setBounds(0, 0, 1051, 77);
		add(panel_1);
		
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
		panelVocab.setBounds(0, 27, 115, 50);
		panel_1.add(panelVocab);
		
		lblVocab = new JLabel("Từ vựng");
		lblVocab.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocab.setFont(new Font("Arial", Font.BOLD, 14));
		lblVocab.setBounds(0, 0, 115, 50);
		panelVocab.add(lblVocab);
		
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
		panelCategory.setBounds(115, 27, 115, 50);
		panel_1.add(panelCategory);
		
		lblCategory = new JLabel("Chủ đề");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(0, 0, 115, 50);
		panelCategory.add(lblCategory);
		
		JPanel fieldAuthor = new JPanel();
		fieldAuthor.setLayout(null);
		fieldAuthor.setBackground(Color.WHITE);
		fieldAuthor.setBounds(936, 27, 115, 50);
		panel_1.add(fieldAuthor);
		
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
		panelLesson.setBounds(230, 27, 115, 50);
		panel_1.add(panelLesson);
		
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
		panelProfile.setBounds(571, 27, 115, 50);
		panel_1.add(panelProfile);
		
		lblProfile = new JLabel("Thông tin");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Arial", Font.BOLD, 14));
		lblProfile.setBounds(0, 0, 115, 50);
		panelProfile.add(lblProfile);
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
}
