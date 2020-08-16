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
public class Prescription implements Serializable, ListableByString{

   private String Dose;
   private String Medicine;
   private int Quantity;
   private final UUID PrescriptionUID = java.util.UUID.randomUUID();
   
   @Override
    public String getUID()
   {
      return this.PrescriptionUID.toString();
   }
      
   public Prescription()
   {
   }

   @Override
   public String getSearchString() {
      return Medicine;
   }
   
   public void setDose(String dose)
   {
      this.Dose = dose;
   }
   
   public void setPrescriptionQuantity(int quantity)
   {
     this.Quantity = quantity;
   }
   
   public void setMedicine(String Medicine) {
      this.Medicine = Medicine ;
   }
   
   public int getRequiredStock()
   {
      return this.Quantity;
   }
   
   @Override 
   public String toString()
   {
      return Medicine + " x " + Quantity;
   }
   
   public void savePrescription(String UID)
   {
   try {
         new File("users/"+UID+"/prescriptions/").mkdirs();
         FileOutputStream fileOut = new FileOutputStream("users/"+UID+"/prescriptions/"+this.PrescriptionUID+".ser");
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
