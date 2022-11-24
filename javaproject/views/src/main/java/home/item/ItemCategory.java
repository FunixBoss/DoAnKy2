package home.item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import admin.item.ItemVocab;
import entity.Category;
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

public class ItemCategory extends JPanel {
	private JLabel lblCategory;
	private JLabel lblImage;

	/**
	 * Create the panel.
	 */
	
	public ItemCategory(Category cate) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FrameCategory fr = new FrameCategory(cate.getId());
					
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					fr.setLocation(dim.width/2-fr.getSize().width/2, dim.height/2-fr.getSize().height/2);

					fr.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(1, 1, 260, 83);
		
		lblCategory = new JLabel();
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(97, 11, 153, 47);
		add(lblCategory);
		lblCategory.setText(toCapitalize(cate.getName()));
		
		lblImage = new JLabel();
		lblImage.setBounds(22, 11, 50, 50);
		add(lblImage);
		lblImage.setIcon(getImageByURL(cate.getImageIcon()));
	}
	
	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemVocab.class.getResource("/category/" + imageName);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 40;
				BufferedImage bimg = ImageIO.read(imageUrl);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(
						new ImageIcon(imageUrl).getImage().getScaledInstance(rowWidth, ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	private String toCapitalize(String str) {
		if(str.length() <= 0) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
