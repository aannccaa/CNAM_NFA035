package colectii.hashMap;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Elev {
	String nume;

	// tablou de materii cu Lista de note /materie
	Map<String, List<Double>> note;

	public Elev(String nume) {
		this.nume = nume;
		this.note = new HashMap<>();
	}

	public List<Double> getNote(String numeMaterie) {
		// obtin lista de note pentru o materie data
		List<Double> noteMaterie = this.note.get(numeMaterie);
		// daca nu exista note pentru materia "numeMaterie"
		if (noteMaterie == null) {
			// creez o Lista vid
			noteMaterie = new ArrayList<>();
			// adaug lista in map
			this.note.put(numeMaterie, noteMaterie);
		}
		return noteMaterie;
	}

	public void addNota(String numeMaterie, Double nota) {
		// obtin Lista de note pentru o materie
		List<Double> noteMaterie = this.getNote(numeMaterie);
		// adaug nota (dublele sunt acceptate)
		noteMaterie.add(nota);
	}

	public double getMedieMaterie(String numeMaterie) {
		List<Double> noteMaterie = this.getNote(numeMaterie);
		return Util.getMedie(noteMaterie);
	}

	public double getMinMaterie(String numeMaterie) {
		List<Double> noteMaterie = this.getNote(numeMaterie);
		return Util.getMin(noteMaterie);
	}
}
