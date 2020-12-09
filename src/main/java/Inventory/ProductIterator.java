/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Inventory.Product;
import java.util.LinkedList;

/**
 *
 * @author jonat
 */
public class ProductIterator implements Iter{
    LinkedList<Product> prodList;
    int pos=0;

    public ProductIterator(LinkedList<Product> productList) {
        this.prodList=productList;
    }
    public boolean hasNext() {
        
        if(pos>=prodList.size()){
            return false;
        }
        else
            return true;
        }
    public Object next() {
        Product product=prodList.get(pos);
        pos +=1;
        return product;
    }
}
