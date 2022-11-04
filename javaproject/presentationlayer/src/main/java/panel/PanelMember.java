package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import dao.impl.UserDAOImpl;
import entity.User;
import insert.FrameMember;
import item.ItemMember;

public class PanelMember extends JPanel {
	Integer pageNumber = 1;
	Integer rowsOfPage = 10;
	Integer totalOfRows = 0; 
	Double totalPage = 0.0;
	private JLabel lblStatusPage;
	private JLabel lblRowCount;	
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public PanelMember() {
		setLayout(null);
		setBounds(0, 0, 1085, 729);
		setBackground(new Color(242, 247, 255));
		JLabel lblDashboard = new JLabel("Thành viên");
		lblDashboard.setForeground(new Color(37, 57, 111));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		lblDashboard.setBounds(41, 0, 134, 39);
		add(lblDashboard);
		
		JLabel lblBreadcrumb = new JLabel("Trang chủ / Thành viên");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(885, 0, 147, 13);
		add(lblBreadcrumb);
		
		lblStatusPage = new JLabel("Trang 1 of 0");
		lblStatusPage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblStatusPage.setBounds(225, 680, 76, 39);
		add(lblStatusPage);
		
		lblRowCount = new JLabel("Số dòng: 0");
		lblRowCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRowCount.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRowCount.setBounds(753, 686, 121, 27);
		add(lblRowCount);
		
		JButton btnFirst = new JButton("Trang đầu");
		btnFirst.setForeground(new Color(255, 255, 255));
		btnFirst.setFont(new Font("Arial", Font.BOLD, 12));
		btnFirst.setBackground(new Color(67, 98, 190));
		btnFirst.setBounds(115, 636, 121, 40);
		add(btnFirst);
		
		JButton btnLast = new JButton("Trang cuối");
		btnLast.setForeground(new Color(255, 255, 255));
		btnLast.setFont(new Font("Arial", Font.BOLD, 12));
		btnLast.setBackground(new Color(67, 98, 190));
		btnLast.setBounds(854, 636, 121, 40);
		add(btnLast);
		
		JButton btnPrevious = new JButton("Trang trước");
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setFont(new Font("Arial", Font.BOLD, 12));
		btnPrevious.setBackground(new Color(67, 98, 190));
		btnPrevious.setBounds(276, 636, 121, 40);
		add(btnPrevious);
		
		JButton btnNext = new JButton("Trang sau");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Arial", Font.BOLD, 12));
		btnNext.setBackground(new Color(67, 98, 190));
		btnNext.setBounds(694, 636, 121, 40);
		add(btnNext);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "50"}));
		comboBox_1.setBounds(436, 636, 220, 40);
		add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 105, 1000, 508);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(980, 400));
		panel.setBackground(new Color(242, 247, 255));
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
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(17, 12, 35, 13);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(37, 57, 111));
		panel_1_1.setBounds(915, 0, 88, 40);
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
		
		JLabel lblSa = new JLabel("Sửa");
		lblSa.setForeground(Color.WHITE);
		lblSa.setFont(new Font("Arial", Font.BOLD, 14));
		lblSa.setBounds(0, 8, 47, 20);
		panel_1_1_1.add(lblSa);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(37, 57, 111));
		panel_1_2.setBounds(55, 0, 270, 40);
		panelHeader.add(panel_1_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(36, 12, 59, 13);
		panel_1_2.add(lblEmail);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(37, 57, 111));
		panel_1_2_1.setBounds(325, 0, 197, 40);
		panelHeader.add(panel_1_2_1);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setForeground(Color.WHITE);
		lblHVTn.setFont(new Font("Arial", Font.BOLD, 14));
		lblHVTn.setBounds(22, 12, 96, 13);
		panel_1_2_1.add(lblHVTn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(37, 57, 111));
		panel_2.setBounds(520, 0, 150, 40);
		panelHeader.add(panel_2);
		
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Arial", Font.BOLD, 14));
		lblPhone.setBounds(8, 12, 109, 13);
		panel_2.add(lblPhone);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(37, 57, 111));
		panel_2_1.setBounds(670, 0, 165, 40);
		panelHeader.add(panel_2_1);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setForeground(Color.WHITE);
		lblNgySinh.setFont(new Font("Arial", Font.BOLD, 14));
		lblNgySinh.setBounds(10, 12, 109, 13);
		panel_2_1.add(lblNgySinh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 40, 990, 460);
		panel.add(panel_3);
		int y = 0;
		int x = 0;
		for(User user : new UserDAOImpl().getList(2)){
			ItemMember userItem = new ItemMember(user, y);			
			panel_3.add(userItem);
			y = y + 42;
			x = x + 44;
			panel.setPreferredSize(new Dimension(980, 40 + x));
		}
		
		textField = new JTextField();
		textField.setMargin(new Insets(2, 6, 2, 2));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(41, 42, 273, 36);
		add(textField);
		
		JButton btnAdd = new JButton("Thêm thành viên");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(67, 98, 190));
		btnAdd.setBounds(885, 41, 147, 36);
		add(btnAdd);

		totalPage = Math.ceil(totalOfRows/ rowsOfPage);
		
		// lbl
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		lblRowCount.setText("Row Count: " + totalOfRows);
		
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		FrameMember frame = new FrameMember();
		frame.setLocation(300, 300);
		frame.setVisible(true);
	}
}
