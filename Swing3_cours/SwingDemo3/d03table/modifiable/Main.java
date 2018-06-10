package d03table.modifiable;

import javax.swing.SwingUtilities;

/**
 *
 * @author rosmord
 */
public class Main {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DemoTablePersonnes());
    }
}
