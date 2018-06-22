package ex3_Swing;
/*
On considère l’interface graphique, qui est supposée servir à sauvegarder 
les informations d’un nouvel utilisateur.
=================
Identifiant: ...
mot de passe: ...
répéter mot de passe: ...

Enregistrer
=================

Comme vous le voyez, le bouton pour enregistrer le nouvel utilisateur est désactivé
(on l’a conﬁguré avec bouton.setEnabled(false). Pour le réactiver, il faut appeler 
bouton.setEnabled(true). On vous demande d’implémenter le comportement suivant:

— le bouton ne doit être activé que si l’identiﬁant et les mot de passe ne sont 
pas vides, et que d’autre part, les deux mots de passe sont égaux (pour simpliﬁer, 
on considèrera que les deux mots de passe sont édités par des JTextField).
L’activation (ou la désactivation) du bouton doit se faire en cours de frappe: 
dès que le contenu des champs texte est correct, le bouton doit s’activer. 
— quand on presse le bouton, il doit appeler la méthode sauverUtilisateur(), 
qu’on ne vous demande pas d’écrire. Complétez le code suivant, en écrivant 
la méthode activer() (et éventuellement les classes et méthodes auxiliaires 
dont vous avez besoin) 
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CreateurUtilisateur {
	private JTextField identifiantField = new JTextField(10);
	private JTextField motDePasse1Field = new JTextField(10);
	private JTextField motDePasse2Field = new JTextField(10);
	private JButton bouton = new JButton("Enregistrer");
	private JFrame frame = new JFrame("Gérer identifiant");
	private JLabel identifiantLabel = new JLabel("Identifiant: ");
	private JLabel motDePasse1Label = new JLabel("mot de passe: ");
	private JLabel motDePasse2Label = new JLabel("répéter mot de passe: ");

	/*
	 * Pour la vé́rification des champs ≪ à la volée ≫ on va utiliser la technique
	 * vue en cours, en attachant un DocumentListener aux divers champs. Pour créer
	 * le DocumentListener, on peut utiliser une classe interne comme ci-dessous. On
	 * ne peut pas utiliser de lambda (car un DocumentListener a plusieurs
	 * méthodes); on peut aussi utiliser un EventHandler (assez pratique, toutes les
	 * mé́thodes feront la même chose).
	 */
	// classe interne: le documentListener:
	private class MyDocListener implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			/* RIEN */}

		public void insertUpdate(DocumentEvent e) {
			verifBouton();
		}

		public void removeUpdate(DocumentEvent e) {
			verifBouton();
		}
	}

	private MyDocListener docListener = new MyDocListener();

	public CreateurUtilisateur() {
		mettreEnPage();
		// assigner un comportement au boutons
		activer();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void mettreEnPage() { // ne pas écrire . . .
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 0));
		panel.add(identifiantLabel);
		panel.add(motDePasse1Label);
		panel.add(motDePasse2Label);
		panel.add(identifiantField);
		panel.add(motDePasse1Field);
		panel.add(motDePasse2Field);
		panel.add(bouton);
		frame.add(panel);
		frame.pack();
	}

	private void activer() {
		// met en place les divers listeners
		// . . . // A ECRIRE !!!
		//this.bouton.addActionListener(EventHandler.create(ActionListener.class, this, "sauverUtilisateur"));
		// variante (lambda expression):
		this.bouton.addActionListener(e -> sauverUtilisateur(this.getIdentifiant(), this.getPwd1()));

		this.identifiantField.getDocument().addDocumentListener(this.docListener);
		this.motDePasse1Field.getDocument().addDocumentListener(this.docListener);
		this.motDePasse2Field.getDocument().addDocumentListener(this.docListener);

		// on active ou desactive le bouton en fonction des règles spécifiées
		verifBouton();
	}

	public String getIdentifiant() {
		return this.identifiantField.getText();
	}

	public String getPwd1() {
		return this.motDePasse1Field.getText();
	}

	public String getPwd2() {
		return this.motDePasse2Field.getText();
	}

	// si le identifiant n'est pas vide, et que les 2 pwd sont identiques et pas
	// vides,
	// alors on active le bouton
	public void verifBouton() {
		boolean active = !this.getIdentifiant().isEmpty() && !this.getPwd1().isEmpty()
				&& this.getPwd1().equals(this.getPwd2());
		this.bouton.setEnabled(active);
	}

	/*
	 * méethode auxiliaire que vous pouvez utiliser.
	 * 
	 * la méthode est déjà écrite, on ne vous demande pas de l’écrire∗
	 */

	public void sauverUtilisateur(String identifiant, String motDePasse) {
		// NE PAS ECRIRE
		System.out.println("Utilisateur enregistré");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new CreateurUtilisateur();
			}
		});

	}

}
