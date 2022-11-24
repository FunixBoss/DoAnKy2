package home.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.impl.CategoryDAOImpl;
import entity.Vocabulary;
import home.item.ItemVocab;

import java.awt.GridLayout;
import java.awt.Color;

public class FrameCategory extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameCategory(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 5, 2, 2));

		for (Vocabulary vocab : new CategoryDAOImpl().selectAllVocabByCategoryId(id)) {
			ItemVocab item = new ItemVocab(vocab);
			contentPane.add(item);
		}
	}

}
