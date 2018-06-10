package colectii.cartiJoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mana {
	Set<Carte> cartiMana;

	public Mana() {
		this.cartiMana = new HashSet<>();
	}

	public void adaugaCarte(Carte c) {
		cartiMana.add(c);
	}

	public List<Carte> sorteazaCrescator() {
		List<Carte> rezult = new ArrayList<>(cartiMana);
		rezult.sort(null);
		return rezult;
	}

	// triez mai intai
	public String toString() {
		List<Carte> cartiSortateCrescator = this.sorteazaCrescator();
		List<String> rezult = new ArrayList<>();
		for (Carte c : cartiSortateCrescator) {
			rezult.add(c.toString());
		}
		return String.join(";", rezult);
	}

	public void afficheaza() {
		System.out.println(this.toString());
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Mana other = (Mana) obj;

		if (this.cartiMana.size() != other.cartiMana.size()) {
			return false;
		}

		// mai putin eficace
		// return this.toString().equals(other.toString());
		// mai eficace
		List<Carte> cartiMana = this.sorteazaCrescator();
		List<Carte> cartiAltaMana = other.sorteazaCrescator();
		for (int i = 0; i < cartiMana.size(); i++) {
			Carte c1 = cartiMana.get(i);
			Carte c2 = cartiAltaMana.get(i);
			if (!c1.equals(c2)) {
				return false;
			}
		}
		return true;
	}

	public Map<Integer, Integer> getCountByNumar() {
		Map<Integer, Integer> result = new HashMap<>();

		for (Carte c : this.cartiMana) {
			int numarCarte = c.getNumar();
			Integer precCount = result.get(numarCarte);
			if (precCount == null) {
				precCount = 1;
			} else {
				precCount++;
			}
			result.put(numarCarte, precCount);
		}
		return result;
	}

	public List<Set<Carte>> getPerechi() {
		List<Set<Carte>> rezult = new ArrayList<>();
		Map<Integer, Integer> countByNumar = this.getCountByNumar();
		for (Map.Entry<Integer, Integer> pereche : countByNumar.entrySet()) {
			Integer numarCartePentruPereche = pereche.getKey();
			Integer numarCartiCuAcelasiNumar = pereche.getValue();
			if (!numarCartiCuAcelasiNumar.equals(2)) {
				continue;
			}
			Set<Carte> perecheCarti = new HashSet<>();
			rezult.add(perecheCarti);
			for (Carte c : this.cartiMana) {
				if (numarCartePentruPereche.equals(c.getNumar())) {
					perecheCarti.add(c);
					if (perecheCarti.size() == 2) {// daca am gasit perechea, ma opresc
						break;
					}
				}
			}
		}
		return rezult;
	}
}
