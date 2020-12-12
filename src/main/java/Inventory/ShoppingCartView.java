/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
import javax.swing.ScrollPaneLayout;

public class ShoppingCartView extends JFrame {
    public Color bg = new Color(221,221,221);
    public JPanel inventory = new JPanel();
    public JScrollPane inventoryScroll = new JScrollPane();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width=(int)screenSize.getWidth();
    private int height = (int)screenSize.getHeight();
    private GridBagConstraints c = new GridBagConstraints();
    int totalComponents=0;
    
    public ShoppingCartView(){
        build();
    }
    
    public void build(){
        Color backGround = new Color(151, 186, 255);
        this.setBounds(width/8, 1, (width-width/4)+50, height-100);
        //adds panels to JFrame
	this.setBackground(bg);
	this.setLayout(null);
        
        //inventory.setBounds(0, 100, (width-width/4), height-300);
        inventory.setBounds(0, 100,(width-width/4) , 1000);
        //inventory.setLayout(new BoxLayout(inventory,BoxLayout.Y_AXIS));//setting box layout for inventory view
        //inventory.setLayout(new FlowLayout(FlowLayout.LEADING));
        inventory.setLayout(new GridLayout(0,1,5,5));
        c.fill=GridBagConstraints.NONE;
        inventory.setBorder(BorderFactory.createLineBorder(Color.black));
        inventoryScroll=new JScrollPane(inventory,VERTICAL_SCROLLBAR_ALWAYS,HORIZONTAL_SCROLLBAR_NEVER);
        inventoryScroll.setBounds(0, 100, (width-width/4), height-300);
        this.add(inventoryScroll);//scroll bar
        
          
    }
    public void addProductPanel(Product p){
        JPanel product = new ProductPanelView(p);
        inventory.setBounds(0, 100, (width-width/4), height-300+(totalComponents*140));
        totalComponents++;
        inventory.add(product,c);
        inventory.revalidate();
        inventoryScroll.revalidate();
    }
}