package exo2;

public class TestCouleur0 {
	
	public static void main(String[] args) {
		// question 1: quelques expériences avec le type énuméré Couleur
		Couleur c = Couleur.COEUR;
		System.out.println("c.toString() : "+c);
		System.out.println("c.ordinal() : "+c.ordinal());
		System.out.println("c.equals(\"COEUR\") : "+c.equals("COEUR"));
		System.out.println("c.toString(\"COEUR\") : "+ c.toString().equals("COEUR"));
		// Dans quel ordre sont-ils affichés?
		// => ordre de declaration dans l'enuméré: PIQUE, TREFLE, COEUR, CARREAU;
		System.out.println();
		System.out.println("Affichage dans l'ordre:");
		for(Couleur co : Couleur.values()){
			System.out.println(co);
		}
	}
}
