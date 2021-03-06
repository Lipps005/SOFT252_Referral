/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.*;
import my.models.*;
import my.models.userevents.*;
import my.models.userevents.Listable.FilterRemovePrecedingDate;
import my.models.userevents.Listable.FilterRemoveSucceedingDate;
import my.models.userevents.Listable.IFilterByDateTimeBehaviour;
import my.models.userevents.Listable.ILoadAllBehaviour;
import my.models.userevents.Listable.ListableDirectory;
import my.models.userevents.Listable.LoadObjectsFromFile;

/**
 *
 * @author samue
 */
public class PatientHomeWindow extends javax.swing.JFrame {

   private final Patient WindowPatient; 
   private DefaultListModel UpcomingAppointmentsModel;
   private DefaultListModel PendingPrescriptionsModel;
   private DefaultListModel PastAppointmentsModel;
   private ListableDirectory directory;
   private ILoadAllBehaviour loadBehaviour;
   private IFilterByDateTimeBehaviour dateTimeFilter;
   
   
   public boolean getUserStatus()
   {
      if(this.WindowPatient == null)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   public PatientHomeWindow(String UID, String Password) {
      initComponents();
      boolean LoggedIn = false;
      Patient patient = (Patient) User.loadUser(UID);
      if(patient != null)
      {
        if(patient.verifyPassword(Password) == true && patient.getAccountStatus() == User.AccountStatus.ACTIVE)
        {
           LoggedIn = true;
        }
      }
      
      if(LoggedIn == true)
      {
         this.WindowPatient = (Patient) User.loadUser(UID);
         this.setTitle(this.WindowPatient.getSearchString());
         this.setVisible(LoggedIn);
         this.directory = new ListableDirectory.ListableTemplateBuilder()
                 .AddTopLevelFolder("users")
                 .AddFolderUID(UID)
                 .AddSubFolder("appointments")
                 .Build();
         loadBehaviour = new LoadObjectsFromFile();
         this.UpcomingAppointmentsModel = loadBehaviour.LoadAll(directory);
         this.dateTimeFilter = new FilterRemovePrecedingDate();
         this.UpcomingAppointmentsModel = dateTimeFilter.filterByDateTime(UpcomingAppointmentsModel, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
         this.UpcomingAppointmentsJList.setModel(UpcomingAppointmentsModel);
         this.PastAppointmentsModel = loadBehaviour.LoadAll(directory);
         this.dateTimeFilter = new FilterRemoveSucceedingDate();
         this.PastAppointmentsModel = dateTimeFilter.filterByDateTime(PastAppointmentsModel, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
         this.PastAppointmentsJList.setModel(PastAppointmentsModel);
         this.directory.setSubFolder("prescriptions");
         this.PendingPrescriptionsModel = loadBehaviour.LoadAll(directory);
         this.PendingPrescriptionsJList.setModel(PendingPrescriptionsModel);
      }
      else
      {
         this.WindowPatient = null;
      }
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel5 = new javax.swing.JLabel();
      UpcomingAppointmentsJPanel = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      UpcomingAppointmentsJList = new javax.swing.JList<>();
      PendingPrescriptionsJPanel = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      PendingPrescriptionsJList = new javax.swing.JList<>();
      PatientHistoryJPanel = new javax.swing.JPanel();
      jScrollPane3 = new javax.swing.JScrollPane();
      PastAppointmentsJList = new javax.swing.JList<>();
      jPanel1 = new javax.swing.JPanel();
      RequestAppointmentJButton = new javax.swing.JButton();

      jLabel5.setText("jLabel5");

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      UpcomingAppointmentsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Upcoming Appointments"));

      UpcomingAppointmentsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      UpcomingAppointmentsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            UpcomingAppointmentsJListValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(UpcomingAppointmentsJList);

      javax.swing.GroupLayout UpcomingAppointmentsJPanelLayout = new javax.swing.GroupLayout(UpcomingAppointmentsJPanel);
      UpcomingAppointmentsJPanel.setLayout(UpcomingAppointmentsJPanelLayout);
      UpcomingAppointmentsJPanelLayout.setHorizontalGroup(
         UpcomingAppointmentsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
      );
      UpcomingAppointmentsJPanelLayout.setVerticalGroup(
         UpcomingAppointmentsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
      );

      PendingPrescriptionsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Pending Prescriptions"));

      PendingPrescriptionsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jScrollPane2.setViewportView(PendingPrescriptionsJList);

      javax.swing.GroupLayout PendingPrescriptionsJPanelLayout = new javax.swing.GroupLayout(PendingPrescriptionsJPanel);
      PendingPrescriptionsJPanel.setLayout(PendingPrescriptionsJPanelLayout);
      PendingPrescriptionsJPanelLayout.setHorizontalGroup(
         PendingPrescriptionsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
      );
      PendingPrescriptionsJPanelLayout.setVerticalGroup(
         PendingPrescriptionsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
      );

      PatientHistoryJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("My History"));

      PastAppointmentsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      PastAppointmentsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            PastAppointmentsJListValueChanged(evt);
         }
      });
      jScrollPane3.setViewportView(PastAppointmentsJList);

