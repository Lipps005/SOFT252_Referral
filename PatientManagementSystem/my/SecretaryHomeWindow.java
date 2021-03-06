/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import my.models.*;
import my.models.userevents.Listable.FilterByString;
import my.models.userevents.Listable.FilterByUID;
import my.models.userevents.Listable.IFilterByDateTimeBehaviour;
import my.models.userevents.Listable.IFilterByStringBehaviour;
import my.models.userevents.Listable.ILoadAllBehaviour;
import my.models.userevents.Listable.ListableDirectory;
import my.models.userevents.Listable.LoadObjectsFromFile;
import my.models.userevents.Listable.LoadUsers;
import my.models.userevents.SubFrameCloseListener;

/**
 *
 * @author samue
 */
public class SecretaryHomeWindow extends javax.swing.JFrame implements SubFrameCloseListener{

   private final Secretary WindowSecretary; 
  
   
   private ListableDirectory directory;
   private ILoadAllBehaviour loadBehaviour;
   private IFilterByDateTimeBehaviour dateTimeFilter;
   private IFilterByStringBehaviour stringFilter;
   
   private DefaultListModel AccountActionModel;
   private DefaultListModel MedicineActionModel;
   private DefaultListModel AppointmentRequestsModel;
   private DefaultListModel MedicinesModel;
   private DefaultListModel PatientsModel;
   
