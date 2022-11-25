package home.panel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dao.impl.VocabularyDAOImpl;
import entity.Vocabulary;
import home.item.ItemVocab;
import javax.swing.JTextField;

public class PanelVocab extends JPanel {
	public JPanel panelMain;
	public JScrollPane scrollPane;
	public JPanel panel;
	public JLabel lblNewLabel;
	private JTextField textSearch;
	private JPanel panelDetailVocab;
	private ItemVocab item;
	private PanelDetailVocab detail;
	/**
	 * Create the panel.
	 */

	public PanelVocab() {
		initComponent();
		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		int y = 0;
		for (Vocabulary vocab : dao.selectAll()) {
			item = new ItemVocab(vocab, y);
			panelMain.add(item);
			y = y + 29;
		}
		
	}
	private void initComponent() {
		setBorder(null);
		setBackground(new Color(37, 57, 111));
		setBounds(0, 0, 1302, 702);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 60, 245, 623);
		panel.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(245, 1000));
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panelMain);
		panelMain.setLayout(null);
		panelMain.setBounds(0, 0, 245, 1000);
		
		textSearch = new JTextField();
		textSearch.setBounds(10, 10, 245, 40);
		panel.add(textSearch);
		textSearch.setColumns(10);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setBounds(0, 0, 265, 691);
		panel.add(panelSearch);
		
		panelDetailVocab = new JPanel();
		panelDetailVocab.setBounds(265, 0, 1017, 691);
		panel.add(panelDetailVocab);
		
		
	}
}