      javax.swing.GroupLayout PatientHistoryJPanelLayout = new javax.swing.GroupLayout(PatientHistoryJPanel);
      PatientHistoryJPanel.setLayout(PatientHistoryJPanelLayout);
      PatientHistoryJPanelLayout.setHorizontalGroup(
         PatientHistoryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
      );
      PatientHistoryJPanelLayout.setVerticalGroup(
         PatientHistoryJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane3)
      );

      RequestAppointmentJButton.setText("Request Appointment");
      RequestAppointmentJButton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            RequestAppointmentJButtonMouseClicked(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(RequestAppointmentJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
            .addContainerGap())
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(RequestAppointmentJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(518, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(UpcomingAppointmentsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(PendingPrescriptionsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(PatientHistoryJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(UpcomingAppointmentsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(PendingPrescriptionsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(PatientHistoryJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void RequestAppointmentJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestAppointmentJButtonMouseClicked
      new RequestAppointmentWindow(this.WindowPatient.getUID()).setVisible(true);
   }//GEN-LAST:event_RequestAppointmentJButtonMouseClicked

   private void PastAppointmentsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_PastAppointmentsJListValueChanged
     try
     {
        if(!evt.getValueIsAdjusting() && !PastAppointmentsModel.isEmpty() && !PastAppointmentsJList.isSelectionEmpty())
        {
          Appointment historyAppointment = (Appointment)PastAppointmentsModel.getElementAt(PastAppointmentsJList.getSelectedIndex());
          AppointmentWindow appointmentWindow = new AppointmentWindow(historyAppointment, new SetPropertiesAsPatient()); 
          PastAppointmentsJList.clearSelection();
        }
        
     }
     catch(NullPointerException e)
     {
        
     }
   }//GEN-LAST:event_PastAppointmentsJListValueChanged

   private void UpcomingAppointmentsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_UpcomingAppointmentsJListValueChanged
     try
     {
        if(!evt.getValueIsAdjusting() && !UpcomingAppointmentsModel.isEmpty() && !UpcomingAppointmentsJList.isSelectionEmpty() )
        {
        Appointment upcomingAppointment = (Appointment)UpcomingAppointmentsModel.getElementAt(UpcomingAppointmentsJList.getSelectedIndex());
        AppointmentWindow appointmentWindow = new AppointmentWindow(upcomingAppointment, new SetPropertiesAsPatient());
        UpcomingAppointmentsJList.clearSelection();
        }
     }
     catch(NullPointerException e)
     {
        
     }
   }//GEN-LAST:event_UpcomingAppointmentsJListValueChanged

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
         java.util.logging.Logger.getLogger(PatientHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(PatientHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(PatientHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(PatientHomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new PatientHomeWindow().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JList<String> PastAppointmentsJList;
   private javax.swing.JPanel PatientHistoryJPanel;
   private javax.swing.JList<String> PendingPrescriptionsJList;
   private javax.swing.JPanel PendingPrescriptionsJPanel;
   private javax.swing.JButton RequestAppointmentJButton;
   private javax.swing.JList<String> UpcomingAppointmentsJList;
   private javax.swing.JPanel UpcomingAppointmentsJPanel;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   // End of variables declaration//GEN-END:variables
}
