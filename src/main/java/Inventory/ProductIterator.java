/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Inventory.Product;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jonat
 */
public class ProductIterator implements Iterator{
    public ArrayList<Product> prodList;
    public int pos=0;

    public ProductIterator(ArrayList<Product> productList) {
        this.prodList=productList;
    }
    public boolean hasNext() {
        if(pos<prodList.size()){
            return true;
        }
        return false;
    }
    public Object next() {
        Product product=prodList.get(pos);
        pos +=1;
        return product;
    }
}
