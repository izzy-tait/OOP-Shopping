/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.Iterator;
import java.util.LinkedList;


public class Inventory implements Collection {
    public LinkedList<Product> productList;
    public Inventory(){
        productList= new LinkedList<Product>();
    }
    public void addProduct(Product p){
        productList.add(p);
    }

    public Iterator createIterator() {
        return new ProductIterator(productList);
    }  
    
}
