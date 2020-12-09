/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author jonat
 */
public class BuyerHomeController {
    private Account currentUser;
    
    BuyerHomeView bHome = new BuyerHomeView();
   
    public void setAccount(Account user){
        this.currentUser=user;
    }
    public void setView(){
        bHome.setVisible(true);
    }
    
}
