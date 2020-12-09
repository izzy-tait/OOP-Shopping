/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Isabel
 */
public class SellerHomeController {
    private Account currentUser; 
    
    SellerHomeView sHome = new SellerHomeView();
    
    public void setAccount(Account user)
    {
        this.currentUser = user;
    }
    
    public void setView()
    {
        sHome.setVisible(true);
        
        sHome.inventoryButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }    
            }
        );
    }
}
