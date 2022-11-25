package home.panel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGeneral extends JPanel {

	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public PanelGeneral() {
		initComponent();
		
		
	}

	private void initComponent() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblHeader = new JLabel("THÔNG TIN CHUNG");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		lblHeader.setBounds(50, 30, 339, 50);
		panel.add(lblHeader);
	}

}
