package home.panel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import entity.Category;
import home.item.ItemCategory;
import home.item.ItemLesson;
import javax.swing.JButton;

public class PanelHome extends JPanel {

	private ItemLesson itemLesson;
	private JPanel panelLesson;
	private ItemCategory itemCategory;
	private Category cate;
	
	private JPanel panelCategory;
	public PanelHome() {
		initComponent();
//		itemLesson = new ItemLesson();
//		itemLesson.setLocation(32, 55);
//		panelLesson.add(itemLesson);
//		
//		ItemLesson itemLesson_1 = new ItemLesson();
//		itemLesson_1.setBounds(329, 55, 264, 292);
//		panelLesson.add(itemLesson_1);
//		cate = new Category();
//		itemCategory = new ItemCategory(cate);
//		itemCategory.setSize(264, 102);
//		itemCategory.setLocation(32, 36);
//		panelCategory.add(itemCategory);
		
	}
	private void initComponent() {
		setBorder(null);
		setBackground(new Color(37, 57, 111));
		setBounds(0, 0, 1302, 702);
		setLayout(new BorderLayout());
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(
				new ImageIcon(getClass().getResource("/image/background.jpg")).getImage().getScaledInstance(1302, 702, Image.SCALE_SMOOTH)
				));
		add(background, BorderLayout.CENTER);
//		setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(255, 255, 255));
//		panel.setBounds(10, 0, 1282, 691);
//		add(panel);
//		panel.setLayout(null);
//		
//		panelLesson = new JPanel();
//		panelLesson.setBackground(new Color(255, 255, 255));
//		panelLesson.setBounds(10, 10, 631, 376);
//		panel.add(panelLesson);
//		panelLesson.setLayout(null);
//		
//		panelCategory = new JPanel();
//		panelCategory.setBackground(new Color(255, 255, 255));
//		panelCategory.setBounds(10, 399, 631, 253);
//		panel.add(panelCategory);
//		panelCategory.setLayout(null);
//		
//		JLabel lblCategory = new JLabel("Chủ đề mới nhất");
//		lblCategory.setBounds(32, 0, 200, 35);
//		panelCategory.add(lblCategory);
//		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
//		lblCategory.setFont(new Font("Arial", Font.BOLD, 18));
//		
//		JLabel lblLesson = new JLabel("Bài học mới nhất");
//		lblLesson.setBounds(22, 10, 200, 35);
//		panelLesson.add(lblLesson);
//		lblLesson.setHorizontalAlignment(SwingConstants.LEFT);
//		lblLesson.setFont(new Font("Arial", Font.BOLD, 18));
//		
//		JLabel lblFooter = new JLabel("@ MADE BY AFK TEAM");
//		lblFooter.setHorizontalAlignment(SwingConstants.CENTER);
//		lblFooter.setFont(new Font("Arial", Font.BOLD, 14));
//		lblFooter.setBounds(450, 666, 384, 19);
//		panel.add(lblFooter);
//		
//		JPanel panelMarketing = new JPanel();
//		panelMarketing.setBackground(new Color(255, 255, 255));
//		panelMarketing.setBounds(651, 10, 621, 642);
//		panel.add(panelMarketing);
//		panelMarketing.setLayout(new BorderLayout(0, 0));
		
	}
}
