package exo1.question1;

import java.io.StreamTokenizer;

public abstract class CommandSansParametres implements Command {

	@Override
	public void lireParametres(StreamTokenizer tok) {
		// rien à faire car commande sans paramètres
	}

}
