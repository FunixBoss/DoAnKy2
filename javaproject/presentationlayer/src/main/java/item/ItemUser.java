package item;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import entity.User;
import update.FrameMember;

public class ItemUser extends JPanel {

	private JLabel lblPhone;
	private JLabel lblDob;
	private JLabel lblFullname;
	private JLabel lblEmail;
	/**
	 * Create the panel.
	 */
	public ItemUser(User user, int y) {
		setLayout(null);
		setBounds(0, y, 995, 40);
		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelHeader.setLayout(null);
		panelHeader.setBounds(0, 0, 995, 42);
		add(panelHeader);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 55, 40);
		panelHeader.add(panel_1);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(37, 57, 111));
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setBounds(20, 12, 33, 18);
		panel_1.add(lblID);
		lblID.setText(user.getId().toString());
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(898, 0, 95, 40);
		panelHeader.add(panel_1_1);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnDelete_actionPerformed(e);
			}
		});
		btnDelete.setBorder(null);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(5, 5, 60, 30);
		panel_1_1.add(btnDelete);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1_1.setBounds(798, 0, 100, 40);
		panelHeader.add(panel_1_1_1);
		
		JButton btnEdit = new JButton("Sửa ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnEdit_actionPerformed(e);
			}
		});
		btnEdit.setBorder(null);
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(67, 98, 190));
		btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
		btnEdit.setBounds(15, 5, 60, 30);
		panel_1_1_1.add(btnEdit);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(255, 255, 255));
		panel_1_2.setBounds(55, 0, 270, 40);
		panelHeader.add(panel_1_2);
		
		lblEmail = new JLabel();
		lblEmail.setForeground(new Color(37, 57, 111));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(36, 12, 224, 18);
		panel_1_2.add(lblEmail);
		lblEmail.setText(user.getEmail());
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(new Color(255, 255, 255));
		panel_1_2_1.setBounds(325, 0, 195, 40);
		panelHeader.add(panel_1_2_1);
		
		lblFullname = new JLabel("Họ và tên");
		lblFullname.setForeground(new Color(37, 57, 111));
		lblFullname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFullname.setBounds(22, 12, 187, 18);
		panel_1_2_1.add(lblFullname);
		lblFullname.setText(user.getFullname());
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(520, 0, 150, 40);
		panelHeader.add(panel_2);
		
		lblPhone = new JLabel("Số điện thoại");
		lblPhone.setForeground(new Color(37, 57, 111));
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhone.setBounds(12, 12, 109, 18);
		panel_2.add(lblPhone);
		lblPhone.setText(user.getPhoneNumber());
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(669, 0, 130, 40);
		panelHeader.add(panel_2_1);
		
		lblDob = new JLabel("Ngày sinh");
		lblDob.setForeground(new Color(37, 57, 111));
		lblDob.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDob.setBounds(10, 12, 125, 18);
		panel_2_1.add(lblDob);
		lblDob.setText(user.getDateOfBirth().toString());
	}
	protected void do_btnEdit_actionPerformed(ActionEvent e) {
		User user = new User();
		user.setFullname(lblFullname.getText());
		user.setPhoneNumber(lblPhone.getText());
		user.setDateOfBirth(LocalDate.parse(lblDob.getText()));
		user.setEmail(lblEmail.getText());
		FrameMember fr = new FrameMember(user);
		fr.setVisible(true);
		fr.setLocation(300, 300);
	}
	protected void do_btnDelete_actionPerformed(ActionEvent e) {
		
	}
}
