package devoir2;
import nfa035.metier.Sujet;

/**
 * Main pour rendre le projet. 
 * <p>NE PAS MODIFIER CE CODE.
 * <p>Faire RUN AS JAVA APPLICATION pour lancer le logiciel de rendu. 
 * @author rosmord
 */
public class RendreProjet {
	public static void main(String[] args) {
		Sujet sujet= new Sujet("002");
		new nfa035.Main().startAppli(sujet);		
	}
}
