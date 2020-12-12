package login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AccountList implements Serializable {
    
    private static ArrayList<Account> accounts =new ArrayList<Account>();
    private Iterator<Account> accountIterator;
    private static AccountList instance = new AccountList();
    private static String fileName="AccountList.ser";
    
    private AccountList(){
        this.accountIterator=accounts.iterator();
    }
    public static AccountList getInstance(){
        accounts=load(fileName);
        return instance;
    }
    public ArrayList<Account> getAccounts()
    {
        return this.accounts; 
    }

    public void addAccount(Account anAccount)
    {
        this.accounts.add(anAccount);
        this.save(accounts,"AccountList.ser");
        this.accountIterator=accounts.iterator();
    }
    public Account retrieveAccount(String user,String pass){
        
        this.accountIterator=accounts.iterator();
        while(accountIterator.hasNext()){
            Account account = accountIterator.next();
            if(account.getUsername().equals(user) && account.getPassword().equals(pass)){
                return account;
            }
        }
        return null;
    }
    private void save(ArrayList temp, String fileName){
        try {
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(temp); 
                os.close();
                fos.close();

                System.out.println("works");
            } catch (Exception x) {
                System.out.print("x - save error"); 
            }
    
    }
    
	private static ArrayList load(String fileName) {
    	//Loads data into Buyer list
            ArrayList temp = new ArrayList(); 
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream is = new ObjectInputStream(fis);
            
                temp = (ArrayList) is.readObject(); 
           
                is.close();
                fis.close();
                System.out.println("works");
            
            } catch (Exception x) {
                System.out.print(" x - load error"); 
            }	
            return temp;
	}
    
}