package mvpDemo;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Ici, l'application se contente de créer et relier tout le monde.
 * 
 * @author rosmord
 * 
 */
public class PersonnesApplication {
	private PersonnesFacade modele;
	private JPersonneFormulaire vue;
	private PersonnesPresentateur presentateur;

	public PersonnesApplication() {
		modele= new PersonnesFacade();
		vue = new JPersonneFormulaire();
		presentateur= new PersonnesPresentateur(vue, modele);
		JFrame frame= new JFrame("Formulaire");
		frame.add(vue.getPanel());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new PersonnesApplication();
			}
		});
	}
}
