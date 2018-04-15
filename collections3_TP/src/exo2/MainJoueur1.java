package exo2;

import java.util.HashSet;
import java.util.Iterator;

/*
Question 4 : MainJoueur1
Ecrivez une classe MainJoueur1 afin de repre ́senter la main d’un joueur, contenant 
plusieurs cartes. Utilisez un HashSet pour stocker les cartes dans la main. 
Dans un premier temps on souhaite doter cette classe des me ́thodes suivantes:
• addCarte(Carte): ajoute une carte a` la main.
• addCarte(Carte): teste si la main contient une carte.
• toString(): renvoie une repre ́sentation de la main sous forme de chaˆıne. 
Ve ́rifiez le bon fonctionnement de votre classe avec un petit programme qui 
l’utilise.

Question 5 : ite ́ration sur MainJoueur1
On veut disposer d’un moyen simple de parcourir les cartes d’une MainJouer1. 
Pour cela, modifiez cette classe de sorte qu’elle implante l’interface 
Iterable<Carte>. Testez le re ́sultat en e ́crivant dans un programme de test :
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

     }
// Test pour la question 7: ite ́ration sur une MinJoeur1
for( Carte c: m){ 
	System.out.println(c.toString());
}
 */

public class MainJoueur1 implements Iterable<Carte> {
	private HashSet<Carte> cartes;

	public MainJoueur1() {
		cartes = new HashSet<>();
	}

	public void addCarte(Carte carte) {
		this.cartes.add(carte);
	}

	public boolean contientCarte(Carte carte) {
		return this.cartes.contains(carte);
	}

	public String toString() {
		String s = "";
		String sep = ";";
		for (Carte c : cartes) {
			s = sep + s + c.toString();
			sep = ";";
		}
		return s;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new NotRemovableIterator<Carte>(this.cartes.iterator());
		//return this.cartes.iterator();
	}

	public static void main(String[] args) {
		// Q4
		HashSet<Carte> cartes = new HashSet<>();
		
		Carte carreau10 = new Carte(10, Couleur.CARREAU);
		Carte coeur1 = new Carte(1, Couleur.COEUR);
		Carte trefle3 = new Carte(3, Couleur.TREFLE);
		Carte pique5 = new Carte(5, Couleur.PIQUE);

		cartes.add(carreau10);
		cartes.add(coeur1);
		cartes.add(trefle3);
		cartes.add(pique5);

		System.out.println("Cartes en main : " + cartes.toString());
		System.out.println("cartesMain.contains(pique5)? => " + cartes.contains(pique5));
		System.out.println("Nb cartes : " + cartes.size());

		// Q5
		MainJoueur1 m = new MainJoueur1();
		m.addCarte(new Carte(10, Couleur.CARREAU));
		m.addCarte(new Carte(1, Couleur.COEUR));
		m.addCarte(new Carte(10, Couleur.TREFLE));
		
		if (m.contientCarte(new Carte(10, Couleur.CARREAU))) {
			System.out.println("Le jeu contient le 10 de carreau");
		} else {
			System.out.println("Le jeu ne contient pas le 10 de carreau");
		}

		// Test pour la question 7: itération sur une MainJoeur1
		System.out.println("test for each: ");
		for (Carte c : m) {
			System.out.println(c.toString());
		}
		
		System.out.println("test iterator: ");
		Iterator<Carte> it = m.iterator(); 
		Iterator<Carte> it2 = m.iterator();
		
		if(it==it2) {
			System.out.println("sunt identice (au aceeasi adresa)");
		} else if(it.equals(it2)){
			System.out.println("sunt egale dar nu identice");
		} else {
			System.out.println("sunt diferite");
		}
		while(it.hasNext()) {
			Carte carte = it.next();
			// it.remove();
			System.out.println(carte.toString());
		}
		System.out.println("it2 hasNext = " + it2.hasNext());
		System.out.println("test for each: ");
		for (Carte c : m) {
			System.out.println(c.toString());
		}
	}

}
