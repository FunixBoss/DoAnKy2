package home.panel;

import java.awt.Color;
import javax.swing.JPanel;

import home.item.ItemLesson;


public class PanelLesson extends JPanel {

	private JPanel panel;
	private ItemLesson item;

	public PanelLesson() {
		initComponent();
		item = new ItemLesson();
		panel.add(item);
	}

	private void initComponent() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);
		
		
	}

}
