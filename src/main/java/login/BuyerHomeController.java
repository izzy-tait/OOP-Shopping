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
 * @author jonat
 */
public class BuyerHomeController {
    private BuyerAccount currentUser;
    BuyerHomeView bHome = new BuyerHomeView();
    LoginView lView = new LoginView();
    
    public void setAccount(BuyerAccount user){
        this.currentUser=user;
    }
    public void sendLoginView(LoginView log){
        this.lView=log;
    }
    
    public void setView(){
        bHome.setVisible(true);
        bHome.signout.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentUser=null;
                    System.out.println("Changing views");
                    bHome.setVisible(false);
                    lView.setVisible(true);
                }    
            }      
        ); 
        
        bHome.cart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }    
            }      
        );  
    }  
}
