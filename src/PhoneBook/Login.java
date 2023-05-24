
package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
       JLabel l1,l2,l3;
       JTextField tf;
       JPasswordField pf;
       JPanel p1,p2;
       JButton bt1,bt2;
       Font f1,f2;
       
       Login(){
           super("Phone Directory login page");
           setLocation(400,300);
           setSize(550,250);
           
           f1=new Font("Arial",Font.BOLD,30);
           f2=new Font("Arial",Font.BOLD,20);
           
           l1=new JLabel("Welcome to Phone Directory");
           l2=new JLabel("UserName");
           l3=new JLabel("Password");
           
           l1.setHorizontalAlignment(JLabel.CENTER);
           l1.setFont(f1);
           l2.setFont(f2);
           l3.setFont(f2);
           
           tf=new JTextField();
           pf=new JPasswordField();
           
           bt1=new JButton("Login");
           bt2=new JButton("Cancel");
           bt1.addActionListener(this);
           bt2.addActionListener(this);
           bt1.setFont(f2);
           bt2.setFont(f2);
                      
           p1=new JPanel();
           p1.setLayout(new GridLayout(3,2,10,10));
           p1.add(l2);
           p1.add(tf);
           p1.add(l3);
           p1.add(pf);
           p1.add(bt1);
           p1.add(bt2);
           
           p2=new JPanel();
           p2.setLayout(new GridLayout(1,1,10,10));
           p2.add(l1);
           
           setLayout(new BorderLayout(10,20));
           
           add(p2,"North");
           add(p1,"Center");
       }
       
       public void actionPerformed(ActionEvent e){
              String username=tf.getText();
              String password=pf.getText();
               
              if (e.getSource()==bt1){
                  try{
                      ConnectionClass obj=new ConnectionClass();
                      String q="Select * from login where username='"+username+"'and password='"+password+"'";
                      ResultSet res=obj.stm.executeQuery(q);
                      if (res.next()){
                       //   new Home().setVisible(true);
                          this.setVisible(false);
                      }
                      else{
                          JOptionPane.showMessageDialog(null, "Invalid Credentials!Enter again!");
                          this.setVisible(false);
                      }   
                  }
                  catch (Exception exp){
                      exp.printStackTrace();
                  }
               }
              if (e.getSource()==bt2)
                  this.setVisible(false); 
           }
           
       public static void main(String args[]){
              new Login().setVisible(true);
       }
}
