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

public class P_RecentTop5 extends JPanel {

	
	private JButton btnInit;
	private JTextField searchText;
	private Font f1, f2, f3;
	static JTable table3;
	static JPanel sear;
	static int number;

    public P_RecentTop5(Frame f) {
    	
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
      
       
        f1 = new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 20);//15
		f2 = new Font("±√º≠", Font.BOLD, 50);//20
		f3 = new Font("πŸ≈¡", Font.ITALIC, 75);//30
		

		setVisible(true);
		
		JButton back = new JButton("Back");
		back.setBounds(670, 51, 80, 60);
		add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame.F.getCardLayout().show(Frame.F.getContentPane(), "Two");		

			}
		});
		
	
		String [] header = {"No","word","time"};
		String [][] contents = {
		};
		DefaultTableModel dtm = new DefaultTableModel(contents, header);
		table3 = new JTable(dtm);
		DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
		dt.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tm = table3.getColumnModel();
		tm.getColumn(0).setCellRenderer(dt);
		tm.getColumn(1).setCellRenderer(dt);
		tm.getColumn(2).setCellRenderer(dt);
		tm.getColumn(0).setPreferredWidth(30);
		tm.getColumn(1).setPreferredWidth(90);
		tm.getColumn(2).setPreferredWidth(90);

		JScrollPane jsp = new JScrollPane(P_RecentTop5.table3);
		jsp.setSize(450, 500);
		jsp.setLocation(110, 200);
		add(jsp);
		


//		sear = this;
		
		
		
		
	
	}
}
