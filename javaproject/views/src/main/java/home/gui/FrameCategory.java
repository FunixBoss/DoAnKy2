package home.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.impl.CategoryDAOImpl;
import entity.Vocabulary;
import helper.FrameUtils;
import home.item.ItemVocab;

import java.awt.GridLayout;
import java.awt.Color;

public class FrameCategory extends JFrame {

	private JPanel contentPane;

	public FrameCategory(Integer cateId) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 5, 2, 2));

		for (Vocabulary vocab : new CategoryDAOImpl().selectAllVocabByCategoryId(cateId)) {
			ItemVocab item = new ItemVocab(vocab,21);
			contentPane.add(item);
		}
		
		FrameUtils.alignFrameScreenCenter(this);
	}

}
