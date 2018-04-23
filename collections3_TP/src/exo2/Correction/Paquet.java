package exo2.Correction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet {
	/**
	 * Comme l'ordre importe (et qu'on peut le CHANGER), on choisit 
	 * de représenter le paquet par une liste.
	 */
	List<Carte> cartes;
	
	public Paquet() {
		cartes= new ArrayList<>();
		for (Couleur couleur: Couleur.values()) {
			for (int valeur= 1; valeur <= 13; valeur++) {
				cartes.add(new Carte(valeur, couleur));
			}
		}
		Collections.shuffle(cartes);
	}
	
	public int size() {
		return cartes.size();
	}
	
	public MainJoueur1 creerMain1() {
		MainJoueur1 mainJoueur= new MainJoueur1();
		for (int i= 0; i < 5; i++) {
			// On enlève la dernière carte, c'est plus efficace 
			// (pas de déplacement dans le tableau).
			Carte c= cartes.get(cartes.size() -1);
			cartes.remove(cartes.size() -1);
			mainJoueur.addCarte(c);
		}
		return mainJoueur;
	}
	
	public MainJoueur2 creerMain2() {
		MainJoueur2 mainJoueur= new MainJoueur2();
		for (int i= 0; i < 5; i++) {
			// On enlève la dernière carte, c'est plus efficace 
			// (pas de déplacement dans le tableau).
			Carte c= cartes.get(cartes.size() -1);
			cartes.remove(cartes.size() -1);
			mainJoueur.addCarte(c);
		}
		return mainJoueur;
	}
	
	@Override
	public String toString() {
		return cartes.toString();
	}
}
