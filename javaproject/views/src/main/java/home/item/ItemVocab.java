package home.item;

import javax.swing.JPanel;
import dao.impl.WordTypeDAOImpl;
import entity.Vocabulary;
import home.panel.PanelDetailVocab;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemVocab extends JPanel {

	private JLabel lblWord;
	private WordTypeDAOImpl typeDao;

	public ItemVocab(Vocabulary vocab, int y) {
		initComponent(vocab,y);
	}
	
	public ItemVocab(Vocabulary vocab) {
		initComponent(vocab);
	}

	private void initComponent(Vocabulary vocab,int y) {		
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(0,y, 245, 29);
		typeDao = new WordTypeDAOImpl();
		lblWord = new JLabel("");
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(7, 5, 228, 18);
		add(lblWord);
		lblWord.setText(toCapitalize(vocab.getWord()) + " (" + typeDao.get(vocab.getWordTypeId()).toLowerCase() + ") ");
	}
	
	private void initComponent(Vocabulary vocab) {		
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(0,0, 213, 29);
		typeDao = new WordTypeDAOImpl();
		lblWord = new JLabel("");
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(7, 5, 196, 18);
		add(lblWord);
		lblWord.setText(toCapitalize(vocab.getWord()) +  typeDao.get(vocab.getWordTypeId()));
	}

	private String toCapitalize(String str) {
		if(str.length() <= 0) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
