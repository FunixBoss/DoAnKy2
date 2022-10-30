package panel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setBorder(null);
		setBackground(new Color(242, 247, 255));
		setBounds(0, 0, 1085, 702);
		setLayout(null);
		
		JLabel lblBreadcrumb = new JLabel("Trang chủ /");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(916, 11, 114, 14);
		add(lblBreadcrumb);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 57, 981, 597);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chào mừng mọi người đến với từ điển Anh-Việt !!!!");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(240, 178, 537, 156);
		panel.add(lblNewLabel);
	}

}
