package ex1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Q3_ui extends JFrame{
	private JTextField textField;
	private JButton buttonUppercase;
	private JButton buttonLowercase;
	
	public Q3_ui() {
		this.textField =  new JTextField(10);
		this.buttonUppercase = new JButton("transf en majuscules");
		this.buttonLowercase = new JButton("transf en minuscules");
		this.pageSetup();
	}
	
	private void pageSetup() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(textField);
		p.add(buttonUppercase);
		p.add(buttonLowercase);
		
		this.add(p);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton getButtonUppercase() {	
		return this.buttonUppercase;
	}
	
	public JButton getButtonLowercase() {	
		return this.buttonLowercase;
	}

	public JTextField getTextField() {
		return this.textField;
	}
	
	
	
	
	
	
	
}
