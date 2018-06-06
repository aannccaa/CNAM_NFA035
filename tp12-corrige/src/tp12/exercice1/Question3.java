package tp12.exercice1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Une application pas très bien organisée avec une barre de progression.
 * @author rosmord
 *
 */
public class Question3 {
	private JFrame frame;
	private JBarreDeProgression barreDeProgression;
	private JSlider slider;
	
	public Question3() {
		frame= new JFrame("Exercice 1");
		slider= new JSlider(0, 100);
		slider.setValue(0);
		barreDeProgression= new JBarreDeProgression();
		mettreEnPage();
		activer();
		frame.setVisible(true);
	}

	private void activer() {
		slider.addChangeListener(evenement -> changerProgression());
	}

	
	private void changerProgression() {
		// récupère la valeur du slider.
		int valeurSlider= slider.getValue();
		// Modifie la valeur de progression.
		barreDeProgression.setProgression(valeurSlider);
	}

	private void mettreEnPage() {
		frame.setLayout(new GridBagLayout());
		GridBagConstraints cc= new GridBagConstraints();
		cc.fill= GridBagConstraints.HORIZONTAL;
		cc.weightx= 1.0;
		frame.add(slider,cc);
		cc.gridy= 1;
		frame.add(barreDeProgression, cc);
		frame.pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Question3());
	}
}
