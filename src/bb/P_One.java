package bb;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class P_One extends JPanel {
	private CardLayout cards = new CardLayout();
    private Frame F;
    private String Idname;
    private String Idpwd;
	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	private Font f1, f2, f3;

    public P_One(Frame f) {
    	
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
      
        F = f;
       
        f1 = new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 40);//15
		f2 = new Font("±√º≠", Font.BOLD, 50);//20
		f3 = new Font("πŸ≈¡", Font.ITALIC, 75);//30
		

		setVisible(true);
		JLabel userLabel2 = new JLabel("DataBase System");
		userLabel2.setBounds(40, 60, 1000, 100);//40,100,400,25
		userLabel2.setFont(f2);
		add(userLabel2);
		
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(40, 250, 200, 65);//(40, 210, 80, 25);
		userLabel.setFont(f1);
		add(userLabel);
		
		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds(40, 340, 200, 65);//(40, 240, 80, 25);
		passLabel.setFont(f1);
		add(passLabel);
		
		userText = new JTextField(20);
		userText.setBounds(190, 250, 400, 65);//(100, 210, 160, 25);
		userText.setFont(f1);
		add(userText);
		
		passText = new JPasswordField(20);
		passText.setBounds(190, 340, 400, 65);//(100, 240, 160, 25);
		passText.setFont(f1);
		add(passText);
		
                    
        btnInit = new JButton("Register");
		btnInit.setBounds(40, 450, 250, 65);//(40, 280, 100, 25);
		btnInit.setFont(f1);
		add(btnInit);	
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//userText.setText("");
				//passText.setText("");
				//Info.ID[current]=userText.toString();
				F.getCardLayout().show(F.getContentPane(), "Join");
			}
		});
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(415, 450, 250, 65);//(190, 280, 100, 25);
		btnLogin.setFont(f1);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
	
	}
  
 
    public void isLoginCheck(){
    	
    	Test i= new Test();
		
		i.LoginCheck(userText.getText(), new String(passText.getPassword()));
		if(i.loginCheck == 1)
		{
			JOptionPane.showMessageDialog(null, "Success");
			F.getCardLayout().show(F.getContentPane(), "Two");
		}
		
		else{
    		JOptionPane.showMessageDialog(null, "Faild");
    	}
    		   
    }
    		  
	
}


