package home;

import java.awt.Color;
import javax.swing.JPanel;
import dao.impl.CategoryDAOImpl;
import entity.Category;
import item.ItemCategory;
import java.awt.GridLayout;

public class PanelCategory extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelCategory() {
		setBorder(null);
		setBackground(new Color(37, 57, 111));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1282, 691);
		add(panel);
		panel.setLayout(new GridLayout(3, 2, 2, 2));
		
		for(Category cate : new CategoryDAOImpl().selectAll()){
			ItemCategory cateItem = new ItemCategory(cate);
			panel.add(cateItem);
		}
	}

}
