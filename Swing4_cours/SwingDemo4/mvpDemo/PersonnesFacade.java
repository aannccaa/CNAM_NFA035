package mvpDemo;

import java.util.ArrayList;

/**
 * Modèle de l'application, utilisé par le MVP.
 * @author rosmord
 *
 */
public class PersonnesFacade {
	// Invariant pour cet exemple : il y a toujours une personne à la position "position".
	private ArrayList<Personne> personnes= new ArrayList<Personne>();
	private int position= 0;
	
	public PersonnesFacade() {
		personnes.add(new Personne(1, "", ""));
	}
	
	public Personne getPersonne() {
		return personnes.get(position);
		
	}

	/**
	 * Ajoute une entrée après l'entrée courante...
	 */
	public void ajouter() {
		personnes.add(position+1, new Personne(personnes.size() + 1, "", ""));
		suivant();
	}

	public void suivant() {
		if (position < personnes.size() -1 )
			position++;
	}

	public void precedent() {
		if (position > 0)
			position--;
	}

	public void mettreAJour(Personne nouveau) {
		// On peut directement utiliser "nouveau", car les objets personnes sont immuables.
		// pas de risque qu'on le modifie derrière notre dos.
		personnes.set(position, nouveau);
	}
	
}
