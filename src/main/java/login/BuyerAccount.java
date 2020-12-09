package login;
import java.io.*;
import java.util.*;

public class BuyerAccount extends Account implements Serializable {
    public BuyerAccount(String auserName, String apassWord, String afirstName, String alastName){
	super(auserName, apassWord, afirstName, alastName);	
    }
    
}