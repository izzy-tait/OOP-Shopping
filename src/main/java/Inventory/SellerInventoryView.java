package Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.*;



public class SellerInventoryView extends JFrame{
    //backGround
     Color backGround = new Color(151, 186, 255);

     // java - get screen size using the Toolkit class
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

     // the screen width
     int width = (int)screenSize.getWidth();

     // the screen height
     int height = (int)screenSize.getHeight();
     
    JLabel menuBar = new JLabel();
    public JButton home = new JButton("Home");
    JButton Inventory = new JButton("Inventory");
    JLabel info = new JLabel();
    Color bg = new Color(221,221,221);
    JLabel editField = new JLabel();
    public JButton addItem = new JButton("Add Item");
    JButton summit = new JButton("Submit");
    JButton summit1 = new JButton("Submit");
    JButton Cancel = new JButton("Cancel");
    JButton Confirm	= new JButton("Confirm");



    public SellerInventoryView()
    {
      build();  
    }

    public void build()
    {
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



        //Edit Inventory
        Inventory.setBounds(200, 0, 200, 100);
        Inventory.setBorder(BorderFactory.createLineBorder(Color.black));
        Inventory.setLayout(null);
        Inventory.setHorizontalAlignment(JLabel.CENTER);

        Inventory.setFont(new Font("Arial", Font.BOLD, 35));
        Inventory.setBackground(backGround);
        Inventory.setOpaque(true);
        Inventory.setForeground(Color.white);

        menuBar.add(Inventory);


        //Home label
        addItem.setBounds(width-width/4-200, 0, 200, 100);
        addItem.setBorder(BorderFactory.createLineBorder(Color.black));
        addItem.setLayout(null);
        addItem.setHorizontalAlignment(JTextField.CENTER);

        addItem.setFont(new Font("Arial", Font.BOLD, 35));
        addItem.setBackground(backGround);
        addItem.setOpaque(true);
        addItem.setForeground(Color.white);

        menuBar.add(addItem);

        //Profile information
        info.setBounds(0, 100, width-width/4-20, height*2);
        info.setBackground(bg);
        info.setOpaque(true);


        this.add(info);


        //scroll bar
        JScrollBar s = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0, height);
        s.setBounds(width-width/4-20, 100, 20, height-200);

        //Action listener for scroll bar
        s.addAdjustmentListener(new AdjustmentListener() {  
                public void adjustmentValueChanged(AdjustmentEvent e) {  
                        info.setLocation((0), (int) -s.getValue()*2+100);

                        //this.repaint();
                }  
        });  



        this.add(s);






        this.setBackground(bg);
        //this.setOpaque(true);
        this.setLayout(null);

       }

}
