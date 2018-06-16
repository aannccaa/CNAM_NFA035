package colectii.lista.sondaj;

import java.util.ArrayList;
import java.util.List;

public class Intrebare {
	public static final RaspunsIntrebare FARA_RASPUNS = new RaspunsIntrebare("fara raspuns");
	public final String textIntrebare;
	public final List<RaspunsIntrebare> raspunsuriPosibile;

	public Intrebare(String intrebare, String... raspunsuriPosibile) {
		this.textIntrebare = intrebare;
		this.raspunsuriPosibile = new ArrayList<>();
		// pe prima positie adaug "fara" raspuns
		this.raspunsuriPosibile.add(FARA_RASPUNS);
		
		for (int i = 0; i < raspunsuriPosibile.length; i++) {
			String textRaspuns = raspunsuriPosibile[i];
			RaspunsIntrebare unRaspuns = new RaspunsIntrebare(textRaspuns);
			this.raspunsuriPosibile.add(unRaspuns);
		}
	}
}
