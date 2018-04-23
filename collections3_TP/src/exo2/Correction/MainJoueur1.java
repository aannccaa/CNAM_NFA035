package exo2.Correction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainJoueur1 implements Iterable<Carte> {
	Set<Carte> cartes = new HashSet<>();

	public void addCarte(Carte c) {
		cartes.add(c);
	}

	public boolean contientCarte(Carte c) {
		return cartes.contains(c);
	}

	public String toString() {
		// Regardez sur internet (ou dans la javadoc).
		// StringBuilder est une manière efficace de construire de grandes
		// String.
		StringBuilder b = new StringBuilder();
		boolean pasDebut = false;
		for (Carte c : cartes) {
			if (pasDebut)
				b.append(", ");
			// Notez l'utilisation du toString de carte !
			b.append(c.toString());
			pasDebut = true;
		}
		return b.toString();
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}

	public static void main(String[] args) {
		System.out.println("Petit programme d'exemple pour la question 4");
		System.out.println("On pourrait (on DEVRAIT) plutôt écrire des jeux de test.");
		MainJoueur1 m = new MainJoueur1();
		System.out.println("main vide: " + m.toString());
		m.addCarte(new Carte(10, Couleur.Coeur));
		m.addCarte(new Carte(9, Couleur.Pique));
		m.addCarte(new Carte(10, Couleur.Coeur));
		// Normalement, deux cartes seulement.
		System.out.println("Main avec deux cartes " + m);
		Carte cartes[] = { new Carte(10, Couleur.Coeur), new Carte(10, Couleur.Trefle), new Carte(11, Couleur.Coeur) };
		for (Carte c : cartes) {
			System.out.println("Main contient " + c + " " + m.contientCarte(c));
		}
		System.out.println("Test question 5");
		for (Carte c: m) {
			System.out.println(c);
		}
		
	}
}
