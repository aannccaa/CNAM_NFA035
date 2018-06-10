package ex2.corection;

import java.awt.BorderLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/**
 * @author rosmord
 *
 */
public class Exercice2 {
	private JFrame frame;
	private JButton lireButton;
	private JButton ecrireButton;
	private JTextArea area;
	private File fichier= null;
	
	public Exercice2() {
		frame= new JFrame("Petit éditeur");
		area= new JTextArea(10, 80);
		lireButton= new JButton("lire");
		ecrireButton= new JButton("ecrire");
		mettreEnPage();
		activer();
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	private void activer() {
		lireButton.addActionListener(e -> lire());
		ecrireButton.addActionListener(e -> ecrire());
	}

	private void mettreEnPage() {
		// Bon, on va essayer de faire plus beau que d'habitude.
		frame.setLayout(new BorderLayout());
		// Barre d'outils
		JToolBar outils= new JToolBar(JToolBar.HORIZONTAL);
		outils.add(lireButton);
		outils.add(ecrireButton);
		// Les outils en haut.
		frame.add(outils, BorderLayout.NORTH);
		// le texte au milieu, avec des ascenceurs.
		frame.add(new JScrollPane(area), BorderLayout.CENTER);
		
	}

	public void lire() {
		JFileChooser fileChooser= new JFileChooser(fichier);
		int res = fileChooser.showOpenDialog(frame);
		if (res == JFileChooser.APPROVE_OPTION) {
			fichier= fileChooser.getSelectedFile();
			try {
				String s= FilesUtils.read(fichier);
				area.setText(s);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "Fichier "+ fichier+ " non trouvé");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Fichier "+ fichier+ " non lisible");
			}			
		}
	}
	
	public void ecrire() {
		JFileChooser fileChooser= new JFileChooser();
		fileChooser.setSelectedFile(fichier);
		int res = fileChooser.showSaveDialog(frame);
		if (res == JFileChooser.APPROVE_OPTION) {
			try {
				fichier= fileChooser.getSelectedFile();
				FilesUtils.write(fichier, area.getText());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Fichier "+ fichier+ " non inscriptible");
			}
		}
	}
	
	public static void main(String[] args) {
		 
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Exercice2();
			}
		});
	}
}
