package collections1_TP_correction;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LivreRecettesTest {

	// recettes triées par note desc[ 'Glace vanille', (note moyenne: 3,5 sur 2
	// notes), 'Ile flotante', (note moyenne: 3,0 sur 3 notes), 'Tarte aux Pomme',
	// (note moyenne: 2,0 sur 1 notes), 'Glace chocolat', (note moyenne: 0,0 sur 0
	// notes)]
	// recettes triées par nom[ 'Glace chocolat', (note moyenne: 0,0 sur 0 notes),
	// 'Glace vanille', (note moyenne: 3,5 sur 2 notes), 'Ile flotante', (note
	// moyenne: 3,0 sur 3 notes), 'Tarte aux Pomme', (note moyenne: 2,0 sur 1
	// notes)]

	@Test
	public void getRecettesParNoteDesc() {
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
		Recette tarteAuxPomme = new Recette("Tarte aux Pomme");
		livreRecettes.addRecette(tarteAuxPomme, 2);
		List<Recette> actuals = livreRecettes.getRecettesParNoteDesc();
		Recette[] expecteds = { glaceVanille, ileFlotante, tarteAuxPomme, glaceChocolat };
		Assert.assertArrayEquals(expecteds, actuals.toArray());
	}

}
