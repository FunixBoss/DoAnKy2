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
import insert.FrameRelative;
import insert.FrameVocab;
import insert.FrameWordType;

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

		table = new JTable() {
			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0 -> {
					return Integer.class;
				}
				case 1 -> {
					return String.class;
				}
				case 2 -> {
					return String.class;
				}
				case 3 -> {
					return String.class;
				}
				case 4 -> {
					return ImageIcon.class;
				}
				case 5 -> {
					return String.class;
				}
				case 6 -> {
					return String.class;
				}
				default -> {
					return String.class;
				}
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("Từ");
		model.addColumn("Nghĩa (VN)");
		model.addColumn("Phát Âm");
		model.addColumn("Hình Ảnh");
		model.addColumn("Sửa");
		model.addColumn("Xóa");
//		model.addColumn("Date of Birth");
//		model.addColumn("Created At");
//		model.addColumn("Update At");
		VocabularyDAOImpl dao = new VocabularyDAOImpl();
		totalPage = Math.ceil(totalOfRows / rowsOfPage);

		// lbl
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		lblRowCount.setText("Row Count: " + totalOfRows);

		// handle
		dao.selectAll()
				.forEach(vocab -> model.addRow(new Object[] {
					vocab.getId(),
					vocab.getWord(),
					null,
					vocab.getPronunciation(),					
					new ImageIcon(
						new ImageIcon(
							PanelVocab.class.getResource("/vocabulary/" + vocab.getImage())
						).getImage().getScaledInstance(100, 60, Image.SCALE_SMOOTH)
					),
					"Sửa",
					"Xóa"
				}));

		table.setModel(model);
		table.setRowHeight(60);
		table.getTableHeader().setBackground(new Color(37, 57, 111));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
		table.getTableHeader().setBounds(0, 0, 50, 39);
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
