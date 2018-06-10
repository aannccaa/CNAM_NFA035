package exo1.question1;

import java.util.ArrayList;
import java.util.List;

public class Programme {
	List<Commande> commandes= new ArrayList<>();
	
	public void ajouter(Commande c) {
		commandes.add(c);
	}
	
	public void evaluer(Contexte contexte) {
		for (Commande c: commandes) {
			c.executer(contexte);
		}				
	}
}
