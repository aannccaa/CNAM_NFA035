package exo2.Correction;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Un paquet de cartes est formé de 13 cartes de chaque couleur.
 * Les cartes du paquet sont mélangées.
 *
 */
public class Paquet {

	private ArrayList<Carte> cartes= new ArrayList<Carte>();
	
	public Paquet() {
		for (Couleur couleur : Couleur.values()) {
			for (int i= 1; i <= 13; i++) {
				cartes.add(new Carte(i, couleur));
			}
		}
		Collections.shuffle(cartes);
	}
	
	public MainJoueur1 creerMain1() {
		MainJoueur1 m= new MainJoueur1();
		for (int i= 0 ; i < 5; i++) {
			m.add(cartes.get(cartes.size() -1 )); // On prend la dernière carte
			cartes.remove(cartes.get(cartes.size() -1 )); // On l'enlève...
		}
		return m;
	}
	
	public int size(){
		return cartes.size();
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

}
