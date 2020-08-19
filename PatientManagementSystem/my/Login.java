/***
 * @author Samuel Lippett
 * @date 28/07/2020
 */
package my;


import java.awt.Color;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import my.models.*;


public class Login extends javax.swing.JFrame {

   private Patient patient;
   /**
    * Creates new form Login
    */
   public Login() {
      initComponents();
      patient = new Patient(User.UIDGenerator('P'));
      Register_FullName_JTextField.setEditable(true);
      Register_Password_JTextField.setEditable(false);
      Register_Address_JTextArea.setEditable(false);
      Register_GenderFemale_JRadioBtn.setSelected(true);
      Register_GenderFemale_JRadioBtn.setEnabled(false);
      Register_GenderMale_JRadioBtn.setEnabled(false);
      Register_Registerbtn_JButton.setEnabled(false);
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      buttonGroup1 = new javax.swing.ButtonGroup();
      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      Login_Password_TextField = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      Login_UID_TextField = new javax.swing.JTextField();
      Login_Loginbtn_JButton = new javax.swing.JButton();
      Login_LoginError_JLabel1 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      jLabel8 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      Register_FullName_JTextField = new javax.swing.JTextField();
      Register_Password_JTextField = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      Register_Address_JTextArea = new javax.swing.JTextArea();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      Register_Registerbtn_JButton = new javax.swing.JButton();
      Register_RegisterUID_JLabel = new javax.swing.JLabel();
      Register_GenderFemale_JRadioBtn = new javax.swing.JRadioButton();
      Register_GenderMale_JRadioBtn = new javax.swing.JRadioButton();
      jLabel6 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      jLabel1.setText("UID");

      Login_Password_TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

      jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
      jLabel2.setText("PASSWORD");

      Login_UID_TextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

      Login_Loginbtn_JButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      Login_Loginbtn_JButton.setText("Login");
      Login_Loginbtn_JButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            Login_Loginbtn_JButtonMouseClicked(evt);
         }
      });

      jLabel7.setText("Admin, enter a UID (if you have one) and a Password (if you have one).");

      jLabel8.setText("If the account does not exist, it will be created when you click Login.");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(Login_Password_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(Login_UID_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(131, 131, 131)
                  .addComponent(Login_Loginbtn_JButton)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap())
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
               .addContainerGap(33, Short.MAX_VALUE)
               .addComponent(Login_LoginError_JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(23, 23, 23)))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(62, 62, 62)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(Login_UID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(Login_Password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(43, 43, 43)
            .addComponent(Login_Loginbtn_JButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel8)
            .addGap(20, 20, 20))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
               .addContainerGap(280, Short.MAX_VALUE)
               .addComponent(Login_LoginError_JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(148, 148, 148)))
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patient Register", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

      Register_FullName_JTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            Register_FullName_JTextFieldCaretUpdate(evt);
         }
      });

      Register_Password_JTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            Register_Password_JTextFieldCaretUpdate(evt);
         }
      });

      Register_Address_JTextArea.setColumns(20);
      Register_Address_JTextArea.setLineWrap(true);
      Register_Address_JTextArea.setRows(5);
      Register_Address_JTextArea.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            Register_Address_JTextAreaCaretUpdate(evt);
         }
      });
      jScrollPane1.setViewportView(Register_Address_JTextArea);

      jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel3.setText("Full Name");

      jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel4.setText("Password");

      jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel5.setText("Address");

      Register_Registerbtn_JButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      Register_Registerbtn_JButton.setText("Register");
      Register_Registerbtn_JButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            Register_Registerbtn_JButtonActionPerformed(evt);
         }
      });

      buttonGroup1.add(Register_GenderFemale_JRadioBtn);
      Register_GenderFemale_JRadioBtn.setText("Female");
      Register_GenderFemale_JRadioBtn.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            Register_GenderFemale_JRadioBtnStateChanged(evt);
         }
      });

      buttonGroup1.add(Register_GenderMale_JRadioBtn);
      Register_GenderMale_JRadioBtn.setText("Male");

      jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel6.setText("Gender");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(36, 36, 36)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel6)
                     .addComponent(Register_GenderFemale_JRadioBtn))
                  .addGap(31, 31, 31)
                  .addComponent(Register_GenderMale_JRadioBtn))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(31, 31, 31)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel5)
                     .addComponent(jLabel4)
                     .addComponent(jLabel3)
                     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(Register_Password_JTextField)
                        .addComponent(Register_FullName_JTextField))))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addComponent(Register_RegisterUID_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(96, 96, 96)
                  .addComponent(Register_Registerbtn_JButton)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(61, 61, 61)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Register_FullName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Register_Password_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(28, 28, 28)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(Register_GenderFemale_JRadioBtn)
               .addComponent(Register_GenderMale_JRadioBtn))
            .addGap(18, 18, 18)
            .addComponent(Register_Registerbtn_JButton)
            .addGap(27, 27, 27)
            .addComponent(Register_RegisterUID_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void Login_Loginbtn_JButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_Loginbtn_JButtonMouseClicked
      String Password = Login_Password_TextField.getText();
     String UID = Login_UID_TextField.getText();
      if(!"".equals(Password) && !"".equals(UID))
      {
         /***
         User user = (User) User.loadUser(UID);
         if(user.verifyPassword(Password) && user.getAccountStatus() == User.AccountStatus.ACTIVE)
         {
            
         }
         */
         boolean LoggedIn = false;
         if(UID.contains("P"))
         {
            PatientHomeWindow PatientWindow = new PatientHomeWindow(UID, Password);
            LoggedIn = PatientWindow.getUserStatus();
         }
         else if(UID.contains("D"))
         {
            DoctorHomeWindow DoctorWindow = new DoctorHomeWindow(UID, Password);
            LoggedIn = DoctorWindow.getUserStatus();   
         }
         else if(UID.contains("S"))
         {
            SecretaryHomeWindow SecretaryWindow = new SecretaryHomeWindow(UID, Password);
            LoggedIn = SecretaryWindow.getUserStatus();   
         }
         else if(UID.contains("A"))
         {
               AdminHomeWindow AdminWindow = new AdminHomeWindow(UID, Password);
               LoggedIn = AdminWindow.getUserStatus();   
         }
         
         if(LoggedIn == false)
         {
            if(UID.contains("A"))
            {
               Admin admin = new Admin(UID);
               admin.setPassword(Password);
               admin.saveUser();
               Login_LoginError_JLabel1.setText("Your account has been created.");
            }
            else
            {
               Login_LoginError_JLabel1.setText("Error logging in. Try again later.");
            }
            
            
         }
        
      }
      
   }//GEN-LAST:event_Login_Loginbtn_JButtonMouseClicked

   private void Register_FullName_JTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Register_FullName_JTextFieldCaretUpdate
      if(Register_FullName_JTextField.getText().length() > 6)
      {
         this.patient.setName(Register_FullName_JTextField.getText());
         Register_FullName_JTextField.setForeground(Color.GREEN);
         Register_Password_JTextField.setEditable(true);
      }
      else
      {
         Register_FullName_JTextField.setForeground(Color.RED);
         Register_Registerbtn_JButton.setEnabled(false);
      }
   }//GEN-LAST:event_Register_FullName_JTextFieldCaretUpdate

   private void Register_Password_JTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Register_Password_JTextFieldCaretUpdate
      if(Register_Password_JTextField.getText().length() > 6)
      {
         this.patient.setPassword(Register_Password_JTextField.getText());
         Register_Password_JTextField.setForeground(Color.GREEN);
         Register_Address_JTextArea.setEditable(true);
      }
      else
      {
         Register_Password_JTextField.setForeground(Color.RED);
         Register_Registerbtn_JButton.setEnabled(false);
      }
   }//GEN-LAST:event_Register_Password_JTextFieldCaretUpdate

   private void Register_Address_JTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Register_Address_JTextAreaCaretUpdate
      if(Register_Address_JTextArea.getText().length() > 20)
      {
         this.patient.setAddress(Register_Address_JTextArea.getText());
         Register_GenderFemale_JRadioBtn.setEnabled(true);
         Register_GenderMale_JRadioBtn.setEnabled(true);
      }
      else
      {
         Register_Registerbtn_JButton.setEnabled(false);
      }
   }//GEN-LAST:event_Register_Address_JTextAreaCaretUpdate

   private void Register_GenderFemale_JRadioBtnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Register_GenderFemale_JRadioBtnStateChanged
      if(Register_GenderFemale_JRadioBtn.isSelected())
      {
         this.patient.setGender("Female");
         Register_Registerbtn_JButton.setEnabled(true);
      }
      else if(Register_GenderMale_JRadioBtn.isSelected())
      {
         this.patient.setGender("Male");
         Register_Registerbtn_JButton.setEnabled(true);
      }
      else
      {
          Register_Registerbtn_JButton.setEnabled(false);
      }
     
      
   }//GEN-LAST:event_Register_GenderFemale_JRadioBtnStateChanged

   private void Register_Registerbtn_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_Registerbtn_JButtonActionPerformed
      this.patient.saveUser();
      AccountActionRequest action = new AccountActionRequest(this.patient.getUID(), User.AccountStatus.ACTIVE);
      action.saveAccountActionRequest();
      JOptionPane.showMessageDialog(null, "Thanks for registering. The Secretary will notify you when your account is active.", "User Request Sent", JOptionPane.INFORMATION_MESSAGE);
      Register_RegisterUID_JLabel.setText("Here is your patient ID. Don't forget it! " + this.patient.getUID());
      this.patient = new Patient(User.UIDGenerator('P'));
      Register_FullName_JTextField.setText("");
      Register_Password_JTextField.setText("");
      Register_Address_JTextArea.setText("");
      Register_GenderFemale_JRadioBtn.setEnabled(false);
      Register_GenderMale_JRadioBtn.setEnabled(false);
      buttonGroup1.clearSelection();
   }//GEN-LAST:event_Register_Registerbtn_JButtonActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new File("users").mkdirs();
            new File("medicines").mkdirs();
           
