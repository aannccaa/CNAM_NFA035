package d04Mvp;

import java.awt.event.ActionListener;
import java.beans.EventHandler;

/**
 * Le présentateur... Exercice possible : modifier le code du présentateur et du
 * modèle pour pouvoir activer ou désactiver les boutons (valider, suivant et
 * précédent).
 * 
 * @author rosmord
 * 
 */
public class PersonnesPresentateur {
	JPersonneFormulaire vue;
	PersonnesFacade modele;

	public PersonnesPresentateur(JPersonneFormulaire vue, PersonnesFacade modele) {
		this.vue = vue;
		this.modele = modele;
		activer();
		charger();
	}

	
	private void activer() {
		
		vue.getAjouterButton().addActionListener(
				EventHandler.create(ActionListener.class, this, "ajouter"));
		vue.getPrecedentButton().addActionListener(
				EventHandler.create(ActionListener.class, this, "precedent"));
		vue.getSuivantButton().addActionListener(
				EventHandler.create(ActionListener.class, this, "suivant"));
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

}
