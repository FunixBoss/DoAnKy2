package item;

import java.awt.Color;

import javax.swing.JPanel;

import entity.Category;
import entity.Meaning;
import entity.Vocabulary;
import service.UserService;
import service.VocabularyService;
import update.FrameUpdateVocab;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class ItemVocab extends JPanel {
	private VocabularyService vocabService;
	
	public ItemVocab(Vocabulary vocab, int y) {
		setLayout(null);
		setBounds(0, y, 980, 80);

		JPanel panel = new JPanel();
		panel.setBounds(0, 77, 995, 3);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));

		JPanel panelHeader_1 = new JPanel();
		panelHeader_1.setBounds(0, 0, 980, 80);
		add(panelHeader_1);
		panelHeader_1.setLayout(new GridLayout(1, 8, 0, 0));

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

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameUpdateVocab fr = new FrameUpdateVocab(vocab);
				fr.setVisible(true);
			}
		});
		btnEdit.setBounds(32, 25, 58, 30);
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
				btnDeleteActionPerformed(e, vocab);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(32, 25, 60, 30);
		panel_1_1.add(btnDelete);
	}

	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemVocab.class.getResource("/vocabulary/" + imageName);
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
	protected void btnDeleteActionPerformed(ActionEvent e, Vocabulary vocab) {
		int option = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa từ vựng này?", "Xóa từ vựng", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION) {
			vocabService = new VocabularyService();
			if(vocabService.delete(vocab)) {
				JOptionPane.showMessageDialog(this, "Xoá từ vựng thành công!");
			}
		}
	}
}
