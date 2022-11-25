package helper;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageUtils {
	public static ImageIcon getImageByFile(File f, final int ROW_HEIGHT) {
		if (f != null) {
			try {
				BufferedImage bimg = ImageIO.read(f);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(new ImageIcon(f.getAbsolutePath()).getImage().getScaledInstance(rowWidth,
						ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
			}
		}
		return null;
	}

	public static ImageIcon getImageByURL(String folderName, String imageName, final int ROW_HEIGHT) {
		var imageUrl = ImageUtils.class.getResource("/" + folderName + "/" + imageName);
//		System.out.println(imageUrl);
		if (imageUrl != null) {
			try {
				BufferedImage bimg = ImageIO.read(imageUrl);
				int imgWidth = bimg.getWidth();
				int imgHeight = bimg.getHeight();
				int rowWidth = (ROW_HEIGHT * imgWidth) / imgHeight;
				return new ImageIcon(
						new ImageIcon(imageUrl).getImage().getScaledInstance(rowWidth, ROW_HEIGHT, Image.SCALE_SMOOTH));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}
}
