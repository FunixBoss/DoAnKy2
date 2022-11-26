package home.item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import admin.item.ItemVocab;
import entity.Category;
import helper.ImageUtils;
import helper.StringUtils;
import home.gui.FrameCategory;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ItemCategory extends JPanel {
	private JLabel lblCategory;
	private JLabel lblImage;

	public ItemCategory(Category cate) {
		initComponent(cate);
		
		lblCategory.setText(StringUtils.toCapitalize(cate.getName()));
		final int ROW_HEIGHT = 50;
		lblImage.setIcon(ImageUtils.getImageByURL("category", cate.getImageIcon(), ROW_HEIGHT));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameCategory fr = new FrameCategory(cate.getId());
					fr.setVisible(true);
				} catch (Exception e2) {
				}
				
			}
		});
	}

	private void initComponent(Category cate) {
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(1, 1, 277, 102);
		
		lblCategory = new JLabel();
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(76, 0, 201, 102);
		add(lblCategory);
		
		lblImage = new JLabel();
		lblImage.setBounds(40, 24, 72, 62);
		add(lblImage);
	}
}

