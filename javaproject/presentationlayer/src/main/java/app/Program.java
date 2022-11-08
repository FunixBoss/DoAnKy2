package app;

import java.awt.EventQueue;

import frame.FrameHome;
import frame.FrameSignIn;

public class Program {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSignIn frame = new FrameSignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
