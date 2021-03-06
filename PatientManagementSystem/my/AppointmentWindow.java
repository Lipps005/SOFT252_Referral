/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import my.models.Appointment;
import my.models.userevents.IEventPropertiesBehaviour;
import my.models.Prescription;
import my.models.userevents.Listable.ListableDirectory;
import my.models.userevents.SetPropertiesAsDoctor;
import my.models.userevents.SetPropertiesAsPatient;
import my.models.userevents.SetPropertiesAsSectretary;
import my.models.userevents.SubFrameCloseListener;
import my.models.userevents.SubFrameModelAddListener;

/**
 *
 * @author samue
 */
public class AppointmentWindow extends javax.swing.JFrame implements SubFrameModelAddListener{
   private Appointment WindowAppointment;
   private IEventPropertiesBehaviour behaviour;
   SubFrameCloseListener listener;

   public AppointmentWindow(Appointment thisAppointment, IEventPropertiesBehaviour behaviour) {
      initComponents();
      this.WindowAppointment = thisAppointment;
      this.behaviour = behaviour;
      this.behaviour.setPropertyRights(this);
      this.Appointment_Treatment_JTextField.setText(WindowAppointment.getTreatmentNotes());
      this.App_Date_JLabel.setText(WindowAppointment.getAppointmentDate().toString());
      this.App_Time_JLabel.setText(WindowAppointment.getAppointmentTime().toString());
      this.DoctorNameJLabel.setText(WindowAppointment.getDoctorID());
      this.PatientNameJLabel1.setText(WindowAppointment.getPatientID());
      this.AppointmentPrescriptionsJList.setModel(this.WindowAppointment.PrescribedMedicines);
      this.setVisible(true);
   }
   
   public void setTreatmentVisibility(boolean visibilityRight)
   {
      Appointment_Treatment_JTextField.setVisible(visibilityRight);
   }
   public void setTreatmentEditability(boolean visibilityRight)
   {
      Appointment_Treatment_JTextField.setEditable(visibilityRight);
   }
   
   public void setSaveButtonEnabled(boolean visibilityRight)
   {
      App_Save_JButton.setEnabled(visibilityRight);
   }
   
   public void setPrescriptionAddButtonEnabled(boolean visibilityRight)
   {
      PrescriptionAddJButton.setEnabled(visibilityRight);
   }


   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jToolBar1 = new javax.swing.JToolBar();
      Appointment_DoctorPanel = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      Appointment_Treatment_JTextField = new javax.swing.JTextArea();
      jLabel3 = new javax.swing.JLabel();
      App_Save_JButton = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      AppointmentPrescriptionsJList = new javax.swing.JList<>();
      PrescriptionAddJButton = new javax.swing.JButton();
      Appointment_InfoPanel = new javax.swing.JPanel();
      App_PatientName_JLabel = new javax.swing.JLabel();
      App_DoctorName_JLabel = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      App_Date_JLabel = new javax.swing.JLabel();
      App_Time_JLabel = new javax.swing.JLabel();
      DoctorNameJLabel = new javax.swing.JLabel();
      PatientNameJLabel1 = new javax.swing.JLabel();

