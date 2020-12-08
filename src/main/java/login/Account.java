package login;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

public class Account implements Serializable{
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    	
    public Account(String auserName, String apassWord, String afirstName, String alastName) {
	this.username = auserName;
	this.password = apassWord;
	this.firstName = afirstName;
	this.lastName = alastName;
    }

    public String getUsername()
    {
       return this.username; 
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }
}