package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LoginView extends JFrame
{
    public JLabel pageTitle = new JLabel("Login");
    public JLabel userLabel = new JLabel("Username"); 
    public JTextField userText = new JTextField(20);
    public JLabel passLabel = new JLabel("Password");
    public JPasswordField passText = new JPasswordField();
    public JButton loginButton = new JButton("Login");
    public JButton signupButton = new JButton("Register Here");
    
    Color background = new Color(151, 186, 255);

    public LoginView()
    {
        build();
    }

    public void build()
    {
        JPanel loginPanel = new JPanel(); 
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(loginPanel);

        loginPanel.setLayout(null); 

        //page title configurations 
        pageTitle.setBounds(250, 10, 100, 40);
        loginPanel.add(pageTitle);

        //username label configurations
        userLabel.setBounds(100, 200, 80, 25);
        loginPanel.add(userLabel);
        
        //username text field configurations
        userText.setBounds(190, 200, 165, 25);
        loginPanel.add(userText);

        //password label configurations
        passLabel.setBounds(100, 300, 80, 25);
        loginPanel.add(passLabel);

        //password text field configurations
        passText.setBounds(190, 300, 165, 25);    //setBounds method has setBounds(x , y, width, height)
        loginPanel.add(passText);
 
        //login button configurations
        loginButton.setBounds(225, 350, 80, 25);
        loginPanel.add(loginButton);

        //signup button configurations
        signupButton.setBounds(210, 500, 120, 25);
        loginPanel.add(signupButton);

        loginPanel.setBackground(background);
        //this.setVisible(true);

    }
}