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
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.awt.GridLayout;

public class PanelVocab extends JPanel {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textSearch;
	private JPanel panelDetailVocab;
	private ItemVocab item;
	private PanelDetailVocab detail;
	private JPanel panelLeft;
	private List<String> getItemss;
	private List<Vocabulary> itemss;
	private DefaultListModel<String> model;
	private JPanel panelParent;
	private JScrollPane scrollPane;
	private JPanel panelList;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private PanelDetailVocab panelDetail;

	/**
	 * Create the panel.
	 */

	public PanelVocab() {
		initComponent();

		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		itemss = dao.selectAll();
		int y = 0;

		for (int i = 0; i < itemss.size(); i++) {
			item = new ItemVocab(itemss.get(i), y,panelDetailVocab);
			panelList.add(item);
			y = y + 29;
		}
		panelList.setPreferredSize(new Dimension(100,y));
	}

	public void searchVocab() {
		panelList.removeAll();
		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		itemss = dao.searchAll(textSearch.getText());
		Integer y =0;
		for (int i = 0; i < itemss.size(); i++) {
			item = new ItemVocab(itemss.get(i), y,panelDetailVocab);
			panelList.add(item);
			y = y + 29;
		}
		panelList.setPreferredSize(new Dimension(100,y));
		panelList.revalidate();
		panelList.repaint();
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

		panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 265, 691);
		panel.add(panelLeft);
		panelLeft.setLayout(null);

		textSearch = new JTextField();
		textSearch.setBounds(59, 11, 134, 28);
		panelLeft.add(textSearch);
		
		 panelParent = new JPanel();
		panelParent.setBounds(10, 66, 245, 614);
		panelLeft.add(panelParent);
		panelParent.setLayout(new GridLayout(1, 0, 0, 0));
		
		 scrollPane = new JScrollPane();
		panelParent.add(scrollPane);
		
		 panelList = new JPanel();
		scrollPane.setViewportView(panelList);
		panelList.setLayout(null);
		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchVocab();
			}
		});


		panelDetailVocab = new JPanel();
		panelDetailVocab.setBounds(265, 0, 1017, 691);
		panel.add(panelDetailVocab);
		panelDetailVocab.setLayout(null);
		
		
		panelDetail = new PanelDetailVocab(new VocabularyDAOImpl().select(1));
		panelDetail.setBounds(25, 65, 966, 615);
		panelDetailVocab.add(panelDetail);

	}
}
