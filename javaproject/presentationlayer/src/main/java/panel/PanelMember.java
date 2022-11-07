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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.impl.CategoryDAOImpl;
import dao.impl.UserDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.User;
import entity.Vocabulary;
import insert.FrameInsertMember;
import item.ItemUser;
import item.ItemVocab;

public class PanelMember extends JPanel {
	private JLabel lblStatusPage;
	private JLabel lblRowCount;	
	private JPanel panel;
	private JScrollPane scrollPane;
	private UserDAOImpl dao; // data
	
//	Controll data
	private Integer pageNumber;
	private Integer rowsOfPage;
	private Integer totalOfRows;
	private Integer totalPage;
	private JTextField txtPage;
	private JComboBox cbbNumberOfRows;

	public PanelMember() {
		dao = new UserDAOImpl();
		pageNumber = 1;
		rowsOfPage = dao.countNumberOfUser() > 10 ? 10 : dao.countNumberOfUser();
		
		setLayout(null);
		setBounds(0, 0, 1085, 699);
		setBackground(new Color(242, 247, 255));
		JLabel lblDashboard = new JLabel("Thành viên");
		lblDashboard.setForeground(new Color(37, 57, 111));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		lblDashboard.setBounds(41, 11, 134, 39);
		add(lblDashboard);
		
		printTopPageComponent();
		printControllComponent();
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(43, 120, 995, 448);
		add(scrollPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		loadData();
	}
	private void printTopPageComponent() {
		JLabel lblBreadcrumb = new JLabel("Trang chủ / Thành viên");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(904, 21, 134, 14);
		add(lblBreadcrumb);
		
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
		btnAdd.setBounds(891, 61, 147, 36);
		add(btnAdd);
	}
	
	private void printTitleComponent(JPanel panel) {
		JPanel panelHeader = new JPanel();
		panelHeader.setLayout(null);
		panelHeader.setBounds(0, 0, 990, 40);
		panel.add(panelHeader);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(37, 57, 111));
		panel_1.setBounds(0, 0, 55, 50);
		panelHeader.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("ID");
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
	}
	
	private void printControllComponent() {
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
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstActionPerformed(e);
			}
		});
		btnFirst.setForeground(new Color(255, 255, 255));
		btnFirst.setFont(new Font("Arial", Font.BOLD, 12));
		btnFirst.setBackground(new Color(67, 98, 190));
		btnFirst.setBounds(115, 591, 121, 40);
		add(btnFirst);

		JButton btnLast = new JButton("Trang cuối");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		btnLast.setForeground(new Color(255, 255, 255));
		btnLast.setFont(new Font("Arial", Font.BOLD, 12));
		btnLast.setBackground(new Color(67, 98, 190));
		btnLast.setBounds(853, 591, 121, 40);
		add(btnLast);

		JButton btnPrevious = new JButton("Trang trước");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setFont(new Font("Arial", Font.BOLD, 12));
		btnPrevious.setBackground(new Color(67, 98, 190));
		btnPrevious.setBounds(275, 591, 121, 40);
		add(btnPrevious);

		JButton btnNext = new JButton("Trang sau");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Arial", Font.BOLD, 12));
		btnNext.setBackground(new Color(67, 98, 190));
		btnNext.setBounds(693, 591, 121, 40);
		add(btnNext);

		cbbNumberOfRows = new JComboBox();
		cbbNumberOfRows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbNumberOfRowsActionPerformed(e);
			}
		});
		cbbNumberOfRows.setFont(new Font("Arial", Font.BOLD, 12));
		cbbNumberOfRows.setModel(new DefaultComboBoxModel(new String[] { "10", "20", "50" }));
		cbbNumberOfRows.setBounds(435, 591, 220, 40);
		add(cbbNumberOfRows);
		
		txtPage = new JTextField();
		txtPage.setBounds(435, 645, 220, 40);
		txtPage.setColumns(10);
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		add(txtPage);
		
	}
	
	
	private void loadData() {
		if(dao.getList(2) != null) {
			dao.getList(2).clear();
			panel.removeAll();
			totalOfRows = dao.countNumberOfUser();
			totalPage = (int) Math.ceil((double) totalOfRows / rowsOfPage);
			lblStatusPage.setText("Trang " + pageNumber + " / " + totalPage);
			lblRowCount.setText("Số dòng: " + totalOfRows);
			panel.setPreferredSize(new Dimension(975, rowsOfPage * 63));

			int y = 40;
			printTitleComponent(panel);
			scrollPane.setViewportView(panel);
			for(User user : dao.selectByPages(pageNumber, rowsOfPage)){
				ItemUser userItem = new ItemUser(user, y);			
				panel.add(userItem);
				y = y + 60;
			}	
		} else {
			JLabel noData = new JLabel("No Data");
			noData.setBounds(0, 0, 50, 50);
			panel.add(noData);
		}
			
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		FrameInsertMember frame = FrameInsertMember.getMyInstance();
		if(!frame.isVisible()) {
			frame.setLocation(300, 300);
			frame.setVisible(true);
		}
	}
	
	protected void txtPageActionPerformed(ActionEvent e) {
		if(txtPage.getText() != null) {
			try {
				int page = Integer.parseInt(txtPage.getText());
				if(page >= 1 && page <= totalPage) {
					pageNumber = page;
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "page must be 1 to " + (int) Math.ceil(totalPage));
					txtPage.setText(pageNumber.toString());
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(panel, "Chỉ được phép nhập số!");
			}
		} else {
			pageNumber = 1;
			loadData();
		}
	}
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadData();
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if(pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadData();
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if(pageNumber < totalPage) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadData();
		}
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		loadData();
	}
	protected void cbbNumberOfRowsActionPerformed(ActionEvent e) {
		if(dao != null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowsOfPage = Integer.parseInt(cbbNumberOfRows.getSelectedItem().toString());
			loadData();
		}
	}
}
