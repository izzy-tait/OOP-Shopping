package login;

import Inventory.*;
import SellerHome.*;
import BuyerHome.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App
{
    public static void main(String[] args) 
    {
        AccountList accounts = AccountList.getInstance();
        LoginView login = new LoginView();      
        SignUpView signup = new SignUpView();
        SellerHomeView sHome=new SellerHomeView();
        BuyerHomeController bHomeCont = new BuyerHomeController();
        login.setVisible(true);
        Inventory inventory = new Inventory();
        SellerInventoryView sellerInventoryView = new SellerInventoryView();
        AddProductView addProductView = new AddProductView();
        
        login.loginButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String username = login.userText.getText();
                    char password_char[] = login.passText.getPassword();
                    String password = String.valueOf(password_char);
                    Account user=accounts.retrieveAccount(username,password);
                    if(user!=null){
                        if(user instanceof BuyerAccount){
                            login.setVisible(false);
                            bHomeCont.setAccount((BuyerAccount)user);
                            bHomeCont.setView();
                            bHomeCont.sendLoginView(login);
                        }
                        else if(user instanceof SellerAccount){
                            login.setVisible(false);
                            sHome.setVisible(true);
                        }
                        else{
                            System.out.println("View error");
                        }
                    }
                    else{
                        System.out.println("No such account");
                    }
                }
            }
        );

        //Button on Login page to navigate to the Signup page
        login.signupButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login.setVisible(false);                  //LoginView extends JFrame so it inherits setVisible() method from JFrame class
                    signup.setVisible(true);                  //Display signup page 
                }
            }
        );

        //Toggle button to switch between signup for buyer and seller account 
        // Buy or sell toggle for sign up
	signup.toggleButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(signup.tog.equals("Buyer")) {
                        signup.tog = "Seller";
                    } else {
                        signup.tog = "Buyer";
                    }
                    signup.toggleButton.setText(signup.tog);
                    //f.repaint();
                }			
	        }
        );

        //This is the button the user clicks when creating their account
        signup.signupButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fName = signup.fNameText.getText();
                    String lName = signup.lNameText.getText();
                    String username = signup.userText.getText();
                    String password = signup.passText.getText();

                    //signup.createAccount(fName, lName, username, password);
                    if(signup.tog == "Buyer")
                    {
                        accounts.addAccount(new BuyerAccount(username, password, fName, lName));
                        System.out.println("Added Buyer Account: "+username);
                    }
                    
                    else if(signup.tog == "Seller") //if tog=="Seller" (the user wants to create a seller account)
                    { 
                        accounts.addAccount(new SellerAccount(username, password, fName, lName));
                        System.out.println("Added Seller Account: "+username);
                    }

                    signup.setVisible(false);
                    login.setVisible(true);

                }
            }
        );
        
       //The button on seller home page to navigate to the Inventory 
       sHome.Inventory.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sHome.setVisible(false);
                    sellerInventoryView.setVisible(true);
                }
            }
        );
       
       //The button on the Seller Inventory page to add new item to the inventory
       sellerInventoryView.addItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  addProductView.setVisible(true);  
                }
            });
       
       //Button on Seller Inventory page to get back to Seller Home page
        sellerInventoryView.home.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    sellerInventoryView.setVisible(false);
                    sHome.setVisible(true);
                }
            });
        
      
    }
}