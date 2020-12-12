
package Inventory;

import javax.swing.*;


public class AddProductView extends JFrame{
    public JLabel pageTitle = new JLabel("Add Product For Sale"); 
    
    public JLabel sNameLabel = new JLabel ("UserName");
    public JTextField sNameText = new JTextField(); 
    
    public JLabel pNameLabel = new JLabel ("Name");
    public JTextField pNameText = new JTextField(); 
    
    public JLabel priceLabel = new JLabel("Price");
    public JTextField priceText = new JTextField();
    
    public JLabel costLabel = new JLabel("Cost");
    public JTextField costText = new JTextField(20);
    
    public JLabel prodQuanLabel = new JLabel("Quantity");
    public JTextField prodQuanText = new JTextField();
    
    public JButton submit = new JButton("Submit");
    
    public AddProductView()
    {
        build();
    }
    
    public void build()
    {
        JPanel addItemPanel = new JPanel(); 
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(addItemPanel);

        addItemPanel.setLayout(null); 

        //Page Title configurations
        pageTitle.setBounds(190, 5, 150, 40);
        addItemPanel.add(pageTitle);
        //sellerName
        sNameLabel.setBounds(100, 45, 80, 25);
        addItemPanel.add(sNameLabel);
        //first name text field configurations 
        sNameText.setBounds(190, 45, 165, 25);
        addItemPanel.add(sNameText);
        
        //first name label configurations 
        pNameLabel.setBounds(100, 85, 80, 25);
        addItemPanel.add(pNameLabel);
        //first name text field configurations 
        pNameText.setBounds(190, 85, 165, 25);
        addItemPanel.add(pNameText);

        //last name label configurations 
        priceLabel.setBounds(100, 125, 80, 25);
        addItemPanel.add(priceLabel);
        //last name text field configurations 
        priceText.setBounds(190, 125, 165, 25);
        addItemPanel.add(priceText);

        //username label configurations
        costLabel.setBounds(100, 165, 80, 25);
        addItemPanel.add(costLabel);
        //username text field configurations
        costText.setBounds(190, 165, 165, 25);
        addItemPanel.add(costText);

        //password label configurations
        prodQuanLabel.setBounds(100, 205, 80, 25);
        addItemPanel.add(prodQuanLabel);
        //username text field configurations
        prodQuanText.setBounds(190, 205, 165, 25);
        addItemPanel.add(prodQuanText);
        
        //signup button configurations
        submit.setBounds(225, 280, 90, 25);
        addItemPanel.add(submit);

    }
    public Boolean checkBlankFields(){
	//check if any field is blank
	if(pNameText.getText().equals("") || priceText.getText().equals("") || costText.getText().equals("") || prodQuanText.getText().equals("")) {
		return false;
	}
	//no fields are left blank
        return true;
    }
}
