package bb;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Posttest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static String[][] data = new String[8][4];
	public static String title;
	 public static String writer;
	 public static String contents;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Posttest frame = new Posttest();
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Posttest frame = new Posttest();
					
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public Posttest() {
		 
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("title : ");
		lblTitle.setBounds(48, 17, 61, 16);
		contentPane.add(lblTitle);
		
		JLabel lblWriter = new JLabel("writer : ");
		lblWriter.setBounds(48, 45, 61, 16);
		contentPane.add(lblWriter);
		
		JLabel lblContents = new JLabel("contents : ");
		lblContents.setBounds(48, 73, 82, 16);
		contentPane.add(lblContents);
		
		JLabel lblGetdb = new JLabel("getDB");
		lblGetdb.setBounds(98, 17, 400, 16);
		contentPane.add(lblGetdb);
		lblGetdb.setText(title);
		
		JLabel label = new JLabel("getDB");
		label.setBounds(108, 45, 61, 16);
		contentPane.add(label);
		label.setText(writer);
		
		JLabel label_1 = new JLabel("getDB");
		label_1.setBounds(118, 73, 293, 115);
		contentPane.add(label_1);
		label_1.setText(contents);
		
		textField = new JTextField();
		textField.setBounds(128, 195, 258, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblComment = new JLabel("comment : ");
		lblComment.setBounds(48, 200, 82, 16);
		contentPane.add(lblComment);
		
		JButton btnRegister = new JButton("register");
		btnRegister.setBounds(383, 195, 61, 29);
		contentPane.add(btnRegister);


		String[] headings = new String[]{"comments", "Writer", "Date", "title"};
        
		JTable table = new JTable(data, headings);
		table.setPreferredScrollableViewportSize(new Dimension(700, 200));
		table.setFillsViewportHeight(true);
		table.setBounds(48, 300, 600,200);
		contentPane.add(table);
		
		JButton btnBack = new JButton("back");
		btnBack.setBounds(162, 500, 117, 29);
        contentPane.add(btnBack);
      
        btnBack.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
               // BulletinBoard bulletinBoard = new BulletinBoard();
                //bulletinBoard.setVisible(true);
                setVisible(false);
               
            }
        });

        btnRegister.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                //add reply
            	
            	TimeZone jst = TimeZone.getTimeZone ("JST");
                
            	Calendar cal = Calendar.getInstance ( jst );  
            
            	

               String date= Integer.toString(cal.get ( Calendar.YEAR ))+ "/" + Integer.toString( cal.get ( Calendar.MONTH ) + 1 ) + "/" + Integer.toString(cal.get ( Calendar.DATE ));
            	
            	
            	Test s= new Test();
            
            	s.reply(textField.getText(),s.loginid,date,s.titleid);
            	JOptionPane.showMessageDialog(null, "Success");
            	
            }
        });





        
        //setVisible(true);
        setResizable(false);
        setSize(800, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
    
}