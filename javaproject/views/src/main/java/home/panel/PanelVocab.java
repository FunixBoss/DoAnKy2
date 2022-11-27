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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Font;

public class PanelVocab extends JPanel {
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textSearch;
	private JPanel panelDetailVocab;
	private ItemVocab item;
	private PanelDetailVocab detail;
	private JPanel panelSearch;
	private JList<Vocabulary> listVocab;
	private List<String> getItemss;
	private List<Vocabulary> itemss;
	private DefaultListModel<String> model;
	/**
	 * Create the panel.
	 */

	public PanelVocab() {
		initComponent();
		

		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		 itemss = dao.selectAll();
		getItemss = new ArrayList<>();
		for (int i = 0; i < itemss.size(); i++) {
			getItemss.add(i, itemss.get(i).getWord());
		}

		int y = 0;

		for (int i = 0; i < getItemss.size(); i++) {
			item = new ItemVocab(itemss.get(i), y);
			model.add(i, getItemss.get(i));
			y = y + 29;
		}
		
	}

	public void searchVocab() {
		model.removeAllElements();
		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		 itemss = dao.searchAll(textSearch.getText());
		for (int i = 0; i < itemss.size(); i++) {
			model.add(i, itemss.get(i).getWord());
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

		panelSearch = new JPanel();
		panelSearch.setBounds(0, 0, 265, 691);
		panel.add(panelSearch);
		panelSearch.setLayout(null);

		textSearch = new JTextField();
		textSearch.setBounds(59, 11, 134, 28);
		panelSearch.add(textSearch);
		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchVocab();
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 54, 245, 626);
		panelSearch.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(245, 1000));
		
		 model = new DefaultListModel<>();
		listVocab = new JList(model);
		scrollPane.setViewportView(listVocab);

		listVocab.setFont(new Font("Tahoma", Font.BOLD, 18));

		panelDetailVocab = new JPanel();
		panelDetailVocab.setBounds(265, 0, 1017, 691);
		panel.add(panelDetailVocab);
		panelDetailVocab.setLayout(null);

	}
}
