/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpswing3_sujet;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author rosmord
 */
public class Exo1 {
    private EtudiantTableModel etudiantTableModel;
    private UI ui;
    
    public Exo1() {
    		ui= new UI();
    		etudiantTableModel= new EtudiantTableModel(listeInitiale());
        ui.getTable().setModel(etudiantTableModel);
        ui.ajouterButton.addActionListener(e->ajouter());
        ui.supprimerButton.addActionListener(e->supprimer());
        ui.setVisible(true);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Petite démo pour prouver que le MVC fonctionne bien.
        // (la mise à jour de l'affichage quand on édite est un peu trompeuse,
        // car lors de la dé-selection de la ligne éditée, elle est intégralement 
        // mise à jour)
        // avec un timer, pas d'interaction directe, 
        //Timer t= new Timer(3000, (e)-> etudiantTableModel.setValueAt(10.0, 1, 3));
        //t.start();
    }
    

	public List<Etudiant> listeInitiale() {
    		return Arrays.asList(
    				new Etudiant("Lovelace", "Ada"),
    				new Etudiant("Babbage", "Charles"),
    				new Etudiant("Turing", "Alan"),
    				new Etudiant("von Neuman", "John")
    				);
    }
    
    private void ajouter() {
    		// à compléter !!
    		Etudiant e = new Etudiant(ui.getNom().getText(), ui.getPrenom().getText());
    		etudiantTableModel.ajouterEtudiant(e);
    }
    
    private void supprimer() {
		int ligne = ui.getTable().getSelectedRow();
		if(ligne !=-1) {
			etudiantTableModel.supprimerEtudiant(ligne);
		}
	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exo1());
    }
}
