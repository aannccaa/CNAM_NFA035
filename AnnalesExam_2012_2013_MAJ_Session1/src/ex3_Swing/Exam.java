package ex3_Swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

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
	=> Réponse: parce que JTextField hérite de JTextComponent qui hérite de JComponent
	public class JTextField extends JTextComponent
	public abstract class JTextComponent extends JComponent 

 */

public class Exam {
	private JTextField champTexte = new JTextField(20);
	private JFrame frame = new JFrame("une saisie");
	int nbCharControl = 8;
	// ....

	public Exam() {
		mettreEnPage();
		activate();
	}

	/**
	 * @return the champTexte
	 */
	public JTextField getChampTexte() {
		return champTexte;
	}

	/**
	 * @param champTexte
	 *            the champTexte to set
	 */
	public void setChampTexte(JTextField champTexte) {
		this.champTexte = champTexte;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void mettreEnPage() {
		// S’occupe de "mettre en page"
		// les composants graphiques.
		// (les ajoute à la JFrame ... )
		// ne pas écrire.
		// . . . }
		frame.add(this.champTexte);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void activate() {
		// // variante 1 add action listener (EventHandler)
		// this.champTexte.addActionListener(EventHandler.create(ActionListener.class,
		// this, "fixColor"));

		// variante 2 add action listener (lambda expression)
		this.champTexte.addActionListener(e -> fixColor());

		// // variante 3 add action listener (classe interne annonime)
		// this.champTexte.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// fixColor();
		// }
		// });
	}

	public void fixColor() {
		String s = this.getChampTexte().getText();
		if (s.length() <= this.nbCharControl) {
			this.getChampTexte().setForeground(Color.GREEN);
		} else {
			this.getChampTexte().setForeground(Color.RED);
		}
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
