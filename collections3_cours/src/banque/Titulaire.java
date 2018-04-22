package banque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Titulaire {
	@Override
	public String toString() {
		return String.format("[nom=%s\ncomptesParBanque=%s]", nom, comptesParBanque);
	}

	String nom;
	Map<String, Set<Integer>> comptesParBanque;
	
	public Titulaire(String nom) {
		this.nom = nom;
		this.comptesParBanque = new HashMap<String, Set<Integer>>();
	}

	public void ajouterCompte(String nomBanque, int numCompte) {
		// are titularul conturi in banca ?
		Set<Integer> comptesDansLaBanque = this.comptesParBanque.get(nomBanque);
		// daca nu
		if (comptesDansLaBanque == null) {
			comptesDansLaBanque = new HashSet<Integer>();
			this.comptesParBanque.put(nomBanque, comptesDansLaBanque);
		}
		comptesDansLaBanque.add(new Integer(numCompte));
	}
}