   public boolean getUserStatus()
   {
      if(this.WindowSecretary == null)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   public SecretaryHomeWindow(String UID, String Password) {
      initComponents();
      boolean LoggedIn = false;
      Secretary secretary = (Secretary) User.loadUser(UID);
      if(secretary != null)
      {
        if(secretary.verifyPassword(Password) == true && secretary.getAccountStatus() == User.AccountStatus.ACTIVE)
        {
           LoggedIn = true;
        }
      }
      
      if(LoggedIn == true)
      {
         this.WindowSecretary = (Secretary) User.loadUser(UID);
         this.setTitle(this.WindowSecretary.getSearchString());
         this.setVisible(LoggedIn);
         this.directory = new ListableDirectory.ListableTemplateBuilder().AddTopLevelFolder("users").AddFolderUID(this.WindowSecretary.getUID()).AddSubFolder("appointments").Build();
         this.loadBehaviour = new LoadObjectsFromFile();
         this.AppointmentRequestsModel = this.loadBehaviour.LoadAll(directory);
         this.AppointmentRequestsJList.setModel(this.AppointmentRequestsModel);
         
         this.directory = new ListableDirectory.ListableTemplateBuilder().AddTopLevelFolder("medicines").Build();
         this.MedicinesModel = this.loadBehaviour.LoadAll(directory);
         this.MedicinesJList.setModel(this.MedicinesModel);
         
         this.directory = new ListableDirectory.ListableTemplateBuilder().AddTopLevelFolder("users").Build();
         this.loadBehaviour = new LoadUsers();
         this.stringFilter = new FilterByUID();
         this.PatientsModel = loadBehaviour.LoadAll(directory);
         this.PatientsModel = stringFilter.filterByString(PatientsModel, "P");
         PatientsJList.setModel(PatientsModel);
         
         this.directory = new ListableDirectory.ListableTemplateBuilder()
                 .AddTopLevelFolder("users")
                 .AddFolderUID(UID)
                 .AddSubFolder("accountactions")
                 .Build();
         loadBehaviour = new LoadObjectsFromFile();
         this.AccountActionModel = loadBehaviour.LoadAll(directory);
         AccountActionRequestsJList.setModel(AccountActionModel);
      }
      else
      {
         this.WindowSecretary = null;
      }
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      AppointmentRequestsJPanel = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      AppointmentRequestsJList = new javax.swing.JList<>();
      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      PatientNameJTextField = new javax.swing.JTextField();
      jScrollPane5 = new javax.swing.JScrollPane();
      PatientsJList = new javax.swing.JList<>();
      AccountActionRequests = new javax.swing.JPanel();
      jScrollPane4 = new javax.swing.JScrollPane();
      AccountActionRequestsJList = new javax.swing.JList<>();
      jPanel2 = new javax.swing.JPanel();
      jScrollPane3 = new javax.swing.JScrollPane();
      MedicinesJList = new javax.swing.JList<>();
      MedicineNameJTextField = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      AppointmentRequestsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Appointment Requests"));

      AppointmentRequestsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      AppointmentRequestsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            AppointmentRequestsJListValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(AppointmentRequestsJList);

      javax.swing.GroupLayout AppointmentRequestsJPanelLayout = new javax.swing.GroupLayout(AppointmentRequestsJPanel);
      AppointmentRequestsJPanel.setLayout(AppointmentRequestsJPanelLayout);
      AppointmentRequestsJPanelLayout.setHorizontalGroup(
         AppointmentRequestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
      );
      AppointmentRequestsJPanelLayout.setVerticalGroup(
         AppointmentRequestsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(AppointmentRequestsJPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1))
      );

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prescriptions"));

      jLabel1.setText("Search User");

      PatientNameJTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            PatientNameJTextFieldCaretUpdate(evt);
         }
      });

      PatientsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      PatientsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            PatientsJListValueChanged(evt);
         }
      });
      jScrollPane5.setViewportView(PatientsJList);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(PatientNameJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
               .addComponent(jLabel1))
            .addContainerGap())
         .addComponent(jScrollPane5)
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(PatientNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5))
      );

      AccountActionRequests.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Action Requests"));

      AccountActionRequestsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      AccountActionRequestsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            AccountActionRequestsJListValueChanged(evt);
         }
      });
      jScrollPane4.setViewportView(AccountActionRequestsJList);

      javax.swing.GroupLayout AccountActionRequestsLayout = new javax.swing.GroupLayout(AccountActionRequests);
      AccountActionRequests.setLayout(AccountActionRequestsLayout);
      AccountActionRequestsLayout.setHorizontalGroup(
         AccountActionRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
      );
      AccountActionRequestsLayout.setVerticalGroup(
         AccountActionRequestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(AccountActionRequestsLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4))
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Medicines"));

      MedicinesJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      MedicinesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            MedicinesJListValueChanged(evt);
         }
      });
      jScrollPane3.setViewportView(MedicinesJList);

      MedicineNameJTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            MedicineNameJTextFieldCaretUpdate(evt);
         }
      });

      jLabel2.setText("Search Medicine");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
         .addComponent(MedicineNameJTextField)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(0, 0, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(MedicineNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(AppointmentRequestsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(AccountActionRequests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(AppointmentRequestsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(AccountActionRequests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void PatientsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_PatientsJListValueChanged
      try
      {
         if(!evt.getValueIsAdjusting() && ! PatientsJList.isSelectionEmpty())
         {
           Patient selectedPatient = (Patient)PatientsModel.getElementAt(PatientsJList.getSelectedIndex());
           DispensePrescription dispenseWindow = new DispensePrescription(selectedPatient);
           dispenseWindow.SubFrameCloseListener(this);
           PatientsJList.clearSelection();
         }
      }
      catch(NullPointerException e)
      {
      }
   }//GEN-LAST:event_PatientsJListValueChanged

   private void MedicineNameJTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MedicineNameJTextFieldCaretUpdate
      if(!MedicinesModel.isEmpty())
      {
         this.stringFilter = new FilterByString();
         DefaultListModel model = stringFilter.filterByString(MedicinesModel, MedicineNameJTextField.getText());
         MedicinesJList.setModel(model);
      }
      
   }//GEN-LAST:event_MedicineNameJTextFieldCaretUpdate

   private void PatientNameJTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_PatientNameJTextFieldCaretUpdate
      if(!PatientsModel.isEmpty())
      {
         this.stringFilter = new FilterByString();
          DefaultListModel model = stringFilter.filterByString(PatientsModel, PatientNameJTextField.getText());
         PatientsJList.setModel(model);
      }
   }//GEN-LAST:event_PatientNameJTextFieldCaretUpdate

   private void MedicinesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_MedicinesJListValueChanged
      try
      {
         if(!evt.getValueIsAdjusting() && ! MedicinesJList.isSelectionEmpty())
         {
           Medicine selectedMedicine = (Medicine)MedicinesModel.getElementAt(MedicinesJList.getSelectedIndex());
           MedicineWindow medicineWindow = new MedicineWindow(selectedMedicine);
           MedicinesJList.clearSelection();
         }
      }
      catch(NullPointerException e)
      {
      }
   }//GEN-LAST:event_MedicinesJListValueChanged

   private void AccountActionRequestsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AccountActionRequestsJListValueChanged
      try
      {
         if(!evt.getValueIsAdjusting() && !AccountActionModel.isEmpty() && !AccountActionRequestsJList.isSelectionEmpty())
         {
           AccountActionRequest selectedAction = (AccountActionRequest)AccountActionModel.getElementAt(AccountActionRequestsJList.getSelectedIndex());
           AccountActionWindow actionWindow = new AccountActionWindow(selectedAction, this.WindowSecretary);
           actionWindow.SubFrameCloseListener(this);
           AccountActionRequestsJList.clearSelection();
         }
      }
      catch(NullPointerException e)
      {
      }
   }//GEN-LAST:event_AccountActionRequestsJListValueChanged

   private void AppointmentRequestsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AppointmentRequestsJListValueChanged
      try
      {
         if(!evt.getValueIsAdjusting() && !AppointmentRequestsModel.isEmpty() && !AppointmentRequestsJList.isSelectionEmpty())
         {
           AppointmentRequest appointmentRequest = (AppointmentRequest)AppointmentRequestsModel.getElementAt(AppointmentRequestsJList.getSelectedIndex());
           CreateAppointmentWindow appointmentWindow = new CreateAppointmentWindow(appointmentRequest, this.WindowSecretary);
           appointmentWindow.SubFrameCloseListener(this);
           AppointmentRequestsJList.clearSelection();
         }
      }
      catch(NullPointerException e)
      {
      }
   }//GEN-LAST:event_AppointmentRequestsJListValueChanged

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
         java.util.logging.Logger.getLogger(SecretaryHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(SecretaryHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(SecretaryHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(SecretaryHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new SecretaryHomeWindow().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPanel AccountActionRequests;
   private javax.swing.JList<String> AccountActionRequestsJList;
   private javax.swing.JList<String> AppointmentRequestsJList;
   private javax.swing.JPanel AppointmentRequestsJPanel;
   private javax.swing.JTextField MedicineNameJTextField;
   private javax.swing.JList<String> MedicinesJList;
   private javax.swing.JTextField PatientNameJTextField;
   private javax.swing.JList<String> PatientsJList;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   // End of variables declaration//GEN-END:variables

   @Override
   public void onSubFrameClose(JFrame childFrame) {
      loadBehaviour = new LoadObjectsFromFile();
     this.directory = new ListableDirectory.ListableTemplateBuilder()
      .AddTopLevelFolder("users")
      .AddFolderUID(WindowSecretary.getUID())
      .AddSubFolder("accountactions")
      .Build();
      this.AccountActionModel = loadBehaviour.LoadAll(directory);
      AccountActionRequestsJList.setModel(AccountActionModel);

      
      this.directory = new ListableDirectory.ListableTemplateBuilder()
      .AddTopLevelFolder("users")
      .AddFolderUID(WindowSecretary.getUID())
      .AddSubFolder("appointments")
      .Build();
      this.AppointmentRequestsModel = loadBehaviour.LoadAll(directory);
      AppointmentRequestsJList.setModel(AppointmentRequestsModel);
      
      this.directory = new ListableDirectory.ListableTemplateBuilder()
      .AddTopLevelFolder("medicines")
      .Build();
      this.MedicinesModel = loadBehaviour.LoadAll(directory);
      MedicinesJList.setModel(MedicinesModel);
      
      childFrame.dispose();
   }
}
