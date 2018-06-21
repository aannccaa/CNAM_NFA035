package ex2_Colectii;


public class Main {

	public static void main(String[] args) {
		String nom1;
		String nom2;
		String nom3;
		nom1 = "Toto";
		nom2 = "toto";
		nom3 = "Popo";
		
		String[] nums1 = { "111111", "222222"};
		String[] nums2 = { "3333333"};
		String[] nums3 = { "4444444"};

		RepTel repertoire = new RepTel();
		repertoire.nouveauContact(nom1, nums1);
		repertoire.nouveauContact(nom2, nums2);
		repertoire.nouveauContact(nom3, nums3);

		System.out.println("repertoire.affiche():");
		repertoire.affiche();
		
		System.out.println("repertoire.afficheContactDeNom(nom1):");
		repertoire.afficheContactDeNom(nom1);
		repertoire.afficheContactDeNom_variante(nom1);
		System.out.println("repertoire.afficheParOrdreAlphabetique():");
		repertoire.afficheParOrdreAlphabetique();
		
		Contact c1 = new Contact(nom1);
		
		c1.ajoutNum("12345");
		c1.ajoutNum("678910");
		System.out.println("c1.affiche():");
		c1.affiche();
		System.out.println("c1.afficheNums():");
		c1.afficheNums();
		
		Contact c2 = new Contact(nom2);
		
		c2.ajoutNum("000000");
		c2.ajoutNum("777777");
		c2.affiche();
		System.out.println(c2.contientNumero("777777"));
		
	
	}

}
