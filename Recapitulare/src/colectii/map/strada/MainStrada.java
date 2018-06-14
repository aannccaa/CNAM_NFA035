package colectii.map.strada;

public class MainStrada {

	public static void main(String[] args) {
		Strada alesia = new Strada("Alésia");
		Strada plantes = new Strada("Les Plantes");
		NumarStrada a167 = alesia.addNumarStrada("167");
		NumarStrada a10 = alesia.addNumarStrada("10");
		Persoana ionescu = new Persoana("Ionescu");
		Persoana popescu = new Persoana("Popescu");
		a167.persoane.add(popescu);
		a10.persoane.add(popescu);
		a10.persoane.add(ionescu);
		
		System.out.println(alesia.toString());
		System.out.println(plantes.toString());
		System.out.println("Popescu : " + alesia.findPersoana("Popescu"));
	}

}
