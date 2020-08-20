
package my.models;

import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
Testing:
* a. A new patients default user status is PENDING
* b. A patient can be saved and loaded again from a file
* c. A user cannot login with an incorrect password
*  i. using User.VerifyPassword();
* d. Updating a patients status actually changes the status.
 */
public class PatientTest{
   
   public PatientTest() {
   }
   
   @Before
   public void setUp() {
   }
   
   @After
   public void tearDown() {
      //remove all users from the project. 
      File file = new File("users/P0000/P0000.ser");
      file.delete();
      file = new File("users/P0000/appointments");
      file.delete();
      file = new File("users/P0000/prescriptions");
      file.delete();
      file = new File("users/P0000");
      file.delete();
   }
   
   @Test
   public void testNewUserAccountStatus() {
      Patient patient = new Patient("P0000");
      Secretary secretary = new Secretary("S0000");
      Doctor doctor = new Doctor("D0000");
      assertEquals("Patient account status is not default pending ", User.AccountStatus.PENDING, patient.getAccountStatus());
      //test will fail, but doctor account will be updated to active in the program
      assertEquals("Doctor account status is not default active", User.AccountStatus.ACTIVE, doctor.getAccountStatus()); 
      assertEquals("Secretary account status is not default active", User.AccountStatus.ACTIVE, secretary.getAccountStatus());
   }
   
   @Test
   public void testUserSerialization() {
      String UID = "P0000";
      Patient patient = new Patient(UID);
      patient.saveUser();
      Patient newPatient = (Patient)User.loadUser(UID);
      assertNotNull("de-serialised patient is null", newPatient);
      if(newPatient.equals(patient))
      {
         Assert.fail("objects equal");
      }
   }
   
   @Test
   public void testUserAccountStatusUpdate()
   {
      Patient patient = new Patient("P0000");
      assertEquals("Patient account status is not default Pending ", User.AccountStatus.PENDING, patient.getAccountStatus());
      patient.updateAccountStatus(User.AccountStatus.ACTIVE);
      assertEquals("Patient account status did not update to Active", User.AccountStatus.ACTIVE, patient.getAccountStatus());
   }
   
   @Test
   public void testUserLogin()
   {
      String password = "2109u832rhj";
      Patient patient = new Patient("P0000");
      patient.setPassword(password);
      assertFalse("verify password failed",patient.verifyPassword("d9fids9f"));
      assertTrue("Patient can log in with correct password", patient.verifyPassword(password));
      
      Patient patient2 = new Patient("P0001");
      assertFalse("Patient could log in with null password", patient2.verifyPassword(password));
      assertFalse("Patient could log in with null password", patient2.verifyPassword(null));
      
      patient2.setPassword(null);
      assertFalse("Patient could log in with null password", patient2.verifyPassword(null));
      assertFalse("Patient could log in with blank password", patient2.verifyPassword(""));
      
      patient2.setPassword("");
      assertFalse("Patient could log in with blank password", patient2.verifyPassword(""));
   }
}
