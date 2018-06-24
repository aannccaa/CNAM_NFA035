package collections1_TP_correction;

public class Main {
	
	public static void main(String[] args) {
		Recette ileFlotante = new Recette("Ile flotante");
		ileFlotante.addNote(5);
		ileFlotante.addNote(3);
		ileFlotante.addNote(1);
		
		LivreRecettes livreRecettes = new LivreRecettes();
		livreRecettes.addRecette(ileFlotante);
		
		Recette glaceVanille = new Recette("Glace vanille");
		Recette glaceChocolat = new Recette("Glace chocolat");
		livreRecettes.addRecette(glaceVanille);
		livreRecettes.addRecette(glaceChocolat);
		livreRecettes.addNote(glaceVanille, 3);
		glaceVanille.addNote(4);
		livreRecettes.addRecette(new Recette("Tarte aux Pomme"), 2);
		livreRecettes.afficherRecettes();
		System.out.println("recettes triées par note desc" + livreRecettes.getRecettesParNoteDesc());
		System.out.println("recettes triées par nom" + livreRecettes.getRecettesParNom());
		
	}

}
