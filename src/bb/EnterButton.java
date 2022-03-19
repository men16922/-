package bb;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class EnterButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

    JButton jb;
    public EnterButton() {
        // TODO Auto-generated constructor stub

    	jb = new JButton("Enter");
        jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				P_Show.number = P_Search.table.getSelectedRow();
				Frame.F.getCardLayout().show(Frame.F.getContentPane(), "Show");		
				
				

			
			}
		});

    }
   
    public EnterButton(JTable j) {
        // TODO Auto-generated constructor stub
        
       jb = new JButton("Enter");
        jb.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
        	 Test s= new Test();
		        
         	int row = j. getSelectedRow();
         	//System.out.println(j.getColumnName(j.getSelectedColumn()));
         	String value=(String) j.getValueAt(row,1);
         	//System.out.println(value);
         	s.titleid=value;
         	s.comment(value);
         	s.text(value);
            JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.add(panel);
        //frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(800, 640);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Posttest posttest = new Posttest();
        BulletinBoard bulletinboard = new BulletinBoard();
            posttest.setVisible(true);
           bulletinboard.setVisible(false);
         }
      });

    }

    @Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // TODO Auto-generated method stub

        return jb;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        // TODO Auto-generated method stub

        return jb;
    }

}
