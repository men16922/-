
package bb;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class ScenarioBoard extends JFrame {
	 public static String[][] data = new String[300][5];
	 public static String[] headings ={"#", "#", "#", "#", "#"};
    
     public void ScenarioBoard(){
        setTitle("Scenario Board");
        Test s= new Test();
        s.bulletin();
      
        JPanel showList = new JPanel();
        
       
        
        
        JTable table = new JTable();
      

        
        table.setModel(new DefaultTableModel(data,headings));
        DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
        dt.setHorizontalAlignment(SwingConstants.CENTER);
         TableColumnModel tm = table.getColumnModel();
         tm.getColumn(0).setCellRenderer(dt);
         tm.getColumn(1).setCellRenderer(dt);
         tm.getColumn(2).setCellRenderer(dt);
         tm.getColumn(3).setCellRenderer(dt);
         tm.getColumn(4).setCellRenderer(dt);
         tm.getColumn(0).setPreferredWidth(50);
         tm.getColumn(1).setPreferredWidth(130);
         tm.getColumn(2).setPreferredWidth(80);
         tm.getColumn(3).setPreferredWidth(130);
         tm.getColumn(4).setPreferredWidth(80);

       
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        table.setFillsViewportHeight(true);
        
 
                
     
      
    
        
      
        
        JTextField searchPost = new JTextField(50);

        showList.add(new JScrollPane(table));
        add(showList);


        setVisible(true);
        setResizable(false);
        setSize(800, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
     
     

    public static void main(String[] args) {
        new ScenarioBoard();
        
    }
}