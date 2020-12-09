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
    
    Color backGround = new Color(151, 186, 255);
    Product p;
    JLabel quantity;
    /**
    int j = (int) Math.floor(width/280);
    int k;
    int x = 10;
    int y = 20;
    int i2 = 0;
    
    k = (int) Math.floor(i2/j);
    y = 20 + 160*k;
    x = 10*(i2%j+1) + 270*(i2%j);
    */

    
    public ProductPanelView(Product aProduct)
    {
       build(); 
       p = aProduct;
    }
    
    public void build()
    {
        Font fn = new Font("Arial", Font.BOLD, 25);
        Font fn1 = new Font("Arial", Font.BOLD, 15);
        this.setBounds(150, 150, 270, 140);    //first two parameters were xloc and yloc

        //add Image to panel
        //ImageIcon imgIcon = new ImageIcon(product.path);

        JLabel img = new JLabel();
        //img.setIcon(imgIcon);
        img.setBounds(5,5,90,90);
        img.setOpaque(true);
        img.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(img);

        //Product name
        JLabel name = new JLabel(p.getProductName());
        name.setBounds(105,5, 120, 30);
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
