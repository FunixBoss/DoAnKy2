package home;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.ExampleDAOImpl;
import dao.impl.MeaningDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.Example;
import entity.Meaning;
import entity.Vocabulary;
import entity.WordType;
import item.ItemContent;
import item.ItemVocab;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class FrameDetailVocab extends JFrame {

	private JPanel contentPane;
	private Image starImg = new ImageIcon(getClass().getResource("/image/star.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image starAltImg = new ImageIcon(getClass().getResource("/image/star-alt.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JLabel lblStar;
	private JLabel lblImage;
	private JLabel lblPronunciation;
	/**
	 * Create the frame.
	 */
	public FrameDetailVocab(Vocabulary vocab) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 892, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWord = new JLabel();
		lblWord.setFont(new Font("Arial", Font.BOLD, 25));
		lblWord.setBackground(new Color(255, 255, 255));
		lblWord.setBounds(35, 25, 236, 36);
		contentPane.add(lblWord);
		lblWord.setText(vocab.getWord());
		
		lblStar = new JLabel("");
		lblStar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_lblStar_mouseClicked(e);
			}
		});
		lblStar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStar.setBounds(786, 25, 46, 27);
		contentPane.add(lblStar);
		lblStar.setIcon(new ImageIcon(starImg));
		
		JLabel lblWordType = new JLabel();
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWordType.setBounds(35, 64, 87, 27);
		contentPane.add(lblWordType);
		
		WordTypeDAOImpl wordTypeDao = new WordTypeDAOImpl();
		WordType wordType = new WordType();
		wordType = wordTypeDao.select(vocab.getWordTypeId());
		lblWordType.setText(wordType.getType());
		
		int y = 90;
		for ( Meaning meaning : new VocabularyDAOImpl().selectAllMeaningByVocabId(vocab.getId())) {
			for(Example ex : new MeaningDAOImpl().selectAllExampleByMeaningId(meaning.getId())) {
				ItemContent contentItem = new ItemContent(meaning, ex, y);
				contentPane.add(contentItem);
				y = y + 106;
			}
		}


		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon());
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblImage.setBounds(561, 79, 271, 279);
		contentPane.add(lblImage);
		lblImage.setIcon(getImageByURL(vocab.getImage()));
		
		lblPronunciation = new JLabel("");
		lblPronunciation.setIcon(new ImageIcon(FrameDetailVocab.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		lblPronunciation.setBounds(161, 59, 31, 27);
		contentPane.add(lblPronunciation);
	}

	protected void do_lblStar_mouseClicked(MouseEvent e) {
		lblStar.setIcon(new ImageIcon(starAltImg));
	}
	
	private ImageIcon getImageByURL(String imageName) {
		var imageUrl = ItemVocab.class.getResource("/vocabulary/" + imageName);
		if (imageUrl != null) {
			try {
				final int ROW_HEIGHT = 200;
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
