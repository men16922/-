package bb;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Joindisplay extends JPanel{
	private CardLayout cards = new CardLayout();
    private Frame F;
	
	private boolean bLoginCheck;
	
	private JButton btnLogin;
	private JButton btnInit;
	private JTextField[] Jtxt = new JTextField[4];
	private int[] numArr = {150,240,400,500}; 
	
	private Font f1, f2;
	private String id, pw, name, age;
	

    public Joindisplay(Frame f) throws CloneNotSupportedException {
    	setBackground(Color.LIGHT_GRAY);
 	    setLayout(null);
 	  
 	    F = f;
 	   
 	    f1 = new Font("¸¼Àº °íµñ", Font.PLAIN, 40);//15
		f2 = new Font("±Ã¼­", Font.BOLD, 50);//20
			
 		setVisible(true);
 		JLabel userLabel2 = new JLabel("Personal Information");
 		userLabel2.setBounds(40, 10, 1000, 100);
 		userLabel2.setFont(f2);
 		add(userLabel2);
 		
 		JLabel userLabel = new JLabel("ID");
 		userLabel.setBounds(40, 150, 200, 65);//(40, 210, 80, 25);
 		userLabel.setFont(f2);
 		add(userLabel);
 		
 		JLabel userLabel3 = new JLabel("PW");
 		userLabel3.setBounds(40, 240, 200, 65);//(40, 240, 80, 25);
 		userLabel3.setFont(f2);
 		add(userLabel3);
 		
 		JLabel userLabel6 = new JLabel("-essential input-");
 		userLabel6.setBounds(200, 320, 300, 65);//(40, 240, 80, 25);
 		userLabel6.setFont(f1);
 		add(userLabel6);
 		
 		JLabel userLabel4 = new JLabel("name");
 		userLabel4.setBounds(40, 400, 200, 65);//(40, 240, 80, 25);
 		userLabel4.setFont(f2);
 		add(userLabel4);
 		
 		JLabel userLabel5 = new JLabel("class");
 		userLabel5.setBounds(40, 500, 250, 65);//(40, 240, 80, 25);
 		userLabel5.setFont(f2);
 		add(userLabel5);
 		
 		for(int i=0;i<4;i++){
 			Jtxt[i] = new JTextField(20);
 			Jtxt[i].setBounds(240, numArr[i], 400, 65);
 			Jtxt[i].setFont(f1);
 			add(Jtxt[i]);
 		}
		               
        btnInit = new JButton("Enter");
		btnInit.setBounds(40, 600, 250, 65);//(40, 280, 100, 25);
		btnInit.setFont(f1);
		add(btnInit);
		
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id=Jtxt[0].getText();
				pw=Jtxt[1].getText();
				name=Jtxt[2].getText();
				age=Jtxt[3].getText();
						
				Test i = new Test();
				i.checklist(id);
				if(i.redunCheck==1)
				{
					i.insert(id,pw,name,age);
					JOptionPane.showMessageDialog(null, "Success");
					for(int k=0;k<4;k++){
			 			Jtxt[k].setText("");
			 		}
					F.getCardLayout().show(F.getContentPane(), "One");
			
				}
				else
				{
					JOptionPane.showMessageDialog(null, "already have id");	
				}
		
			}
			
		});
		
		btnLogin = new JButton("Back");
		btnLogin.setBounds(415, 600, 250, 65);//(190, 280, 100, 25);
		btnLogin.setFont(f1); 		
		add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<4;i++){
		 			Jtxt[i].setText("");
		 		}
				F.getCardLayout().show(F.getContentPane(), "One");
			}
		});
	

    }}
     
