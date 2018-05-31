/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.colonnes;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author rosmord
 */
public class Main {
    JFrame frame= new JFrame("Un tableau");
    JTable table= new JTable();

    public Main() {
        table.setModel(new DemoTableModel(7));
        frame.add(new JScrollPane(table));        
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
