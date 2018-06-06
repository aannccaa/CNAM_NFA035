package tp12.exercice1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Question1 implements ActionListener {
	Timer timer;
	JBarreDeProgression barre;
	int deltaProgression;

	public Question1() {
		JFrame frame = new JFrame("Question 1");
		barre = new JBarreDeProgression(0);
		frame.add(barre);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		deltaProgression = +1;
		timer = new Timer(50, this);

		timer.start();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Question1());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int current = barre.getProgression();

		if (current == 0) {
			deltaProgression = 1;
		} else if (current == 100) {
			deltaProgression = -1;
		}
		barre.setProgression(current + deltaProgression);
	}
}
