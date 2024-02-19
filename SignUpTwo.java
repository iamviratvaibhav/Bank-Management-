package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpTwo extends JFrame implements ActionListener {

    long random;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton cancel, submit;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel ll = new JLabel("Account Detail");
        ll.setBounds(300, 20, 400, 40);
        ll.setFont(new Font("Raleway", Font.BOLD, 30));
        ll.setBackground(Color.WHITE);
        add(ll);

        setSize(850, 830);
        setLocation(350, 0);
        setVisible(true);

        JLabel actype = new JLabel("Account type");
        actype.setBounds(100, 80, 200, 30);
        actype.setFont(new Font("Raleway", Font.BOLD, 20));
        add(actype);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 10));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 130, 200, 30);//20
        add(r1);

        r2 = new JRadioButton("Merchant Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 10));
        r2.setBackground(Color.WHITE);
        r2.setBounds(500, 130, 200, 30);//20
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 10));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 180, 200, 30);//20=50;
        add(r3);

        r4 = new JRadioButton("Recurrence Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 10));
        r4.setBackground(Color.WHITE);
        r4.setBounds(500, 180, 200, 30);//20
        add(r4);
        ButtonGroup buttgrpvar = new ButtonGroup();
        buttgrpvar.add(r1);
        buttgrpvar.add(r2);
        buttgrpvar.add(r3);
        buttgrpvar.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-3452");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardnoline = new JLabel("This is your 16 digit card no");
        cardnoline.setFont(new Font("Raleway", Font.BOLD, 10));
        cardnoline.setBounds(100, 320, 300, 30);
        add(cardnoline);

        JLabel pin = new JLabel("XXXX");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(330, 350, 300, 30);
        add(pin);
        JLabel pinNum = new JLabel("Pin:");
        pinNum.setFont(new Font("Raleway", Font.BOLD, 20));
        pinNum.setBounds(100, 350, 300, 40);
        add(pinNum);
        JLabel pinnoline = new JLabel("This is your pin no");
        pinnoline.setFont(new Font("Raleway", Font.BOLD, 10));
        pinnoline.setBounds(100, 370, 300, 30);
        add(pinnoline);

        JLabel services = new JLabel("Service Required");
        services.setFont(new Font("Raleway", Font.BOLD, 30));
        services.setBounds(100, 450, 300, 30);
        add(services);
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 20));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Check Book");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 20));
        c2.setBounds(500, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 20));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Credit Card");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 20));
        c4.setBounds(500, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Pass Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 20));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("Debit Card");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 20));
        c6.setBounds(500, 600, 200, 30);
        add(c6);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 720, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(400, 720, 100, 30);
        submit.setFont(new Font("Releway", Font.BOLD, 20));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Account Detail");
        // Set the title of the JFrame

    }

        public void actionPerformed(ActionEvent ae) {
        String accountType = null;

        if (ae.getSource() == submit) {
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Merchant Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccurance Deposit Account";
            }
        }

        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5046066000000000L);
        cardnumber = cardnumber.substring(0, 16); // Ensure it's within the desired length

        String pinnumber = "" + Math.abs((random.nextLong() % 90000L) + 1000L);

        String facility = "";
        if (c1.isSelected()) {
            facility = facility + "ATM Card";
        } else if (c2.isSelected()) {
            facility = facility + "Check Book";
        } else if (c3.isSelected()) {
            facility = facility + "Mobile Banking";
        } else if (c4.isSelected()) {
            facility = facility + "Credit Card";
        } else if (c5.isSelected()) {
            facility = facility + "Pass Book";
        } else if (c6.isSelected()) {
            facility = facility + "Debit Card";
        }

        try {
            if (accountType == null || accountType.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select an account type");
            } else {
                conn connection = new conn();
                String query1 = "INSERT INTO signuptwo(formno, accountType, cardnumber, pinnumber, facility) VALUES ('" + formno + "', '" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                connection.s.executeUpdate(query1);
                String query2 = "INSERT INTO login(formno, cardnumber, pinnumber) VALUES ('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                connection.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Data Inserted Successfully!");
                JOptionPane.showMessageDialog(null, "Card No:" + cardnumber + "\n Pin number:" + pinnumber);

                setVisible(false);  //this for opening becoz you can't open acc without 0 balance...
                new Deposit(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception details for debugging
        }
//            else if(ae.getSource()==cancel){
//            setVisible(false);
//            new Login().setVisible(true);
//            }

    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
