/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.*;


public class Product implements Serializable{
	private int productID;
	private String sellerName;
	private String name; 
	private Double price;
	private Double cost;
	private int quantity;

	
	public Product(String asellerName, String aname, String aprice, String acost, String aquantity) {
            this.sellerName = asellerName;
            this.name = aname;
            this.price = Double.parseDouble(aprice);
            this.cost = Double.parseDouble(acost);
            this.quantity = Integer.parseInt(aquantity);
            this.productID= getSeller().hashCode()+getProductName().hashCode();
	}
        public String getSeller(){
            return this.sellerName;
        }
        public String getProductName(){
            return this.name;
        }
        public Double getProducePrice(){
            return this.price;
        }
        public Double getProductCost(){
            return this.cost;
        }
        public int getProductID(){
            return productID;
        }
        public int getProductQuantity(){
            return this.quantity;
        }

	
	
	
}

