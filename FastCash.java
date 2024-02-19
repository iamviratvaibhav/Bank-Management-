package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; //DOt data isliye likha h kyuke yha pr date sql or util ke andar bhe hota h 
//to compiler confuse hoga ke khonse package se date utahana h
public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastcash, pinchnge, ministatement, balinq, exit, mainmenu;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(190, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        deposit = new JButton("₹ 500");
        deposit.setBounds(160, 415, 170, 30);
        deposit.setBackground(Color.WHITE);
        deposit.setFont(new Font("System", Font.BOLD, 18));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("₹ 1000");
        withdrawal.setBounds(355, 415, 160, 30);
        withdrawal.setBackground(Color.WHITE);
        withdrawal.setFont(new Font("System", Font.BOLD, 18));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("MAIN MENU");
        fastcash.setBounds(160, 520, 170, 30);
        fastcash.setBackground(Color.WHITE);
        fastcash.setFont(new Font("System", Font.BOLD, 18));
        fastcash.addActionListener(this);
        image.add(fastcash);

        pinchnge = new JButton("₹ 10000");
        pinchnge.setBounds(355, 485, 160, 30);
        pinchnge.setBackground(Color.WHITE);
        pinchnge.setFont(new Font("System", Font.BOLD, 18));
        pinchnge.addActionListener(this);
        image.add(pinchnge);

        ministatement = new JButton("₹ 1500");
        ministatement.setBounds(160, 450, 170, 30);
        ministatement.setBackground(Color.WHITE);
        ministatement.setFont(new Font("System", Font.BOLD, 18));
        ministatement.addActionListener(this);
        image.add(ministatement);

        balinq = new JButton("₹ 5000");
        balinq.setBounds(160, 485, 170, 30);
        balinq.setBackground(Color.WHITE);
        balinq.setFont(new Font("System", Font.BOLD, 18));
        balinq.addActionListener(this);
        image.add(balinq);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 160, 30);
        exit.setBackground(Color.WHITE);
        exit.setFont(new Font("System", Font.BOLD, 18));
        exit.addActionListener(this);
        image.add(exit);

        mainmenu = new JButton("₹ 2000");
        mainmenu.setBounds(355, 450, 160, 30);
        mainmenu.setBackground(Color.WHITE);
        mainmenu.setFont(new Font("System", Font.BOLD, 18));
        mainmenu.addActionListener(this);
        image.add(mainmenu);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(2);
            conn connection = new conn();

            try {
                ResultSet rs = connection.s.executeQuery("select * from bank where '" + pinnumber + "' ");
                  int balance = 0;

                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                 if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ;
                }
                Date date =new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹"+amount+"Debit Successfully");
                
               
                setVisible(false);
                new Transection(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                System.out.print(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
