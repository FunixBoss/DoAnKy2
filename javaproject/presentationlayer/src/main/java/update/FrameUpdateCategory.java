package update;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.impl.CategoryDAOImpl;
import entity.Category;
import helper.ErrorMessage;
import item.ItemCategory;
import item.ItemVocab;
import service.CategoryService;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;



public class FrameUpdateCategory extends JFrame {

	private JPanel contentPane;
	private JTextField textCategory;
	private JLabel lblTopic;
	private JLabel lblCategory;
	private JButton btnAdd;
	private JButton btnReset;
	private JPanel panel ;
	private JButton btnImage;
	private CategoryService cateService;
	private JLabel lblImageShow;
	private static FrameUpdateCategory myInstance;
	private JPanel panelImageShow;
	private Map<String, String> data;
	
	public static FrameUpdateCategory getMyInstance(Category category) {
		if (myInstance == null) {
			myInstance = new FrameUpdateCategory(category);
		}
		return myInstance;
	}
	
	public FrameUpdateCategory(Category category) {
		initComponent();
		data = new HashMap<>();
		data.put("id", Integer.toString(category.getId()));
		cateService = new CategoryService();
		textCategory.setText(category.getName());
		lblImageShow.setIcon(getImageByURL(category.getImageIcon()));
	}

	private void initComponent() {
		setResizable(false);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 428, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTopic = new JLabel("Thêm chủ đề");
		lblTopic.setBounds(20, 11, 219, 34);
		lblTopic.setForeground(new Color(37, 57, 111));
		lblTopic.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblTopic);
		
		JLabel lblCategory = new JLabel("Chủ đề");
		lblCategory.setBounds(44, 97, 84, 21);
		lblCategory.setForeground(Color.BLACK);
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblCategory);
		
		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setBounds(137, 386, 133, 44);
		btnUpdate.setBackground(new Color(67, 98, 190));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btnUpdate);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 412, 62);
		panel.setBackground(new Color(242, 247, 255));
		contentPane.add(panel);
		
		JLabel lblImage = new JLabel("Hình ảnh");
		lblImage.setBounds(44, 164, 96, 21);
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblImage);
		
		JButton btnImage = new JButton("Tải ảnh lên");
		btnImage.setBounds(192, 156, 175, 37);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					do_btnImage_actionPerformed(e);
				} catch (URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		panelImageShow = new JPanel();
		panelImageShow.setBounds(10, 204, 392, 171);
		contentPane.add(panelImageShow);
		panelImageShow.setLayout(new BorderLayout(0, 0));
		
		lblImageShow = new JLabel("");
		lblImageShow.setHorizontalAlignment(SwingConstants.CENTER);
		panelImageShow.add(lblImageShow);
		lblImageShow.setForeground(new Color(0, 0, 0));
		lblImageShow.setBackground(new Color(192, 192, 192));
	}
	protected void do_btnImage_actionPerformed(ActionEvent e) throws URISyntaxException, IOException {
		JFileChooser chooser = new JFileChooser("desktop://");
		chooser.setDialogTitle("Hình ảnh");
		chooser.setFileFilter(
					new FileNameExtensionFilter("image(jpg, png, gif)","jpg","png","gif" )
				);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog( null);
		File rawFile = null;
		if(result == chooser.APPROVE_OPTION) {
			rawFile = chooser.getSelectedFile();
			lblImageShow.setIcon(getImageByFile(rawFile.getAbsoluteFile()));
			data.put("image", rawFile.toPath().toString());
		}
	}
	
	private ImageIcon getImageByFile(File f) {
		if (f != null) {
			try {
				final int ROW_HEIGHT = 171;
				BufferedImage bimg = ImageIO.read(f);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(
						new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(rowWidth, ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemCategory.class.getResource("/category/" + imageName);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 171;
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
	
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		data.put("category", textCategory.getText());
		if(cateService.update(data)) {
			JOptionPane.showMessageDialog(this, "Cập nhật chủ đề thành công");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, ErrorMessage.ERROR_MESSAGES);
		}
		
	}
}
