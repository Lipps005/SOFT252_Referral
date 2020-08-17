/***
 * @author Samuel Lippett
 * @date 28/07/2020
 */
package my.models;
import java.util.*;
import java.io.*;
import java.time.*;
import javax.swing.DefaultListModel;
import my.models.userevents.Listable.ListableByDateTime;


public class Appointment extends UserEvent implements Serializable, ListableByDateTime{
   private String AppointmentPatient;
   private String AppointmentDoctor;
   private final LocalDate AppointmentDate;
   private final LocalTime AppointmentTime;
   private final UUID AppointmentUID = java.util.UUID.randomUUID();
   private String TreatmentNotes;
   public DefaultListModel PrescribedMedicines;
   
  
   public Appointment(LocalDate AppointmentDate, LocalTime AppointmentTime)
   {
      this.AppointmentDate = AppointmentDate;
      this.AppointmentTime = AppointmentTime;
      this.PrescribedMedicines = new DefaultListModel();
   }
           
   @Override
   public String toString() 
   {
    return AppointmentDate.toString()+" @ "+LocalTime.of(AppointmentTime.getHour(), AppointmentTime.getMinute()).toString();
   }
   
   public LocalDate getAppointmentDate()
   {
      return this.AppointmentDate;
   }
   public LocalTime getAppointmentTime()
   {
      return this.AppointmentTime;
   }
   
   public String getDoctorID()
   {
      return this.AppointmentDoctor;
   }
   
      public String getPatientID()
   {
      return this.AppointmentPatient;
   }
      
   public UUID getUID()
   {
      return this.AppointmentUID;
   }
   
   public String getTreatmentNotes()
   {
      return this.TreatmentNotes;
   }
   
   public static DefaultListModel getAllAppointments(String UID) 
   {
      DefaultListModel UpcomingAppointments = new DefaultListModel();
      try
        {    

            // Reading the object from a file 
            File folder = new File("users/"+UID+Appointment.Directory);
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) 
            {
               if (file.isFile()) 
               {
                  FileInputStream inFile = new FileInputStream(file); 
                  ObjectInputStream in = new ObjectInputStream(inFile); 
                  Appointment app = (Appointment) in.readObject(); 
                  System.out.println(app.getAppointmentDate());
                  System.out.println(LocalDate.now());
                  
       
                  in.close(); 
                  inFile.close(); 
               }
            }
        } 
          
        catch(IOException | ClassNotFoundException ex) 
        { 
           System.out.println(ex);
        } 
      return UpcomingAppointments;
   }
   
   public void saveAppointment(String UID)
   {
   try {
         new File("users/"+UID+"/appointments/").mkdirs();
         FileOutputStream fileOut = new FileOutputStream("users/"+UID+"/appointments/"+this.AppointmentUID+".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved");
      } catch (IOException i) {
         i.printStackTrace();
      }
   }
   
   public void setPatient(String UID)
   {
      this.AppointmentPatient = UID;
   }
   
   public void setDoctor(String UID)
   {
      this.AppointmentDoctor = UID;
   }

   @Override
   public LocalDateTime getSearchDateTime() {
      return LocalDateTime.of(AppointmentDate, AppointmentTime);
   }

   public void setTreatmentNotes(String notes)
   {
      this.TreatmentNotes = notes;
   }
   
   
}
