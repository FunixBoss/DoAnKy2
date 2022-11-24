package admin.item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import entity.Category;
import home.gui.FrameCategory;
import service.CategoryService;
import service.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import admin.update.FrameUpdateCategory;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemCategory extends JPanel {

	private CategoryService cateService;
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
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCategory detail = new FrameCategory(cate.getId());
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				detail.setLocation(dim.width/2-detail.getSize().width/2, dim.height/2-detail.getSize().height/2);
				detail.setVisible(true);
			}
		});
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
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameUpdateCategory fr = new FrameUpdateCategory(cate);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				fr.setLocation(dim.width/2-fr.getSize().width/2, dim.height/2-fr.getSize().height/2);
				fr.setVisible(true);
			}
		});
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
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e, cate);
			}
		});
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
				final int ROW_HEIGHT = 60;
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
	protected void btnDeleteActionPerformed(ActionEvent e, Category category) {
		int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chủ đề này này?", "Xóa chủ đề", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION) {
			cateService = new CategoryService();
			if(cateService.delete(category)) {
				JOptionPane.showMessageDialog(this, "Xoá chủ đề thành công!");
			}
		}
	}
}
