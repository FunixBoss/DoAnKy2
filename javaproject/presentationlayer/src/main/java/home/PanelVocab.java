package home;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dao.impl.VocabularyDAOImpl;
import entity.Vocabulary;
import item.ItemDictionary;
import java.awt.GridLayout;

public class PanelVocab extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelVocab() {
		setBorder(null);
		setBackground(new Color(37, 57, 111));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 11, 1262, 669);
		panel.add(scrollPane);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panelMain);
		panelMain.setLayout(new GridLayout(10, 2, 2, 2));

	
		for (Vocabulary vocab : new VocabularyDAOImpl().selectAll()) {
			ItemDictionary item = new ItemDictionary(vocab);
			panelMain.add(item);
		}
	}
}
