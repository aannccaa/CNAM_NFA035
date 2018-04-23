package exo2.Correction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MainJoueur2 implements Iterable<Carte> {
	Set<Carte> cartes = new TreeSet<>();

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

	/**
	 * La main forme-t-elle une suite. Une suite (quinte si on a cinq carte) est une
	 * main dont les cartes sont consécutives. Elles peuvent ne pas avoir toutes la
	 * même couleur (sinon, c'est en plus une <em>quinte flush</em>).
	 * <p>
	 * Pour la cohérence de la définition mathématique,
	 * on considèrera qu'une main
	 * vide est une suite.
	 * <p> On s'aperçoit que la manipulation de la valeur des
	 * cartes est un peu malaisée (si vous avez utilisé getValeur() directement,
	 * considérez que c'est bon, ceci dit)... On aura sans doute
	 * intérêt à faire des valeurs des cartes une classe, comme on l'a fait
	 * pour les couleurs.
	 * @return vrai si la main est une suite.
	 */
	public boolean estSuite() {
		Iterator<Carte> it = cartes.iterator();
		boolean estSuite = true;
		if (it.hasNext()) {
			// Il y a au moins une carte dans le jeu...
			Carte precedente = it.next();
			while (estSuite && it.hasNext()) {
				Carte carte = it.next();
				if (carte.getVraieValeur()
						!= precedente.getVraieValeur() + 1) {
					estSuite = false;
				} else {
					precedente = carte;
				}
			}
		}
		return estSuite;
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}

	public int getNombreCouleurs() {
		// algorithme demandé (un peu tarabiscoté).
		TreeSet<Carte> parCouleur = new TreeSet<>(new CouleurComparator());
		parCouleur.addAll(cartes);
		Iterator<Carte> it = parCouleur.iterator();
		if (!it.hasNext()) {
			// La main est vide !!!!
			return 0;
		} else {
			Carte c = it.next();
			Couleur courante = c.getCouleur();
			int nb = 1;
			while (it.hasNext()) {
				c = it.next();
				if (c.getCouleur() != courante) {
					nb++;
					courante = c.getCouleur();
				}
			}
			return nb;
		}
	}

	public int getNombreCouleursBis() {
		// meilleur algorithme:
		HashSet<Couleur> couleurs = new HashSet<>();
		for (Carte c : cartes) {
			couleurs.add(c.getCouleur());
		}
		return couleurs.size();
	}

}
