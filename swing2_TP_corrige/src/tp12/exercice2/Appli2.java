package tp12.exercice2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 * Une application pas très bien organisée avec un histogramme.
 * @author rosmord
 *
 */
public class Appli2 {
	private JFrame frame;
	private JHistogramme histogramme;
	/**
	 * Le champ avec le numéro de l'élément à sélectionner.
	 */
	private JSpinner positionSpinner;
	private JTextField valeurChamp;
	private JButton modifierBouton;
	
	public Appli2() {
		frame= new JFrame("histogramme");		
		histogramme= new JHistogramme();
		int nb = histogramme.getModele().getNombreDeValeurs();
		SpinnerNumberModel spinnerNumberModel= new SpinnerNumberModel(nb, 1, 100, 1);
		positionSpinner= new JSpinner(spinnerNumberModel);
		valeurChamp= new JTextField(10);
		modifierBouton= new JButton("modifier");
		mettreEnPage();
		activer();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void activer() {
		modifierBouton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changerValeur();
			}
		});
	}

	/**
	 * Change la valeur du champ sélectionné
	 */
	protected void changerValeur() {
		int i= (Integer) positionSpinner.getValue();
		double v= Double.parseDouble(valeurChamp.getText());
		histogramme.getModele().setValeur(i, v);
	}

	private void mettreEnPage() {
		frame.setLayout(new BorderLayout());
		frame.add(new JScrollPane(histogramme), BorderLayout.CENTER);
		JPanel panel= new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(new JLabel("position"));
		panel.add(positionSpinner);
		panel.add(new JLabel("valeur"));
		panel.add(valeurChamp);
		panel.add(modifierBouton);
		frame.add(panel, BorderLayout.SOUTH);		
		frame.pack();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Appli2();
			}
		});
	}
}
