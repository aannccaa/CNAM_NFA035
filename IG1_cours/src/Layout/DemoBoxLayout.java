package Layout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoBoxLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		BoxLayout b = new BoxLayout(panel, BoxLayout.PAGE_AXIS); // orientation verticale
		panel.setLayout(b);
		JTextField f1 = new JTextField("f1");
		JTextField f2 = new JTextField("f2");
		JTextField f3 = new JTextField("f3");
		JTextField f4 = new JTextField("f4");
		panel.add(f1);
		panel.add(f2);
		panel.add(f3);
		panel.add(f4);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
