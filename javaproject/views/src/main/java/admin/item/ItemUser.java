package admin.item;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import entity.User;
import service.UserService;

public class ItemUser extends JPanel {

	private JLabel lblEmail;

	public ItemUser(User user, int y) {
		setLayout(null);
		setBounds(0, y, 995, 53);

		JPanel panel = new JPanel();
		panel.setBounds(0, 52, 995, 1);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));

		JPanel panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelHeader.setLayout(null);
		panelHeader.setBounds(0, 0, 995, 50);
		add(panelHeader);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 55, 50);
		panelHeader.add(panel_1);

		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(37, 57, 111));
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setBounds(20, 18, 33, 18);
		panel_1.add(lblID);
		lblID.setText(user.getId().toString());


		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(255, 255, 255));
		panel_1_2.setBounds(55, 0, 270, 50);
		panelHeader.add(panel_1_2);

		lblEmail = new JLabel();
		lblEmail.setForeground(new Color(37, 57, 111));
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(36, 18, 224, 18);
		panel_1_2.add(lblEmail);
		lblEmail.setText(user.getEmail());

	}


}
