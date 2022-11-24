package home.item;

import javax.swing.JPanel;
import entity.Example;
import entity.Meaning;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ItemContent extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemContent(Meaning meaning, Example example, int y) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(40, y, 491, 106);
		JLabel lblMeaning = new JLabel((String) null);
		lblMeaning.setForeground(new Color(37, 57, 111));
		lblMeaning.setFont(new Font("Arial", Font.BOLD, 14));
		lblMeaning.setBackground(Color.BLACK);
		lblMeaning.setBounds(10, 11, 344, 27);
		add(lblMeaning);
		lblMeaning.setText(meaning.getContent());
		
		JLabel lblExample = new JLabel((String) null);
		lblExample.setFont(new Font("Arial", Font.PLAIN, 14));
		lblExample.setBounds(10, 40, 344, 27);
		add(lblExample);
		lblExample.setText(example.getContent());
		
		JLabel lblContent = new JLabel((String) null);
		lblContent.setFont(new Font("Arial", Font.ITALIC, 14));
		lblContent.setBounds(10, 68, 344, 27);
		add(lblContent);
		lblContent.setText(example.getMeaning());
		
	}
}
