package home.insert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import dao.impl.UserDAOImpl;
import dao.impl.VocabularyContributionDAOImpl;
import entity.User;
import entity.VocabularyContribution;
import home.item.ItemMeaning;
import service.Authorization;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelInsertVocab extends JPanel {
	private JPanel panel;
	private JTextField textWord;
	private JTextField textMeaning;
	private Container panelMain;
	private JTextArea textExample;
	private Panel panelExample;
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
		panelMain.setBounds(10, 91, 1262, 596);
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

//		Panel panelMeaning = new Panel();
//		panelMeaning.setLayout(null);
//		panelMeaning.setBackground(Color.BLACK);
//		panelMeaning.setBounds(147, 125, 362, 42);
//		panelMain.add(panelMeaning);

		
		 panelExample = new Panel();
		panelExample.setBackground(Color.BLACK);
		panelExample.setBounds(147, 122, 341, 100);
		panelMain.add(panelExample);
		panelExample.setLayout(new BorderLayout(0, 0));

		textExample = new JTextArea();
		textExample.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		textExample.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textExample.setBackground(Color.WHITE);
		panelExample.add(textExample);
//		
		JScrollPane jspEx1 = new JScrollPane(textExample, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelExample.add(jspEx1);
//		
//		
//		
		
		JLabel lblMeaning = new JLabel("Ý nghĩa :");
		lblMeaning.setForeground(Color.BLACK);
		lblMeaning.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMeaning.setBounds(41, 109, 74, 21);
		panelMain.add(lblMeaning);

		JButton btnngGp = new JButton("Đóng góp");
		btnngGp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnngGpActionPerformed(e);
			}
		});
		
		btnngGp.setBorder(null);
		btnngGp.setForeground(Color.WHITE);
		btnngGp.setFont(new Font("Arial", Font.BOLD, 16));
		btnngGp.setBackground(new Color(67, 98, 190));
		btnngGp.setBounds(332, 51, 150, 44);
		panelMain.add(btnngGp);

	}
	protected void btnngGpActionPerformed(ActionEvent e) {
		UserDAOImpl user = new UserDAOImpl();
		VocabularyContribution contri = new VocabularyContribution(textWord.getText(), textExample.getText(), user.getIdFromDbByAccount(Authorization.email));
		new VocabularyContributionDAOImpl().insert(contri);
	}
}
