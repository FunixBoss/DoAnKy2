package item;

import java.awt.Color;

import javax.swing.JPanel;

import entity.Category;
import entity.Meaning;
import entity.Vocabulary;
import update.FrameUpdateVocab;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemVocabDashboard extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemVocabDashboard(Vocabulary vocab, int y) {
		setLayout(null);
		setBounds(0, y, 1005, 64);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1005, 1);
		add(panel);
		panel.setBackground(new Color(186, 123, 247));

		JPanel panelHeader_1 = new JPanel();
		panelHeader_1.setBounds(0, 0, 1005, 63);
		add(panelHeader_1);
		panelHeader_1.setLayout(new GridLayout(0, 6, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblId = new JLabel("STT");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblId);
		lblId.setText(vocab.getId().toString());

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2);
		panel_1_2.setLayout(new BorderLayout(0, 0));

		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setForeground(new Color(0, 0, 0));
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2.add(lblWord);
		String word = toCapitalize(vocab.getWord());
		lblWord.setText(word);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));

		JLabel lblMeaning = new JLabel("");
		lblMeaning.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeaning.setForeground(new Color(0, 0, 0));
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		List<Meaning> means = new VocabularyDAOImpl().selectAllMeaningByVocabId(vocab.getId());
		if (means != null) {
			String meansStr = means.stream()
					.limit(4)
					.map(mean -> toCapitalize(mean.getContent()))
					.collect(Collectors.joining("<br/>"));
			if (means.size() > 5) {
				meansStr += " ...";
			}

			lblMeaning.setText("<html>" + meansStr + "</html>");
			panel_2_1.add(lblMeaning);
		}

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2_2);
		panel_1_2_2.setLayout(new BorderLayout(0, 0));

		JLabel lblWordType = new JLabel();
		lblWordType.setHorizontalAlignment(SwingConstants.CENTER);
		lblWordType.setForeground(new Color(0, 0, 0));
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2_2.add(lblWordType);
		String wordType = new WordTypeDAOImpl().select(vocab.getWordTypeId()).getType().toUpperCase();
		lblWordType.setText(wordType);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(getImageByURL(vocab.getImage()));
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblImage);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new BorderLayout(0, 0));

		JLabel lblCategory = new JLabel();
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setForeground(new Color(0, 0, 0));
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2_1.add(lblCategory);
		
		Category cate = new CategoryDAOImpl().select(vocab.getCategoryId());
		String cateName = (cate != null) ? cate.getName().toUpperCase() : "";
		lblCategory.setText(cateName);
	}

	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemVocabDashboard.class.getResource("/vocabulary/" + imageName);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 63;
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
