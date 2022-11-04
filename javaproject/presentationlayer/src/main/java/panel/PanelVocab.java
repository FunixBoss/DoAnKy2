package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.User;
import entity.Vocabulary;
import insert.FrameRelative;
import insert.FrameVocab;
import insert.FrameWordType;
import item.ItemMember;
import item.ItemVocab;

import java.awt.Dimension;

public class PanelVocab extends JPanel {

	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0;
	Double totalPage = 0.0;
	private JLabel lblStatusPage;
	private JLabel lblRowCount;
	private JTextField textField;
	private JTable table;

	/* Create the panel. */
	public PanelVocab() {
		setLayout(null);
		setBounds(0, 0, 1085, 699);
		setBackground(new Color(242, 247, 255));
		JLabel lblDashboard = new JLabel("Từ vựng");
		lblDashboard.setForeground(new Color(37, 57, 111));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		lblDashboard.setBounds(43, 11, 134, 39);
		add(lblDashboard);

		JLabel lblBreadcrumb = new JLabel("Trang chủ / Từ vựng");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(904, 21, 134, 14);
		add(lblBreadcrumb);

		lblStatusPage = new JLabel("Trang 1 of 0");
		lblStatusPage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStatusPage.setBounds(226, 642, 76, 39);
		add(lblStatusPage);

		lblRowCount = new JLabel("Số dòng: 0");
		lblRowCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRowCount.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRowCount.setBounds(769, 642, 104, 27);
		add(lblRowCount);

		JButton btnFirst = new JButton("Trang đầu");
		btnFirst.setForeground(new Color(255, 255, 255));
		btnFirst.setFont(new Font("Arial", Font.BOLD, 12));
		btnFirst.setBackground(new Color(67, 98, 190));
		btnFirst.setBounds(115, 591, 121, 40);
		add(btnFirst);

		JButton btnLast = new JButton("Trang cuối");
		btnLast.setForeground(new Color(255, 255, 255));
		btnLast.setFont(new Font("Arial", Font.BOLD, 12));
		btnLast.setBackground(new Color(67, 98, 190));
		btnLast.setBounds(853, 591, 121, 40);
		add(btnLast);

		JButton btnPrevious = new JButton("Trang trước");
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setFont(new Font("Arial", Font.BOLD, 12));
		btnPrevious.setBackground(new Color(67, 98, 190));
		btnPrevious.setBounds(275, 591, 121, 40);
		add(btnPrevious);

		JButton btnNext = new JButton("Trang sau");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Arial", Font.BOLD, 12));
		btnNext.setBackground(new Color(67, 98, 190));
		btnNext.setBounds(693, 591, 121, 40);
		add(btnNext);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "50" }));
		comboBox_1.setBounds(435, 591, 220, 40);
		add(comboBox_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 120, 995, 448);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(975, 600));
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(null);
		panelHeader.setBounds(0, 0, 990, 40);
		panel.add(panelHeader);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(37, 57, 111));
		panel_1.setBounds(0, 0, 55, 40);
		panelHeader.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("STT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 12, 35, 13);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(37, 57, 111));
		panel_1_1.setBounds(907, 0, 88, 40);
		panelHeader.add(panel_1_1);
		
		JLabel lblXa = new JLabel("Xóa");
		lblXa.setForeground(Color.WHITE);
		lblXa.setFont(new Font("Arial", Font.BOLD, 14));
		lblXa.setBounds(10, 8, 47, 20);
		panel_1_1.add(lblXa);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(37, 57, 111));
		panel_1_1_1.setBounds(827, 0, 88, 40);
		panelHeader.add(panel_1_1_1);
		
		JLabel lblEdit = new JLabel("Sửa");
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdit.setBounds(0, 8, 47, 20);
		panel_1_1_1.add(lblEdit);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(37, 57, 111));
		panel_1_2.setBounds(55, 0, 136, 40);
		panelHeader.add(panel_1_2);
		
		JLabel lblWord = new JLabel("Từ vựng");
		lblWord.setForeground(Color.WHITE);
		lblWord.setFont(new Font("Arial", Font.BOLD, 14));
		lblWord.setBounds(36, 12, 90, 13);
		panel_1_2.add(lblWord);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(37, 57, 111));
		panel_1_2_1.setBounds(320, 0, 130, 40);
		panelHeader.add(panel_1_2_1);
		
		JLabel lblCategory = new JLabel("Chủ đề");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
		lblCategory.setBounds(22, 12, 96, 13);
		panel_1_2_1.add(lblCategory);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(37, 57, 111));
		panel_2.setBounds(450, 0, 150, 40);
		panelHeader.add(panel_2);
		
		JLabel lblImage = new JLabel("Hình ảnh");
		lblImage.setForeground(Color.WHITE);
		lblImage.setFont(new Font("Arial", Font.BOLD, 14));
		lblImage.setBounds(10, 12, 109, 15);
		panel_2.add(lblImage);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(37, 57, 111));
		panel_2_1.setBounds(600, 0, 234, 40);
		panelHeader.add(panel_2_1);
		
		JLabel lblMeaning = new JLabel("Ý nghĩa");
		lblMeaning.setForeground(Color.WHITE);
		lblMeaning.setFont(new Font("Arial", Font.BOLD, 14));
		lblMeaning.setBounds(25, 10, 109, 20);
		panel_2_1.add(lblMeaning);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(new Color(37, 57, 111));
		panel_1_2_2.setBounds(191, 0, 130, 40);
		panelHeader.add(panel_1_2_2);
		
		JLabel lblWordType = new JLabel("Loại từ");
		lblWordType.setForeground(Color.WHITE);
		lblWordType.setFont(new Font("Arial", Font.BOLD, 14));
		lblWordType.setBounds(36, 12, 90, 13);
		panel_1_2_2.add(lblWordType);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 40, 995, 460);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		int y = 0;
		for(Vocabulary vocab : new VocabularyDAOImpl(). selectAll()){
			ItemVocab vocabItem = new 	ItemVocab(vocab, y);			
			panel_3.add(vocabItem);
			y = y + 84;
		}

		textField = new JTextField();
		textField.setMargin(new Insets(2, 6, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(45, 61, 273, 36);
		add(textField);

		JButton btnAdd = new JButton("Thêm từ vựng");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setBounds(891, 61, 147, 36);
		add(btnAdd);

		JButton btnWordType = new JButton("Thêm loại từ");
		btnWordType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnWordType_actionPerformed(e);
			}
		});
		btnWordType.setForeground(Color.WHITE);
		btnWordType.setFont(new Font("Arial", Font.BOLD, 14));
		btnWordType.setBorder(null);
		btnWordType.setBackground(new Color(67, 98, 190));
		btnWordType.setBounds(726, 61, 147, 36);
		add(btnWordType);

		JButton btnRelative = new JButton("Thêm từ liên quan");
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnRelative_actionPerformed(e);
			}
		});
		btnRelative.setForeground(Color.WHITE);
		btnRelative.setFont(new Font("Arial", Font.BOLD, 14));
		btnRelative.setBorder(null);
		btnRelative.setBackground(new Color(67, 98, 190));
		btnRelative.setBounds(560, 61, 147, 36);
		add(btnRelative);

		
		totalPage = Math.ceil(totalOfRows / rowsOfPage);

		// lbl
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		lblRowCount.setText("Row Count: " + totalOfRows);

		// handle
	
	}
	

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		FrameVocab frame = new FrameVocab();
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

	protected void do_btnWordType_actionPerformed(ActionEvent e) {
		FrameWordType frame = new FrameWordType();
		frame.setLocation(500, 300);
		frame.setVisible(true);
	}

	protected void do_btnRelative_actionPerformed(ActionEvent e) {
		FrameRelative frame = new FrameRelative();
		frame.setLocation(500, 300);
		frame.setVisible(true);
	}
}
