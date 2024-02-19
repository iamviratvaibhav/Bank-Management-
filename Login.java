
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signUp, clear;
    JTextField cardTxtFild;
    JPasswordField pinTxtField;
    Login() {
        // Set the default close operation
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use the Event Dispatch Thread to create the GUI
        SwingUtilities.invokeLater(() -> {
            setLayout(null);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100,100, Image. SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            label.setBounds(50,10,100,100); // from starting the frame, from frame up to down, height, weight
            add(label);
            
            getContentPane().setBackground(Color.WHITE);
            
            JLabel text = new JLabel("Welcome to Virtual ATM");
            text.setFont(new Font("Osward", Font.BOLD, 38));
            text.setBounds(200, 40, 450, 40);
            add(text);
            
            JLabel cardno= new JLabel("CardNo:");
            cardno.setFont(new Font("Raleway", Font.BOLD, 28));
            cardno.setBounds(100, 150, 300, 30);
            add(cardno);
            
            cardTxtFild= new JTextField();
            cardTxtFild.setBounds(300,150, 250,30);
            cardTxtFild.setFont(new Font("Arial", Font.BOLD,14));
            add(cardTxtFild);
            
            JLabel pin = new JLabel("Pin:");
            pin.setFont(new Font("Raleway", Font.BOLD, 28));
            pin.setBounds(100, 220, 250, 30);
            add(pin);
            
            pinTxtField=new JPasswordField();
            pinTxtField.setFont(new Font("Arial", Font.BOLD, 14));
            pinTxtField.setBounds(300,220,250,30);
//            pin.setBounds(WIDTH, WIDTH, WIDTH, HEIGHT);
            add(pinTxtField);
            
            login=new JButton("SIGN IN");
            login.setBounds(300,300,100,30);
            login.setBackground(Color.black);
            login.setForeground(Color.WHITE);
            add(login);
            
            clear=new JButton("Clear");
            clear.setBounds(450,300,100,30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            add(clear);
            
            signUp=new JButton("Sign Up");
            signUp.setBounds(300, 350, 250,30 );
            signUp.setBackground(Color.BLACK);
            signUp.setForeground(Color.WHITE);
            add(signUp);
            

            setSize(800, 480);
            setTitle("Automatic taller machine");
            setVisible(true);
            setLocation(350, 200);
            
        clear.addActionListener(this);
        login.addActionListener(this);
        signUp.addActionListener(this);
        });
    }

    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTxtFild.setText("");
            pinTxtField.setText("");
        }
        else if(ae.getSource()==login){
            conn connection=new conn();
            String cardnumber=cardTxtFild.getText();
            String pinnumber=pinTxtField.getText();
//            String query="select * from login where cardNumber='"+cardnumber+"' and pinnumber='"+pinnumber+"';
            String query = "SELECT * FROM login WHERE cardNumber = '" + cardnumber + "' AND pinnumber = '" + pinnumber + "';";

             try{
               ResultSet rs=  connection.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false); //login frame closing statement;
                   new Transection (pinnumber).setVisible(true);//transection frame opening statement; // pin numer for not for futher use
               }
               else{
                   JOptionPane.showMessageDialog(null,"Incorrect card number and pin");
               }
             }catch(Exception e){
                 System.out.print(e);
             }
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignUp().setVisible(true);
//                SignUp is a class name
    }}
    public static void main(String[] args) {
        // Create an instance of the Login class
        new Login();
    }
}
//46328