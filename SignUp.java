
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignUp extends JFrame implements ActionListener {
long random;
    JTextField nameTextField, fnameTextField, emailBox,addBox,cityBox,stateBox,pinBox;
    JButton next;
    JRadioButton male, female, yesno, yesno2,stdnt_work, work_St,yesno3, yesno4;
    JDateChooser datechooser; 
    SignUp(){
        
        setLayout(null);
        Random ran= new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno= new JLabel("APPLICATION FORM NO:"+ random);
        formno.setFont(new Font("Raleway",Font. BOLD,38 ));
        formno.setBounds(150,40,600,40);
        add(formno);
        
       JLabel personaldetail= new JLabel("Page 1: Personal Details");
        personaldetail.setFont(new Font("Raleway",Font. BOLD,22 ));
        personaldetail.setBounds(290,110,400,30);
        add(personaldetail);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 190,100,20);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Releway", Font.BOLD,20));
        nameTextField.setBounds(300, 190, 450 , 30);
        add(nameTextField);
        
        
        
        JLabel father_n=new JLabel("Father Name:");
        father_n.setBounds(100, 230, 150, 20);
        father_n.setFont(new Font("Raleway", Font.BOLD,20));
        add(father_n);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Releway", Font.BOLD,20));
        fnameTextField.setBounds(300,230, 450,30);
        add(fnameTextField);
        
        
        
        JLabel dobLabel=new JLabel("Date of birth:");
        dobLabel.setFont(new Font("Raleway", Font.BOLD,20));
        dobLabel.setBounds(100, 270,150,20);
        add(dobLabel);
        
        datechooser=new JDateChooser();
        datechooser.setBounds(300,270,450,30);
        add(datechooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setBounds(100,310,100,20);
        gender.setFont(new Font("Releway", Font.BOLD,20));
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,310,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        
        female=new JRadioButton("Female");
        female.setBounds(400,310,100,30);
        female.setBackground(Color.WHITE); //background
        add(female);
      
        ButtonGroup gendergroup=new ButtonGroup(); //join the both button
        gendergroup.add(male);
        gendergroup.add(female);
        
    
        
        JLabel email=new JLabel("Email Address:");
        email.setBounds(100,350,150,20);
        email.setFont(new Font("Releway", Font.BOLD,20));
        add(email);
        
        emailBox=new JTextField ();
        emailBox.setBounds(300,350,450,30);
        emailBox.setFont(new Font("Releway", Font.BOLD,20));
        add(emailBox);
        
        
        JLabel address=new JLabel("House no:");
        address.setBounds(100,390,100,20);
        address.setFont(new Font("Releway", Font.BOLD,20));
        add(address);
        
        addBox=new JTextField ();
        addBox.setBounds(300,390,450,30);
        addBox.setFont(new Font("Releway", Font.BOLD,20));
        add(addBox);
        
        
        JLabel cityadd=new JLabel("City no:");
        cityadd.setBounds(100,430,100,20);
        cityadd.setFont(new Font("Releway", Font.BOLD,20));
        add(cityadd);
        
        cityBox=new JTextField ();
        cityBox.setBounds(300,430,450,30);
        cityBox.setFont(new Font("Releway", Font.BOLD,20));
        add(cityBox);
        
        
        JLabel stateadd=new JLabel("State:");
        stateadd.setBounds(100,470,100,20);
        stateadd.setFont(new Font("Releway", Font.BOLD,20));
        add(stateadd);
        
        stateBox=new JTextField ();
        stateBox.setBounds(300,470,450,30);
        stateBox.setFont(new Font("Releway", Font.BOLD,20));
        add(stateBox);
        
        
     
        JLabel pincode=new JLabel("Pincode:");
        pincode.setBounds(100,510,100,20);
        pincode.setFont(new Font("Releway", Font.BOLD,20));
        add(pincode);
        
        pinBox=new JTextField ();
        pinBox.setBounds(300,510,450,30);
        pinBox.setFont(new Font("Releway", Font.BOLD,20));
        add(pinBox);
        
        JLabel meretialsta = new JLabel("Meretial Status:");
        meretialsta.setBounds(100,550,150,20);
        meretialsta.setFont(new Font("Releway", Font.BOLD,20));
        add(meretialsta);
        
        yesno=new JRadioButton("Yes");
        yesno.setBounds(300 , 550, 100, 30);
        yesno.setBackground( Color.WHITE);
        add(yesno);
        
        yesno2=new JRadioButton("No");
        yesno2.setBounds(400,550,100,30);
        yesno2.setBackground(Color.WHITE);
        add(yesno2);
        
        ButtonGroup joinyesno=new ButtonGroup();
        joinyesno.add(yesno);
        joinyesno.add(yesno2);
        
        
        JLabel status=new JLabel("Student/Worker:");
        status.setBounds(100,590,200,20);
        status.setFont(new Font("Releway", Font.BOLD, 20));
        add(status);
        
        stdnt_work=new JRadioButton("Student");
        stdnt_work.setBounds(300 , 590, 100, 30);
        stdnt_work.setBackground( Color.WHITE);
        add(stdnt_work);
        
        work_St=new JRadioButton("Worker");
        work_St.setBounds(400 , 590, 100, 30);
        work_St.setBackground( Color.WHITE);
        add(work_St);
        
        ButtonGroup wo_st=new ButtonGroup();
        wo_st.add(work_St);
        wo_st.add(stdnt_work);
        
        JLabel intbnk=new JLabel("Internet Banking");
        intbnk.setBounds(100,630,200,25);
        intbnk.setFont(new Font("Releway",Font.BOLD,20));
        add(intbnk);
        
        yesno3=new JRadioButton("Yes");
        yesno3.setBounds(300 , 630, 100, 30);
        yesno3.setBackground( Color.WHITE);
        add(yesno3);
        
        yesno4=new JRadioButton("No");
        yesno4.setBounds(400 , 630, 100, 30);
        yesno4.setBackground( Color.WHITE);
        add(yesno4);
        
        ButtonGroup joinyesno2=new ButtonGroup();
        joinyesno2.add(yesno3);
        joinyesno2.add(yesno4);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 700, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350,10);
       setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String emailGet=emailBox.getText();
             
        String addget=addBox.getText();
        String cityget=cityBox.getText();
        String stateget=stateBox.getText();
        String pinget=pinBox.getText();


        String dateofBirthGet = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }else {
            gender="Female";
        }
     
        String merital = null;
        if(yesno.isSelected()){
            merital="Yes";
        }
        else{
            merital="No";
        }
        String status=null;
        if(stdnt_work.isSelected()){
            status="Student";
        }
        else{
            status="Worker";
        }
        
        String intbank=null;
        if(yesno3.isSelected()){
            intbank="yes";    
        }
        
        else{
            intbank="No";
        }
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required:");
            }
            else{
               conn c=new conn();
               String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+emailGet+"','"+gender+"','"+merital+"','"+intbank+"','"+addget+"','"+cityget+"','"+stateget+"','"+pinget+"')";
               //dml command 
               c.s.executeUpdate(query);
                setVisible(false); //current frame would be close 
        new SignUpTwo(formno).setVisible(true); //next frame would be open and visible it 
            }
            }
        catch(Exception e){
                System.out.print(e);
                }
     
       
            
       

    }
    public static void main (String args[]){
//        new: Allocates memory for a new instance of the class.
        new SignUp();
    }
}
