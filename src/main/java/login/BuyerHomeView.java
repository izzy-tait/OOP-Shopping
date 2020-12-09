package login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jonat
 */
public class BuyerHomeView extends JFrame{
    public JLabel pageTitle = new JLabel("Buyer Home View");
    public JLabel fNameLabel = new JLabel ("First Name");
    public JTextField fNameText = new JTextField(); 
    public JLabel lNameLabel = new JLabel("Last Name");
    public JTextField lNameText = new JTextField();
    public JLabel userLabel = new JLabel("Username");
    public JTextField userText = new JTextField(20);
    public JLabel passLabel = new JLabel("Password");
    public JTextField passText = new JTextField();
    public JButton signupButton = new JButton("Submit");
}
