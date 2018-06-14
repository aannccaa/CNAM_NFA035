package colectii.map.elev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clasa {
	public final String nume;
	public final Set<Elev> elevi;

	public Clasa(String nume) {
		this.nume = nume;
		this.elevi = new HashSet<>();
	}
	
	public List<Nota> getMedii(){
		List<Nota> result = new ArrayList<>();
		for(Elev e: elevi) {
			List<Nota> mediiElev = e.getMedii();
			result.addAll(mediiElev);
		}
		return result;
	}

}
