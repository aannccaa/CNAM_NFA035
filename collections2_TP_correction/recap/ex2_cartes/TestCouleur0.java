package ex2_cartes;

public class TestCouleur0 {
	
	public static void main(String[] args) {
		// question 1: quelques expériences avec le type énuméré Couleur
		Couleur c = Couleur.Coeur;
		System.out.println(c);
		System.out.println(c.ordinal());
		System.out.println(c.equals("Coeur"));
		System.out.println(c.toString().equals("Coeur"));
		// Dans quel ordre sont-ils affichés?
		for(Couleur co : Couleur.values()){
			System.out.println(co);
		}
	}
}
