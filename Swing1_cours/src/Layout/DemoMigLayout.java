package Layout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// téléchargé depuis internet
import net.miginfocom.swing.MigLayout;

public class DemoMigLayout {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		p.setLayout(new MigLayout());
		p.add(new JLabel("nom"));
		JTextField nomTextField = new JTextField(5);
		p.add(nomTextField, "wrap");//passe à la ligne suivante l'objet suivant
		p.add(new JLabel("prenom")); // l'objet prenom este créé sur nouvelle ligne, du au wrap précédant
		JTextField prenomTextField = new JTextField(5);
		p.add(prenomTextField);
		f.add(p);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
