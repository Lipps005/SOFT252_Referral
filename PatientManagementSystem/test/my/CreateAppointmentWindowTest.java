
package my;

import java.awt.Component;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import my.models.Appointment;
import my.models.AppointmentRequest;
import my.models.Doctor;
import my.models.Patient;
import my.models.Secretary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * prerequisites:
 * 1. One doctor needs to exist, who will have at least one appointment
 * 2. Create an appointment request whose date range includes the taken appointment
 * 
To emulate Create Appointment Window, we will test the following:
*  a. If the entered date is the same as the taken appointment, the save button is disabled. 
*  b. If the entered time is the same as the taken appointment, the save button is still disabled. 
*  c. If the entered date and time do not conflict with the taken appointment, the save button is enabled. 
*     ci. When the save button is clicked, the appointment is created, and appears in the doctors appointment folder. 
*     cii. When the save button is clicked, the appointment request is deleted from the secretary folder. 
 */
public class CreateAppointmentWindowTest {
   Doctor testDoctor;
   Patient testPatient;
   Secretary testSecretary;
   CreateAppointmentWindow testWindow;
   Appointment pastAppointment;
   AppointmentRequest testRequest;
   public CreateAppointmentWindowTest() {
   }
   
   @Before
   public void setUp() {
      //create test doctor
      testDoctor = new Doctor("D0001");
      testDoctor.saveUser();
      
      //create test patient
      testPatient = new Patient("P0001");
      testPatient.saveUser();
      
      testSecretary = new Secretary("S0001");
      testSecretary.saveUser();
      //create appointment in the past
      pastAppointment = new Appointment(LocalDate.parse("2020-02-20", DateTimeFormatter.ISO_DATE), LocalTime.NOON);
      pastAppointment.setDoctor("D0001");
      pastAppointment.setPatient("P0001");
      //save appointment in both users directories.
      pastAppointment.saveAppointment("P0001");
      pastAppointment.saveAppointment("D0001");
      

      AppointmentRequest testRequest = new AppointmentRequest();
      testRequest.saveAppointmentRequest();
      
   }
   
   @After
   public void tearDown() {
      File file = new File("/users/"+testSecretary.getUID()+"/appointments/"+testRequest.getUID().toString()+".ser");
      file.delete();
      File file2 = new File("/users/"+testPatient.getUID()+"/appointments/"+pastAppointment.getUID().toString()+".ser");
      file2.delete();
      File file3 = new File("/users/"+testDoctor.getUID()+"/appointments/"+pastAppointment.getUID().toString()+".ser");
      file3.delete();
      File file4 = new File("/users/"+testDoctor.getUID()+"/"+testDoctor.getUID()+".ser");
      file4.delete();
      File file5 = new File("/users/"+testDoctor.getUID()+"/appointments/");
      file5.delete();
      File file6 = new File("/users/"+testDoctor.getUID()+"/prescriptions/");
      file6.delete();
      File file7 = new File("/users/"+testPatient.getUID()+"/appointments/");
      file7.delete();
      File file8 = new File("/users/"+testPatient.getUID()+"/prescriptions/");
      file8.delete();
      
      File file9 = new File("/users/"+testDoctor.getUID());
      file9.delete();
      File file10 = new File("/users/"+testPatient.getUID());
      file10.delete();
      File file11 = new File("/users/"+testSecretary.getUID());
      file11.delete();
   }

   @Test
   public void TestAppointmentRequestSave()
   {
      //create test appointment request in secretaries directory. 
      //if this were the doctor, this would just be a local variable. 
      //we will test the saving of the appointment request
      testRequest = new AppointmentRequest();
      testRequest.saveAppointmentRequest();
      //try create file for appointment request
      File file = new File("users/"+testSecretary.getUID()+"/appointments/"+testRequest.getUID().toString()+".ser");
      assertTrue(file.exists());
   }
   
   @Test
   public void TestCreateAppointmentWindowInvalidDate()
   {
      //create test appointment request in secretaries directory. 
      //if this were the doctor, this would just be a local variable. 
      //we will test the saving of the appointment request
      testRequest = new AppointmentRequest();
      testRequest.setDateFrom(LocalDate.now());
      testRequest.setDateTo(LocalDate.MAX);
      testRequest.setDoctor(testDoctor.getUID());
      testRequest.setPatientUID(testPatient.getUID());
      testRequest.saveAppointmentRequest();
      testWindow = new CreateAppointmentWindow(testRequest, testSecretary);
      List<Component> components = testWindow.getCreateAppointmentComponents();
      JTextField dateField = (JTextField) components.get(2);
      JButton saveButton = (JButton) components.get(0);
      JComboBox minuteBox = (JComboBox)components.get(4);
      JComboBox hourBox = (JComboBox)components.get(3);
      
      dateField.setText("2020-");
      
      assertFalse(saveButton.isEnabled());
      assertFalse(minuteBox.isEnabled());
      assertFalse(hourBox.isEnabled());
      
   }
   
