/***
 * @author Samuel Lippett
 * @date 28/07/2020
 */
package my.models;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author samue
 */
public class AppointmentRequest implements Serializable{
   private String PatientUID;
   private String DoctorUID;
   private LocalDate DateFrom;
   private LocalDate DateTo;
   private final UUID AccountActionUID = java.util.UUID.randomUUID();
   
   public AppointmentRequest()
   {

   }
   
    public UUID getUID()
   {
      return this.AccountActionUID;
   }
         
   @Override
   public String toString()
   {
      return PatientUID + " Requested a new Appointment.";
   }
   
   public void setPatientUID(String PatientUID)
   {
      this.PatientUID = PatientUID;
   }
   
   public String getPatientUID()
   {
      return this.PatientUID;
   }
   
   public void setDateFrom(LocalDate DateFrom)
   {
      this.DateFrom = DateFrom;
   }
   public LocalDate getDateFrom()
   {
      return this.DateFrom;
   }
   
   public void setDateTo(LocalDate DateTo)
   {
      this.DateTo = DateTo;
   }
   public LocalDate getDateTo()
   {
      return this.DateTo;
   }
   
   
   public void setDoctor(String DoctorUID)
   {
      this.DoctorUID = DoctorUID;
   }
   public String getDoctorUID()
   {
      return this.DoctorUID;
   }
   
   public boolean saveAppointmentRequest()
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
                  FileOutputStream fileOut = new FileOutputStream("users/"+filename+"/appointments/"+AccountActionUID+".ser");
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

   
}
