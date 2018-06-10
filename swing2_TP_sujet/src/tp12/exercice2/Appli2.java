package tp12.exercice2;

import java.awt.BorderLayout;

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
	private HistogrammeModele histogrammeModele;
	
	/**
	 * Le champ avec le numéro de l'élément à sélectionner.
	 */
	private JSpinner positionSpinner;
	private JTextField valeurChamp;
	private JButton modifierBouton;
	
	public Appli2() {
		histogrammeModele= new HistogrammeModele(10);
		frame= new JFrame("histogramme");
		histogramme= new JHistogramme();
		histogramme.setModele(histogrammeModele);
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
	
	/**
	 * Mets en place les listeners des boutons, etc...
	 */
	private void activer() {
		modifierBouton.addActionListener(event -> modifierValeurs());
	}
	
	/**
	 * Appelé quand l'utilisateur change les valeurs de l'histogramme.
	 */
	private void modifierValeurs() {
		int index= (Integer) positionSpinner.getValue()-1;
		double valeur= Double.parseDouble(valeurChamp.getText());
		histogrammeModele.setValeur(index, valeur);
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
		SwingUtilities.invokeLater(()-> new Appli2());
	}
}
