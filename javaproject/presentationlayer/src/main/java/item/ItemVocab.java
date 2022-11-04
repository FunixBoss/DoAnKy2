package item;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import entity.Vocabulary;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ItemVocab extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemVocab(Vocabulary vocab, int y) {
		setLayout(null);
		setBounds(0, y, 980, 80);
		JPanel panelHeader_1 = new JPanel();
		panelHeader_1.setLayout(null);
		panelHeader_1.setBounds(0, 0, 980, 80);
		add(panelHeader_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 55, 80);
		panelHeader_1.add(panel_1);
		
		JLabel lblId = new JLabel("STT");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(12, 12, 35, 13);
		panel_1.add(lblId);
		lblId.setText(vocab.getId().toString());
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(895, 0, 85, 80);
		panelHeader_1.add(panel_1_1);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(10, 23, 60, 30);
		panel_1_1.add(btnDelete);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1.setBounds(810, 0, 99, 80);
		panelHeader_1.add(panel_1_1_1);
		
		JButton btnEdit = new JButton("Sửa ");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
		btnEdit.setBorder(null);
		btnEdit.setBackground(new Color(67, 98, 190));
		btnEdit.setBounds(10, 22, 60, 30);
		panel_1_1_1.add(btnEdit);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(255, 255, 255));
		panel_1_2.setBounds(55, 0, 136, 80);
		panelHeader_1.add(panel_1_2);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setForeground(new Color(0, 0, 0));
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWord.setBounds(36, 12, 90, 13);
		panel_1_2.add(lblWord);
		lblWord.setText(vocab.getWord());
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(255, 255, 255));
		panel_1_2_1.setBounds(320, 0, 130, 80);
		panelHeader_1.add(panel_1_2_1);
		
		JLabel lblCategory = new JLabel();
		lblCategory.setForeground(new Color(0, 0, 0));
		lblCategory.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCategory.setBounds(22, 8, 96, 20);
		panel_1_2_1.add(lblCategory);
		lblCategory.setText(vocab.getCategoryId().toString());
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(450, 0, 150, 80);
		panelHeader_1.add(panel_2);
		
		JLabel lblImage = new JLabel("Hình ảnh");
		lblImage.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Desktop\\DoAnKy2-main\\DoAnKy2-main\\javaproject\\presentationlayer\\src\\main\\resources\\vocabulary\\greet.png"));
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));
		lblImage.setBounds(20, 10, 109, 60);
		panel_2.add(lblImage);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(610, 0, 210, 80);
		panelHeader_1.add(panel_2_1);
		
		JLabel lblMeaning = new JLabel("");
		lblMeaning.setForeground(new Color(0, 0, 0));
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning.setBounds(25, 8, 109, 20);
		panel_2_1.add(lblMeaning);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(new Color(255, 255, 255));
		panel_1_2_2.setBounds(191, 0, 130, 80);
		panelHeader_1.add(panel_1_2_2);
		
		JLabel lblWordType = new JLabel();
		lblWordType.setForeground(new Color(0, 0, 0));
		lblWordType.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWordType.setBounds(36, 12, 90, 13);
		panel_1_2_2.add(lblWordType);
		lblWordType.setText(vocab.getWordTypeId().toString());
	}
}
