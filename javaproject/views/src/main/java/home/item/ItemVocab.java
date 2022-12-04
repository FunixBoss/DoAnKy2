package home.item;

import javax.swing.JPanel;

import dao.impl.BookmarkDAOImpl;
import dao.impl.HistoryDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.Bookmark;
import entity.History;
import entity.Vocabulary;
import helper.StringUtils;
import home.panel.PanelDetailVocab;
import service.Authorization;

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
				do_this_mouseClicked(e,vocab);
			}
		});
	}
	
	public ItemVocab(Vocabulary vocab, int y,JPanel panelDetailVocab) {
		initComponent(vocab,y);
		addMouseListener(new MouseAdapter() {
			private PanelDetailVocab q;

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDetailVocab.removeAll();
				Integer userId = new UserDAOImpl().selectIdByUserEmail(Authorization.email); 
				History his = new History(vocab.getId(), userId);
				HistoryDAOImpl hdao= new HistoryDAOImpl();
				if(hdao.checkExistHistory(userId, vocab.getId()) == null){
					hdao.insert(his);
				}
				q = new PanelDetailVocab(vocab);
				q.setBounds(25, 65, 966, 615);
				panelDetailVocab.add(q);
				panelDetailVocab.revalidate();
				panelDetailVocab.repaint();
			}
		});
	}

	private void initComponent(Vocabulary vocab,int y) {		
		setBackground(new Color(128, 128, 128));
		setLayout(null);
		setBounds(0,y, 300, 29);
		typeDao = new WordTypeDAOImpl();
		lblWord = new JLabel("");
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(7, 5, 228, 18);
		add(lblWord);
		lblWord.setText(StringUtils.toCapitalize(vocab.getWord()) + " (" + typeDao.get(vocab.getWordTypeId()).toLowerCase() + ") ");
	}
	
	

	protected void do_this_mouseClicked(MouseEvent e,Vocabulary vocab) {
		System.out.println(vocab);
	}
}
