package home.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dao.impl.BookmarkDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Vocabulary;
import home.item.ItemVocab;
import service.Authorization;

public class PanelBookmark extends JPanel {

	public JPanel panelMain;
	public JScrollPane scrollPane;
	public JPanel panel;
	public JLabel lblNewLabel;
	private JPanel panelParent;

	public void initConstructor() {
		int id = UserDAOImpl.getIdFromDbByAccount(Authorization.email);
		Integer y = 0;
		if (new BookmarkDAOImpl().selectAllVocabByUserId(id) != null) {
			for(Vocabulary vocab : new BookmarkDAOImpl().selectAllVocabByUserId(id)) {
				ItemVocab item = new ItemVocab(vocab, y);
				panelMain.add(item);
				y+=29;
			}
			
		} else {
			panel.removeAll();
			lblNewLabel = new JLabel("Bạn Chưa Lưu Mục Nào!");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
			lblNewLabel.setBounds(354, 202, 544, 154);
			panel.add(lblNewLabel);
		}
		panelMain.setPreferredSize(new Dimension(300,y));
	}

	public PanelBookmark() {
		initComponent();
		initConstructor();
	}

	private void initComponent() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1302, 702);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1282, 691);
		add(panel);
		panel.setLayout(null);

		JLabel lblHeader = new JLabel("TỪ VỰNG YÊU THÍCH");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		lblHeader.setBounds(50, 30, 339, 50);
		panel.add(lblHeader);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		
		scrollPane.setViewportView(panelMain);
		panelMain.setLayout(null);
		
		panelParent = new JPanel();
		panelParent.setBounds(308, 132, 385, 549);
		panelParent.add(scrollPane);
		panel.add(panelParent);
		panelParent.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
