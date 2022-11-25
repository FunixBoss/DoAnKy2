package admin.item;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class ItemFeedback extends JPanel {
	private JPanel panel;
	private JPanel panelHeader;
	private JPanel panelID;
	private JLabel lblID;;
	private JPanel panelUser;
	private JLabel lblUser;
	private JPanel panelFeedback;
	private JLabel lblFeedback;

	public ItemFeedback() {
		setLayout(null);
		setBounds(0, 62, 995, 66);

		panel = new JPanel();
		panel.setBounds(0, 61, 995, 5);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));

		panelHeader = new JPanel();
		panelHeader.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panelHeader.setLayout(null);
		panelHeader.setBounds(0, 0, 995, 66);
		add(panelHeader);

		panelID = new JPanel();
		panelID.setLayout(null);
		panelID.setBackground(new Color(255, 255, 255));
		panelID.setBounds(0, 0, 55, 61);
		panelHeader.add(panelID);

		lblID = new JLabel("ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setForeground(new Color(37, 57, 111));
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setBounds(0, 0, 55, 61);
		panelID.add(lblID);

		panelUser = new JPanel();
		panelUser.setLayout(null);
		panelUser.setBackground(new Color(255, 255, 255));
		panelUser.setBounds(55, 0, 325, 61);
		panelHeader.add(panelUser);

		lblUser = new JLabel("User ID");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUser.setBounds(24, 10, 215, 41);
		panelUser.add(lblUser);

		panelFeedback = new JPanel();
		panelFeedback.setLayout(null);
		panelFeedback.setBackground(new Color(255, 255, 255));
		panelFeedback.setBounds(379, 0, 616, 61);
		panelHeader.add(panelFeedback);

		lblFeedback = new JLabel("Feedback");
		lblFeedback.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFeedback.setBounds(23, 10, 215, 41);
		panelFeedback.add(lblFeedback);

	}

}
