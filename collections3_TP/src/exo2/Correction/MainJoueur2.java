
package exo2.Correction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MainJoueur2 implements Iterable<Carte> {
	
    // private TreeSet<Carte> cartes= new TreeSet<Carte>(new OrdreCartes()); // Avec Comparator

    private TreeSet<Carte> cartes = new TreeSet<Carte>();  // Avec ordre défini dans Carte

    public void add(Carte c) {
        cartes.add(c);
    }

    public boolean contient(Carte c) {
        return cartes.contains(c);
    }
	
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (Carte c : cartes) {
            buff.append(c);
            buff.append("\n");
        }
        return buff.toString();
    }

    @Override
    public Iterator<Carte> iterator() {
        return cartes.iterator();
    }
    
    // Question 8.
    /**
     * Teste si une main correspond à une suite de cartes.
     * Une suite de cartes est une main triée composée
     * de cartes de même couleur avec valeurs consécutives.
     * @return 
     */
    public boolean estSuite(){
        boolean debut = true;
        int val = 0;
        Couleur col = Couleur.Carreau;
        for( Carte c: cartes){
            if (debut){
              val = c.getValeur();
              col = c.getCouleur();
              debut = false;
            } else if (c.getValeur() <= val || c.getCouleur().compareTo(col) != 0)
                return false;
            else {  
              val = c.getValeur();
              col = c.getCouleur();
            }
        }
        return true;
    }
    
    // Question 9
    /** 
     * Retourne le nombre de couleurs différentes de la main.
     * @return 
     */
    public int getNombreCouleurs(){
       Set<Couleur> couleursdansmain = new HashSet<>();
       for (Carte c : cartes){
           couleursdansmain.add(c.getCouleur());
       }
       return couleursdansmain.size();
    }
}
