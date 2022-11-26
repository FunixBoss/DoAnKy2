package home.insert;

import java.awt.Color;
import javax.swing.JPanel;
public class PanelInsertFeedback extends JPanel{

	public PanelInsertFeedback() {
		initComponent();

	}

	private void initComponent() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1302, 702);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
	}
}
