package panel;

import java.awt.Color;
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

public class PanelDashboard extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDashboard() {
		setLayout(null);
		setBounds(0, 0, 1085, 699);
		setBackground(new Color(242, 247, 255));
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(37, 57, 111));
		lblDashboard.setFont(new Font("Arial", Font.BOLD, 20));
		lblDashboard.setBounds(43, 11, 134, 39);
		add(lblDashboard);
		
		JLabel lblBreadcrumb = new JLabel("Trang chủ / Dashboard");
		lblBreadcrumb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreadcrumb.setBounds(904, 21, 134, 14);
		add(lblBreadcrumb);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(43, 90, 216, 119);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblVocab = new JLabel("Từ vựng");
		lblVocab.setFont(new Font("Arial", Font.BOLD, 14));
		lblVocab.setBounds(22, 11, 68, 21);
		panel.add(lblVocab);
		
		JLabel lblVocabNum = new JLabel("22");
		lblVocabNum.setBackground(new Color(37, 57, 111));
		lblVocabNum.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVocabNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocabNum.setBounds(100, 34, 93, 63);
		panel.add(lblVocabNum);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(300, 90, 216, 119);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTopic = new JLabel("Chủ đề");
		lblTopic.setFont(new Font("Arial", Font.BOLD, 14));
		lblTopic.setBounds(22, 11, 68, 21);
		panel_1.add(lblTopic);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(561, 90, 216, 119);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMember = new JLabel("Thành viên");
		lblMember.setFont(new Font("Arial", Font.BOLD, 14));
		lblMember.setBounds(22, 11, 90, 21);
		panel_2.add(lblMember);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(822, 90, 216, 119);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Quản trị viên");
		lblAdmin.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdmin.setBounds(22, 11, 99, 21);
		panel_3.add(lblAdmin);
		

	}
}
