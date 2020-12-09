package login;

import Inventory.*;
import SellerHome.*;
import BuyerHome.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;

public class App
{
    public static void main(String[] args) 
    {
        AccountList accounts = AccountList.getInstance();
        LoginView login = new LoginView();      
        SignUpView signup = new SignUpView();
        SellerHomeView sHome=new SellerHomeView();
        login.setVisible(true);
        SellerInventoryView sellerInventoryView = new SellerInventoryView();
        AddProductView addProductView = new AddProductView();
        BuyerHomeView bHome = new BuyerHomeView();
        BuyerInventoryView bHomeInv = new BuyerInventoryView();
        Inventory inventory = new Inventory();
        
        //test
        Product oreo = new Product("Isabel", "Oreo", "4.99", "6", "50");
        inventory.addProduct(oreo);
                
        //public Product(String asellerName, String aname, String aprice, String acost, String aquantity) {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        ArrayList<JButton> editInv = new ArrayList<JButton>();
	ArrayList<JButton> deleteInv = new ArrayList<JButton>();
	ArrayList<JButton> addInv = new ArrayList<JButton>();
        
        bHome.signout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    bHome.setVisible(false);
                    login.setVisible(true);
                }  
            }      
        );
        
        //Button to navigate to Inventory on Buyer Home page 
        bHome.inventory.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    bHome.setVisible(false);
                    bHomeInv.setVisible(true);
<<<<<<< HEAD
                    
                    int j = (int) Math.floor(width/280);
                    int k;
                    int x = 10;
                    int y = 20;
                    int i2 = 0;
                    
                    Iterator inventoryIterator = inventory.createIterator();
                    while (inventoryIterator.hasNext())
                    {
                        Product p = (Product)inventoryIterator.next();
                        System.out.println(p.getProductName());
                        
                        k = (int) Math.floor(i2/j);
                        y = 20 + 160*k;
                        x = 10*(i2%j+1) + 270*(i2%j);

                        ProductPanelView temp = new ProductPanelView(p);
                        JButton temp1 = new JButton("Edit");
                        JButton temp2 = new JButton("Delete");

                        temp1.setBounds(30, 105, 90,25);
                        temp2.setBounds(130, 105, 90, 25);


                        editInv.add(temp1);
                        deleteInv.add(temp2);


                        temp.add(editInv.get(i2));
                        temp.add(deleteInv.get(i2));

                        i2 = i2 +1;
                        bHomeInv.inventory.add(temp);
                        bHome.inventory.repaint();
                        
                    }
=======
>>>>>>> upstream/master
                }  
            }      
        );
        
        
        bHomeInv.home.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    bHomeInv.setVisible(false);
                    bHome.setVisible(true);
                }  
            }      
        );
        
        
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
                            bHome.setVisible(true);
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