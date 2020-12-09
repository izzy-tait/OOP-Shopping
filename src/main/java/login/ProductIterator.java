/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.LinkedList;

/**
 *
 * @author jonat
 */
public class ProductIterator implements Iterator{
    LinkedList<Product> productList;
    int pos=0;
    public ProductIterator(LinkedList<Product> p){
        this.productList=p;
    }
    public boolean hasNext() {
        
        if(pos>=productList.size()){
            return false;
        }
        else
            return true;
        }

    @Override
    public Object next() {
        Product product=productList.get(pos);
        pos +=1;
        return product;
    }
}
