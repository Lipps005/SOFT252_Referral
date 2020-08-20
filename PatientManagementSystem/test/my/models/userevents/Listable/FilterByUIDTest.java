
package my.models.userevents.Listable;

import javax.swing.DefaultListModel;
import my.models.Admin;
import my.models.Doctor;
import my.models.Patient;
import my.models.Secretary;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
Testing:
* First, create a default list model object. Create 3 different users (one doctor, one secretary, one patient). Add objects to model.
* a. Filtering by the role identification character (e.g, P) returns only that type of User.
*  i. test by making sure user has same ID
* b. Filtering by exact UID returns the expected user.
 */
public class FilterByUIDTest {
   
   private DefaultListModel testModel = new DefaultListModel();
   
   private final Patient testPatient;
   private final Doctor testDoctor;
   private final Secretary testSecretary;
   private final Admin testAdmin;
   
   private final IFilterByStringBehaviour testFilter = new FilterByUID();
   
   
   public FilterByUIDTest() {
      this.testDoctor = new Doctor("D1021");
      this.testPatient = new Patient("P1021");
      this.testSecretary = new Secretary("S1021");
      this.testAdmin = new Admin("A1021");
   }
   
   @Before
   public void setUp() {
      this.testModel = new DefaultListModel();
      testModel.addElement(testPatient);
      testModel.addElement(testDoctor);
      testModel.addElement(testSecretary);
      testModel.addElement(testAdmin);
      
      
   }
   
   @After
   public void tearDown() {
   }

   @Test
   public void testFilteringExactUID() {
      String filterUID = "P1021";
      
      //Filtering exact UID returns only 1 model, 
      //and the object in the model is the expected User.
      
      DefaultListModel resultModel = this.testFilter.filterByString(this.testModel, filterUID);
      
      assertTrue("resulting model has more than one object", resultModel.size() == 1);
      assertTrue("resulting model does not contain patient object", resultModel.contains(this.testPatient));
      assertFalse("Model does contain Secretary object", resultModel.contains(this.testSecretary));
      assertFalse("Model does contain Doctor object", resultModel.contains(this.testDoctor));
      assertFalse("Model does contain Admin object", resultModel.contains(this.testAdmin));
   }
   
   @Test
   public void testFilteringRoleIdentificationCharacter() {
      //Filtering UID by role identification character P only returns the patient object
      setUp();
      String filterCharacter = "P";
      DefaultListModel resultModel = this.testFilter.filterByString(testModel, filterCharacter);
      assertTrue("resulting model has more than one object", resultModel.size() == 1);
      assertTrue("resulting model does not contain patient object", resultModel.contains(this.testPatient));
      assertFalse("Model does contain Secretary object", resultModel.contains(this.testSecretary));
      assertFalse("Model does contain Doctor object", resultModel.contains(this.testDoctor));
      assertFalse("Model does contain Admin object", resultModel.contains(this.testAdmin));
   }

   
   @Test
   public void testFilteringReturnsAllOfRole() {   
      //Where there are more than one of a type of user, all users with the same 
      //identification character are returned. 
      String filterCharacter = "P";
      setUp();
      Patient additionalPatient = new Patient("P4567");
      this.testModel.addElement(additionalPatient);
      DefaultListModel resultModel = this.testFilter.filterByString(testModel, filterCharacter);
      assertTrue("resulting model has more than two objects", resultModel.size() == 2);
      assertTrue("resulting model does not contain both patient objects", resultModel.contains(this.testPatient) && resultModel.contains(additionalPatient));
      assertFalse("Model does contain Secretary object", resultModel.contains(this.testSecretary));
      assertFalse("Model does contain Doctor object", resultModel.contains(this.testDoctor));
      assertFalse("Model does contain Admin object", resultModel.contains(this.testAdmin));
   }

   
   @Test
   public void testFilteringNonExistantUser() {      
      //Where the UID does not exist, no users are returned.
      setUp();
      String filterUID = "P0901";
      DefaultListModel resultModel = this.testFilter.filterByString(testModel, filterUID);
      assertTrue("Filter returned one or more objects", resultModel.size() == 0);
      assertFalse("Model does contain Admin object", resultModel.contains(this.testPatient));
      assertFalse("Model does contain Secretary object", resultModel.contains(this.testSecretary));
      assertFalse("Model does contain Doctor object", resultModel.contains(this.testDoctor));
      assertFalse("Model does contain Admin object", resultModel.contains(this.testAdmin));
      
   }
   
}
