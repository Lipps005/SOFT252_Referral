/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models;

/**
 *
 * @author samue
 */
public class Admin extends User{
   public Admin(String UID)
   {
      this.UID = UID;
      this.status = User.AccountStatus.ACTIVE;
   }
   
   
}
