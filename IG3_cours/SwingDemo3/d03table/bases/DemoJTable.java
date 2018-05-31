/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d03table.bases;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DemoJTable {
    JFrame frame= new JFrame("Un tableau");
    JTable table= new JTable(0, 3);

    public DemoJTable() {       
        DefaultTableModel defaultModel= (DefaultTableModel) table.getModel();
        defaultModel.setColumnIdentifiers(new String [] {"col1", "col2", "col3"});
        defaultModel.addRow(new String[] {"un", "deux", "trois"});        
        defaultModel.addRow(new String[] {"one", "two", "three"});  
        frame.add(new JScrollPane(table));        
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DemoJTable());
    }
}
