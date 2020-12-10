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
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

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
        
        //inventory.setBounds(0, 100, width-width/4, height-100);
        inventory.setLayout(new BoxLayout(inventory,BoxLayout.Y_AXIS));//setting box layout for inventory view
        inventory.setBorder(BorderFactory.createLineBorder(Color.black));
        inventory.setAutoscrolls(true);
        //scrollPane=new JScrollPane(inventory,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //scrollPane.setBounds(0, 100, width-width/6, height-200);
        this.add(inventory);//scroll bar
        
        /*JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
        s.setBounds(width-width/4-20, 100, 20, height-200);

        //Action listener for scroll bar
        s.addAdjustmentListener(new AdjustmentListener() {  
                public void adjustmentValueChanged(AdjustmentEvent e) {  
                        inventory.setLocation((0), (int) -s.getValue()*2+100);

                        //this.repaint();
                }  
        });  
        
        inventory.add(s);
        */
           
    }
    public void addProductPanel(Product p){
        JPanel product = new ProductPanelView(p);
        inventory.add(product);
        //inventory.revalidate();
    }
}
