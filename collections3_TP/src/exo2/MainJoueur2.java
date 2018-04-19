package exo2;

import java.util.TreeSet;
import java.util.Iterator;


/*
Question 8 : MainJoueur2
Pour cette question vous allez creer une nouvelle classe MainJoueur2 avec les memes fonctionnalite ́s 
que MainJoueur1, mais qui stocke les cartes de la main dans un TreeSet de Cartes. 
Un TreeSet est un ensemble ordonné. L’ordre des cartes sera testé selon leur valeur puis selon leur 
coleur.

Question 9 : tester les suites
Dans MainJoueur2 ajoutez la méthode estSuite() qui teste si une main est une suite de cartes.

Question 10 (optionnelle) : nombre de couleurs d’une main
On veut implémenter getNombreCouleurs (qui renvoie le nombre de couleurs qui apparaissent dans une main). 
Pour cela, on desire travailler sur un jeu trié par couleur. En utilisant un Comparator, 
et en travaillant sur un TreeSet temporaire, ecrire cette méthode dans une des classes MainJoueur.
 */

public class MainJoueur2 implements Iterable<Carte> {
	private TreeSet<Carte> cartes;

	public MainJoueur2() {
		cartes = new TreeSet<>();
	}

	public void add(Carte carte) {
		this.cartes.add(carte);
	}

	public boolean contient(Carte carte) {
		return this.cartes.contains(carte);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Carte c: cartes) {
			buffer.append(c);
			buffer.append("\n");
		}
		return buffer.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return new NotRemovableIterator<Carte>(this.cartes.iterator());
		//return this.cartes.iterator();
	}

	public static void main(String[] args) {
		// Q4
		TreeSet<Carte> cartes = new TreeSet<>();
		
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
		MainJoueur2 m = new MainJoueur2();
		m.add(new Carte(10, Couleur.CARREAU));
		m.add(new Carte(1, Couleur.COEUR));
		m.add(new Carte(10, Couleur.TREFLE));
		
		if (m.contient(new Carte(10, Couleur.CARREAU))) {
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
