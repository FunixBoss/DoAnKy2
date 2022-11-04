package home.item;

import java.awt.Color;

import javax.swing.JPanel;

import entity.Category;
import home.FrameListCategory;
import item.ItemVocab;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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
				FrameListCategory fr = new FrameListCategory(cate.getId());
				fr.setVisible(true);
				fr.setLocation(100,100);
			}
		});
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(0, 0, 260, 83);
		
		lblCategory = new JLabel();
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(97, 11, 153, 47);
		add(lblCategory);
		lblCategory.setText(cate.getName());
		
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
}

