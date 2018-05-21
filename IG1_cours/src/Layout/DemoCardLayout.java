package Layout;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoCardLayout {

	public static void main(String[] args) {
		JFrame f = new JFrame("CardLayout demo");
		JPanel panelParent = new JPanel();
		
		
		JPanel p1 = new JPanel();
		p1.add(new JTextField("f1", 10));
		p1.add(new JButton("Buton1"));
		
		JPanel p2 = new JPanel();
		p2.add(new JTextField("f2", 10));
		p2.add(new JButton("Buton2"));
		
		CardLayout layout = new CardLayout();
		panelParent.setLayout(layout);
		
		// on rajoute les panels p1 et p2 au panel parent
		panelParent.add(p1,"p1");
		panelParent.add(p2,"p2");
		// on affiche dans panel parent le panel "p2"
		layout.show(panelParent, "p2");
		
		f.add(panelParent);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
