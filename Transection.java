
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transection extends JFrame implements ActionListener{
    JButton deposit, withdrawal,pinchaange,fastcash,ministatement,balinq,exit,mainmenu;
    String pinnumber;
    
    Transection (String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your transection");
        text.setBounds(230,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        image.add(text);
        
        deposit=new JButton ("Deposit");
       deposit.setBounds(160,415,170,30);
       deposit.setBackground(Color.WHITE);
       deposit.setFont(new Font("System",Font.BOLD,20));
       deposit.addActionListener(this);
       image.add(deposit);
       
        withdrawal=new JButton ("Withdrawal");
       withdrawal.setBounds(355,415,160,30);
       withdrawal.setBackground(Color.WHITE);
       withdrawal.setFont(new Font("System",Font.BOLD,20));
       withdrawal.addActionListener(this);
       image.add(withdrawal);
       
        fastcash=new JButton ("Fast Cash");
       fastcash.setBounds(160,520,170,30);
       fastcash.setBackground(Color.WHITE);
       fastcash.setFont(new Font("System",Font.BOLD,20));
       fastcash.addActionListener(this);
       image.add(fastcash);
       
        pinchaange=new JButton ("Pin Change");
       pinchaange.setBounds(355,485,160,30);
       pinchaange.setBackground(Color.WHITE);
       pinchaange.setFont(new Font("System",Font.BOLD,20));
       pinchaange.addActionListener(this);
       image.add(pinchaange);
       
       
        ministatement=new JButton ("Mini Statement");
       ministatement.setBounds(160,450,170,30);
       ministatement.setBackground(Color.WHITE);
       ministatement.setFont(new Font("System",Font.BOLD,18));
       ministatement.addActionListener(this);
       image.add(ministatement);
    
        balinq=new JButton ("Balance Inquiry");
       balinq.setBounds(160,485,170,30);
       balinq.setBackground(Color.WHITE);
       balinq.setFont(new Font("System",Font.BOLD,18));
       balinq.addActionListener(this);
       image.add(balinq);
       
       exit=new JButton ("Exit");
       exit.setBounds(355,520,160,30);
       exit.setBackground(Color.WHITE);
       exit.setFont(new Font("System",Font.BOLD,18));
       exit.addActionListener(this);
       image.add(exit);
       
       mainmenu=new JButton ("Main Menu");
       mainmenu.setBounds(355,450,160,30);
       mainmenu.setBackground(Color.WHITE);
       mainmenu.setFont(new Font("System",Font.BOLD,18));
       mainmenu.addActionListener(this);
       image.add(mainmenu);
      
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);   
        }       //Deposit - wo he hona chaya jo class na naam h 
        else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash (pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchaange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[] args){
        new Transection("");
    }
}
