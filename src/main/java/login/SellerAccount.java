package login;
import Inventory.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SellerAccount extends Account {

    private double monthlyRevenue;
    private double monthlyIncome;
    private double yearlyRevenue;
    private double yearlyIncome;
    public ArrayList<Product> itemsSold = new ArrayList<Product>();
	
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
    public String totalItemsSold() 
    {        
        int temp =0;
        for(int i =0; i < itemsSold.size();i++) {
                temp = temp + itemsSold.get(i).getProductQuantity();
        }

        return Integer.toString(temp);
    }
    
    public String calculateYearlyRevenue() {
		
		double temp =0;
		Date tempYear = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			
			if(itemsSold.get(i).date.getYear() == tempYear.getYear()) {
				temp = temp + itemsSold.get(i).getProductPrice()*itemsSold.get(i).getProductQuantity();
			}
			
		}
		return String.format("%.2f", temp);
	}
	
	public String calculateYearlyIncome() {
		
		double temp =0;
		double temp1 = 0;
		Date tempYear = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			
			if(itemsSold.get(i).date.getYear() == tempYear .getYear()) {
				temp = temp + itemsSold.get(i).getProductPrice()*itemsSold.get(i).getProductQuantity();
				temp1 = temp1 + itemsSold.get(i).getProductCost()*itemsSold.get(i).getProductQuantity();
		
			}
		}
		
		
		return String.format("%.2f", temp-temp1);
	}
	
	public String calculateMonthlyRevenue() {
		
		double temp =0;
		Date tempMonth = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			if(itemsSold.get(i).date.getMonth() == tempMonth.getMonth()) {
				temp = temp + itemsSold.get(i).getProductPrice()*itemsSold.get(i).getProductQuantity();
			}
		}
		return String.format("%.2f", temp);
	}
	
	public String calculateMonthlyIncome() {
		
		double temp =0;
		double temp1 = 0;
		Date tempMonth = new Date();
		for(int i =0; i < itemsSold.size();i++) {
			if(itemsSold.get(i).date.getMonth() == tempMonth.getMonth()) {
				
			temp = temp + itemsSold.get(i).getProductPrice()*itemsSold.get(i).getProductQuantity();
			temp1 = temp1 + itemsSold.get(i).getProductCost()*itemsSold.get(i).getProductQuantity();
			}
		}
		
		
		
		return String.format("%.2f", temp-temp1);
	}
}