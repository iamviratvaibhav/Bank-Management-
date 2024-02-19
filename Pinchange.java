package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {

    JLabel text, pintext, againpintext;
    JPasswordField pin, re_boxpin, box2;
    JButton change, back;
    String pinnumber;
    Pinchange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 850);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(200, 300, 400, 20);
        image.add(text);

        JLabel pintext = new JLabel("Enter your Pin ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(150, 350, 400, 20);
        image.add(pintext);

        JLabel againpintext = new JLabel("Re-Enter Pin ");
        againpintext.setForeground(Color.WHITE);
        againpintext.setFont(new Font("System", Font.BOLD, 16));
        againpintext.setBounds(150, 390, 400, 20);
        image.add(againpintext);

        pin = new JPasswordField("");
        pin.setFont(new Font("Releway", Font.BOLD, 22));
        pin.setBounds(320, 350, 170, 25);
        add(pin);

        back = new JButton("Back");
        back.setBounds(320, 490, 150, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        change = new JButton("Change");
        change.setBounds(320, 455, 150, 30);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        image.add(change);

        re_boxpin = new JPasswordField("");
        re_boxpin.setFont(new Font("Releway", Font.BOLD, 22));
        re_boxpin.setBounds(320, 390, 170, 25);
        add(re_boxpin);

        setSize(850, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = re_boxpin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Pin Not Match");
                    return;
                }
                 if (npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return;
                }
                  if (rpin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter re-pin:");
                    return;
                }
                 conn connections=new conn();

//                String query1 = "update bank set pin?='" + rpin + "' where pin?='" + pinnumber + "'";
                String query1 = "UPDATE bank SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"'";
//                 String query2="update login set pin?='"+rpin+"' where pin?= '"+pinnumber+"'";
                String query2 = "UPDATE login SET pin = '"+rpin+"' WHERE pin ='"+pinnumber+"' ";
//                 String query3="update signuptwo set pin?='"+rpin+"' where pin?= '"+pinnumber+"'";
                   String query3 = "UPDATE signuptwo SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"'";
                 connections .s.executeUpdate(query1);
                 connections.s.executeUpdate(query2);
                 connections.s.executeUpdate(query3);
                  JOptionPane.showMessageDialog(null, "Pin Change Successfully");
                  setVisible(false);
//                  new Transection (rpin).setVisible(true);
                    new Transection (rpin);
                 
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        else{
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}
