package colectii.cartiJoc;

public class Main {

	public static void main(String[] args) {
		Carte c1 = new Carte(10, Culoare.TREFLA);
		Carte c2 = new Carte(1, Culoare.INIMA_NEAGRA);
		Carte c3 = new Carte(13, Culoare.INIMA_ROSIE);
		Carte c4 = new Carte(13, Culoare.INIMA_NEAGRA);
		Carte c5 = new Carte(5, Culoare.INIMA_ROSIE);
		Carte c6 = new Carte(5, Culoare.INIMA_NEAGRA);

		
		Mana m1 = new Mana();
		m1.adaugaCarte(c1);
		m1.adaugaCarte(c2);
		m1.adaugaCarte(c3);
		m1.adaugaCarte(c4);
		m1.adaugaCarte(c5);
		m1.adaugaCarte(c6);
		m1.afficheaza();
		System.out.println(m1.getCountByNumar());
		System.out.println(m1.getPerechi());
		
		Carte c11 = new Carte(10, Culoare.TREFLA);
		Carte c12 = new Carte(1, Culoare.INIMA_NEAGRA);
		Carte c13 = new Carte(13, Culoare.INIMA_ROSIE);
		
		Mana m2 = new Mana();
		m2.adaugaCarte(c13);
		m2.adaugaCarte(c12);
		//m2.adaugaCarte(c11);
		m2.afficheaza();
		System.out.println(m2.getCountByNumar());
		
		System.out.println(m1.equals(m2));
	}

}
