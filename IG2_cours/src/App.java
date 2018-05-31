import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class App {

	private JFrame frame = new JFrame("Carré avec rond");
	private CarreAvecRond3 monObjet = new CarreAvecRond3();
	private JButton choisirCouleurBouton = new JButton("couleur");
	private JButton droiteBouton = new JButton("droite");
	private JButton gaucheBouton = new JButton("gauche");
	private JButton hautBouton = new JButton("haut");
	private JButton basBouton = new JButton("bas");

	public App() {
		activer();
		mettreEnPage();
	}

	private void activer() {
		// TODO Auto-generated method stub

	}

	private void mettreEnPage() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
		toolBar.add(choisirCouleurBouton);
		toolBar.add(gaucheBouton);
		toolBar.add(droiteBouton);
		toolBar.add(hautBouton);
		toolBar.add(basBouton);

		JScrollPane scrollPane = new JScrollPane(monObjet);
		panel.add(scrollPane);
		panel.add(toolBar, BorderLayout.WEST);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CarreAvecRond3 app = new CarreAvecRond3();
			}

		});

	}
}
