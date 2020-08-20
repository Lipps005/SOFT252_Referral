
package my;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import my.models.Medicine;
import my.models.Patient;
import my.models.Prescription;
import my.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
This test will emulate the actions in the DispensePrescription window.
* 1. create 2 prescriptions of different medicines for a patient
* 2. set the stock for one of medicine to be 0, so it cannot be dispensed
* 
* 3. create a third prescription to take the remaining stock of one of the medicines. 
* 4. duplicate the prescription, and attempt to dispense the medicine.
* 
Testing:
* a. A prescription for a medicine that is in stock and has enough stock left can be dispensed.
* b. A prescription for a medicine that has no stock cannot be dispensed.
* c. A prescription requiring all the remaining stock can be dispensed
* d. When a prescription is dispensed, the prescription is deleted from the patient file. 
 */

/*
When Debugging, please remember to delete all the test files created before repeating the test.
Not doing so might result in duplicates. 
*/
public class DispensePrescriptionTest{
   
   private Patient testPatient;
   private DispensePrescription testWindow;
   Medicine med1;
   Medicine med2;
   Prescription prescriptionA;
   Prescription prescriptionB;
   Prescription prescriptionC;
   
   public DispensePrescriptionTest(){
      
   }
   
   @Before
   public void setUp() {
      testPatient = new Patient("P1188");
      
      testPatient.saveUser();
      med1 = new Medicine("Medicine 1");
      med1.addStock(100);
      
      med2 = new Medicine("Medicine 2");
      med2.addStock(0);
      
      med1.saveMedicine();
      med2.saveMedicine();
      
      prescriptionA = new Prescription();
      prescriptionA.setMedicine(med1.getSearchString());
      prescriptionA.setPrescriptionQuantity(50);
      prescriptionA.savePrescription("P1188");
      
      prescriptionB = new Prescription();
      prescriptionB.setMedicine(med2.getSearchString());
      prescriptionB.setPrescriptionQuantity(50);
      prescriptionB.savePrescription("P1188");
      
      prescriptionC = new Prescription();
      prescriptionC.setMedicine(med1.getSearchString());
      prescriptionC.setPrescriptionQuantity(50);
      prescriptionC.savePrescription("P1188");
      
      testWindow = new DispensePrescription(testPatient);
      
      
   }
   
   @After
   public void tearDown() {
      File file = new File("medicines/"+med1.getUID()+".ser");
      file.delete();
      File file2 = new File("medicines/"+med2.getUID()+".ser");
      file2.delete();
      
      File file3 = new File("users/"+testPatient.getUID()+"/prescriptions/"+prescriptionA.getUID()+".ser");
      file3.delete();
      File file4 = new File("users/"+testPatient.getUID()+"/prescriptions/"+prescriptionB.getUID()+".ser");
      file4.delete();
      File file5 = new File("users/"+testPatient.getUID()+"/prescriptions/"+prescriptionC.getUID()+".ser");
      file5.delete();
   }

   @Test
   public void NoStockMedicineDispenseTest()
   {
      List<Component> dispensePrescriptionComponents = testWindow.getDispensePrescriptionComponents();
      JButton dispenseButton = (JButton) dispensePrescriptionComponents.get(0);
      JList prescriptionsList = (JList) dispensePrescriptionComponents.get(1);
      
      DefaultListModel m = (DefaultListModel) prescriptionsList.getModel();
      prescriptionsList.setSelectedIndex(getFirstIndexOfObject(prescriptionB, m));
       m = (DefaultListModel) prescriptionsList.getModel();
      assertFalse(dispenseButton.isEnabled());
      assertEquals(3, m.size());
   }
   
   @Test
   public void DispenseMedicineWithStock()
   {
      
      
      List<Component> dispensePrescriptionComponents = testWindow.getDispensePrescriptionComponents();
      JButton dispenseButton = (JButton) dispensePrescriptionComponents.get(0);
      JList prescriptionsList = (JList) dispensePrescriptionComponents.get(1);
      
      DefaultListModel m = (DefaultListModel) prescriptionsList.getModel();
      prescriptionsList.setSelectedIndex(getFirstIndexOfObject(prescriptionA, m));
      assertTrue(dispenseButton.isEnabled());
      
      dispenseButton.doClick();
      int index = getFirstIndexOfObject(prescriptionA, m);
      assertEquals(-1, index);
      assertEquals(2, m.size());
      File file = new File("users/"+testPatient.getUID()+"/prescriptions/"+prescriptionA.getUID()+".ser");
      assertFalse(file.exists());
   }
   
   @Test
   public void DispenseMedicineWithEnoughStock()
   {
      List<Component> dispensePrescriptionComponents = testWindow.getDispensePrescriptionComponents();
      JButton dispenseButton = (JButton) dispensePrescriptionComponents.get(0);
      JList prescriptionsList = (JList) dispensePrescriptionComponents.get(1);
      
      DefaultListModel m = (DefaultListModel) prescriptionsList.getModel();
      prescriptionsList.setSelectedIndex(getFirstIndexOfObject(prescriptionC, m));
      assertTrue(dispenseButton.isEnabled());
      
      dispenseButton.doClick();
      
      m = (DefaultListModel) prescriptionsList.getModel();
      //assertEquals(1, m.size());
      /*Dont know why, but a new window is created each time, along with three new prescriptions. Therefore, although if this were
      all happening consecutively in the same window we would expec the list to only have the prescription with 0 stock left, because
      this test only removed one prescription out of the three, we actually have two prescriptions left. 
      */
      assertEquals(2, m.size());
      File file = new File("users/"+testPatient.getUID()+"/prescriptions/"+prescriptionC.getUID()+".ser");
      assertFalse(file.exists());
   }
   
   
   
   
   public int getFirstIndexOfObject(Prescription p, DefaultListModel m)
   {
      for(int i = 0; i < m.getSize(); i++)
      {
         Prescription pq = (Prescription) m.get(i);
         if(pq.getUID().equals(p.getUID()))
         {
            return i;
         }
         
      }
      return -1;
   }
}
