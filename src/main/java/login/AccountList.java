package login;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class AccountList implements Serializable {
    
    private LinkedList<Account> accounts;
    private Iterator<Account> accountIterator;
    public AccountList(){
        this.accounts=new LinkedList<Account>();
        this.accountIterator=accounts.iterator();
    }
    public LinkedList<Account> getAccounts()
    {
        return this.accounts; 
    }

    public void addAccount(Account anAccount)
    {
        this.accounts.add(anAccount);
        this.accountIterator=accounts.iterator();
    }
    public char verify(String user,String pass){
        while(accountIterator.hasNext()){
            Account temp = accountIterator.next();
            if(temp.getUsername().equals(user) && temp.getPassword().equals(pass)){
                if(temp instanceof BuyerAccount){
                    return 'b';
                }
                else if(temp instanceof SellerAccount){
                    return 's';
                }
            }
        }
        return 'f';
    }
    /*public void printAccounts(){
        while(accountIterator.hasNext()){
            Account temp = accountIterator.next();
            System.out.println(temp.getUsername());
            System.out.println(temp.getUsername());
        }
    
    }*/
    
}