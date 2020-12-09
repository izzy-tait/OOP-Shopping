/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author jonat
 */
public class BuyerInventoryView extends JFrame {
    public JLabel menuBar = new JLabel();
    public JButton home = new JButton("Home");
    public Color bg = new Color(221,221,221);
    public JPanel inventory = new JPanel();
    public JScrollPane scrollPane = new JScrollPane();
    
    ArrayList<JButton> editInv = new ArrayList<JButton>();
    ArrayList<JButton> deleteInv = new ArrayList<JButton>();
    ArrayList<JButton> addInv = new ArrayList<JButton>();
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();

    
    public BuyerInventoryView(){
        build();
    }
    
    public void build(){
        Color backGround = new Color(151, 186, 255);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        this.setBounds(width/8, 1, width-width/4, height);
	

	menuBar.setBounds(0, 0, width-width/4, 100);
	menuBar.setBackground(backGround);
	menuBar.setOpaque(true);
	menuBar.setBorder(BorderFactory.createLineBorder(Color.black));
		
	//Home label
	home.setBounds(0, 0, 200, 100);
	home.setBorder(BorderFactory.createLineBorder(Color.black));
	home.setLayout(null);
	home.setHorizontalAlignment(JTextField.CENTER);
		
	home.setFont(new Font("Arial", Font.BOLD, 35));
	home.setBackground(backGround);
	home.setOpaque(true);
	home.setForeground(Color.white);
        
	this.add(menuBar);
	
        menuBar.add(home);
		
	this.setBackground(bg);
	this.setLayout(null);
        
        
        inventory.setLayout(new BoxLayout(inventory,BoxLayout.Y_AXIS));
        inventory.setAutoscrolls(true);
        scrollPane=new JScrollPane(inventory);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(50, 30, 800, 800);
           
    }
    
    /*
    public void displayProductPanels()
    {
        
        int j = (int) Math.floor(width/280);
        int k;
        int x = 10;
        int y = 20;
        int i2 = 0;
        


        for(int i = 0; i < inv.size(); i++) {
                if(inv.get(i).sellerName.equals(sellerName)) {


                        k = (int) Math.floor(i2/j);
                        y = 20 + 160*k;
                        x = 10*(i2%j+1) + 270*(i2%j);

                        ProductPanelView temp = new ProductPanelView(inv.get(i), backGround, x, y);
                        JButton temp1 = new JButton("Edit");
                        JButton temp2 = new JButton("Delete");

                        temp1.setBounds(30, 105, 90,25);
                        temp2.setBounds(130, 105, 90, 25);


                        editInv.add(temp1);
                        deleteInv.add(temp2);


                        temp.add(editInv.get(i2));
                        temp.add(deleteInv.get(i2));

                        i2 = i2 +1;
                        t.add(temp);

                }

        }

        for(int i = 0; i < t.size(); i++) {
                label.add(t.get(i));

        }
    }
    */
}
