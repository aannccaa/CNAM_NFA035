package ex1;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Q4_view extends JFrame {
	private JTextField textField;
	private JComboBox combo;
	private JButton buttonFaire;

	public Q4_view() {
		super();
		this.textField = new JTextField(15);
		this.textField.setText("aBccccT123_e");
		String[] choix = { "UpperCase", "Lowercase", "Effacer" };
		this.combo = new JComboBox(choix);
		this.buttonFaire = new JButton("Faire");
		this.pageSetup();
	}

	private void pageSetup() {
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(textField);
		c.add(combo);
		c.add(buttonFaire);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String getTextCombo() {
		return (String) this.combo.getSelectedItem();
	}

	public JTextField getTextField() {
		return this.textField;
	}

	public JButton getButtonFaire() {
		return this.buttonFaire;
	}

}
