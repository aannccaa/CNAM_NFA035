package exo1.Correction;


import java.util.Comparator;

/**
 * Compare deux recettes, d'abord par note, puis par nom.
 * @author rosmord
 *
 */
public class NoteComparator implements Comparator<Recette>{

	@Override
	public int compare(Recette o1, Recette o2) {
		// Solution simple et de bon goût pour les notes:
		// int resultat= Double.compare(o1.getMoyenneNotes(), o2.getMoyenneNotes());
		// Mais on fait tout à la main pour bien comprendre...
		
		// On pourrait se passer de la variable résultat, 
		// mais ça aide à comprendre comment passer à n variables d'instances...
		int resultat;
		if (o1.getMoyenneNotes() > o2.getMoyenneNotes())
			resultat= 1;
		else if (o1.getMoyenneNotes() < o2.getMoyenneNotes())
			resultat= -1;
		else
			resultat= 0;
		if (resultat != 0) return resultat;
		resultat= o1.getTitre().compareTo(o2.getTitre());
		return resultat;			
	}

}