   @Test
   public void TestCreateAppointmentWindowValidDate()
   {
      //create test appointment request in secretaries directory. 
      //if this were the doctor, this would just be a local variable. 
      //we will test the saving of the appointment request
      testRequest = new AppointmentRequest();
      testRequest.setDateFrom(LocalDate.now());
      testRequest.setDateTo(LocalDate.MAX);
      testRequest.setDoctor(testDoctor.getUID());
      testRequest.setPatientUID(testPatient.getUID());
      testRequest.saveAppointmentRequest();
      testWindow = new CreateAppointmentWindow(testRequest, testSecretary);
      List<Component> components = testWindow.getCreateAppointmentComponents();
      JTextField dateField = (JTextField) components.get(2);
      JButton saveButton = (JButton) components.get(0);
      JComboBox minuteBox = (JComboBox)components.get(4);
      JComboBox hourBox = (JComboBox)components.get(3);
      
      //Because our create appointment window filters preceding dates, 
      //our taken appointments model is empty. therefore, even though there is
      //an appointment at this date, it doesnt show up in the list. This could be
      //considered an error, but it is useful for testing. 
      dateField.setText("2020-02-20");
      //text value is not bound, so setting the text does not fire any property change 
      //listeners. We therefore need to change the caret postion manually to fire our 
      //Caret update event. The position we set it to could be random, but i made it
      //to be the end of the text.
      dateField.setCaretPosition(dateField.getText().length());
      
      //Still want save button disabled, because we havent chosen our time yet.

      assertFalse(saveButton.isEnabled());
      assertTrue(minuteBox.isEnabled());
      assertTrue(hourBox.isEnabled());
      
   }
   
   public void TestCreateAppointmentWindowValidTime()
   {
      //create test appointment request in secretaries directory. 
      //if this were the doctor, this would just be a local variable. 
      //we will test the saving of the appointment request
      testRequest = new AppointmentRequest();
      testRequest.setDateFrom(LocalDate.now());
      testRequest.setDateTo(LocalDate.MAX);
      testRequest.setDoctor(testDoctor.getUID());
      testRequest.setPatientUID(testPatient.getUID());
      testRequest.saveAppointmentRequest();
      testWindow = new CreateAppointmentWindow(testRequest, testSecretary);
      List<Component> components = testWindow.getCreateAppointmentComponents();
      JTextField dateField = (JTextField) components.get(2);
      JButton saveButton = (JButton) components.get(0);
      JComboBox minuteBox = (JComboBox)components.get(4);
      JComboBox hourBox = (JComboBox)components.get(3);
      
      //Because our create appointment window filters preceding dates, 
      //our taken appointments model is empty. therefore, even though there is
      //an appointment at this date, it doesnt show up in the list. This could be
      //considered an error, but it is useful for testing. 
      dateField.setText("2020-02-20");
      //text value is not bound, so setting the text does not fire any property change 
      //listeners. We therefore need to change the caret postion manually to fire our 
      //Caret update event. The position we set it to could be random, but i made it
      //to be the end of the text.
      dateField.setCaretPosition(dateField.getText().length());
      
      minuteBox.setSelectedIndex(4);

      //as all the combinations make a vaid time, just updating or clicking on the 
      //combo box to make the selection is enough to create a valid time. 
      assertTrue(saveButton.isEnabled());
      assertTrue(minuteBox.isEnabled());
      assertTrue(hourBox.isEnabled());
      
   }
   
   public void TestCreateAppointment()
   {
      //create test appointment request in secretaries directory. 
      //if this were the doctor, this would just be a local variable. 
      //we will test the saving of the appointment request
      testRequest = new AppointmentRequest();
      testRequest.setDateFrom(LocalDate.now());
      testRequest.setDateTo(LocalDate.MAX);
      testRequest.setDoctor(testDoctor.getUID());
      testRequest.setPatientUID(testPatient.getUID());
      testRequest.saveAppointmentRequest();
      testWindow = new CreateAppointmentWindow(testRequest, testSecretary);
      List<Component> components = testWindow.getCreateAppointmentComponents();
      JTextField dateField = (JTextField) components.get(2);
      JButton saveButton = (JButton) components.get(0);
      JComboBox minuteBox = (JComboBox)components.get(4);
      JComboBox hourBox = (JComboBox)components.get(3);
      
      //Because our create appointment window filters preceding dates, 
      //our taken appointments model is empty. therefore, even though there is
      //an appointment at this date, it doesnt show up in the list. This could be
      //considered an error, but it is useful for testing. 
      dateField.setText("2020-02-20");
      //text value is not bound, so setting the text does not fire any property change 
      //listeners. We therefore need to change the caret postion manually to fire our 
      //Caret update event. The position we set it to could be random, but i made it
      //to be the end of the text.
      dateField.setCaretPosition(dateField.getText().length());
      
      minuteBox.setSelectedIndex(4);

      //as all the combinations make a vaid time, just updating or clicking on the 
      //combo box to make the selection is enough to create a valid time. 
      
      saveButton.doClick();
      
      File requestFile = new File("users/"+testSecretary.getUID()+"/appointments/"+testRequest.getUID().toString()+".ser");
      assertFalse(requestFile.exists());
      
      File newAppointmentFile = new File("users/"+testDoctor.getUID()+"/appointments/"+testWindow.testGetAppointmentUID()+".ser");
      assertTrue(newAppointmentFile.exists());
      
      newAppointmentFile = new File("users/"+testPatient.getUID()+"/appointments/"+testWindow.testGetAppointmentUID()+".ser");
      assertTrue(newAppointmentFile.exists());
      
   }
}
