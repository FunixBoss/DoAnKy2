package home.item;

import javax.swing.JPanel;
import dao.impl.WordTypeDAOImpl;
import entity.Vocabulary;
import helper.ImageUtils;
import helper.StringUtils;
import home.gui.FrameDetailVocab;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ItemCategoryVocab extends JPanel {

	private JLabel lblWord;
	private WordTypeDAOImpl typeDao;

	public ItemCategoryVocab(Vocabulary vocab, int y, int x) {
		initComponent(vocab, y, x);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameDetailVocab fr = new FrameDetailVocab(vocab);
				fr.setVisible(true);
			}
		});
	}

	private void initComponent(Vocabulary vocab, int y, int x) {		
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(x,y, 300, 120);
		typeDao = new WordTypeDAOImpl();
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBackground(new Color(0, 0, 0));
		lblImage.setBounds(0, 0, 119, 119);
		add(lblImage);
		lblImage.setIcon(ImageUtils.getImageByURL("vocabulary", vocab.getImage(),80));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(37, 57, 111));
		panel.setBounds(120, 0, 180, 119);
		add(panel);
		panel.setLayout(null);
		lblWord = new JLabel("");
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setBounds(0, 0, 180, 119);
		panel.add(lblWord);
		lblWord.setForeground(new Color(255, 255, 255));
		lblWord.setFont(new Font("Arial", Font.PLAIN, 18));
		lblWord.setText(StringUtils.toCapitalize(vocab.getWord()) + " (" + typeDao.get(vocab.getWordTypeId()).toLowerCase() + ") ");
	}

}
