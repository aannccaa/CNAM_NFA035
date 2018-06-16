package colectii.lista.sondaj;

public class Main {

	public static void main(String[] args) {
		Sondaj s1 = new Sondaj();
		s1.addIntrebare("Varsta ?", "<30", ">=30");
		s1.addIntrebare("Fumati ?", "da", "nu");
		s1.printFormular();
		s1.addRaspuns("id11", 1, 1);
		s1.addRaspuns("id30", 0, 2);
		s1.printRaspunsSondaj("id11");
		s1.printRaspunsSondaj("id30");
	}

}
