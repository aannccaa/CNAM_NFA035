package ex1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Q2_ui extends JFrame{
	private JTextField textField;
	private JButton buttonUppercase;
	
	public Q2_ui() {
		this.textField =  new JTextField(10);
		this.buttonUppercase = new JButton("transf en majuscules");
		this.pageSetup();
	}
	
	private void pageSetup() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(textField);
		p.add(buttonUppercase);
		
		this.add(p);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JButton getButtonUppercase() {	
		return this.buttonUppercase;
	}

	public JTextField getTextField() {
		return this.textField;
	}
	
	
	
	
	
	
	
}
