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
import java.io.Serializable;
import java.util.UUID;
import my.models.User.AccountStatus;

/**
 *
 * @author samue
 */
public class AccountActionRequest implements Serializable {
   private String PatientUID;
   private AccountStatus accountUpdateStatus;
   private final UUID AccountActionUID = java.util.UUID.randomUUID();
   
   public AccountActionRequest(String PatientUID, AccountStatus updateTo)
   {
      this.PatientUID = PatientUID;
      this.accountUpdateStatus = updateTo;
   }
   
   public boolean saveAccountActionRequest()
   {
      boolean success = false;
      try
        {    

            // Reading the object from a file 
            File folder = new File("users/");
            File[] listOfFiles = folder.listFiles();

            for(File file : listOfFiles)
            {
               String filename = file.getName();
               if(file.getName().contains("S"))
               {
                  new File("users/"+filename).mkdirs();
                  FileOutputStream fileOut = new FileOutputStream("users/"+filename+"/accountactions/"+AccountActionUID+".ser");
                  ObjectOutputStream out = new ObjectOutputStream(fileOut);
                  out.writeObject(this);
                  out.close();
                  fileOut.close();
                  System.out.printf("Serialized data is saved");
                  success = true;
                  break;
               }
            }
        } 
          
        catch(IOException ex) 
        { 
           System.out.println(ex);
           success = false;
        } 
         return success;
   }
   
   public String getPatientUID()
   {
      return this.PatientUID;
   }
   
      public UUID getUID()
   {
      return this.AccountActionUID;
   }
      
   @Override 
   public String toString()
   {
      return PatientUID +" to " + accountUpdateStatus;
   }
   
   
}
