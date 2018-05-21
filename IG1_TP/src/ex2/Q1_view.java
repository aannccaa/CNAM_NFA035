package ex2;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Q1_view extends JFrame{
	private JTextArea textArea;
	private JScrollPane scrollTextArea;
	
	public Q1_view() {
		this.textArea = new JTextArea(5, 10);
		this.pageSetup();
	}
	
	public void pageSetup() {
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(textArea);
		scrollTextArea = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		c.add(scrollTextArea);
	
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}

}
