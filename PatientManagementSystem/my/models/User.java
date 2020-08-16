/***
 * @author Samuel Lippett
 * @date 28/07/2020
 */
package my.models;

import java.util.*;
import java.io.*;
import my.models.userevents.Listable.ListableByString;


public class User implements Serializable, ListableByString {

   protected String UID;
   protected String Password;
   protected String Name;
   protected String Address;
   protected String Gender;
   protected AccountStatus status = AccountStatus.PENDING;

   @Override
   public String getSearchString() {
      return this.Name;//+this.UID;
   }
   
   
   public static String UIDGenerator(char userType)
   {
       boolean unique = false;
       String UID =""+userType;
       while(!unique)
       {
          Random rand = new Random();
          UID += rand.nextInt(9);
          UID += rand.nextInt(9);
          UID += rand.nextInt(9);
          UID += rand.nextInt(9);
          File folder = new File("users");
          File[] listOfFiles = folder.listFiles();
          if(listOfFiles.length == 0)
          {
             unique = true;
             break;
          }
          for(File file : listOfFiles)
          {
             unique = !UID.equals(file.getName());
          }
       }
       
       return UID;
   }
   
   
   static public enum AccountStatus {
    PENDING,
    ACTIVE,
    DELETED
  }
   
   public void setGender(String gender)
   {
      this.Gender = gender;
   }
   
   public void updateAccountStatus(AccountStatus status)
   {
      this.status = status;
   }
   
   public AccountStatus getAccountStatus()
   {
      return this.status;
   }
   
      public String getAddress()
   {
      return this.Address;
   }
      
   public void setPassword(String Password)
   {
      this.Password = Password;
   }
   
    public void setName(String Name)
   {
      this.Name = Name;
   }
    
     public void setAddress(String Address)
   {
      this.Address = Address;
   }
   
   public boolean verifyPassword(String passwordIn)
   {
      if(this.Password == null)
      {
         return false;
      }
      if(passwordIn.equals(this.Password))
      {
         return true;
      }
      else
      {
         return false;  
      }
   }

   public static Object loadUser(String UID)
   {
      Object obin = null;
      try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream("users/"+UID+"/"+UID+".ser"); 
            ObjectInputStream in = new ObjectInputStream(file); 
            // Method for deserialization of object 
            obin =  in.readObject();            
            in.close(); 
            file.close();   
        }           
        catch(IOException | ClassNotFoundException ex) 
        { 
           System.out.println(ex);
        } 
      return obin;
   }
   
   
   public void saveUser()
   {
         try {
         new File("users/"+this.UID).mkdirs();
         new File("users/"+this.UID+"/appointments").mkdirs();
         new File("users/"+this.UID+"/prescriptions").mkdirs();
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
   
   @Override
   public String getUID()
   {
      return this.UID;
   }
   
      @Override
   public String toString()
      {
         return this.Name;
      }
}
