package home;

import java.awt.Color;
import javax.swing.JPanel;
import dao.impl.CategoryDAOImpl;
import entity.Category;
import home.item.ItemCategory;
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
		panel.setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(10, 11, 1262, 669);
		panel.add(panelMain);
		panelMain.setLayout(new GridLayout(10, 2, 2, 2));
		
		for(Category cate : new CategoryDAOImpl().selectAll()){
			ItemCategory cateItem = new ItemCategory(cate);
			panelMain.add(cateItem);
		}
	}

}
