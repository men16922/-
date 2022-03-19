package bb;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JList;


public class P_Two extends JPanel {

    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
	private Font f1, f2, f3;

    private Frame F;
    private JDialog jDialog = new JDialog(F, "Attendance date Input");
    private JDialog jDialog2 = new JDialog(F, "Quiz");
    private JDialog jDialog3 = new JDialog(F, "Scenarios");
	private JLabel label= new JLabel("PW");
    private JTextField text= new JTextField();
	private JLabel label2= new JLabel("name");
	private JTextField text2= new JTextField();
	private JLabel label3= new JLabel("class");
	private JTextField text3= new JTextField();
	private JButton jButton = new JButton("Click");
	private JButton jButton2 = new JButton("Exit");
	
	private JTextField text4= new JTextField();
	private JButton jButton3 = new JButton("Click");
	private JButton jButton4 = new JButton("Exit");
	private JButton jButton5 = new JButton("Click");
	private JButton jButton6 = new JButton("Exit");
	public static int sn=20;
	String word;
	
	String pw,name,classname;
	String quizword="word";
	private JLabel label4= new JLabel(quizword);
    public P_Two(Frame f) {
    	Test Test= new Test();
    	f1 = new Font("맑은 고딕", Font.PLAIN, 40);//15
		f2 = new Font("궁서", Font.BOLD, 50);//20
		f3 = new Font("바탕", Font.ITALIC, 75);//30

		setBackground(Color.GRAY);
        setSize(1200,1200);//600,600
        setLayout(null);
        jDialog.setLayout(new GridLayout(2,2));
        jDialog2.setLayout(new GridLayout(1,4));
        jDialog3.setLayout(new GridLayout(1,3));
        F = f;
        
        List quizlist= new List(15);
        quizlist.setFont(f1);
        jDialog2.add(quizlist);
        
        List scenariolist= new List(25);
        scenariolist.setFont(f2);
        jDialog3.add(scenariolist);
       
        jDialog.setSize(600, 600);//300,300
        jDialog2.setSize(1200, 400);//300,300
        jDialog3.setSize(1000, 400);//300,300
        label.setFont(f1);
        jDialog.add(label);
        
        text.setFont(f1);
        jDialog.add(text);

        label2.setFont(f1);
        jDialog.add(label2);
        
        text2.setFont(f1);
        jDialog.add(text2);
        
        label3.setFont(f1);
        jDialog.add(label3);
        
        text3.setFont(f1);
        jDialog.add(text3);
        
        jButton.setFont(f1);
        jDialog.add(jButton);
        
        jButton2.setFont(f1);
        jDialog.add(jButton2);
        
        label4.setFont(f1);
        jDialog2.add(label4);
        
        text4.setFont(f1);
        jDialog2.add(text4);
        
        jButton3.setFont(f1);
        jDialog2.add(jButton3);
        
        jButton4.setFont(f1);
        jDialog2.add(jButton4);
        
        jButton5.setFont(f2);
        jDialog3.add(jButton5);
        
        jButton6.setFont(f2);
        jDialog3.add(jButton6);
        
        jDialog.setLocation(400,300);//800,600
        jDialog2.setLocation(400,300);//800,600
        jButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
      		   pw=text.getText();	  
      		   name=text2.getText();
    		   classname=text3.getText();    		  
    		  
    		   Test s= new Test();
    		   s.update(s.loginid, pw, name, classname);
      		 
    		   JOptionPane.showMessageDialog(null, "profile updated");
	 		   
      		
              }
          });
            
      jButton2.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent arg0) {
  		 
    		  jDialog.setVisible(false);
          }
      });
      
      
      jButton3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		pw=text.getText();	  
   		   name=text2.getText();
 		   classname=text3.getText();    		  
 		   quizword=text4.getText();
 		   Test s= new Test();
 		   
 		  String n=quizlist.getSelectedItem();
 		 s.quiz(quizword);
 		 if(s.result.equals(n))
 		   	JOptionPane.showMessageDialog(null, "정답");
      	
      	else
      		JOptionPane.showMessageDialog(null, "틀렸습니다");
    		
            }
        });
      
      jButton4.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent arg0) {
  		 
    		  jDialog2.setVisible(false);
          }
      });
      
      jButton5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String n=scenariolist.getSelectedItem();
   		   Test s = new Test();
   		   s.scenariosearch(n);
   		   
   		   s.sqlsearch(s.mysql);
   		
   		  
        	
   		  ScenarioBoard b= new ScenarioBoard();
		   b.ScenarioBoard();
        	}});
      
      jButton6.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent arg0) {
  		 
    		  jDialog3.setVisible(false);
          }
      });
   
       btn1 = new JButton("1. View Profile");
       btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	F.getCardLayout().show(F.getContentPane(), "Profile");
            	Test s= new Test();
            	s.showuser();
            	

            	// 화면 추가
            }
        });
       
       btn1.setBounds(80, 30, 600, 40);//(20, 35, 113, 23);
       btn1.setFont(f1);
       add(btn1);
        
    
       
       btn2 = new JButton("2. Delete user");
       btn2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
            	 Test s= new Test();
            	 s.delete(s.loginid);
            	 JOptionPane.showMessageDialog(null, s.loginid + " is deleted");
            	 s.loginid="";
             	 F.getCardLayout().show(F.getContentPane(), "One");     	
              }
       });
       btn2.setBounds(80, 80, 600, 40);
       btn2.setFont(f1);
       add(btn2);
       
       btn3 = new JButton("3. Update user");
       btn3.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   jDialog.setVisible(true);
           }
       });
       btn3.setBounds(80, 130, 600, 40);
       btn3.setFont(f1);
       add(btn3);
       
       btn4 = new JButton("4. Search");
       btn4.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   F.getCardLayout().show(F.getContentPane(), "Search");
    	   }
       });
       btn4.setBounds(80, 180, 600, 40);
       btn4.setFont(f1);
       add(btn4);
       
       btn5 = new JButton("5.뉴스/영상 Search");
       btn5.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   
    		   F.getCardLayout().show(F.getContentPane(), "Search2");
    		   
    		   
           }
       });
       btn5.setBounds(80, 230, 600, 40);
       btn5.setFont(f1);
       add(btn5);
       
       btn6 = new JButton("6. Quiz");
       btn6.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   Test s= new Test();
    		   s.quizselect();
    		   quizlist.removeAll();  
    		   for(int i=0; i<15; i++)
    		   {
    		   quizlist.add(s.words[i]);
    		   }
    		   jDialog2.setVisible(true);
    		   
    	   }
       });
       btn6.setBounds(80, 280, 600, 40);
       btn6.setFont(f1);
       add(btn6);
       
       btn7 = new JButton("7. Bulletin");
       btn7.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   BulletinBoard b = new BulletinBoard();
    		   b.BulletinBoard();
    		  
    	   
    	   }
       });
       btn7.setBounds(80, 330, 600, 40);
       btn7.setFont(f1);
       add(btn7);
       
       btn8 = new JButton("8. 조회수 Top 5");
       btn8.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   F.getCardLayout().show(F.getContentPane(), "View");
				Test.viewTop();
				
    	   }
       });
       btn8.setBounds(80, 380, 600, 40);
       btn8.setFont(f1);
       add(btn8);
       
       btn9 = new JButton("9. 최근 검색어 five");
       btn9.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   
    		 

    		   F.getCardLayout().show(F.getContentPane(), "Recent");
    		   Test.recentTop();
    	   }
       });
       
       btn9.setBounds(80, 430, 600, 40);//(20, 175, 113, 23);
       btn9.setFont(f1);
       add(btn9);
       
       btn10 = new JButton("10. Scenarios");
       btn10.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   
    		   Test s= new Test();
    		   s.scenario();
    		   scenariolist.removeAll();  
    		   for(int i=0; i<sn; i++)
    		   {
    		   scenariolist.add(s.scenarios[i]);
    		   }
    		   jDialog3.setVisible(true);
    		   
    		   
    		   
    	   }
       });
       
       btn10.setBounds(80, 480, 600, 40);//(20, 175, 113, 23);
       btn10.setFont(f1);
       add(btn10);
       
       btn11 = new JButton("11. Escape from North");
       btn11.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		  pp asdf = new pp();
    		  asdf.run();
    		   
    	   }
       });
       
       btn11.setBounds(80, 530, 600, 40);//(20, 175, 113, 23);
       btn11.setFont(f1);
       add(btn11);
       
       btn12 = new JButton("12. Logout");
       btn12.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent arg0) {
    		   Test s= new Test();
    		   s.loginid="";
    		   F.getCardLayout().show(F.getContentPane(), "One");
    		   
    	   }
       });
       
       btn12.setBounds(80, 580, 600, 40);//(20, 175, 113, 23);
       btn12.setFont(f1);
       add(btn12);
     
 
       setVisible(true);
    }
}


