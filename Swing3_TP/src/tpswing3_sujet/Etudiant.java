/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_sujet;
/*
Exercice 1
On veut saisir les notes des  ́etudiants au partiel et `a l’examen, et pouvoir voir 
leur moyenne.
Pour cela, on a crée la classe Etudiant. Un étudiant a un nom, un prénom, et 
deux notes (partiel et examen).

Question 1
Complétez la classe EtudiantTableModel pour obtenir un TableModel capable d’afficher 
les données d’une ArrayList d’ ́etudiants (pour chaque  ́etudiant : nom, prénom, 
et ses deux notes).

Question 1 bis
Regardez le résultat en lançant le programme Exo1. 

Question 1 ter
Arrangez-vous pour que les noms des colonnes apparaissent.

Question 2
Ajouter au JTable une colonne qui donnera la moyenne de l’étudiant `a ses deux 
examens. 

Question 3
Rendre les deux notes (mais pas la moyenne !) éditables. Vérifier que, quand on 
les modifie, la moyenne est correctement affich ́ee.
N’oubliez pas de ≪ prévenir ≪ la vue `a l’aide des m ́ethode fire... adapt ́ees.
note : dans ce cas précis, la mécanique de l’édition va faire que la ligne éditée 
sera redessinées, mˆeme si vous oubliez les fire.... Mais ça n’est pas une raison.

Question 4
Rendre actif le bouton ajouter, qui créera un nouvel étudiant. Nous vous proposons 
pour cela de petits champs de formulaires en bas de l’UI.

Question 5
Rendre actif le bouton ≪ supprimer ≫, qui supprime l’étudiant actuellement sélectionnée.
Il faudra écrire une méthode supprimer dans le mod`ele. Elle pourra recevoir comme 
argument l’index (le numéro de ligne) de l’ étudiant `a supprimer.
 */

/**
 *
 * @author rosmord
 */
public class Etudiant {
	String nom;
	String prenom;
	double partiel;
	double examen;

	public Etudiant() {
		nom = "";
		prenom = "";
	}

	public Etudiant(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getPartiel() {
		return this.partiel;
	}

	/**
	 * Fixe la note du partiel. Si la note est hors limite, ne fait rien.
	 *
	 * @param partiel
	 */
	public void setPartiel(double partiel) {
		if (partiel < 0 || partiel > 20) {
			return;
		}
		this.partiel = partiel;
	}

	public double getExamen() {
		return this.examen;
	}

	public void setExamen(double examen) {
		if (examen < 0 || examen > 20) {
			return;
		}
		this.examen = examen;
	}

	public double getMoyenne() {
		return (this.partiel + this.examen) / 2.0;
	}

}