//           Medicine med = new Medicine("Tramadol");
//          med.addStock(100);
//           med.saveMedicine();
//           
//           Medicine med2 = new Medicine("Methadone");
//           med2.addStock(100);
//          med2.saveMedicine();
//          
//          Medicine med3 = new Medicine("Diamorphine");
//           med3.addStock(100);
//          med3.saveMedicine();
//
//          Medicine med4 = new Medicine("Buprenorphine");
//           med4.addStock(100);
//          med4.saveMedicine();
//          
//          Medicine med5 = new Medicine("Fentanyl");
//          med5.addStock(100);
//          med5.saveMedicine();
//          
//          Medicine med6 = new Medicine("Hydrocortisone");
//          med6.addStock(100);
//          med6.saveMedicine();
//          
//          Medicine med7 = new Medicine("Oxycodone");
//          med7.addStock(100);
//          med7.saveMedicine();
//          
//          Medicine med8 = new Medicine("Alfentanil");
//          med8.addStock(100);
//          med8.saveMedicine();
//          
//          Medicine med9 = new Medicine("Morphine");
//          med8.addStock(100);
//          med8.saveMedicine();
//          
//         Medicine med10 = new Medicine("Vicodin");
//          med10.addStock(100);
//          med10.saveMedicine();
          new Login().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel Login_LoginError_JLabel1;
   private javax.swing.JButton Login_Loginbtn_JButton;
   private javax.swing.JTextField Login_Password_TextField;
   private javax.swing.JTextField Login_UID_TextField;
   private javax.swing.JTextArea Register_Address_JTextArea;
   private javax.swing.JTextField Register_FullName_JTextField;
   private javax.swing.JRadioButton Register_GenderFemale_JRadioBtn;
   private javax.swing.JRadioButton Register_GenderMale_JRadioBtn;
   private javax.swing.JTextField Register_Password_JTextField;
   private javax.swing.JLabel Register_RegisterUID_JLabel;
   private javax.swing.JButton Register_Registerbtn_JButton;
   private javax.swing.ButtonGroup buttonGroup1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
