
package exo2.Correction;

import java.util.Comparator;

/**
 *
 * @author aponte
 */
public class OrdreCartes implements Comparator<Carte>{

    @Override
    public int compare(Carte o1, Carte o2) {
        if (o1.getValeur() == o2.getValeur()) {
            if (o1.getCouleur().ordinal() < o2.getCouleur().ordinal()) {
                return -1;
            } else if (o1.getCouleur().ordinal() > o2.getCouleur().ordinal()) {
                return 1;
            } else {
                return 0;
            }
        } else if (o1.getValeur() < o2.getValeur())
           return -1;
        else 
            return 1;
    }
}
