package ex3_Swing;

import java.util.ArrayList;
import java.util.List;

/*
Exercice3 5 points 
Un bout d’interface pour un logiciel de gestion des inscriptions. On suppose 
donnée la classe CoursCnam. Un object CoursCnam représente un cours donné au Cnam.
Il a un code (codeUE, comme "NFA035”) et une durée en heures (40 pour NFA035 
par exemple). La liste de tous les cours est disponible à travers une méthode 
statique : creerlesCours().

public class CoursCnam {
	private String codeUE;
	private int nombreHeures;
	
	/**
	// Methode statique fabrique. Retourne le tableau de tous les cours disponibles.
	// 
	// @return
	//
	public static CoursCnam[] creerLesCours() {	... }

	public CoursCnam(String codeUE, int nombreHeures) { ... }

	public String getCodeUE() {
		return codeUE;
	}

	public int getNombreHeures() {
		return nombreHeures;
	}

	public String toString() {
		return codeUE;
	}
}

Question3.1 5 points 

Complétez la classe Exam2.java ...
*/

public class CoursCnam {
	private String codeUE;
	private int nombreHeures;

	public CoursCnam(String codeUE, int nombreHeures) {
		/* ... */
		this.codeUE = codeUE;
		this.nombreHeures = nombreHeures;
	}

	/**
	 * Methode statique fabrique. Retourne le tableau de tous les cours disponibles.
	 * 
	 * @return
	 */
	public static CoursCnam[] creerLesCours() {
		// ...
		CoursCnam nfa031 = new CoursCnam("NFA031", 60);
		CoursCnam nfa032 = new CoursCnam("NFA032", 50);
		CoursCnam nfa035 = new CoursCnam("NFA035", 48);
		CoursCnam[] result = { nfa031, nfa032, nfa035 };
		return result;
	}

	public void addCours(String codeUE, int nombreHeures) {
		List<CoursCnam> listeCours = new ArrayList<>();
		CoursCnam c = new CoursCnam(codeUE, nombreHeures);
		listeCours.add(c);
	}


	public String getCodeUE() {
		return this.codeUE;
	}

	public int getNombreHeures() {
		return this.nombreHeures;
	}

	public String toString() {
		return this.codeUE;
	}
}
