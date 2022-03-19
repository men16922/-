package bb;

import java.awt.*;

import java.awt.event.*;


import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame{
	private CardLayout cards = new CardLayout();
    static int current =0; 
    static List<String> resultList;
    static List<String> dataList;
    static Frame F;
    
    public Frame(String title) throws CloneNotSupportedException {
    	super(title);
        setSize(800, 700);//380,350
 	    setLocation(100, 50);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         
        getContentPane().add("One", new P_One(this));
        getContentPane().add("Two", new P_Two(this));
        getContentPane().add("Search", new P_Search(this)); 
        getContentPane().add("Join", new Joindisplay(this));
        getContentPane().add("Show", new P_Show(this));
        getContentPane().add("View", new P_ViewTop5(this));
        getContentPane().add("Recent", new P_RecentTop5(this));
        getContentPane().add("Search2", new P_Search2(this)); 
        getContentPane().add("Profile", new P_Profile(this)); 
    
        setVisible(true);
    }
     
    public void changePanel() {
        cards.next(this.getContentPane());
    }
    public CardLayout getCardLayout() {
    	 return cards;
    	}


	public static void main(String[] args) throws CloneNotSupportedException
	{
		F=new Frame("DataBase System");
		
	}
}