package home.panel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dao.impl.CategoryDAOImpl;
import entity.Category;
import home.item.ItemCategory;
import java.awt.GridLayout;

public class PanelCategory extends JPanel {
	public JPanel panelMain;
	public JScrollPane scrollPane;
	public JPanel panel;
	public JLabel lblNewLabel;
	/**
	 * Create the panel.
	 */
	
	public PanelCategory() {
		initComponent();
		for (Category cate : new CategoryDAOImpl().selectAll()) { 
			ItemCategory item = new ItemCategory(cate);
			panelMain.add(item);
		}
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 11, 1262, 669);
		panel.add(scrollPane);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panelMain);
		panelMain.setLayout(new GridLayout(4, 2, 2, 2));
	}

}
