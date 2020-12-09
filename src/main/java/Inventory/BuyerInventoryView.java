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
    public void createProductPane(String productName,Double productPrice,int quantity){
        {
            JPanel panel = new JPanel();
            panel.add(new JLabel("Hello"));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            inventory.add(panel, gbc, 0);

            validate();
            repaint();
    }
}
