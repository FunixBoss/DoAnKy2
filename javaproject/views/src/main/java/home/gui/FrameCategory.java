package home.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.impl.CategoryDAOImpl;
import entity.Vocabulary;
import helper.FrameUtils;
import home.item.ItemCategoryVocab;
import java.awt.GridLayout;
import java.awt.Color;

public class FrameCategory extends JFrame {

	private JPanel contentPane;

	public FrameCategory(Integer cateId) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 1010, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		int x = 10; 
		int y = 10;
		int z = 1;
		for (Vocabulary vocab : new CategoryDAOImpl().selectAllVocabByCategoryId(cateId)) {
			if (z % 2 != 0) {
				x = 10;
				ItemCategoryVocab item = new ItemCategoryVocab(vocab,y,x);
				contentPane.add(item);
				z = z + 1;
			} else if ( z % 3 == 0) {
				x = 680;
				ItemCategoryVocab item = new ItemCategoryVocab(vocab,y,x);
				contentPane.add(item);
				z = z + 1;
				y = y + 150;
			} else if (z % 2 == 0){
				x = 345;
				ItemCategoryVocab item = new ItemCategoryVocab(vocab,y,x);
				contentPane.add(item);
				z = z + 1;
			}
		}
		
		FrameUtils.alignFrameScreenCenter(this);
	}

}
