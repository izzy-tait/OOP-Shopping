/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jonat
 */
public class Inventory implements Collection {
    LinkedList<Product> productList;
    public Inventory(){
        productList= new LinkedList<Product>();
    
    }
    public void addProduct(Product p){
        productList.add(p);
    }
    @Override
    public Iterator createIterator() {
        return (Iterator) new ProductIterator(productList);
    }
    
    
}
