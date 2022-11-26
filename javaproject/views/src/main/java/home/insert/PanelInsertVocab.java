package home.insert;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import home.item.ItemMeaning;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInsertVocab extends JPanel {
	private JPanel panel;
	private JTextField textWord;
	private JTextField textMeaning;
	private Container panelMain;
	private int i = 66;
	private int y = 178;
	
	public PanelInsertVocab() {
		initComponent();
	}

	private void initComponent() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1302, 702);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1282, 702);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblHeader = new JLabel("ĐÓNG GÓP TỪ VỰNG");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		lblHeader.setBounds(50, 30, 339, 50);
		panel.add(lblHeader);
		
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBounds(10, 96, 1262, 596);
		panel.add(panelMain);
		panelMain.setLayout(null);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setForeground(Color.BLACK);
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(41, 36, 84, 21);
		panelMain.add(lblWord);
		
		textWord = new JTextField();
		textWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textWord.setColumns(10);
		textWord.setBounds(147, 52, 175, 42);
		panelMain.add(textWord);
		
		Panel panelMeaning = new Panel();
		panelMeaning.setLayout(null);
		panelMeaning.setBackground(Color.BLACK);
		panelMeaning.setBounds(147, 125, 362, 42);
		panelMain.add(panelMeaning);
		
		textMeaning = new JTextField();
		textMeaning.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMeaning.setColumns(10);
		textMeaning.setBounds(0, 0, 362, 42);
		panelMeaning.add(textMeaning);
		
		JLabel lblMeaning = new JLabel("Ý nghĩa :");
		lblMeaning.setForeground(Color.BLACK);
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning.setBounds(41, 109, 74, 21);
		panelMain.add(lblMeaning);
		
		JButton btnngGp = new JButton("Đóng góp");
		btnngGp.setBorder(null);
		btnngGp.setForeground(Color.WHITE);
		btnngGp.setFont(new Font("Arial", Font.BOLD, 16));
		btnngGp.setBackground(new Color(67, 98, 190));
		btnngGp.setBounds(665, 34, 150, 44);
		panelMain.add(btnngGp);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBorder(null);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPlus_actionPerformed(e);
			}
		});
		btnPlus.setForeground(Color.WHITE);
		btnPlus.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlus.setBackground(new Color(67, 98, 190));
		btnPlus.setBounds(556, 123, 44, 44);
		panelMain.add(btnPlus);
		
	}
	
	protected void do_btnPlus_actionPerformed(ActionEvent e) {
		ItemMeaning item = new ItemMeaning(y);
		panelMain.add(item);
		y = y + i;
	}
}
