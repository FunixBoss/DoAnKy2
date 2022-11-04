package item;

import java.awt.Color;

import javax.swing.JPanel;

import entity.Category;
import entity.Meaning;
import entity.Vocabulary;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import dao.impl.CategoryDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;

import java.awt.GridLayout;

public class ItemCategory extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemCategory(Category cate, int y) {
		setLayout(null);
		setBounds(0, y, 980, 80);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 77, 995, 3);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));
		
		JPanel panelHeader_1 = new JPanel();
		panelHeader_1.setBounds(0, 0, 980, 80);
		add(panelHeader_1);
		panelHeader_1.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblId);
		lblId.setText(cate.getId().toString());

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2);
		panel_1_2.setLayout(new BorderLayout(0, 0));

		JLabel lblWord = new JLabel("Chủ đề");
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setForeground(new Color(0, 0, 0));
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2.add(lblWord);
		String word = toCapitalize(cate.getName());
		lblWord.setText(word);

		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImage = new JLabel();
		panel_1_2_1.add(lblImage, BorderLayout.CENTER);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(getImageByURL(cate.getImageIcon()));
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));

		
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(Color.WHITE);
		panelHeader_1.add(panel_1_1_1_1);
		
		JButton btnDetail = new JButton("Chi tiết");
		btnDetail.setForeground(Color.WHITE);
		btnDetail.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetail.setBorder(null);
		btnDetail.setBackground(new Color(67, 98, 190));
		btnDetail.setBounds(38, 25, 100, 30);
		panel_1_1_1_1.add(btnDetail);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setBounds(44, 25, 73, 30);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
		btnEdit.setBorder(null);
		btnEdit.setBackground(new Color(67, 98, 190));
		panel_1_1_1.add(btnEdit);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_1);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(46, 25, 75, 30);
		panel_1_1.add(btnDelete);
		
		
	}

	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemCategory.class.getResource("/category/" + imageName);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 78;
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
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
