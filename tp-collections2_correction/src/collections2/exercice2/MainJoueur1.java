package collections2.exercice2;

import java.util.*;
import java.util.Iterator;
/**
 * Une main de joueur (sans doublons)
 *
 */

public class MainJoueur1 implements Iterable<Carte>{

	private HashSet<Carte> cartes= new HashSet<>();
	
	public void add(Carte c) {
		cartes.add(c);
	}
	
	public boolean contient(Carte c) {
		return cartes.contains(c);
	}
	
	@Override
	public String toString() {
		StringBuffer buff= new StringBuffer();
		for (Carte c: cartes) {
			buff.append(c);
			buff.append("\n");
		}
		return buff.toString();
	}
	
    // Réponse à la question 5
    @Override
    public Iterator<Carte> iterator() {
        return cartes.iterator();
    }   
}
