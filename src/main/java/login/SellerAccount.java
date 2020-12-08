package login;
import java.io.Serializable;

public class SellerAccount extends Account implements Serializable {

    private double monthlyRevenue;
    private double monthlyIncome;
    private double yearlyRevenue;
    private double yearlyIncome;
	
    public SellerAccount(String auserName, String apassWord, String afirstName, String alastName){
	super(auserName, apassWord, afirstName, alastName);
		
	setMonthRev(0.0);
	setMonthIncome(0.0);
	setYearRevenue(0.0);
	setYearIncome(0.0);	
    }
    public void setMonthRev(double amonthlyRevenue)
    {
	this.monthlyRevenue = amonthlyRevenue;
    }

    public void setMonthIncome(double aMonthIncome)
    {
	this.monthlyIncome = aMonthIncome;
    }
   
    public void setYearRevenue(double aYearRevenue)
    {
	this.yearlyRevenue = aYearRevenue;
    }

    public void setYearIncome(double aYearIncome)
    {
	this.yearlyIncome = aYearIncome;
    }	
}