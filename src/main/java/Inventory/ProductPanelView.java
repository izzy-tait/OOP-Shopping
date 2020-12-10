/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class ProductPanelView extends JPanel{
    
    Color backGround = new Color(140, 150, 255);
    Product p;
    JLabel quantity;
    
    public ProductPanelView(Product aProduct)
    {
       p = aProduct;
       build(); 
    }
    
    public void build()
    {
        Font fn = new Font("Arial", Font.BOLD, 25);
        Font fn1 = new Font("Arial", Font.BOLD, 15);
        this.setBounds(150, 150, 270, 140);    //first two parameters were xloc and yloc

        //Product name
        JLabel name = new JLabel(p.getProductName());
        name.setBounds(40,5, 120, 30);
        name.setFont(fn);
        name.setOpaque(true);
        name.setBackground(backGround);

        this.add(name);

        //Quantity left
        quantity = new JLabel("In Stock: " + Integer.toString(p.getProductQuantity()));
        quantity.setBounds(105,35, 140, 30);
        quantity.setFont(fn1);
        quantity.setOpaque(true);
        quantity.setBackground(backGround);

        this.add(quantity);

        //Price
        JLabel price = new JLabel("Price: $" + String.format("%.2f", p.getProductPrice()));
        price.setBounds(105,65, 140, 30);
        price.setFont(fn1);
        price.setOpaque(true);
        price.setBackground(backGround);

        this.add(price);

        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(backGround);
        this.setOpaque(true);
        this.setLayout(null);
    }
    
}
