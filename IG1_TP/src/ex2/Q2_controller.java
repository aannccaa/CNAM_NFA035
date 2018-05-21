package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ex2.corection.FilesUtils;

public class Q2_controller {
	Q2_model model;
	Q2_view view;
	private File fichier;
	 

	public Q2_controller() {
		this.model = new Q2_model();
		this.view = new Q2_view();
		this.activate();
	}

	public void activate() {
		synchroModelFromView();
		this.view.getOpenButton().addActionListener(e->openFile());
		synchroViewFromModel();
		
		synchroModelFromView();
		this.view.getSaveButton().addActionListener(e->saveFile());
		synchroViewFromModel();
	}

	

	public void openFile() {
		JFileChooser fileChooser = new JFileChooser(fichier);
		int res = fileChooser.showOpenDialog(view);
		if (res == JFileChooser.APPROVE_OPTION) {
			fichier = fileChooser.getSelectedFile();
			try {
				String s = FilesUtils.read(fichier);
				view.getTextArea().setText(s);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(view, "Fichier " + fichier + " non trouvé");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(view, "Fichier " + fichier + " non lisible");
			}
		}
	}

	public void saveFile() {
		JFileChooser fileChooser= new JFileChooser();
		fileChooser.setSelectedFile(fichier);
		int res = fileChooser.showSaveDialog(view);
		if (res == JFileChooser.APPROVE_OPTION) {
			try {
				fichier= fileChooser.getSelectedFile();
				FilesUtils.write(fichier, view.getTextArea().getText());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(view, "Fichier "+ fichier+ " non inscriptible");
			}
		}
	}



	private void synchroModelFromView() {
		// je prend la val de l'écran et je la mets dans le modèle
		String text = view.getTextArea().getText();// valeur de l'écran
		model.setText(text);
	}

	private void synchroViewFromModel() {
		String text;
		// je prend la val du modèle et je la mets dans l'écran
		text = model.getText(); // val du modèle
		view.getTextArea().setText(text);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Q2_controller app = new Q2_controller();
			}
		});

	}

}
