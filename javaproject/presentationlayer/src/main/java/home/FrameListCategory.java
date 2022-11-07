package home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.impl.CategoryDAOImpl;
import entity.Vocabulary;
import item.ItemDictionary;

import java.awt.GridLayout;
import java.awt.Color;

public class FrameListCategory extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public void initConstructor() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(200, 200, 1300, 700);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(255, 255, 255));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(new GridLayout(2, 10, 2, 2));
//
//		for (Vocabulary vocab : new CategoryDAOImpl().selectAllVocabByCategoryId(id)) {
//			ItemDictionary item = new ItemDictionary(vocab);
//			contentPane.add(item);
//		}
	}

	public FrameListCategory(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 10, 2, 2));

		for (Vocabulary vocab : new CategoryDAOImpl().selectAllVocabByCategoryId(id)) {
			ItemDictionary item = new ItemDictionary(vocab);
			contentPane.add(item);
		}
	}

}
