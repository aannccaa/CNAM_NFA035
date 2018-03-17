package exo2;

import static org.junit.Assert.*;
import org.junit.Test;

/*
Question 1
La classe Prog035 produit une erreur a la compilation. Pourquoi? Corrigez cette erreur.

Question 2
Déclarez ensuite une classe de test avec une méthode main qui effectue les actions suivantes:
1. Déclarez un tableau capable de contenir 4 objets de type AvecNote. Initialisez ce tableau 
avec des objets instance de Prog032 dans les case 0 et 2, et de Prog035 dans les case 1 et 3 
du tableau.
2. Ajoutez dans votre main l’instruction String s1 = UEs[0].getSession1(); Expliquez l’erreur 
signalée par le compilateur. Enlevez ensuite cette ligne de votre programme main.
3. Ecrivez une méthode statique moyenneTabNotes qui prend en arguement un tableau d’objets 
de type AvecNote et qui calcule la moyenne des notes pour ses composantes.
4. Utilisez cette méthode pour calculer et afficher la moyenne des notes pour les UEs dans 
le tableau.
5. Ajoutez une méthode afficher dans la classe Prog032: elle doit utiliser la méthode toString.
6. Ajoutez l’interface suivante dans votre projet:
interface Affichable { void afficher();}
Quelle est la classe qui implante cette interface? Ajoutez cette interface dans sa clause 
implements.
7. Peut-on écrire Affichable a = new Prog035(12, 6,10.5);. Pourquoi?

Question 3
Etudiez la classe Eleve. Expliquez comment elle utilise l’interface AvecNote. 
Un éleve pourra-t-il ajouter parmi ses UES des objets de classes Prog032 et Prog035? 
Ajoutez dans votre programme main un éleve Bob. Ajoutez des ues Prog032 et Prog035 pour Bob.

Question 4
Ecrivez une classe Prog031 qui implante AvecNote et ajoutez une ue de ce type pour Bob.

Question 5
On voudrait ajouter une méthode qui permet d’afficher toutes les UES d’un eleve. 
Que faut-il modifier d’apres vous?
 */

public class Main {

	// 3. Ecrivez une méthode statique moyenneTabNotes qui prend en argument
	// un tableau d’objets de type AvecNote et qui calcule la moyenne des notes
	// pour ses composantes.

	public static double moyenneTabNotes(AvecNote[] t) {
		// throw new RuntimeException("écrivez-moi!!!");
		double resultat = 0;

		for (int i = 0; i < t.length; i++) {
			resultat = resultat + t[i].calculeNote();
		}
		return resultat / t.length;
	}

	public static void main(String[] args) {

		// 1. Déclarez un tableau capable de contenir 4 objets de type AvecNote.
		// Initialisez ce tableau avec des objets instance de Prog032 dans les case 0 et
		// 2,
		// et de Prog035 dans les case 1 et 3 du tableau.

		AvecNote[] UEs = new AvecNote[4];
		UEs[0] = new Prog032(8, 13);
		UEs[1] = new Prog035(20, 10, 10);
		UEs[2] = new Prog032(20, 0);
		UEs[3] = new Prog035(17, 13, 20);

		// 2. Ajoutez dans votre main l’instruction String s1 = UEs[0].getSession1();
		// Expliquez l’erreur signalee par le compilateur.
		// Enlevez ensuite cette ligne de votre programme main.

		// String s1 = UEs[0].getSession1(); // faille car getSession1() existe pas dans
		// l'interface AvecNote

		// 4. Utilisez cette méthode pour calculer et afficher la moyenne des notes
		// pour les UEs dans le tableau.
		System.out.println("UEs[0]: " + UEs[0].calculeNote());
		System.out.println("UEs[1]: " + UEs[1].calculeNote());
		System.out.println("UEs[2]: " + UEs[2].calculeNote());
		System.out.println("UEs[3]: " + UEs[3].calculeNote());

		System.out.println("Moyenne Notes UEs: " + moyenneTabNotes(UEs));

		// 6. Ajoutez l’interface suivante dans votre projet:
		// interface Affichable{ void afficher();}
		// Quelle est la classe qui implémente cette interface?
		// Ajoutez cette interface dans sa clause implements.
		Affichable a0 = new Prog032(8, 13);
		a0.afficher();

		// 7. Peut-on écrire Affichable a = new Prog035(12, 6,10.5);. Pourquoi?
		Affichable a = new Prog035(12, 6, 10.5);
		a.afficher();

		/*
		 * Question 3 Etudiez la classe Eleve. Expliquez comment elle utilise
		 * l’interface AvecNote. Un éleve pourra-t-il ajouter parmi ses UES des objets
		 * de classes Prog032 et Prog035? Ajoutez dans votre programme main un éleve
		 * Bob. Ajoutez des ues Prog032 et Prog035 pour Bob.
		 */
		Eleve e1 = new Eleve("Bob");
		e1.ajout(new Prog032(8, 13));
		e1.ajout(new Prog035(12, 6, 10.5));
		e1.afficher();

		//Question 4
		//Ecrivez une classe Prog031 qui implante AvecNote et ajoutez une ue de ce type pour Bob.
		e1.ajout(new Prog031(8, 12));
		e1.afficher();
	}
}
