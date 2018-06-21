package ex2_Colectii;
/*
Exercice 2 collections (9 points)
On souhaite modéliser un répertoire téléphonique formé d’un ensemble de contacts. 
Chaque contact est caractérisé par son nom et la liste de ses numéros de téléphone, sans doublons. 
Un numéro de téléphone sera représenté par une chaîne de caractères, sur laquelle, pour simplifier, 
on ne fera aucune vérification pour assurer qu’elle a la forme d’un numéro. Les opérations sur le 
répertoire devront garantir que les noms de contacts sont différents, et par ailleurs, on ne 
distinguera pas entre majuscules et minuscules en comparant deux noms de contacts. Une partie du 
code des classes Contact et RepTel vous est fourni ci-dessus : à vous de compléter le corps des 
méthodes signalées et de répondre aux questions posées.


Question 2.1 classe Contact, 3 points 
Complétez le code de la classe Contact donné plus bas.

 */

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Contact {
	private String nom;
	private Set<String> numTel;

	public Contact(String n) {
		this.nom = n;
		numTel = new HashSet<String>(); // A compléter
	}

	public String getNom() {
		return nom;
	}

	/** Affiche donnes contact + ses numeros de teléphone */
	public void affiche() {
		System.out.println(getNom());
		afficheNums();
	}

	// A compléter −> code methodes suivantes
	/**
	 * Ajoute un numero de telephone ( sans doublons ) pas de verification de bonne
	 * formation du numero ∗/
	 */
	public boolean ajoutNum(String num) {
		// A compléter
		return numTel.add(num);
	}

	/** Affiche les numeros de telephone du contact */
	public void afficheNums() {
		// A compléter
		String sep = "";
		System.out.print("{");
		for (String numero : numTel) {
			System.out.print(sep + numero);
			sep = "; ";
		}
		System.out.println("}");
	}

	/** Teste si ce contact contient un numero de téléphone */
	public boolean contientNumero(String num) {
		// A compléter
		return numTel.contains(num);
	}

}
