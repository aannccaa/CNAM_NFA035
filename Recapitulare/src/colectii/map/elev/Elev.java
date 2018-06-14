package colectii.map.elev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elev {
	public final String nume;
	// map de materie, lista de note
	public final Map<String, List<Double>> note;

	public Elev(String nume) {
		this.nume = nume;
		this.note = new HashMap<>();
	}

	public String toString() {
		return String.format("%s", this.nume);
	}

	public void addNota(String materie, double nota) {
		List<Double> noteMaterie = this.note.get(materie);
		// daca lista nu exista
		if (noteMaterie == null) {
			// o creez
			noteMaterie = new ArrayList<Double>();
			// o adaug in map
			this.note.put(materie, noteMaterie);
		}
		noteMaterie.add(nota);
	}

	public List<Nota> getNotePtToateMateriile() {
		List<Nota> result = new ArrayList<>();
		// pentru fiecare pereche materie, lista de note/materie
		for (Map.Entry<String, List<Double>> entry : this.note.entrySet()) {
			// obtin materia
			String materie = entry.getKey();
			// obtin lista de note/materie
			List<Double> noteMaterie = entry.getValue();
			// obtin lista de obiecte nota pe materie, transformand List<Double> in
			// List<Nota>
			List<Nota> obiecteNota = transformNoteInObiectNote(materie, noteMaterie);
			// adaug toate obiectele nota la rezultat
			result.addAll(obiecteNota);
		}
		return result;
	}

	private List<Nota> transformNoteInObiectNote(String materie, List<Double> noteMaterie) {
		List<Nota> result = new ArrayList<>();
		if (noteMaterie != null) {
			// pentru fiecare nota
			for (Double nota : noteMaterie) {
				// creez un obiect nota
				Nota n = new Nota(nota, this.nume, materie);
				// pe care-l adaug la rezultat (lista de note)
				result.add(n);
			}
		}
		return result;
	}

	public List<Nota> getNoteMaterie(String materie) {
		List<Nota> result = new ArrayList<>();
		// obtin lista de note / materie
		List<Double> noteMaterie = this.note.get(materie);
		// obtin lista de obiecte nota pe materie, transformand List<Double> in
		// List<Nota>
		List<Nota> obiecteNota = transformNoteInObiectNote(materie, noteMaterie);
		// adaug toate obiectele nota la rezultat
		result.addAll(obiecteNota);
		return result;
	}

	public List<Nota> getMedii() {
		List<Nota> result = new ArrayList<>();
		
		for (Map.Entry<String, List<Double>> perecheMaterieSiNote : this.note.entrySet()) {
			String materie = perecheMaterieSiNote.getKey();
			List<Double> noteMaterie = perecheMaterieSiNote.getValue();
			double medie = Util.getMedia(noteMaterie);
			Nota m = new Nota(medie, this.nume, materie);
			result.add(m);
		}

		return result;
	}
}
