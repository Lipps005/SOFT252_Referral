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
import my.models.userevents.Listable.ListableByString;

/**
 *
 * @author samue
 */
public class Medicine implements Serializable, ListableByString{
   
   private String MedicineName;
   private int StockUnits;
   private boolean OnOrder;
   private String Description;
   private final UUID MedicineUID = java.util.UUID.randomUUID();
   
   
   public boolean dispenseStock(int Amount)
   {
      if(Amount <= this.StockUnits)
      {
         this.StockUnits -= Amount;
         return true;
      }
      else
      {
         return false;
      }
      
   }
   
   public void putOnOrder(boolean orderChange)
   {
      this.OnOrder = orderChange;
   }
   
   public boolean isOnOrder()
   {
      return this.OnOrder;
   }

   public void addStock(int stocktoadd)
   {
      this.StockUnits += stocktoadd;
   }
   
   public Medicine(String medicineName)
   {
      this.MedicineName = medicineName;
      this.StockUnits = 0;
   }
   public int StockLeft()
   {
      return StockUnits;
   }

   @Override
   public String getSearchString() {
      return MedicineName;
   }
   
   public String getDescription() {
      return Description;
   }
   
   public void setDescription(String description) {
      Description = description;
   }
   
   @Override 
   public String toString()
   {
      return getSearchString();
   }
   
   
   public void saveMedicine()
   {
         try {
         new File("medicines/").mkdirs();
         FileOutputStream fileOut =
         new FileOutputStream("medicines/"+this.MedicineUID+".ser");
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
      return this.MedicineUID.toString();
   }
}
