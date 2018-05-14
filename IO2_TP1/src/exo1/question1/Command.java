package exo1.question1;

import java.io.IOException;
import java.io.StreamTokenizer;

public interface Command {

	public void executer(Context context);

	public void lireParametres(StreamTokenizer tok) throws IOException;
}
