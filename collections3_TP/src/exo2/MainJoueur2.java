package exo2;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Question 8 : MainJoueur2
Pour cette question vous allez creer une nouvelle classe MainJoueur2 avec les memes fonctionnalite ́s 
que MainJoueur1, mais qui stocke les cartes de la main dans un TreeSet de Cartes. 
Un TreeSet est un ensemble ordonné. L’ordre des cartes sera testé selon leur valeur puis selon leur 
couleur.

Question 9 : tester les suites
Dans MainJoueur2 ajoutez la méthode estSuite() qui teste si une main est une suite de cartes.

Question 10 (optionnelle) : nombre de couleurs d’une main
On veut implémenter getNombreCouleurs (qui renvoie le nombre de couleurs qui apparaissent dans une main). 
Pour cela, on desire travailler sur un jeu trié par couleur. En utilisant un Comparator, 
et en travaillant sur un TreeSet temporaire, ecrire cette méthode dans une des classes MainJoueur.
 */

public class MainJoueur2 implements Iterable<Carte> {
	// Q8
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
		for (Carte c : cartes) {
			buffer.append(c);
			buffer.append("\n");
		}
		return buffer.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		// return new NotRemovableIterator<Carte>(this.cartes.iterator());
		return this.cartes.iterator();
	}

	// Q9
	/**
	 * Teste si une main correspond à une suite de cartes. Une suite de cartes est
	 * une main triée composée de cartes de même couleur avec valeurs consécutives.
	 * 
	 * @return
	 */
	public boolean estSuite() {
		boolean debut = true;
		int val = 0;
		int valPrecedente = 0;
		Couleur col = null;
		for (Carte c : cartes) {
			if (debut) {
				val = c.getValeur();
				valPrecedente = c.getValeur();
				col = c.getCouleur();
				debut = false;
			} else if (c.getValeur() <= val 
					|| c.getCouleur().compareTo(col) != 0)
				return false;
			else {
				val = c.getValeur();
				col = c.getCouleur();
				if (val - valPrecedente !=1) {
					return false;
				}
				valPrecedente++;
			}
		}
		return true;
	}
	
	// Q10 (nb. des couleurs dans la main)
	public int getNombreCouleurs() {
		Set<Couleur> couleurDansMain = new HashSet<>();
		for(Carte c: this.cartes) {
			couleurDansMain.add(c.getCouleur());
		}
		return couleurDansMain.size();
	}

	public static void main(String[] args) {
		// Q4
		Set<Carte> cartes = new TreeSet<>();

		Carte carreau7 = new Carte(7, Couleur.CARREAU);
		Carte carreau8 = new Carte(8, Couleur.CARREAU);
		Carte carreau9 = new Carte(9, Couleur.CARREAU);
		Carte carreau10 = new Carte(10, Couleur.CARREAU);
		Carte carreau11 = new Carte(11, Couleur.CARREAU);
		Carte coeur10 = new Carte(10, Couleur.COEUR);
		Carte coeur1 = new Carte(1, Couleur.COEUR);
		Carte trefle3 = new Carte(3, Couleur.TREFLE);
		Carte pique5 = new Carte(5, Couleur.PIQUE);

		//cartes.add(coeur10);
		//cartes.add(carreau10);
		cartes.add(carreau9);
		cartes.add(carreau7);
		cartes.add(carreau9);
		cartes.add(carreau8);
		cartes.add(carreau11);
		
		MainJoueur2 m1 = new MainJoueur2();
		m1.cartes.addAll(cartes);
		System.out.println(m1.toString());
		System.out.println("Nombre couleurs dans la main m1 : " + m1.getNombreCouleurs());

		System.out.println("m1 est suite ? => " + m1.estSuite());

		MainJoueur2 m2 = new MainJoueur2();
		cartes.add(coeur1);
		cartes.add(trefle3);
		cartes.add(pique5);
		m2.cartes.addAll(cartes);
		System.out.println(m2.toString());
		System.out.println("Nombre couleurs dans la main m2 : " + m2.getNombreCouleurs());
		System.out.println("m2 est suite ? => " + m2.estSuite());
	}

}
