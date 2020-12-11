package login;

import Inventory.*;
import SellerHome.*;
import BuyerHome.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
        
       SerilizationList<BuyerAccount> buyerList = new SerilizationList<BuyerAccount>("BuyerList.ser");
       SerilizationList<SellerAccount> sellerList = new SerilizationList<>("SellerList.ser");
       SerilizationList<Account> accountList = new SerilizationList<>("AccountList.ser");
       SerilizationList<Product> productList = new SerilizationList<>("productList.ser");
       SerilizationList<Inventory> inventoryList = new SerilizationList<>("InventoryList.ser");
       SerilizationList<AccountList> accountListLst = new SerilizationList<>("AccountListLst.ser");
       buyerList.load();
       sellerList.load();
       accountList.load();
       productList.load();
       inventoryList.load();
       accountListLst.load();
        //public Product(String asellerName, String aname, String aprice, String acost, String aquantity) {
        
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //int width=(int)screenSize.getWidth();
        //int height = (int)screenSize.getHeight();jjj
        
        //ArrayList<JButton> editInv = new ArrayList<JButton>();
	//ArrayList<JButton> deleteInv = new ArrayList<JButton>();
	//ArrayList<JButton> addInv = new ArrayList<JButton>();
        
        Product oreo = new Product("Isabel", "Oreo", "4.99", "6", "50");
        inventory.addProduct(oreo);
        Product oreo1 = new Product("Jon", "Pasta", "5.99", "6", "50");
        inventory.addProduct(oreo1);
        inventory.addProduct(oreo1);
        inventory.addProduct(oreo1);
        
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
                        buyerList.save();
                        accountList.save();
                        accountListLst.save();
                        System.out.println("Added Buyer Account: "+username);
                    }
                    
                    else if(signup.tog == "Seller") //if tog=="Seller" (the user wants to create a seller account)
                    { 
                        accounts.addAccount(new SellerAccount(username, password, fName, lName));
                        sellerList.save();
                        accountList.save();
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
       
       //The button on the Seller Inventory page to add new item to the inventory
       sellerInventoryView.addItem.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  addProductView.setVisible(true); 
                  productList.save();
                  inventoryList.save();
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