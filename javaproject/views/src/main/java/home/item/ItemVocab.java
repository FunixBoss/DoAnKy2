package home.item;

import javax.swing.JPanel;
import dao.impl.WordTypeDAOImpl;
import entity.Vocabulary;
import helper.StringUtils;
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_this_mouseClicked(e);
			}
		});
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
		lblWord.setText(StringUtils.toCapitalize(vocab.getWord()) + " (" + typeDao.get(vocab.getWordTypeId()).toLowerCase() + ") ");
	}
	
	

	protected void do_this_mouseClicked(MouseEvent e) {
		System.out.println("s");
	}
}
