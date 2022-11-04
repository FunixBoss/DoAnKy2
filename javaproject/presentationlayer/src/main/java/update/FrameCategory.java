package update;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import entity.Category;
import item.ItemCategory;

public class FrameCategory extends JFrame {

	private JPanel contentPane;
	private JTextField textCategory;
	/**
	 * Create the frame.
	 */
	public FrameCategory(Category cate) {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTopic = new JLabel("Sửa chủ đề");
		lblTopic.setBounds(20, 11, 219, 34);
		lblTopic.setForeground(new Color(37, 57, 111));
		lblTopic.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblTopic);
		
		JLabel lblCategory = new JLabel("Chủ đề");
		lblCategory.setBounds(44, 97, 84, 21);
		lblCategory.setForeground(Color.BLACK);
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblCategory);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(44, 399, 148, 44);
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Xóa");
		btnReset.setBounds(219, 399, 148, 44);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setBackground(new Color(67, 98, 190));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1120, 62);
		panel.setBackground(new Color(242, 247, 255));
		contentPane.add(panel);
		
		JLabel lblImage = new JLabel("Hình hiện tại");
		lblImage.setBounds(44, 191, 133, 21);
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblImage);
		
		JButton btnImage = new JButton("Tải ảnh lên");
		btnImage.setBounds(192, 290, 175, 37);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnImage_actionPerformed(e);
			}
		});
		btnImage.setForeground(new Color(0, 0, 0));
		btnImage.setFont(new Font("Arial", Font.BOLD, 14));
		btnImage.setBackground(new Color(242, 247, 255));
		contentPane.add(btnImage);
		
		textCategory = new JTextField();
		textCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		textCategory.setBounds(192, 90, 175, 37);
		contentPane.add(textCategory);
		textCategory.setColumns(10);
		textCategory.setText(cate.getName());
		
		JLabel lblImageIcon = new JLabel("");
		lblImageIcon.setBounds(192, 153, 175, 107);
		contentPane.add(lblImageIcon);
		lblImageIcon.setIcon(getImageByURL(cate.getImageIcon()));
		
		JLabel lblnhMi = new JLabel("Ảnh mới");
		lblnhMi.setForeground(Color.BLACK);
		lblnhMi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblnhMi.setBounds(44, 298, 96, 21);
		contentPane.add(lblnhMi);
	}
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		textCategory.setText("");
	}
	protected void do_btnImage_actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser("c://");
		chooser.setDialogTitle("Hình ảnh");
		chooser.setFileFilter(
					new FileNameExtensionFilter("image(jpg, png, gif)","jpg","png","gif" )
				);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		if(result == chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
		}
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
	
}
