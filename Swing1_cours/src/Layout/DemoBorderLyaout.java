package Layout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DemoBorderLyaout extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JTextField textField1 = new JTextField("textField WEST");
		JTextField textField2 = new JTextField("textField CENTER");
		JTextField textField3 = new JTextField("textField EAST");
		JTextField textField4 = new JTextField("textField SOUTH");
		JTextField textField5 = new JTextField("textField NORTH");
		panel.add(new JScrollPane(textField1), BorderLayout.WEST);
		panel.add(new JScrollPane(textField2), BorderLayout.CENTER);
		panel.add(new JScrollPane(textField3), BorderLayout.EAST);
		panel.add(new JScrollPane(textField4), BorderLayout.SOUTH);
		panel.add(new JScrollPane(textField5), BorderLayout.NORTH);
		frame.add(panel);
		frame.add(new JScrollPane(panel));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}