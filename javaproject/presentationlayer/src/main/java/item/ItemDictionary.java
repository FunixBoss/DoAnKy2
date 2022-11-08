package item;

import javax.swing.JPanel;

import dao.impl.HistoryDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.History;
import entity.Vocabulary;
import home.FrameDetailVocab;
import service.Authorization;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ItemDictionary extends JPanel {

	private JLabel lblWord;
	private JLabel lblWordType;

	
	public ItemDictionary(Vocabulary vocab) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameDetailVocab fr = new FrameDetailVocab(vocab);
				UserDAOImpl dao = new UserDAOImpl();
				if(new HistoryDAOImpl().checkAllExistHistory(dao.selectIdByUserEmail(Authorization.email), vocab.getId()) ==null) {
					new HistoryDAOImpl().insert(new History(vocab.getId(),dao.selectIdByUserEmail(Authorization.email)));
				}
				fr.setVisible(true);
				fr.setLocation(200, 200);
			}
		});
		setBackground(new Color(242, 247, 255));
		setLayout(null);
		setBounds(0,0, 213, 43);
		
		lblWord = new JLabel("New label");
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(7, 5, 196, 18);
		add(lblWord);
		lblWord.setText(vocab.getWord());
		
		lblWordType = new JLabel("New label");
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWordType.setBounds(45, 25, 85, 14);
		add(lblWordType);
		lblWordType.setText(vocab.getWordTypeId().toString());
		
	}


}
