package LetsGoThreading;

import java.awt.EventQueue;

public class Driver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Viewer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
