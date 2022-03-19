package bb;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class P_Search extends JPanel {

	
	private JButton btnInit;
	private JTextField searchText;
	private Font f1, f2, f3;
	static JTable table;
	static JPanel sear;

    public P_Search(Frame f) {
    	
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
      
       
        f1 = new Font("¸¼Àº °íµñ", Font.PLAIN, 20);//15
		f2 = new Font("±Ã¼­", Font.BOLD, 50);//20
		f3 = new Font("¹ÙÅÁ", Font.ITALIC, 75);//30
		

		setVisible(true);
		JLabel userLabel2 = new JLabel("Search");
		userLabel2.setBounds(236, 11, 271, 70);//40,100,400,25
		userLabel2.setFont(f2);
		add(userLabel2);
			
		searchText = new JTextField(20);
		searchText.setBounds(100, 100, 400, 40);//(100, 210, 160, 25);
		searchText.setFont(f1);
		add(searchText);
	                
        btnInit = new JButton("°Ë»ö");
		btnInit.setBounds(500, 100, 100, 40);//(40, 280, 100, 25);
		btnInit.setFont(f1);
		add(btnInit);	
		
		JButton back = new JButton("Back");
		back.setBounds(670, 51, 80, 60);
		add(back);
		
		JButton button = new JButton("dictionary");
		button.setBounds(52, 151, 100, 23);
		add(button);
		
		JButton button_1 = new JButton("environment");
		button_1.setBounds(162, 151, 105, 23);
		add(button_1);
		
		JButton button_2 = new JButton("city");
		button_2.setBounds(277, 151, 89, 23);
		add(button_2);
		
		JButton button_3 = new JButton("population_ns");
		button_3.setBounds(390, 151, 110, 23);
		add(button_3);
		
		JButton button_4 = new JButton("resources");
		button_4.setBounds(510, 151, 100, 23);
		add(button_4);
		
		String [] header = {"Number","Title","button"};
		String [][] contents = {
		};
		DefaultTableModel dtm = new DefaultTableModel(contents, header);
		table = new JTable(dtm);
		DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
		dt.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tm = table.getColumnModel();
		tm.getColumn(0).setCellRenderer(dt);
		tm.getColumn(1).setCellRenderer(dt);
		tm.getColumn(2).setCellRenderer(dt);
		tm.getColumn(0).setPreferredWidth(50);
		tm.getColumn(1).setPreferredWidth(330);
		tm.getColumn(2).setPreferredWidth(80);

		JScrollPane jsp = new JScrollPane(P_Search.table);
		jsp.setSize(450, 500);
		jsp.setLocation(110, 200);
		add(jsp);
//		sear = this;
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Frame.F.getCardLayout().show(Frame.F.getContentPane(), "Two");		

			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test.searchUp(searchText.getText(),button.getText());
				
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test.searchUp(searchText.getText(),button_1.getText());
				
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test.searchUp(searchText.getText(),button_2.getText());
				
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test.searchUp(searchText.getText(),button_3.getText());
				
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test.searchUp(searchText.getText(),button_4.getText());

			}
		});
		btnInit.addActionListener(new ActionListener() {		// °Ë»ö ¹öÆ°
			@Override
			public void actionPerformed(ActionEvent e) {
				Test.searchUpdate(searchText.getText());
				Test.insertWord(searchText.getText());
			}
		});
		
		
	
	}
}
