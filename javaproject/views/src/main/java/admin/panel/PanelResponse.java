package admin.panel;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelResponse extends JPanel {
	private PanelFeedback panelFeedback;
	private PanelVocabContribution panelVocabContribution;
	private JPanel topBar;
	
	private class SideBarMenu extends PanelSideBarFeedback{
		public void doPanelVocabContributionMousePressed(MouseEvent e) {
			menuClicked(panelVocabContribution);
			menuChanged(getPanelVocabContribution(), getLblVocabContribution());
		}
		public void doPanelFeedbackMousePressed(MouseEvent e) {
			menuClicked(panelFeedback);
			menuChanged(getPanelFeedback(),getLblFeedback());
		}
		
	}
	
	public PanelResponse() {
		setLayout(null);
		setBounds(0, 0, 1085, 729);
		setBackground(new Color(242, 247, 255));
		
		topBar = new JPanel();
		topBar.setBackground(new Color(255, 255, 255));
		topBar.setBounds(43, 0, 450, 50);
		topBar.setLayout(null);
		add(topBar);
		SideBarMenu sideBarMenu = new SideBarMenu();
		topBar.add(sideBarMenu);
		
		PanelMainContent mainContent = new PanelMainContent();
		mainContent.setBounds(0, 61, 1085, 668);
		mainContent.setLayout(null);		
		add(mainContent);
		
		panelVocabContribution = new PanelVocabContribution();
		panelVocabContribution.setBounds(0, 0, 1085, 668);
		panelFeedback = new PanelFeedback();
		panelFeedback.setBounds(0, 0, 1085, 668);
		
		mainContent.add(panelVocabContribution);
		mainContent.add(panelFeedback);
		
		sideBarMenu.doPanelVocabContributionMousePressed(null);
	}
	
	private void menuClicked(JPanel panel) {
		panelVocabContribution.setVisible(false);;
		panelFeedback.setVisible(false);
		panel.setVisible(true);
	}
}
