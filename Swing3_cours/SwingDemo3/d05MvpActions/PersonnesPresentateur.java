package d05MvpActions;

import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.HashMap;

import javax.swing.Action;

import d05MvpActions.action.AjouterAction;
import d05MvpActions.action.PrecedentAction;
import d05MvpActions.action.SuivantAction;

/**
 * Le présentateur... Exercice possible : modifier le code du présentateur et du
 * modèle pour pouvoir activer ou désactiver les boutons (valider, suivant et
 * précédent).
 * 
 * @author rosmord
 * 
 */
public class PersonnesPresentateur {
	private final JPersonneFormulaire vue;
	private final PersonnesFacade modele;
	private final HashMap<String, Action> actionMap = new HashMap<>();

	public PersonnesPresentateur(JPersonneFormulaire vue, PersonnesFacade modele) {
		this.vue = vue;
		this.modele = modele;
		creerActions();
		activer();
		charger();
	}

	private void creerActions() {
		actionMap.put(AjouterAction.ID, new AjouterAction(this));
		actionMap.put(SuivantAction.ID, new SuivantAction(this));
		actionMap.put(PrecedentAction.ID, new PrecedentAction(this));

	}

	private void activer() {
		vue.getAjouterButton().setAction(actionMap.get(AjouterAction.ID));
		vue.getPrecedentButton().setAction(actionMap.get(PrecedentAction.ID));
		vue.getSuivantButton().setAction(actionMap.get(SuivantAction.ID));
		vue.getValiderButton().addActionListener(
				EventHandler.create(ActionListener.class, this, "valider"));
	}

	/**
	 * Charge la personne "courante".
	 */
	public void charger() {
		Personne p = modele.getPersonne();
		vue.getIdField().setText("" + p.getId());
		vue.getNomField().setText(p.getNom());
		vue.getPrenomField().setText(p.getPrenom());
		mettreAjourActions();
	}
	
	private void mettreAjourActions() {
		actionMap.get(SuivantAction.ID).setEnabled(modele.aSuivant());
		actionMap.get(PrecedentAction.ID).setEnabled(modele.aPrecedent());

	}

	/**
	 * Ajoute une nouvelle personne.
	 */
	public void ajouter() {
		modele.ajouter();
		charger();
	}

	/**
	 * Passe au suivant (si possible).
	 */
	public void suivant() {
		modele.suivant();
		charger();
	}

	/**
	 * Passe au précédent.
	 */
	public void precedent() {
		modele.precedent();
		charger();
	}

	/**
	 * Met à jour la personne courante.
	 */
	public void valider() {
		Personne ancien = modele.getPersonne();
		Personne nouveau = new Personne(ancien.getId(), vue.getNomField()
				.getText(), vue.getPrenomField().getText());
		modele.mettreAJour(nouveau);
	}

	public Action getAction(String id) {
		return actionMap.get(id);
	}

}
