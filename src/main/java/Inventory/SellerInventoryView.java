package Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class SellerInventoryView extends JFrame{
    //backGround
    private Color backGround = new Color(151, 186, 255);
    private Color bg = new Color(221,221,221);
     // java - get screen size using the Toolkit class
    private  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int width = (int)screenSize.getWidth();// the screen width
    private int height = (int)screenSize.getHeight();// the screen height
     
    private  JLabel menuBar = new JLabel();
    public  JButton home = new JButton("Home");
    private JButton Inventory = new JButton("Inventory");
    public JButton addItem = new JButton("Add Item");
    private JPanel inventory = new JPanel();
    private JScrollPane scroll = new JScrollPane();

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
        menuBar.add(Inventory);

        //addItem label
        addItem.setBounds(width-width/4-200, 0, 200, 100);
        addItem.setBorder(BorderFactory.createLineBorder(Color.black));
        addItem.setLayout(null);
        addItem.setHorizontalAlignment(JTextField.CENTER);

        addItem.setFont(new Font("Arial", Font.BOLD, 35));
        addItem.setBackground(backGround);
        addItem.setOpaque(true);
        addItem.setForeground(Color.white);

        menuBar.add(addItem);
        this.setBackground(bg);
	this.setLayout(null);
        
        inventory.setBounds(0, 100, width-width/4, height-100);
        inventory.setLayout(new BoxLayout(inventory,BoxLayout.Y_AXIS));//setting box layout for inventory view
        inventory.setBorder(BorderFactory.createLineBorder(Color.black));
        inventory.setAutoscrolls(true);
        scroll = new JScrollPane(inventory,VERTICAL_SCROLLBAR_ALWAYS,HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scroll);//scroll bar
      
       }
    public void addProductPanel(Product p){
        JPanel product = new ProductPanelView(p);
        scroll.add(product);
        scroll.revalidate();
    }

}
