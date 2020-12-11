/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Inventory implements Collection,Serializable {
    public ArrayList<Product> productList;
    public Inventory(){
        productList= new ArrayList<Product>();
    }
    public void addProduct(Product p){
        productList.add(p);
    }

    public Iterator createIterator() {
        return new ProductIterator(productList);
    }  
    
}
