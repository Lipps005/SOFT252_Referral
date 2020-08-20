/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author samue
 */
public class Secretary extends User{
   
   public Secretary(String UID)
   {
      this.UID = UID;
   }
   
   @Override 
   public void saveUser()
   {
         try {
         new File("users/"+this.UID).mkdirs();
         new File("users/"+this.UID+"/appointments").mkdirs();
         new File("users/"+this.UID+"/prescriptions").mkdirs();
         new File("users/"+this.UID+"/accountactions").mkdirs();
         FileOutputStream fileOut =
         new FileOutputStream("users/"+this.UID+"/"+this.UID+".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
}
