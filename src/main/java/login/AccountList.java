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
    public Account retrieveAccount(String user,String pass){
        while(accountIterator.hasNext()){
            Account account = accountIterator.next();
            if(account.getUsername().equals(user) && account.getPassword().equals(pass)){
                return account;
            }
        }
        return null;
    }
    
}