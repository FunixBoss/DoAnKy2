package home.panel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class PanelLesson extends JPanel {

	private JPanel panel;
	private JPanel panelMain;

	/**
	 * Create the panel.
	 */
	public PanelLesson() {
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
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setLayout(new GridLayout(4, 2, 2, 2));
	}

}
