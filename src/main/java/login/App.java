package login;

import Inventory.*;
import SellerHome.*;
import BuyerHome.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class App
{   
    private static Account currentUser;
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
        ShoppingCartView shopCartView = new ShoppingCartView();
        ShoppingCart cart = new ShoppingCart();
        
        addProductView.submit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String prodName = addProductView.pNameText.getText();
                    String prodPrice = addProductView.priceText.getText();
                    String prodCost = addProductView.costText.getText();
                    String prodQuan = addProductView.prodQuanText.getText();
                    String sellerName = addProductView.sNameText.getText();
                    
                    inventory.addProduct(new Product(sellerName,prodName,prodPrice,prodCost,prodQuan));
                    
                    addProductView.setVisible(false);
                    sellerInventoryView.revalidate();
                    sellerInventoryView.repaint();
                    sellerInventoryView.setVisible(true);
                }  
            }      
        );
        bHome.signout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    bHome.setVisible(false);
                    login.setVisible(true);
                    currentUser=null;
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
                    bHomeInv.inventory.removeAll();
                    bHomeInv.inventory.revalidate();
                    bHomeInv.inventory.repaint();
                    Iterator inventoryIterator = inventory.createIterator();
                    while (inventoryIterator.hasNext())
                    {
                        Product p = (Product)inventoryIterator.next();//gets product
                        System.out.println(p.getProductName());
                        bHomeInv.addProductPanel(p);
                    }
                    //bHomeInv.pack();
                    System.out.println("Added All Inventory");
                }  
            }      
        );
        bHome.cart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    shopCartView.inventory.removeAll();
                    shopCartView.inventory.revalidate();
                    shopCartView.inventory.repaint();
                    Iterator inventoryIterator = inventory.createIterator();
                    while (inventoryIterator.hasNext())
                    {
                        Product p = (Product)inventoryIterator.next();//gets product
                        System.out.println(p.getProductName());
                        bHomeInv.addProductPanel(p);
                    }
                    //bHomeInv.pack();
                    System.out.println("Added All Inventory");
                    shopCartView.setVisible(true);
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
                            currentUser=user;
                            bHome.name=username;
                            bHome.build();
                            bHome.setVisible(true);
                        }
                        else if(user instanceof SellerAccount){
                            login.setVisible(false);
                            sHome.currentUser=(SellerAccount)user;
                            sHome.updateSellerHome();
                            sHome.build();
                            sHome.setVisible(true);
                            currentUser=user;
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
                    sellerInventoryView.inventory.removeAll();
                    sellerInventoryView.inventory.revalidate();
                    sellerInventoryView.inventory.repaint();
                    Iterator inventoryIterator = inventory.createIterator();
                    while (inventoryIterator.hasNext())
                    {
                        Product p = (Product)inventoryIterator.next();//gets product
                        System.out.println(p.getProductName());
                        sellerInventoryView.addProductPanel(p);
                    }
                }
            }
        );
        sHome.signout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    sHome.setVisible(false);
                    login.setVisible(true);
                    currentUser=null;
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
       sellerInventoryView.home.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Changing views");
                    sellerInventoryView.setVisible(false);
                    sHome.setVisible(true);
                }  
            }      
        );
       
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