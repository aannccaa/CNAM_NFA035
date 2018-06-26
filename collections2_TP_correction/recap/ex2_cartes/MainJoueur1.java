package ex2_cartes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Question 4 : MainJoueur1
Ecrivez une classe MainJoueur1 afin de repre ́senter la main d’un joueur, contenant plusieurs cartes. 
Utilisez un HashSet pour stocker les cartes dans la main. Dans un premier temps on souhaite 
doter cette classe des me ́thodes suivantes:
• addCarte(Carte): ajoute une carte a` la main.
• addCarte(Carte): teste si la main contient une carte.
• toString(): renvoie une repre ́sentation de la main sous forme de chaˆıne. Ve ́rifiez le bon 
fonctionnement de votre classe avec un petit programme qui l’utilise.

Question 5 : ite ́ration sur MainJoueur1
On veut disposer d’un moyen simple de parcourir les cartes d’une MainJouer1. Pour cela, modifiez 
cette classe de sorte qu’elle implante l’interface Iterable<Carte>. Testez le re ́sultat en 
e ́crivant dans un programme de test :

public static void main(String[] args) {
		MainJoueur1 m = new MainJoueur1();
		m.add(new Carte(10, Couleur.Carreau));
		m.add(new Carte(1, Couleur.Coeur));
		m.add(new Carte(10, Couleur.Trefle));
		if (m.contient(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		// Test pour la question 7: ite ́ration sur une MinJoeur1
		for (Carte c : m) {
			System.out.println(c.toString());
		}
	}
}
 */

public class MainJoueur1 implements Iterable<Carte> {
	Set<Carte> main;

	public MainJoueur1() {
		this.main = new HashSet<>();
	}

	public void addCarte(Carte c) {
		this.main.add(c);
	}

	public Set<Carte> getCartesMain() {
		Set<Carte> result = new HashSet<>();
		for (Carte c : main) {
			result.add(c);
		}
		return result;
	}

	public boolean contient(Carte c) {
		return this.main.contains(c);
	}

	public String toString() {
		return String.format("%s", this.getCartesMain());
	}

	public static void main(String[] args) {
		MainJoueur1 m = new MainJoueur1();
		m.addCarte(new Carte(10, Couleur.Carreau));
		m.addCarte(new Carte(1, Couleur.Coeur));
		m.addCarte(new Carte(10, Couleur.Trefle));
		if (m.contient(new Carte(10, Couleur.Carreau))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}
		// Test pour la question 7: ite ́ration sur une MinJoeur1
		Iterator<Carte> it = m.iterator();
		System.out.println("----------->iterator");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("<----------");
		
		System.out.println("----------->forEach");
		for (Carte c : m) {
			System.out.println(c.toString());
		}
		System.out.println("<----------");
	}

	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}

}
