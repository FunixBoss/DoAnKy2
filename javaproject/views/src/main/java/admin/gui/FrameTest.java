package admin.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.panel.PanelFeedback;
import admin.panel.PanelLesson;
import java.awt.BorderLayout;

public class FrameTest extends JFrame {

	private JPanel contentPane;
	private PanelLesson panelLesson;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrameTest frame = new FrameTest();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PanelFeedback panelFB= new PanelFeedback();
		contentPane.add(panelFB);
	}

}
