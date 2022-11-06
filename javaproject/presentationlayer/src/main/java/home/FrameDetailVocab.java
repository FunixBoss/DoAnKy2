package home;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.BookmarkDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Bookmark;
import dao.impl.MeaningDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.Example;
import entity.Meaning;
import entity.Vocabulary;
import entity.WordType;
import item.ItemContent;
import item.ItemVocab;
import service.Authorization;
import jaco.mp3.player.MP3Player;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JToggleButton;
import java.io.File;
import java.net.URL;

public class FrameDetailVocab extends JFrame {

	private JPanel contentPane;
	private Image starImg = new ImageIcon(getClass().getResource("/image/star.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image starAltImg = new ImageIcon(getClass().getResource("/image/star-alt.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private JLabel lblStar;
	private JLabel lblImage;
	private JLabel lblPronunciation;
	private JToggleButton tglbtnNewToggleButton;
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
		

		MP3Player mp3 = new MP3Player(getSongByURL("football.mp3"));
		lblPronunciation = new JLabel("");
		lblPronunciation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mp3.play();
			}
		});
		lblPronunciation.setIcon(new ImageIcon(FrameDetailVocab.class.getResource("/jaco/mp3/player/plaf/resources/mp3PlayerSoundOn.png")));
		lblPronunciation.setBounds(161, 59, 31, 27);
		contentPane.add(lblPronunciation);
		
		tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setContentAreaFilled(false);
		tglbtnNewToggleButton.setBorder(null);
		tglbtnNewToggleButton.setBorderPainted(false);
		tglbtnNewToggleButton.setBounds(693, 0, 65, 61);
		
		//set Icon
		try {
			if(new BookmarkDAOImpl().checkExistBookmarkInDb(new UserDAOImpl().selectIdByUserEmail(Authorization.email),vocab.getId())== null) {
				tglbtnNewToggleButton.setIcon((new ImageIcon(starAltImg)));
			}else {
				tglbtnNewToggleButton.setIcon(new ImageIcon(starImg));
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
		
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((JToggleButton)e.getSource()).isSelected() == true) {
					if(Authorization.email!=null ) {
						if(new BookmarkDAOImpl().checkExistBookmark( new UserDAOImpl().selectIdByUserEmail(Authorization.email),vocab.getId()) ==null) {
							new BookmarkDAOImpl().insert(new Bookmark(vocab.getId(), new UserDAOImpl().selectIdByUserEmail(Authorization.email)));
						}
						tglbtnNewToggleButton.setIcon(new ImageIcon(starImg));
					}
				}else if(((JToggleButton)e.getSource()).isSelected() == false) {
					if(Authorization.email!=null) {
						List<Bookmark> x = new BookmarkDAOImpl().checkExistBookmark( new UserDAOImpl().selectIdByUserEmail(Authorization.email),vocab.getId());
						if(x != null) {
							x.forEach(y->new BookmarkDAOImpl().delete(y));
						}
						tglbtnNewToggleButton.setIcon((new ImageIcon(starAltImg)));
						
					}
				}
				
			}
	      });
		contentPane.add(tglbtnNewToggleButton);
	}

	protected void do_lblStar_mouseClicked(MouseEvent e) {
		lblStar.setIcon(new ImageIcon(starAltImg));
	}
	
	private File getSongByURL (String songName) {
		var songUrl = getClass().getResource("/pronunciation/" + songName).getFile();
		if (songUrl != null) {
			return new File(new File(songUrl), songUrl);
		} return null; 
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
