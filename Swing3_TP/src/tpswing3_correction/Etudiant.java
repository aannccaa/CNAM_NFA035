/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_correction;

/**
 *
 * @author rosmord
 */
public class Etudiant {

    String nom, prenom;

    double partiel, examen;

    public Etudiant() {
        nom = "";
        prenom = "";
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getPartiel() {
        return partiel;
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
        return examen;
    }

    public void setExamen(double examen) {
        if (examen < 0 || examen > 20) {
            return;
        }

        this.examen = examen;
    }

    public double getMoyenne() {
        return (partiel + examen) / 2.0;
    }

}
