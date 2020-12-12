/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Inventory implements Collection,Serializable {
    public ArrayList<Product> productList;
    public Inventory(){
        productList= load("Inventory.ser");
        
    }
    public void addProduct(Product p){
        productList.add(p);
        this.save(productList,"Inventory.ser");
    }

    public Iterator createIterator() {
        return new ProductIterator(productList);
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
