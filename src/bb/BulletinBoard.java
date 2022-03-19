
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


public class BulletinBoard extends JFrame {
	 public static String[][] data = new String[10][4];
		
    
     public void BulletinBoard(){
        setTitle("Bulletin Board");
        Test s= new Test();
        s.bulletin();
        
        JPanel showList = new JPanel();
        
        String[] headings = new String[]{"#", "Title", "Writer", "Date", "Open"};
        
        
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

         tm.getColumn(4).setCellRenderer(new EnterButton(table));   // 踰꾪?�� �굹���굹�룄濡�
         tm.getColumn(4).setCellEditor(new EnterButton(table));      // 踰꾪?�� �닃�읉�쓣�븣 �룞�옉�븯�룄濡�
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        table.setFillsViewportHeight(true);
        
 
        
        
        
        JTextField searchPost = new JTextField(50);
        JButton search = new JButton("Search");
        JButton write = new JButton("Write");
        JButton delete = new JButton("delete");
        
        showList.add(new JScrollPane(table));
        showList.add(searchPost);
        showList.add(search);
        showList.add(write);
        showList.add(delete);
       // table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        search.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
              Test s = new Test();
              
              s.search(searchPost.getText());
              table.setModel(new DefaultTableModel(data,headings));
              tm.getColumn(4).setCellRenderer(new EnterButton(table));   // 踰꾪?�� �굹���굹�룄濡�
              tm.getColumn(4).setCellEditor(new EnterButton(table));      // 踰꾪?�� �닃�읉�쓣�븣 �룞�옉�븯�룄濡�
              
            }
        });
        
        delete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
              Test s = new Test();
              
              s.deletepost(searchPost.getText());
              table.setModel(new DefaultTableModel(data,headings));
              tm.getColumn(4).setCellRenderer(new EnterButton(table));   // 踰꾪?�� �굹���굹�룄濡�
              tm.getColumn(4).setCellEditor(new EnterButton(table));      // 踰꾪?�� �닃�읉�쓣�븣 �룞�옉�븯�룄濡�
              
            }
        });
        
        
        write.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
               WritePost writepost = new WritePost();
               writepost.setVisible(true);
               setVisible(false);
            }
        });


        add(showList);


        setVisible(true);
        setResizable(false);
        setSize(800, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
     
     

    public static void main(String[] args) {
        new BulletinBoard();
        
    }
}