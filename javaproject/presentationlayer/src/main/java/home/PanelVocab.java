package home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dao.impl.HistoryDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.Vocabulary;
import item.ItemDictionary;
import service.Authorization;

import java.awt.GridLayout;

public class PanelVocab extends JPanel {
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
			for (Vocabulary vocab : new VocabularyDAOImpl().selectAll()) {
				ItemDictionary item = new ItemDictionary(vocab);
				panelMain.add(item);
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
	public  void initConstructor(String str) {
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
			try {
				if(new VocabularyDAOImpl().searchAll(str)!= null) {
					for (Vocabulary vocab : new VocabularyDAOImpl().searchAll(str)) {
						ItemDictionary item = new ItemDictionary(vocab);
						panelMain.add(item);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
	
	
	
	public PanelVocab() {
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
		panelMain.setLayout(new GridLayout(10, 2, 2, 2));

		initConstructor();
		
	}
	public static void main(String[] args) {
	}
}
