package d05MvpActions;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import d05MvpActions.action.AjouterAction;
import d05MvpActions.action.PrecedentAction;
import d05MvpActions.action.SuivantAction;

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
	private JFrame frame;
	
	public PersonnesApplication() {
		modele= new PersonnesFacade();
		vue = new JPersonneFormulaire();
		presentateur= new PersonnesPresentateur(vue, modele);
		frame= new JFrame("Formulaire");
		frame.add(vue.getPanel());
		
		creerMenu();
		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void creerMenu() {
		JMenuBar menuBar= new JMenuBar();
		JMenu menu= new JMenu("Editer");
		menu.add(presentateur.getAction(AjouterAction.ID));
		menu.add(presentateur.getAction(SuivantAction.ID));
		menu.add(presentateur.getAction(PrecedentAction.ID));
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}

}
