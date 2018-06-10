/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.readOnly;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import d03table.data.Personnes;

/**
 *
 * @author rosmord
 */
public class DemoTablePersonnes {
    JFrame frame= new JFrame("Un tableau");
    JTable table= new JTable();

    public DemoTablePersonnes() {
        table.setModel(new PersonnesTableModelReadOnly(Personnes.getList()));
        frame.add(new JScrollPane(table));        
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
   
}
