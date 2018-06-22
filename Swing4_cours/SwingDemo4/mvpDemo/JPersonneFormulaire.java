package mvpDemo;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class JPersonneFormulaire {
	private JPanel panel= new JPanel();
	
	private JButton suivantButton= new JButton(">");
	private JButton precedentButton= new JButton("<");
	private JButton ajouterButton= new JButton("+");
	private JButton validerButton= new JButton("valider");
	
	private JTextField idField= new JTextField(20);
	private JTextField nomField= new JTextField(20);
	private JTextField prenomField= new JTextField(20);
	
	public JPersonneFormulaire() {
		idField.setEditable(false);
		mettreEnPage();
	}

	private void mettreEnPage() {
		panel.setLayout(new BorderLayout());
		JPanel main= new JPanel();
		JPanel outils= new JPanel();
		outils.setLayout(new BoxLayout(outils, BoxLayout.LINE_AXIS));
		outils.add(precedentButton);
		outils.add(suivantButton);
		outils.add(ajouterButton);
		outils.add(validerButton);

		main.setLayout(new GridBagLayout());
		GridBagConstraints cc= new GridBagConstraints();
		main.add(new JLabel("id"),cc);
		cc.gridy= 1;
		main.add(new JLabel("prénom"),cc);
		cc.gridy= 2;		
		main.add(new JLabel("nom"),cc);
		cc.gridy= 0;
		cc.gridx= 1;
		cc.weightx= 1;
		main.add(idField, cc);
		cc.gridy= 1;
		main.add(prenomField, cc);
		cc.gridy= 2;
		main.add(nomField, cc);	
		panel.add(main, BorderLayout.CENTER);
		panel.add(outils, BorderLayout.SOUTH);		
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getSuivantButton() {
		return suivantButton;
	}

	public JButton getPrecedentButton() {
		return precedentButton;
	}

	public JButton getAjouterButton() {
		return ajouterButton;
	}

	public JTextField getIdField() {
		return idField;
	}

	public JTextField getNomField() {
		return nomField;
	}

	public JTextField getPrenomField() {
		return prenomField;
	}
	
	public JButton getValiderButton() {
		return validerButton;
	}
	
}
