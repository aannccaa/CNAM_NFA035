package d02Combobox;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Démonstration simple de l'usage d'une combobox.
 * La valeur choisie (de type String) est affichée dans un champ texte.
 * <p> Note: on peut, au choix rendre la box éditable ou non.
 * @author rosmord
 */
public class DemoComboBox {
	private final JComboBox comboBox;
	private final JTextField textField;
	
	public DemoComboBox() {
		Prix prix[]= {
				new Prix(10, "francs"),
				new Prix(16, "euros")
		};
		comboBox= new JComboBox(prix);
		textField= new JTextField(20);
		textField.setEditable(false);
		comboBox.addActionListener(new RecopierActionListener(this));
		mettreEnPage();
	}

	public void recopier() {
		Prix p=  (Prix) comboBox.getSelectedItem();
		textField.setText(""+p.getValue() + " dans l'unité "+ p.getUnite());
	}

	private void mettreEnPage() {
		JFrame frame= new JFrame();
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.add(comboBox);
		panel.add(textField);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
}

class Prix {
	private final double value;
	private final String unite;
	public Prix(double value, String unite) {
		this.value = value;
		this.unite = unite;
	}
	public double getValue() {
		return value;
	}
	public String getUnite() {
		return unite;
	}
	
	@Override
	public String toString() {
		return value + " "+ unite;
	}
}

class RecopierActionListener implements ActionListener {
	DemoComboBox simpleCBDemo;
	
	public RecopierActionListener(DemoComboBox simpleCBDemo) {
		super();
		this.simpleCBDemo = simpleCBDemo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		simpleCBDemo.recopier();
	}
	
}