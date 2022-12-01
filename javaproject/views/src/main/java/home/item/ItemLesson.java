package home.item;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class ItemLesson extends JPanel {
	private JPanel panel;
	private JPanel panelPoint;
	private JLabel lbPoint;
	private JLabel lblLessonTitle;
	private JLabel lblVocalb;
	private JPanel panel_2;
	private JLabel lblImage;
	
	public ItemLesson() {
		initComponent();
		
	}

	private void initComponent() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(20, 20, 264, 292);
		panel = new JPanel();
		panel.setBounds(0, 131, 264, 161);
		panel.setBackground(new Color(242, 247, 255));
		add(panel);
		panel.setLayout(null);
		
		panelPoint = new JPanel();
		panelPoint.setBounds(125, 117, 129, 34);
		panel.add(panelPoint);
		panelPoint.setBackground(new Color(255, 255, 255));
		panelPoint.setLayout(null);
		
		lbPoint = new JLabel("Points");
		lbPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbPoint.setFont(new Font("Arial", Font.PLAIN, 12));
		lbPoint.setBounds(0, 0, 129, 34);
		panelPoint.add(lbPoint);
		
		lblLessonTitle = new JLabel("Title Lesson");
		lblLessonTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblLessonTitle.setBounds(20, 10, 115, 26);
		panel.add(lblLessonTitle);
		
		lblVocalb = new JLabel("Num of Vocab");
		lblVocalb.setFont(new Font("Arial", Font.PLAIN, 12));
		lblVocalb.setBounds(20, 40, 92, 13);
		panel.add(lblVocalb);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 264, 292);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImage.setBackground(new Color(124, 141, 181));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(73, 23, 119, 88);
		panel_2.add(lblImage);
	}
}
