package admin.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.border.LineBorder;
import admin.panel.PanelAdmin;
import admin.panel.PanelCategory;
import admin.panel.PanelDashboard;
import admin.panel.PanelResponse;
import admin.panel.PanelLesson;
import admin.panel.PanelMainContent;
import admin.panel.PanelMember;
import admin.panel.PanelSideBar;
import admin.panel.PanelVocab;
import helper.FrameUtils;
import helper.ImageUtils;

public class FrameDashboard extends JFrame {

	private JPanel contentPane;
	private PanelMember panelMember;
	private PanelVocab panelVocab;
	private PanelAdmin panelAdmin;
	private PanelDashboard panelDashboard;
	private PanelCategory panelCategory;
	private PanelLesson panelLesson;
	private PanelResponse panelResponse;
	
	private PanelMainContent mainContent;
	class SideBarMenu extends PanelSideBar {
		protected void do_panelDashboard_mouseClicked(MouseEvent e) {
			panelDashboard = new PanelDashboard();
			menuClicked(panelDashboard);
			menuChanged(getPanelDashboard(),getLblDashboard());
		}
		protected void do_panelVocab_mouseClicked(MouseEvent e) {
			panelVocab = new PanelVocab();
			menuClicked(panelVocab);
			menuChanged(getPanelVocab(),getLblVocab());
		}
		protected void do_panelCategory_mouseClicked(MouseEvent e) {
			panelCategory = new PanelCategory();
			menuClicked(panelCategory);
			menuChanged(getPanelCategory(),getLblCategory());
		}
		protected void do_panelMember_mouseClicked(MouseEvent e) {
			panelMember = new PanelMember();
			menuClicked(panelMember);	
			menuChanged(getPanelMember(),getLblMember());
		}
		protected void do_panelAdmin_mouseClicked(MouseEvent e) {
			panelAdmin = new PanelAdmin();
			menuClicked(panelAdmin);	
			menuChanged(getPanelAdmin(),getLblAdmin());
		}
		protected void do_panelLesson_mouseClicked(MouseEvent e) {
			panelLesson = new PanelLesson();
			menuClicked(panelLesson);	
			menuChanged(getPanelLesson(),getLblLesson());
		}
		protected void do_panelFeedback_mouseClicked(MouseEvent e) {
			panelResponse = new PanelResponse();
			menuClicked(panelResponse);	
			menuChanged(getPanelFeedback(),getLblFeedback());
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrameDashboard frame = new FrameDashboard();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	public FrameDashboard() {
		initComponent();
	}
	private void initComponent() {
		setResizable(false);
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameDashboard.class.getResource("/image/dictionary-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1318, 816);
		
		contentPane = new JPanel();
		contentPane.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// Side Bar
		JPanel sideBar = new JPanel();
		sideBar.setBackground(new Color(255, 255, 255));
		sideBar.setBounds(0, 0, 217, 777);
		contentPane.add(sideBar);
		sideBar.setLayout(null);
		SideBarMenu sideBarMenu = new SideBarMenu();
		sideBar.add(sideBarMenu);
		
		// Main Content
		mainContent = new PanelMainContent();
		mainContent.setBounds(217, 50, 1085, 729);
		contentPane.add(mainContent);
		mainContent.setLayout(null);
		
		panelDashboard = new PanelDashboard();
		panelDashboard.loadData();
		mainContent.add(panelDashboard);
		
//		panelMember = new PanelMember();
//		panelVocab = new PanelVocab();
//		panelAdmin = new PanelAdmin();
//		panelAdmin.frameParent = this;
//		
//		panelCategory = new PanelCategory();
//		panelDashboard = new PanelDashboard();
//		panelLesson = new PanelLesson();
//		panelResponse = new PanelResponse();
//		panelDashboard.loadData();
//		panelDashboard.setBounds(0, 0, 1085, 729);
	
//		mainContent.add(panelDashboard);
//		mainContent.add(panelVocab);
//		mainContent.add(panelAdmin);
//		mainContent.add(panelMember);
//		mainContent.add(panelCategory);
//		mainContent.add(panelLesson);
//		mainContent.add(panelResponse);
//		menuClicked(panelDashboard);
		
		// Top Bar
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 0, 1085, 50);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(242, 247, 255));
		panel_1.setLayout(null);
		FrameUtils.alignFrameScreenCenter(this);
		
	}
	
	public void callPanel(JPanel panel) {
		//remove
		mainContent.removeAll();
		mainContent.repaint();
		mainContent.revalidate();
		//repaint
		mainContent.add(panel);
		mainContent.repaint();
		mainContent.revalidate();
	}
	
	public void menuClicked(JPanel panel) {
//		panelMember.setVisible(false);
//		panelVocab.setVisible(false);
//		panelAdmin.setVisible(false);
//		panelCategory.setVisible(false);
//		panelDashboard.setVisible(false);
//		panelLesson.setVisible(false);
//		panelResponse.setVisible(false);
//		panel.setVisible(true);
		callPanel(panel);
	}
}
