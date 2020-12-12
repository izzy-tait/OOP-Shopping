/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.ArrayList;

/**
 *
 * @author jonat
 */
public class ShoppingCart {
    ArrayList<Product> shoppingCart;
    public ShoppingCart(){
        shoppingCart = new ArrayList<>();
    }
    public ArrayList<Product> getShoppingCart(){
        return shoppingCart;
    }
    public void addToShoppingCart(Product p){
        shoppingCart.add(p);
    }
    public void removeFromShoppingCart(Product p){
        shoppingCart.remove(shoppingCart.indexOf(p));
    }
}
