package home.item;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class ItemLesson extends JPanel {

	/**
	 * Create the panel.
	 */
	public ItemLesson() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(20, 20, 264, 292);
		JPanel panel = new JPanel();
		panel.setBounds(0, 131, 264, 161);
		panel.setBackground(new Color(242, 247, 255));
		add(panel);
		panel.setLayout(null);
		
		JPanel panelPoint = new JPanel();
		panelPoint.setBounds(125, 117, 129, 34);
		panel.add(panelPoint);
		panelPoint.setBackground(new Color(255, 255, 255));
		panelPoint.setLayout(null);
		
		JLabel lbPoint = new JLabel("Points");
		lbPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint.setFont(new Font("Arial", Font.PLAIN, 12));
		lbPoint.setBounds(0, 0, 129, 34);
		panelPoint.add(lbPoint);
		
		JLabel lblLessonTitle = new JLabel("Title Lesson");
		lblLessonTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblLessonTitle.setBounds(20, 10, 115, 26);
		panel.add(lblLessonTitle);
		
		JLabel lblVocalb = new JLabel("Num of Vocab");
		lblVocalb.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVocalb.setBounds(20, 40, 92, 13);
		panel.add(lblVocalb);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 264, 292);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImage.setBackground(new Color(124, 141, 181));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(73, 23, 119, 88);
		panel_2.add(lblImage);
		
	}
}
