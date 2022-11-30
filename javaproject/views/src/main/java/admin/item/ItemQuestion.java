package admin.item;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ItemQuestion extends JPanel {
	private JTextField textQuestion;
	private Panel panelQuestion;
	private JTextField textAnswer;
	private JTextField textQuestion2;
	private JTextField textAnswer2;
	private JTextField textQuestion3;
	private JTextField textAnswer3;
	private JComboBox<String> comboCategory;
	private JButton btnWatch;
	private JButton btnSa;
	private JButton btnThm;
	public ItemQuestion(int y) {
		initComponent(y);
	}

	private void initComponent(int y) {
		setBackground(new Color(192, 192, 192));
		setBounds(30, y, 930, 259);
		setLayout(null);

		panelQuestion = new Panel();
		panelQuestion.setBackground(Color.BLACK);
		panelQuestion.setBounds(95, 92, 350, 37);
		add(panelQuestion);
		panelQuestion.setLayout(new BorderLayout(0, 0));

		textQuestion = new JTextField();
		textQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textQuestion.setColumns(10);
		panelQuestion.add(textQuestion);

		JLabel lblQuestion = new JLabel("Câu hỏi");
		lblQuestion.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuestion.setBounds(10, 103, 65, 14);
		add(lblQuestion);

		JLabel lblAnswer = new JLabel("Câu trả lời");
		lblAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAnswer.setBounds(465, 103, 85, 14);
		add(lblAnswer);

		Panel panelExample = new Panel();
		panelExample.setBackground(Color.BLACK);
		panelExample.setBounds(570, 92, 350, 37);
		add(panelExample);
		panelExample.setLayout(new BorderLayout(0, 0));

		textAnswer = new JTextField();
		textAnswer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAnswer.setColumns(10);
		panelExample.add(textAnswer);

		Panel panelMeaning2 = new Panel();
		panelMeaning2.setBackground(Color.BLACK);
		panelMeaning2.setBounds(95, 152, 350, 37);
		add(panelMeaning2);
		panelMeaning2.setLayout(new BorderLayout(0, 0));

		textQuestion2 = new JTextField();
		textQuestion2.setHorizontalAlignment(SwingConstants.CENTER);
		textQuestion2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textQuestion2.setColumns(10);
		panelMeaning2.add(textQuestion2);

		JLabel lblQuestion_1 = new JLabel("Câu hỏi");
		lblQuestion_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuestion_1.setBounds(10, 164, 65, 14);
		add(lblQuestion_1);

		JLabel lblAnswer_1 = new JLabel("Câu trả lời");
		lblAnswer_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAnswer_1.setBounds(465, 164, 85, 14);
		add(lblAnswer_1);

		Panel panelExample_1 = new Panel();
		panelExample_1.setBackground(Color.BLACK);
		panelExample_1.setBounds(570, 152, 350, 37);
		add(panelExample_1);
		panelExample_1.setLayout(new BorderLayout(0, 0));

		textAnswer2 = new JTextField();
		textAnswer2.setHorizontalAlignment(SwingConstants.CENTER);
		textAnswer2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAnswer2.setColumns(10);
		panelExample_1.add(textAnswer2, BorderLayout.CENTER);

		JLabel lblQuestion_1_1 = new JLabel("Câu hỏi");
		lblQuestion_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuestion_1_1.setBounds(10, 224, 65, 14);
		add(lblQuestion_1_1);

		Panel panelMeaning_1_1 = new Panel();
		panelMeaning_1_1.setBackground(Color.BLACK);
		panelMeaning_1_1.setBounds(95, 212, 350, 37);
		add(panelMeaning_1_1);
		panelMeaning_1_1.setLayout(new BorderLayout(0, 0));

		textQuestion3 = new JTextField();
		textQuestion3.setHorizontalAlignment(SwingConstants.CENTER);
		textQuestion3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textQuestion3.setColumns(10);
		panelMeaning_1_1.add(textQuestion3, BorderLayout.CENTER);

		JLabel lblAnswer_1_1 = new JLabel("Câu trả lời");
		lblAnswer_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAnswer_1_1.setBounds(465, 224, 85, 14);
		add(lblAnswer_1_1);

		Panel panelExample_1_1 = new Panel();
		panelExample_1_1.setBackground(Color.BLACK);
		panelExample_1_1.setBounds(570, 212, 350, 37);
		add(panelExample_1_1);
		panelExample_1_1.setLayout(new BorderLayout(0, 0));

		textAnswer3 = new JTextField();
		textAnswer3.setHorizontalAlignment(SwingConstants.CENTER);
		textAnswer3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAnswer3.setColumns(10);
		panelExample_1_1.add(textAnswer3, BorderLayout.CENTER);

		JLabel lblVocab = new JLabel("Từ vựng");
		lblVocab.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVocab.setBounds(10, 33, 65, 14);
		add(lblVocab);
		
		comboCategory = new JComboBox<String>();
		comboCategory.setFont(new Font("Arial", Font.PLAIN, 16));
		comboCategory.setBackground(Color.WHITE);
		comboCategory.setBounds(95, 20, 350, 38);
		add(comboCategory);
		
		btnWatch = new JButton("Xem");
		btnWatch.setBounds(467, 20, 130, 37);
		add(btnWatch);
		
		btnSa = new JButton("Sửa");
		btnSa.setBounds(630, 20, 130, 37);
		add(btnSa);
		
		btnThm = new JButton("Thêm");
		btnThm.setBounds(790, 20, 130, 37);
		add(btnThm);
	}
}
