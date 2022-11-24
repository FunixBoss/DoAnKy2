package home.panel;

import java.awt.Color;
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
	/**
	 * Create the panel.
	 */
	public  void initConstructor() {
		if(Authorization.email!=null) {
			panel.removeAll();
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBounds(10, 11, 1262, 669);
			panel.add(scrollPane);
			
			JPanel panelMain = new JPanel();
			panelMain.setBackground(new Color(255, 255, 255));
			scrollPane.setViewportView(panelMain);
			panelMain.setLayout(new GridLayout(10, 2, 2, 2));
			
			
			panelMain.removeAll();
			
			
			UserDAOImpl user= new UserDAOImpl();
			int id = user.getIdFromDbByAccount(Authorization.email);
			if( new BookmarkDAOImpl().selectAllVocabByUserId(id) !=null ) {
				for (Vocabulary vocab : new BookmarkDAOImpl().selectAllVocabByUserId(id)) { 
					ItemVocab item = new ItemVocab(vocab);
					panelMain.add(item);
				}
			}else {
				panel.removeAll();
				lblNewLabel = new JLabel("Bạn Chưa Lưu Mục Nào!");
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
				lblNewLabel.setBounds(354, 202, 544, 154);
				panel.add(lblNewLabel);
			}
		}
		else {
			panel.removeAll();
			lblNewLabel = new JLabel("Vui Lòng Đăng Nhập Để Sử Dụng!!");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
			lblNewLabel.setBounds(354, 202, 544, 154);
			panel.add(lblNewLabel);
			
		}
		
	}
	
	public PanelBookmark() {
		initComponent();
		initConstructor();
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
		scrollPane.setBounds(10, 11, 1262, 669);
		panel.add(scrollPane);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		
		scrollPane.setViewportView(panelMain);
		panelMain.setLayout(new GridLayout(5, 2, 2, 2));
	}

}
