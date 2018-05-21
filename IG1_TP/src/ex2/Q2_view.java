package ex2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ex2.corection.FilesUtils;

public class Q2_view extends JFrame {
	private JTextArea textArea;
	private JFileChooser fc;
	private JButton openButton;
	private JButton saveButton;
	

	public Q2_view() {
		this.textArea = new JTextArea(5, 10);
		this.fc = new JFileChooser();
		this.pageSetup();
	}

	public void pageSetup() {
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(textArea);
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		textArea.setLineWrap(true);
		c.add(scrollTextArea);
		openButton = new JButton("Open");
		saveButton = new JButton("Save");
		c.add(openButton);
		c.add(saveButton);

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextArea getTextArea() {
		return this.textArea;
	}

	public JButton getOpenButton() {
		return this.openButton;
	}

	public JButton getSaveButton() {
		return this.saveButton;
	}


}