      jToolBar1.setRollover(true);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      Appointment_Treatment_JTextField.setColumns(20);
      Appointment_Treatment_JTextField.setLineWrap(true);
      Appointment_Treatment_JTextField.setRows(5);
      Appointment_Treatment_JTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            Appointment_Treatment_JTextFieldCaretUpdate(evt);
         }
      });
      jScrollPane1.setViewportView(Appointment_Treatment_JTextField);

      jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel3.setText("Notes");

      App_Save_JButton.setText("Save");
      App_Save_JButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            App_Save_JButtonActionPerformed(evt);
         }
      });

      jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel4.setText("Prescriptions");

      AppointmentPrescriptionsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jScrollPane2.setViewportView(AppointmentPrescriptionsJList);

      PrescriptionAddJButton.setText("ADD");
      PrescriptionAddJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            PrescriptionAddJButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout Appointment_DoctorPanelLayout = new javax.swing.GroupLayout(Appointment_DoctorPanel);
      Appointment_DoctorPanel.setLayout(Appointment_DoctorPanelLayout);
      Appointment_DoctorPanelLayout.setHorizontalGroup(
         Appointment_DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(Appointment_DoctorPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(Appointment_DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
               .addGroup(Appointment_DoctorPanelLayout.createSequentialGroup()
                  .addGroup(Appointment_DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel3)
                     .addComponent(jLabel4))
                  .addGap(0, 0, Short.MAX_VALUE))
               .addComponent(jScrollPane2)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Appointment_DoctorPanelLayout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addGroup(Appointment_DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(PrescriptionAddJButton)
                     .addComponent(App_Save_JButton))))
            .addContainerGap())
      );
      Appointment_DoctorPanelLayout.setVerticalGroup(
         Appointment_DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(Appointment_DoctorPanelLayout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(PrescriptionAddJButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
            .addComponent(App_Save_JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      App_PatientName_JLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      App_PatientName_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      App_PatientName_JLabel.setText("Patient");

      App_DoctorName_JLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
      App_DoctorName_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      App_DoctorName_JLabel.setText("Doctor");

      jLabel1.setText("Date:");

      jLabel2.setText("Time:");

      App_Date_JLabel.setText("10/01/2020");

      App_Time_JLabel.setText("10:15");

      javax.swing.GroupLayout Appointment_InfoPanelLayout = new javax.swing.GroupLayout(Appointment_InfoPanel);
      Appointment_InfoPanel.setLayout(Appointment_InfoPanelLayout);
      Appointment_InfoPanelLayout.setHorizontalGroup(
         Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
            .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(App_PatientName_JLabel)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(PatientNameJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(App_Date_JLabel))
                     .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(App_Time_JLabel))))
               .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(App_DoctorName_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(DoctorNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      Appointment_InfoPanelLayout.setVerticalGroup(
         Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
            .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(App_PatientName_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addComponent(PatientNameJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(11, 11, 11)
            .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(Appointment_InfoPanelLayout.createSequentialGroup()
                  .addGap(1, 1, 1)
                  .addComponent(App_DoctorName_JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
               .addComponent(DoctorNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(App_Date_JLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(Appointment_InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(App_Time_JLabel))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(Appointment_DoctorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(Appointment_InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(Appointment_InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(Appointment_DoctorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void Appointment_Treatment_JTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Appointment_Treatment_JTextFieldCaretUpdate
      this.WindowAppointment.setTreatmentNotes(Appointment_Treatment_JTextField.getText());
   }//GEN-LAST:event_Appointment_Treatment_JTextFieldCaretUpdate

   private void PrescriptionAddJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrescriptionAddJButtonActionPerformed
      NewPrescriptionWindow prescriptionWindow = new NewPrescriptionWindow();
      prescriptionWindow.SubFrameModelAddListener(this);
   }//GEN-LAST:event_PrescriptionAddJButtonActionPerformed

   private void App_Save_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_App_Save_JButtonActionPerformed
      for(int i = 0; i < this.WindowAppointment.PrescribedMedicines.getSize(); i++)
      {
         Prescription p = (Prescription)this.WindowAppointment.PrescribedMedicines.elementAt(i);
         p.savePrescription(this.WindowAppointment.getPatientID());
      }
      
      ListableDirectory actionDirectory = new ListableDirectory
              .ListableTemplateBuilder()
              .AddTopLevelFolder("users")
              .AddFolderUID(this.WindowAppointment.getDoctorID())
              .AddSubFolder("appointments")
              .Build();
            String string = actionDirectory.GetDirectory()+this.WindowAppointment.getUID().toString()+".ser";
            File file = new File(string);
            file.delete();
      this.WindowAppointment.saveAppointment(this.WindowAppointment.getPatientID());
      
      JOptionPane.showMessageDialog(null, "The new appointment has been saved.", "Appointment Saved", JOptionPane.INFORMATION_MESSAGE);
      listener.onSubFrameClose(this);
   }//GEN-LAST:event_App_Save_JButtonActionPerformed

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
         java.util.logging.Logger.getLogger(AppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(AppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(AppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(AppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new AppointmentWindow(null, new SetPropertiesAsPatient()).setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel App_Date_JLabel;
   private javax.swing.JLabel App_DoctorName_JLabel;
   private javax.swing.JLabel App_PatientName_JLabel;
   private javax.swing.JButton App_Save_JButton;
   private javax.swing.JLabel App_Time_JLabel;
   private javax.swing.JList<String> AppointmentPrescriptionsJList;
   private javax.swing.JPanel Appointment_DoctorPanel;
   private javax.swing.JPanel Appointment_InfoPanel;
   private javax.swing.JTextArea Appointment_Treatment_JTextField;
   private javax.swing.JLabel DoctorNameJLabel;
   private javax.swing.JLabel PatientNameJLabel1;
   private javax.swing.JButton PrescriptionAddJButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JToolBar jToolBar1;
   // End of variables declaration//GEN-END:variables

   void SubFrameCloseListener(DoctorHomeWindow subFrameCloseListener) {
      this.listener = subFrameCloseListener;
   }

   @Override
   public void onSubFrameNewModel(Object o) {
      this.WindowAppointment.PrescribedMedicines.addElement(o);
      this.AppointmentPrescriptionsJList.setModel(this.WindowAppointment.PrescribedMedicines);
   }



 
}
