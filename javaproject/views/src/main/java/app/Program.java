package app;

import java.awt.EventQueue;
import home.gui.FrameSignIn;

public class Program {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrameSignIn frame = new FrameSignIn();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
