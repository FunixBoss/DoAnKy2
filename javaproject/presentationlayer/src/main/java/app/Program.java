package app;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import frame.FrameHome;
import frame.FrameSignIn;

public class Program {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSignIn frame = new FrameSignIn();
//					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
