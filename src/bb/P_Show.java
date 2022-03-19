	package bb;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class P_Show extends JPanel {

	
	private JButton btnInit;
	private JTextField searchText;
	private Font f1, f2, f3;
	static JTable table2;
	static JPanel sear;
	static int number;

    public P_Show(Frame f) {
    	
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
      
       
        f1 = new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20);//15
		f2 = new Font("±√º≠", Font.BOLD, 50);//20
		f3 = new Font("πŸ≈¡", Font.ITALIC, 75);//30
		

		setVisible(true);
		
		JButton button = new JButton("show");
		button.setBounds(52, 151, 100, 23);
		add(button);
		
		JButton button2 = new JButton("back");
		button2.setBounds(200, 151, 100, 23);
		add(button2);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				String title = (String) P_Search.table.getValueAt(number, 1);
				
				String tname = Test.titleToTable(title);
				
				Test.countUp(tname);
				Test.show(tname,number);
			}
		});
		
button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				Frame.F.getCardLayout().show(Frame.F.getContentPane(), "Search");		
			}
		});
		
	
		String [] header = {"Number","Title","button"};
		String [][] contents = {
		};
		DefaultTableModel dtm = new DefaultTableModel(contents, header);
		table2 = new JTable(dtm);
		DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
		dt.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tm = table2.getColumnModel();
		tm.getColumn(0).setCellRenderer(dt);
		tm.getColumn(1).setCellRenderer(dt);
		tm.getColumn(2).setCellRenderer(dt);
		tm.getColumn(0).setPreferredWidth(70);
		tm.getColumn(1).setPreferredWidth(70);
		tm.getColumn(2).setPreferredWidth(70);

		JScrollPane jsp = new JScrollPane(P_Show.table2);
		jsp.setSize(450, 500);
		jsp.setLocation(110, 200);
		add(jsp);
		


//		sear = this;
		
		
		
		
	
	}
}
