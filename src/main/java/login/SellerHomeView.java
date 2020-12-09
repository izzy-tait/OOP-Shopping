/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.*;

<<<<<<< HEAD
/**
 *
 * @author 
 */
=======
>>>>>>> upstream/master
public class SellerHomeView extends JFrame{
    private JLabel sellerHomeTitle = new JLabel("Sales and Profits");
    public JButton inventoryButton = new JButton("Inventory");
    
    private JLabel monthlyRevenueLabel = new JLabel("Monthly Revenue:");
    private JLabel monthlyIncomeLabel = new JLabel("Monthly Income:");
    private JLabel yearlyRevenueLabel = new JLabel("Yearly Revenue:");
    private JLabel yearlyIncomeLabel = new JLabel("Yearly Income:");
    
    JLabel monthlyRevenue = new JLabel();
    JLabel monthlyIncome = new JLabel();
    JLabel yearlyRevenue = new JLabel();
    JLabel yearlyIncome = new JLabel();
    
   public SellerHomeView()
   {
       build();
   }
   
   private void build()
   {
       JPanel sellerHomePanel = new JPanel();
       this.setSize(600, 600);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       this.add(sellerHomePanel);
       
       sellerHomePanel.setLayout(null);
       
       //Page Title configurations 
       sellerHomeTitle.setBounds(250, 10, 100, 40);
       sellerHomePanel.add(sellerHomeTitle);
       
       //Inventory Button configurations
       inventoryButton.setBounds(500, 10, 80, 25);
       sellerHomePanel.add(inventoryButton);
       
       //display revenues and income 
       //Monthly Revenue Label configurations
       monthlyRevenueLabel.setBounds(200, 100, 100, 40);
       sellerHomePanel.add(monthlyRevenueLabel);
       
       //Monthly Income Label configurations 
       monthlyIncomeLabel.setBounds(200, 200, 100, 40);
       sellerHomePanel.add(monthlyIncomeLabel);
       
       //Yearly Revenue Label configurations 
       yearlyRevenueLabel.setBounds(200, 300, 100, 40);
       sellerHomePanel.add(yearlyRevenueLabel);
       
       //Yearly Income configurations 
       yearlyIncomeLabel.setBounds(200, 400, 100, 40);
       sellerHomePanel.add(yearlyIncomeLabel);
       
       monthlyRevenue.setBounds(250, 100, 100, 40);
       monthlyRevenue.setText("0");
       sellerHomePanel.add(monthlyRevenue);
       
       monthlyIncome.setBounds(250, 200, 100, 40);
       monthlyIncome.setText("0");
       sellerHomePanel.add(monthlyIncome);
       
       yearlyRevenue.setBounds(250, 300, 100, 40);
       yearlyRevenue.setText("0");
       sellerHomePanel.add(yearlyRevenue);
       
       yearlyIncome.setBounds(250, 400, 100, 40);
       yearlyIncome.setText("0");
       sellerHomePanel.add(yearlyIncome);
   }
    
}
