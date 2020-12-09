package login;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame
{
    public JLabel pageTitle = new JLabel("Create Account");
    public JLabel fNameLabel = new JLabel ("First Name");
    public JTextField fNameText = new JTextField(); 
    public JLabel lNameLabel = new JLabel("Last Name");
    public JTextField lNameText = new JTextField();
    public JLabel userLabel = new JLabel("Username");
    public JTextField userText = new JTextField(20);
    public JLabel passLabel = new JLabel("Password");
    public JTextField passText = new JTextField();
    public JButton signupButton = new JButton("Submit");

    String tog = "Buyer"; // Text in toggle button

    JToggleButton toggleButton = new JToggleButton("Buyer", true);
    JLabel toggleLabel = new JLabel("Choose account type: ");

    Color background = new Color(151, 186, 255);

    public SignUpView()
    {
        build();

    }

    public void build()
    {
        JPanel signupPanel = new JPanel(); 
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(signupPanel);

        signupPanel.setLayout(null); 

        //Page Title configurations
        pageTitle.setBounds(190, 5, 100, 40);
        signupPanel.add(pageTitle);

        //first name label configurations 
        fNameLabel.setBounds(100, 50, 80, 25);
        signupPanel.add(fNameLabel);

        //first name text field configurations 
        fNameText.setBounds(190, 50, 165, 25);
        signupPanel.add(fNameText);

        //last name label configurations 
        lNameLabel.setBounds(100, 100, 80, 25);
        signupPanel.add(lNameLabel);

        //last name text field configurations 
        lNameText.setBounds(190, 100, 165, 25);
        signupPanel.add(lNameText);

        //username label configurations
        userLabel.setBounds(100, 200, 80, 25);
        signupPanel.add(userLabel);
        
        //username text field configurations
        userText.setBounds(190, 200, 165, 25);
        signupPanel.add(userText);

        //password label configurations
        passLabel.setBounds(100, 300, 80, 25);
        signupPanel.add(passLabel);

        //password text field configurations
        passText.setBounds(190, 300, 165, 25);    //setBounds method has setBounds(x , y, width, height)
        signupPanel.add(passText);

        //signup button configurations
        signupButton.setBounds(225, 500, 90, 25);
        signupPanel.add(signupButton);

        //Label for toggle button
	toggleLabel.setBounds(225, 400, 300, 50);
	//toggleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
	signupPanel.add(toggleLabel);
		
        //toggle button
        toggleButton.setBounds(225, 450, 90, 25);
        
        
        signupPanel.add(toggleButton);

        signupPanel.setBackground(background);
        //this.setVisible(true);
    }


    public Boolean checkBlankFields(){
	//check if any field is blank
	if(userText.getText().equals("") || passText.getText().equals("") || fNameText.getText().equals("") || lNameText.getText().equals("")) {
		return false;
	}
	//no fields are left blank
        return true;
    }
}