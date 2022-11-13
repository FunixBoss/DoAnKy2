package item;

import javax.swing.JPanel;

import dao.impl.HistoryDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import dao.impl.WordTypeDAOImpl;
import entity.History;
import entity.Vocabulary;
import home.FrameDetailVocab;
import service.Authorization;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ItemDictionary extends JPanel {

	private JLabel lblWord;
	private JLabel lblWordType;
	private WordTypeDAOImpl typeDao;

	
	public ItemDictionary(Vocabulary vocab) {
		typeDao = new WordTypeDAOImpl();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameDetailVocab fr =  FrameDetailVocab.getMyInstance(vocab);
				
				if(!fr.isVisible()) {
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					fr.setLocation(dim.width/2-fr.getSize().width/2, dim.height/2-fr.getSize().height/2);
					fr.setVisible(true);
				}
				
				UserDAOImpl dao = new UserDAOImpl();
				if(new HistoryDAOImpl().checkAllExistHistory(dao.selectIdByUserEmail(Authorization.email), vocab.getId()) ==null) {
					new HistoryDAOImpl().insert(new History(vocab.getId(),dao.selectIdByUserEmail(Authorization.email)));
				}
				fr.setVisible(true);
			}
		});
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(0,0, 213, 43);
		
		lblWord = new JLabel("New label");
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(7, 5, 196, 18);
		add(lblWord);
		lblWord.setText(toCapitalize(vocab.getWord()));
		
		lblWordType = new JLabel("New label");
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWordType.setBounds(45, 25, 85, 14);
		add(lblWordType);
		lblWordType.setText(typeDao.get(vocab.getWordTypeId()));
	}

	private String toCapitalize(String str) {
		if(str.length() <= 0) return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
