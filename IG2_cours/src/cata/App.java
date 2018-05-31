package cata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class App {
	private JFrame frame;
	private SimpleAction[] actions;

	public App() {
		createActions();
		createControls();
	}

	private void createActions() {
		this.actions = new SimpleAction[] { new SimpleAction("gauche", "Aller à gauche"),
				new SimpleAction("droite", "Aller à droite"), new SimpleAction("haut", "Aller vers le haut"),
				new SimpleAction("bas", "Aller vers le bas"), };
	}

	private void executeAction(SimpleAction action) {
		switch (action.getName()) {
		case "gauche":
			gauche();;
			break;
		case "droite":
			droite();;
			break;
		case "haut":
			haut();;
			break;
		case "bas":
			bas();;
			break;
		default:
			throw new RuntimeException();
		}
	}

	private void createControls() {
		frame = new JFrame("Carré avec rond 2, le retour de la vengeance");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		panel.add(toolBar, BorderLayout.WEST);
		frame.add(panel);

		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				SimpleAction action = (SimpleAction)button.getClientProperty("action");
				executeAction(action);
			}
		};
		for(SimpleAction a : this.actions) {
			JButton b = new JButton(a.getText());
			b.putClientProperty("action", a);
			toolBar.add(b);
			b.addActionListener(listener);
		}
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public void droite() {
		JOptionPane.showMessageDialog(frame, "droite");
	}

	public void gauche() {
		JOptionPane.showMessageDialog(frame, "gauche");
	}

	public void haut() {
		JOptionPane.showMessageDialog(frame, "haut");
	}

	public void bas() {
		JOptionPane.showMessageDialog(frame, "bas");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new App();
			}
		});
	}
}
