package ex3_Swing;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
Exercice 3 Swing, 5 points 

Cet exercice porte sur des caractéristiques techniques 
de Swing. On ne cherche pas à réaliser un programme extensible ni bien structuré, 
simplement à mettre en évidence quelques mécanismes des interfaces graphiques.

Question 3.1 4 points 
On se donne la classe Exam: 
public class Exam {
	private JTextField champTexte = new JTextField(20);
	private JFrame frame = new JFrame("une saisie");
	// ....

	public void mettreEnPage() {
		// S ’ occupe de "mettre en page"
		// les composants graphiques .
		// (les ajoute à la JFrame . . . )
		// ne pas écrire.
		// . . . }
	}

	public static void main(String args[]) {
		// Crée et lance un objet Exam .
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Exam();
			}
		});
	}
}

On explore la manière d’avertir l’utilisateur quand un texte qu’il a tapé est trop 
court. On désire donc avoir le comportement suivant: 
– quand l’utilisateur saisit du texte dans le champ texte, et presse la touche 
entrée, le texte s’aﬃche en rouge s’il contient moins de 8 caractères, et 
s’aﬃche en vert s’il fait plus de 8 caractères; 
– les changements de couleurs ont lieu quand l’utilisateur tape sur la touche 
entrée dans le champ texte (rappel: déclenche une action qui peut être écoutée 
par un actionListener). 
Vous devez compléter la classe Exam (en créant éventuellement des classes 
auxilliaires). Ne perdez pas de temps à faire une “jolie” interface graphique. 
Tout ce qu’on veut, c’est qu’elle aﬃche le champ texte demandé. 

Quelques méthodes de la classe JComponent: 
void setForeground(Color fg): fixe la couleur de dessin d’un composant ; 

Quelques constantes de la classe Color: Color.RED, Color.GREEN, Color.BLACK, 
Color.WHITE;

Question 3.2 1 point 
Dans les indications de la question précédente, on vous 
donne des méthodes de JComponent et non de JTextField. 
Pourquoi cela fonctionne-t-il?

 */

public class Exam {
	private JTextField champTexte = new JTextField(20);
	private JFrame frame = new JFrame("une saisie");
	// ....

	public void mettreEnPage() {
		// S’occupe de "mettre en page"
		// les composants graphiques.
		// (les ajoute à la JFrame ... )
		// ne pas écrire.
		// . . . }
	}

	public static void main(String args[]) {
		// Crée et lance un objet Exam .
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Exam();
			}
		});
	}
}
