package colectii.lista.sondaj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sondaj {
	public final List<Intrebare> intrebari;// lista e readonly, dar continutul nu
	public final List<RaspunsSondaj> raspunsuri;

	public Sondaj() {
		intrebari = new ArrayList<>();
		raspunsuri = new ArrayList<>();
	}

	public Intrebare addIntrebare(String textIntrebare, String... raspunsuriPosible) {
		Intrebare intrebare = new Intrebare(textIntrebare, raspunsuriPosible);
		this.intrebari.add(intrebare);
		return intrebare;
	}

	public void printFormular() {
		// pentru fiecare intrebare afisez intrebarea si raspunsurile posibile
		for (Intrebare intrebare : intrebari) {
			System.out.println(intrebare.textIntrebare);
			int i = 0;
			for (RaspunsIntrebare raspunsPosibil : intrebare.raspunsuriPosibile) {
				System.out.println(String.format("    %d. %s", i, raspunsPosibil.textRaspuns));
				i++;
			}
		}
	}

	public void addRaspuns(String idSondat, int... raspunsuriAlese) {
		// raspunsuriDate este un tablou de intregi cu raspunsurile in ordinea
		// intrebarilor
		// un raspunsAles este un intreg corespunzator cu raspunsulposibil din intrebare
		RaspunsSondaj raspunsSondaj = new RaspunsSondaj(idSondat);
		for (int i = 0; i < raspunsuriAlese.length; i++) {
			int numarIntrebare = i;
			int indexRaspunsAles = raspunsuriAlese[i];
			Intrebare intrebareaCorespunzatoareRaspunsului = this.intrebari.get(numarIntrebare);
			RaspunsIntrebare raspunsulAles = intrebareaCorespunzatoareRaspunsului.raspunsuriPosibile
					.get(indexRaspunsAles);
			raspunsSondaj.raspunsuriIntrebari.add(raspunsulAles);
		}

		this.raspunsuri.add(raspunsSondaj);
	}

	public void printRaspunsSondaj(String idSondat) {
		RaspunsSondaj raspunsSondaj = this.getRaspunsSondaj(idSondat);
		printRaspunsSondaj(raspunsSondaj);
	}

	private RaspunsSondaj getRaspunsSondaj(String idSondat) {
		for (RaspunsSondaj raspunsSondaj : raspunsuri) {
			if (idSondat == raspunsSondaj.idSondat) {
				return raspunsSondaj;
			}
		}
		return null;
	}

	private void printRaspunsSondaj(RaspunsSondaj raspunsSondaj) {
		for (int i = 0; i < this.intrebari.size(); i++) {
			Intrebare intrebare = this.intrebari.get(i);
			RaspunsIntrebare raspunsIntrebare = raspunsSondaj.raspunsuriIntrebari.get(i);
			System.out.println(intrebare.textIntrebare);
			System.out.println(raspunsIntrebare.textRaspuns);
		}
	}

	// Care sunt raspunsurile care pentru un numar de intrebare au dat un anumit
	// raspuns?
	public List<RaspunsSondaj> getRaspunsuri(int indexIntrebare, int raspunsAles) {
		List<RaspunsSondaj> result = new ArrayList<>();
		// caut textul raspunsului care corespunde cu indexIntrebare si raspunsAles
		// 1. gasesc intrebarea
		Intrebare intrebare = this.intrebari.get(indexIntrebare);
		// 2. gasesc textul raspunsului care corespunde cu raspunsAles;

		RaspunsIntrebare raspunsCautat = intrebare.raspunsuriPosibile.get(raspunsAles);
		String textRaspunsAles = raspunsCautat.textRaspuns;
		for (RaspunsSondaj raspunsSondaj : raspunsuri) {
			// caut in lista de raspunsuri pe cele care au acelasi index cu numarul
			// intrebarii (conventie)
			RaspunsIntrebare raspunsIntrebare = raspunsSondaj.raspunsuriIntrebari.get(indexIntrebare);
			String textRaspuns = raspunsIntrebare.textRaspuns;
			// daca raspunsul est identic cu raspunsul ales
			if (textRaspuns.equals(textRaspunsAles)) {
				// il adaug la resultat
				result.add(raspunsSondaj);
			}
		}
		return result;
	}
	
}
