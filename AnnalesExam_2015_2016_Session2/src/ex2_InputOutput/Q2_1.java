package ex2_InputOutput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/*
Exercice 2 Entrees/Sorties (7 points)
Question 2.1 3 points

Ecrire le code de la procédure suivante :

public static void copierLignes(Reader r, Writer w,
	int pos, int nombreLignes)
throws IOException{
}

La fonction doit recopier sur w les lignes de texte lues dans r, en copiant nombreLignes lignes, en
commençant a la ligne pos.
— la numerotation des lignes commencé a 0 ;
— Formellement, on doit copier toute ligne dont le numero est compris entre pos (inclus) et pos+
nombreLignes (exclu).
Donc, si pos=0 et nombreLignes=10, la procedure copiera les 10 premiéres lignes lues.
Si le flux lu sur reader n’est pas assez long, par exemple, s’il comporte 6 lignes en tout et qu’on a
demande pos=4 et nombreLignes=8), ça ne sera pas considéré comme une erreur. Dans ce cas précis, on sé
contentera de copier les lignes 4 et 5 (comme la numerotation commencé a 0, il n’y a pas de ligne 6). De
meme, si pos est supérieur ou égal au nombre de lignes lisibles sur r, w sera le fichier vide. 
 */

public class Q2_1 {

	public static void copierLignes_charParChar(Reader r, Writer w, int pos, int nombreLignes) throws IOException {

		int lineCounter = 0;
		int c = 0;
		char ch;
		while (true) {
			c = r.read();
			ch = (char) (c);
			if (c == -1) {
				break;
			}
			if (lineCounter >= pos && lineCounter < pos + nombreLignes) {
				w.write(ch);
			}
			if (ch == '\n') {
				lineCounter++;
			}
		}
	}

	public static void copierLignes_LineParLigne(Reader r, Writer w, int pos, int nombreLignes) throws IOException {

		int lineCounter = 0;
		BufferedReader br = new BufferedReader(r);

		while (true) {
			String textLine = "";
			textLine = br.readLine();
			if (textLine == null) {
				break;
			}
			if (lineCounter >= pos && lineCounter < pos + nombreLignes) {
				w.write(textLine);
				w.write('\n');
			}
			lineCounter++;
		}
		br.close();
	}

	// Corrigé 1
	// on lit les "pos" premières lignes sans rien faire d’autre, puis on lit
	// les
	// lignes demandées en recopiant le texte.
	public static void copierLignes_cor1(Reader r, Writer w, int pos, int nombreLignes) throws IOException {
		BufferedReader buff = new BufferedReader(r);
		int i = 0; // numéro de la ligne courante .
		String l = buff.readLine();
		// On lit les pos premières lignes
		// ( attention à la fin de fichier !!!)
		while (i < pos && l != null) {
			i++;
			l = buff.readLine();
		}
		// On lit les nombreLignes lignes suivantes ( si possible )
		// au départ, si l n’est pas null, il pointe vers la ligne numéro pos
		i = 0; // remise du compteur à 0, on va compter les lignes à écrire.
		while (i < nombreLignes && l != null) {
			w.write(l); // on copie la ligne
			w.write('\n');// on écrit un saut de ligne
			i++; // on augmente le numéro de ligne
			l = buff.readLine(); // on passe à la ligne suivante
		}
		buff.close();
	}

	// Corrigé 2
	// on lit tout le ﬁchier, et pour chaque ligne, on décide si oui ou non on
	// l’afﬁche.
	// Ca simpliﬁe en particulier le problème de savoir pourquoi on s’arrête.
	public static void copierLignes_cor2(Reader r, Writer w, int pos, int nombreLignes) throws IOException {
		BufferedReader buff = new BufferedReader(r);
		int i = 0; // numéro de la ligne courante.
		String l = buff.readLine();
		while (l != null) {
			// si on est entre les lignes à copier, copier !
			if (pos <= i && i < pos + nombreLignes) {
				w.write(l); // on copie la ligne
				w.write('\n'); // on écrit un saut de ligne
			}
			i++;
			l = buff.readLine();
		}
		buff.close();
	}

	public static void main(String[] args) throws IOException {
		String s = "0\n1\n2\n3\n4\n5\n6\n7";
		Reader r;

		// var1
		Writer w = new FileWriter("q21_writer1.txt");
		r = new StringReader(s);
		copierLignes_charParChar(r, w, 5, 2);
		r.close();
		w.close();

		// var2
		StringWriter sw = new StringWriter();
		r = new StringReader(s);
		copierLignes_LineParLigne(r, sw, 5, 2);
		System.out.println(sw.toString());
		r.close();
		sw.close();

		// var3
		Writer w2 = new FileWriter("q21_writer2.txt");
		r = new StringReader(s);
		copierLignes_LineParLigne(r, w2, 5, 2);
		r.close();
		w2.close();

		// var4_cor1
		Writer w_cor1 = new FileWriter("q21_writer_cor1.txt");
		r = new StringReader(s);
		copierLignes_cor1(r, w_cor1, 5, 2);
		r.close();
		w_cor1.close();

		// var5_cor2
		Writer w_cor2 = new FileWriter("q21_writer_cor2.txt");
		r = new StringReader(s);
		copierLignes_cor2(r, w_cor2, 5, 2);
		r.close();
		w_cor2.close();
	}

}
