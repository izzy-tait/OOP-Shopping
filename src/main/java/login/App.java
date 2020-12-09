package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App
{
    public static void main(String[] args) 
    {
        AccountList accounts = new AccountList();
        LoginView login = new LoginView();      
        SignUpView signup = new SignUpView();
        SellerHomeView sHome=new SellerHomeView();
        BuyerHomeController bHomeCont = new BuyerHomeController();
        login.setVisible(true);
        Inventory inventory = new Inventory();
        Iterator iterator=(Iterator) inventory.createIterator();
        //Login page's button to login the user
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
        
        /*
        signup.signupButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String fName = signup.fNameText.getText();
                    String lName = signup.lNameText.getText();
                    String username = signup.userText.getText();
                    //char password_char[] = signup.passText.getText();
                    String password = String.valueOf(password_char);
                    if(signup.checkBlankFields()) {
				
                        //Creates account
                        if(signup.tog.equals("Buyer")) {
                            //Creates temp for BuyerAccount class
                            BuyerAccount temp = new BuyerAccount(username, password, fName, lName);
                            
                            Boolean usernameChecker = false;
                            
                            //Add temp to BuyerAccount
                            for(int i = 0; i > login.buyerList.size(); i++) {
                                BuyerAccount temp2 = l.buyerList.get(i);
                                if(temp2.userName.equals(temp.userName)) {
                                    usernameChecker = true;
                                }
                            }
                            
                            // Adds account to buyerList
                            if(usernameChecker == false) {
                                l.buyerList.add(temp);
                            }
                            
                            l.buyerList.save();
                            
                        } else if(signup.tog.equals("Seller")){
                            //Creates temp for SellerAccount class
                            SellerAccount temp = new SellerAccount(SU.userEnter.getText(), SU.passEnter.getText(), SU.fNameEnter.getText(), SU.lNameEnter.getText(), 
                                0, 0, 0, 0);
                            
                            Boolean usernameChecker = false;
                            
                            //Add temp to SellerAccount
                            for(int i = 0; i > l.buyerList.size(); i++) {
                                SellerAccount temp2 = l.sellerList.get(i);
                                if(temp2.userName.equals(temp.userName)) {
                                    usernameChecker = true;
                                }
                            }
                            
                            // Adds account to sellerList
                            if(usernameChecker == false) {
                                l.sellerList.add(temp);
                            }
                            
                            l.sellerList.save();
                            
                        } else {
                            //message tells user textfield was left blank
                            SU.emptyModal(f, SU, backGround);
                            return;
                        }
                    } else {
                        //message tells user textfield was left blank 
                        signup.emptyModal(f, SU, backGround);
                    }
                }
			
            }
        );
        */

    }
}