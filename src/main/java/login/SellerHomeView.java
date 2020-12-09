/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author 
 */

public class SellerHomeView extends JFrame{
    
    	JLabel menuBar = new JLabel();
	JButton home = new JButton("Home");
	JButton Inventory = new JButton("Inventory");
	JLabel info = new JLabel();
	Color bg = new Color(221,221,221);
	JLabel profile = new JLabel();
	JLabel history = new JLabel();
	JLabel add = new JLabel("Shopping History");
	SellerAccount currentUser;
	JLabel profileName = new JLabel("");
	JLabel sellerName = new JLabel("");
	JLabel itemsSold = new JLabel("Total items sold: 0");
	JLabel yearlyRevenue = new JLabel("This years revenue: 0");
	JLabel yearlyIncome = new JLabel("This years income: 0");
	JLabel monthlyRevenue = new JLabel("This months revenue: 0");
	JLabel monthlyIncome = new JLabel("This months income: 0");
	
        Color backGround = new Color(151, 186, 255);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
    
   public SellerHomeView()
   {
       build();
   }
   
   
   
   public void build()
   {
       Font fn = new Font("Arial", Font.BOLD, 25);
		
		this.setBounds(width/8, 1, width-width/4, height);
		
		
		menuBar.setBounds(0, 0, width-width/4, 100);
		menuBar.setBackground(backGround);
		menuBar.setOpaque(true);
		menuBar.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(menuBar);
		
		
		//Home label
		home.setBounds(0, 0, 200, 100);
		home.setBorder(BorderFactory.createLineBorder(Color.black));
		home.setLayout(null);
		home.setHorizontalAlignment(JTextField.CENTER);
		
		home.setFont(new Font("Arial", Font.BOLD, 35));
		home.setBackground(backGround);
		home.setOpaque(true);
		home.setForeground(Color.white);
		
		menuBar.add(home);
		
		//Let's Shop
		Inventory.setBounds(200, 0, 200, 100);
		Inventory.setBorder(BorderFactory.createLineBorder(Color.black));
		Inventory.setLayout(null);
		Inventory.setHorizontalAlignment(JLabel.CENTER);
		
		Inventory.setFont(new Font("Arial", Font.BOLD, 35));
		Inventory.setBackground(backGround);
		Inventory.setOpaque(true);
		Inventory.setForeground(Color.white);
		
		menuBar.add(Inventory);
		
		//Profile information
		info.setBounds(0, 100, width-width/4, height-100);
		info.setBackground(bg);
		info.setOpaque(true);
		info.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(info);
		
		//Profile section
		profile.setBounds(20, 70, (width-width/4)-40, height-300);
		profile.setBorder(BorderFactory.createLineBorder(Color.black));
		profile.setLayout(null);
		profile.setBackground(backGround);
		profile.setOpaque(true);
		
		info.add(profile);
		
		
		
		//Profile name
		profileName.setBounds(0, 0, (width-width/4)-40, 40);
		profileName.setBorder(BorderFactory.createLineBorder(Color.black));
		profileName.setHorizontalAlignment(JTextField.CENTER);
		profileName.setBackground(backGround);
		profileName.setOpaque(true);
		
		profileName.setFont(new Font("Arial", Font.BOLD, 35));
		profileName.setForeground(Color.white);
		
		profile.add(profileName);
		
		
		//Welcome user
		sellerName.setBounds(10, 60, (width-width/4)-40/2-10, 40);
		sellerName.setFont(fn);
		
		profile.add(sellerName);
		
		//Total items sold
		itemsSold.setBounds(((width-width/4)-40)/2, 60, (width-width/4)-40/2, 40);
		itemsSold.setFont(fn);
		
		profile.add(itemsSold);
		
		//Yearly Revenue
		yearlyRevenue.setBounds(10, 120, (width-width/4)-40/2-10, 40);
		yearlyRevenue.setFont(fn);
		
		profile.add(yearlyRevenue);
		
		//Yearly Income
		yearlyIncome.setBounds(((width-width/4)-40)/2, 120, (width-width/4)-40/2, 40);
		yearlyIncome.setFont(fn);
		
		profile.add(yearlyIncome);
		
		//Monthly Revenue
		monthlyRevenue.setBounds(10, 180, (width-width/4)-40/2-10, 40);
		monthlyRevenue.setFont(fn);
		
		profile.add(monthlyRevenue);
		
		//Monthly Income
		monthlyIncome.setBounds(((width-width/4)-40)/2, 180, (width-width/4)-40/2, 40);
		monthlyIncome.setFont(fn);
		
		profile.add(monthlyIncome);
		

		this.setBackground(bg);
		//this.setOpaque(true);
		
		this.setLayout(null);
   }
   
   public void updateSellerHome() {
		profileName.setText(currentUser.getUsername());
		sellerName.setText("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName());
		itemsSold.setText("Total items sold: " + currentUser.totalItemsSold());
		yearlyRevenue.setText("This year's revenue: " + currentUser.calculateYearlyRevenue());
		yearlyIncome.setText("This year's income: " + currentUser.calculateYearlyIncome());
		monthlyRevenue.setText("This month's revenue: " + currentUser.calculateMonthlyRevenue());
		monthlyIncome.setText("This month's income: " + currentUser.calculateMonthlyIncome());
	}
    
}
