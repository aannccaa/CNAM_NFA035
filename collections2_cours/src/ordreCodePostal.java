import java.util.*;

/**
 * Ordre des adresses par code postal
 * 
 * @author aponte
 *
 */
public class ordreCodePostal implements Comparator<AdressePostale> {
	public int compare(AdressePostale a1, AdressePostale a2) {
		return a1.getCode().compareTo(a2.getCode());
	}
}
