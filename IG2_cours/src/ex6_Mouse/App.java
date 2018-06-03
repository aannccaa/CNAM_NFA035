package ex6_Mouse;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {
	JFrame frame;
	JCercle monObject;

	public App() {
		createControls();
		mettreEnPage();
	}

	public void createControls() {
		frame = new JFrame("Cercle et souris");
		monObject = new JCercle();
	}

	private void mettreEnPage() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(monObject);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new App();

			}
		});

	}

}
