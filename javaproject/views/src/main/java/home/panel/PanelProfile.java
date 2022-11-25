package home.panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import home.insert.PanelInsertFeedback;
import home.insert.PanelInsertVocab;
import home.update.PanelUpdateMember;

public class PanelProfile extends JPanel {

	private JPanel panel;
	private PanelHistory history;
	private PanelBookmark bookmark;
	private PanelUpdateMember member;
	private PanelInsertFeedback feedback;
	private PanelInsertVocab vocab;
	private PanelGeneral general;

	class ProfileBar extends PanelProfileBar{
		protected void do_panelMember_mouseClicked(MouseEvent e) {
			menuClicked(member);	
			menuChanged(getPanelMember(),getLblMember());
		}
		protected void do_panelBookmark_mouseClicked(MouseEvent e) {
			menuClicked(bookmark);	
			menuChanged(getPanelBookmark(),getLblBookmark());
		}
		protected void do_panelHistory_mouseClicked(MouseEvent e) {
			menuClicked(history);	
			menuChanged(getPanelHistory(),getLblHistory());
		}
		protected void do_panelVocab_mouseClicked(MouseEvent e) {
			menuClicked(vocab);	
			menuChanged(getPanelVocab(),getLblVocab());
		}
		protected void do_panelFeedback_mouseClicked(MouseEvent e) {
			menuClicked(feedback);	
			menuChanged(getPanelFeedback(),getLblFeedback());
		}
		protected void do_panelGeneral_mouseClicked(MouseEvent e) {
			menuClicked(general);	
			menuChanged(getPanelGeneral(),getLblGeneral());
		}
		protected void do_panelLogOut_mouseClicked(MouseEvent e) {
			menuChanged(getPanelLogOut(),getLblLogOut());
		}
	}
	/**
	 * Create the panel.
	 */
	public PanelProfile() {
		initComponent();
	}

	private void initComponent() {
		setBorder(null);
		setBackground(new Color(37, 57, 111));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);
		
		// SideBae
		JPanel panelSideBar = new JPanel();
		panelSideBar.setBackground(new Color(255, 255, 255));
		panelSideBar.setBounds(0, 0, 240, 691);
		panel.add(panelSideBar);
		panelSideBar.setLayout(null);
		
		ProfileBar profile = new ProfileBar();
		profile.setSize(240, 691);
		panelSideBar.add(profile);
		
		// Main Content Panel
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBackground(new Color(242, 247, 255));
		panelMainContent.setBounds(240, 0, 1042, 691);
		panel.add(panelMainContent);
		history = new PanelHistory();
		bookmark = new PanelBookmark();
		member = new PanelUpdateMember();
		feedback = new PanelInsertFeedback();
		vocab = new PanelInsertVocab();
		general = new PanelGeneral();
		
		panelMainContent.setLayout(null);
		panelMainContent.add(history);
		panelMainContent.add(bookmark);
		panelMainContent.add(member);
		panelMainContent.add(feedback);
		panelMainContent.add(vocab);
		panelMainContent.add(general);
		menuClicked(general);
		
	}
	public void menuClicked(JPanel panel) {
		history.setVisible(false);
		bookmark.setVisible(false);
		member.setVisible(false);
		feedback.setVisible(false);
		vocab.setVisible(false);
		general.setVisible(false);
		panel.setVisible(true);
	}

}
