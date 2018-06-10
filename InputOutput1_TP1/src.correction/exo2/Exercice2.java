package exo2;

import java.io.*;

public class Exercice2 {

	/**
	 * Copie d'une ligne sur deux de r dans w. Signature donnée en suivant
	 * l'énoncé.
	 * 
	 * Copie une ligne sur de de r dans w.
	 * <ul>
	 * <li>Chaque ligne de w est terminée par '\n' (y compris la dernière).
	 * <li>Si r est vide, w aussi (on aurait pu décider aussi que quand r est
	 * vide, il contient une seule ligne, vide).
	 * </ul>
	 * 
	 * @param r
	 * @param w
	 * @throws IOException
	 */
	public static void copieUneSurDeux(Reader r, Writer w) throws IOException {
		BufferedReader buff = null;
		try {
			buff= new BufferedReader(r);
			String l= buff.readLine();
			boolean aCopier= true;
			while (l!= null) {
				if (aCopier) {
					w.write(l);
					w.write('\n');
				}
				// On inverse "aCopier"
				aCopier= ! aCopier;
				// on lit la suite
				l= buff.readLine();
			}
		} finally {
			w.close();
			buff.close();			
		}
	}
}
