package colectii.lista.sondaj;

import java.util.ArrayList;
import java.util.List;

public class RaspunsSondaj {
	public final String idSondat;
	
	public final List<RaspunsIntrebare> raspunsuriIntrebari;
	public RaspunsSondaj(String idSondat) {
		this.idSondat = idSondat;
		this.raspunsuriIntrebari = new ArrayList<>();
	}
}
