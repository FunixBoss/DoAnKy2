package admin.item;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ItemMeaning extends JPanel {
	private JTextField textField;
	private Panel panelMeaning2;
	private Panel panelExample2;
	private JTextArea textExample2;
	
	public ItemMeaning(int y) {
		initComponent(y);
	}

	private void initComponent(int y) {
		setBackground(new Color(255, 255, 255));
		setBounds(0, y, 1262, 149);
		setLayout(null);
		
		panelMeaning2 = new Panel();
		panelMeaning2.setLayout(null);
		panelMeaning2.setBackground(Color.BLACK);
		panelMeaning2.setBounds(142, 23, 362, 42);
		add(panelMeaning2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(0, 0, 362, 42);
		panelMeaning2.add(textField);
		
		panelExample2 = new Panel();
		panelExample2.setBackground(Color.BLACK);
		panelExample2.setBounds(628, 26, 462, 102);
		add(panelExample2);
		panelExample2.setLayout(null);
		
		textExample2 = new JTextArea();
		textExample2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample2.setBackground(Color.WHITE);
		textExample2.setBounds(1, 1, 460, 100);
		panelExample2.add(textExample2);
	}
}
