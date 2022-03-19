package bb;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.util.*;
import java.text.*;




public class WritePost extends JFrame{
	JTextField txtTitle = new JTextField(50);
    JTextArea txtContents = new JTextArea();
    public WritePost(){
    	TimeZone jst = TimeZone.getTimeZone ("JST");
    
    	Calendar cal = Calendar.getInstance ( jst );  
    
    	

       String date= Integer.toString(cal.get ( Calendar.YEAR ))+ "/" + Integer.toString( cal.get ( Calendar.MONTH ) + 1 ) + "/" + Integer.toString(cal.get ( Calendar.DATE ));
       System.out.println(date);
        JPanel titlePanel = new JPanel();
        JPanel contentsPanel = new JPanel();
        JPanel registerPanel = new JPanel();
        JLabel title = new JLabel("Title : ");
        JLabel contents = new JLabel("Contents : ");
        
        txtContents.setPreferredSize(new Dimension(700, 600));
        JButton register = new JButton("register");

        JTextArea txtArea = new JTextArea();

        titlePanel.add(title);
        titlePanel.add(txtTitle);
        contentsPanel.add(contents);
        contentsPanel.add(txtContents);
        registerPanel.add(register);
        registerPanel.add(txtArea);
        Test s= new Test();
        
        String author=s.loginid;
        register.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
            	String titleid=txtTitle.getText();
              
                String contentsid=txtContents.getText();
             
            	s.write(titleid,author,date,contentsid);
            	
                BulletinBoard bulletinBoard = new BulletinBoard();
                bulletinBoard.setVisible(true);
                setVisible(false);
            }
        });
        
        add(titlePanel, BorderLayout.NORTH);
        add(contentsPanel, BorderLayout.CENTER);
        add(registerPanel, BorderLayout.SOUTH);

        setVisible(true);
        setResizable(false);
        setSize(800, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new WritePost();
    }
}