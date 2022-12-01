package admin.item;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import entity.Lesson;


public class ItemLesson extends JPanel {

	private JPanel panel;
	private JPanel panelHeader_1;
	private JPanel panel_1;
	private JLabel lblId;
	private JPanel panel_1_2;
	private JLabel lblWord;
	private JPanel panel_1_2_1;
	private JLabel lblImage;
	private JPanel panel_1_1_1_1;
	private JButton btnDetail;
	private JPanel panel_1_1_1;
	private JButton btnEdit;
	private JPanel panel_1_1;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public ItemLesson(Lesson lesson, int y) {
		initComponent(y);
	}

	private void initComponent(int y) {
		setBounds(0, y, 980, 80);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 77, 995, 3);
		add(panel);
		panel.setBackground(new Color(238, 238, 238));
		
		panelHeader_1 = new JPanel();
		panelHeader_1.setBounds(0, 0, 980, 80);
		add(panelHeader_1);
		panelHeader_1.setLayout(new GridLayout(0, 6, 0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(lblId);

		panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2);
		panel_1_2.setLayout(new BorderLayout(0, 0));

		lblWord = new JLabel("Bài học");
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setForeground(new Color(0, 0, 0));
		lblWord.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1_2.add(lblWord);
		
		panel_1_2_1 = new JPanel();
		panel_1_2_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new BorderLayout(0, 0));
		
		lblImage = new JLabel();
		panel_1_2_1.add(lblImage, BorderLayout.CENTER);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setForeground(new Color(0, 0, 0));
		lblImage.setFont(new Font("Arial", Font.PLAIN, 14));

		panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(Color.WHITE);
		panelHeader_1.add(panel_1_1_1_1);
		
		btnDetail = new JButton("Chi tiết");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDetail.setForeground(Color.WHITE);
		btnDetail.setFont(new Font("Arial", Font.BOLD, 14));
		btnDetail.setBorder(null);
		btnDetail.setBackground(new Color(67, 98, 190));
		btnDetail.setBounds(38, 25, 100, 30);
		panel_1_1_1_1.add(btnDetail);
		
		panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEdit.setBounds(44, 25, 73, 30);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Arial", Font.BOLD, 14));
		btnEdit.setBorder(null);
		btnEdit.setBackground(new Color(67, 98, 190));
		panel_1_1_1.add(btnEdit);

		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 255, 255));
		panelHeader_1.add(panel_1_1);

		btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(205, 16, 64));
		btnDelete.setBounds(46, 25, 75, 30);
		panel_1_1.add(btnDelete);
	}

}
