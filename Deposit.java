
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton back, deposit;
    String pinnumber;
    
    Deposit(String pinnumber){
    this.pinnumber=pinnumber;    
    
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,850,850);
    add(image);
    
    JLabel text=new JLabel("Enter Amount for Deposit");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(200,300,400,20);
    image.add(text);
    
    amount=new JTextField("");
    amount.setFont(new Font("Releway",Font.BOLD,22));
    amount.setBounds(170,350,280,25);
    add(amount);
    
    back=new JButton("Back");
    back.setBounds(320, 490, 150, 30);
    back.setBackground(Color.WHITE);
    back.addActionListener(this);
    image.add(back);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(320, 455, 150, 30);
    deposit.setBackground(Color.WHITE);
    deposit.addActionListener(this);
    image.add(deposit);
    
    
    setSize(850,850);
    setLocation(300,0);
    setVisible(true);
//    ClassLoaders locate and load class files from various sources such as the file system, 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number=amount.getText();
            Date date=new Date(); //for date obj use import java util.*;
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount ");    
            }
            else {
                try{
                    conn connection=new conn();
//                  //  String query="inser into bank values('"+pinnumber+"', '"+date+"', 'deposit','"+number+"')";
//                    String query="INSERT INTO bank (pin, date, type, amount) VALUES ('"+pinnumber+"','"+date+"','"+deposit+"','"+number+"')";
                    String query="INSERT INTO bank (pin, date, type, amount) VALUES ('"+pinnumber+"','"+date+"','deposit','"+number+"')";

                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"₹"+number+"Deposited Successfully");
                    setVisible(false);
                    new Transection(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }
    }
        
    public static void main(String args[]){
        new Deposit("");
    }
}
