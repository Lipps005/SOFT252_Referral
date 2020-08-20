/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import my.models.AppointmentRequest;
import my.models.AppointmentRequest;
import my.models.Doctor;
import my.models.userevents.Listable.FilterByString;
import my.models.userevents.Listable.IFilterByStringBehaviour;
import my.models.userevents.Listable.ILoadAllBehaviour;
import my.models.userevents.*;
import my.models.userevents.Listable.*;

/**
 *
 * @author samue
 */
public class RequestAppointmentWindow extends javax.swing.JFrame {
   private final AppointmentRequest request;
   private DefaultListModel AllDoctors;
   private final ListableDirectory directory;
   private ILoadAllBehaviour loadBehaviour;
   private IFilterByStringBehaviour filterBehaviour;
   /**
    * Creates new form RequestAppointmentWindow
    */
   public RequestAppointmentWindow(String PatientUID) {
      initComponents();
      this.request = new AppointmentRequest();
      this.request.setPatientUID(PatientUID);
      DateFromJTextField.setEnabled(false);
      DateToJTextField.setEnabled(false);
      SaveRequestJButton.setEnabled(false);
      this.directory = new ListableDirectory.ListableTemplateBuilder().AddTopLevelFolder("users").Build();
      this.loadBehaviour = new LoadUsers();
      this.filterBehaviour = new FilterByUID();
      this.AllDoctors = loadBehaviour.LoadAll(directory);
      this.AllDoctors = filterBehaviour.filterByString(AllDoctors, "D");
      DoctorsJList.setModel(AllDoctors);
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      DateFromJTextField = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      DateToJTextField = new javax.swing.JTextField();
      SaveRequestJButton = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      DoctorsJList = new javax.swing.JList<>();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel1.setText("Request Appointment");

      jLabel2.setText("Doctor");

      jLabel3.setText("Date From:");

      DateFromJTextField.setToolTipText("YYYY-MM-DD");
      DateFromJTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            DateFromJTextFieldCaretUpdate(evt);
         }
      });

      jLabel4.setText("Date To:");

      DateToJTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            DateToJTextFieldCaretUpdate(evt);
         }
      });

      SaveRequestJButton.setText("Save");
      SaveRequestJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            SaveRequestJButtonActionPerformed(evt);
         }
      });

      DoctorsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      DoctorsJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            DoctorsJListValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(DoctorsJList);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(24, 24, 24)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(DateToJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                     .addComponent(jLabel4)
                     .addComponent(jLabel1)
                     .addComponent(DateFromJTextField)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(222, 222, 222))
                     .addComponent(jLabel2)
                     .addComponent(jScrollPane1)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(113, 113, 113)
                  .addComponent(SaveRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(38, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addComponent(jLabel1)
            .addGap(64, 64, 64)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(44, 44, 44)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(DateFromJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(54, 54, 54)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(DateToJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
            .addComponent(SaveRequestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void DoctorsJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DoctorsJListValueChanged
      Doctor doctor = (Doctor)AllDoctors.get(DoctorsJList.getSelectedIndex());
      this.request.setDoctor(doctor.getUID());
      DateFromJTextField.setEnabled(true);
   }//GEN-LAST:event_DoctorsJListValueChanged

   private void DateFromJTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_DateFromJTextFieldCaretUpdate
     SaveRequestJButton.setEnabled(false);
      try
      {
         LocalDate DateFrom = LocalDate.parse(DateFromJTextField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
         if(DateFrom.isAfter(LocalDate.now()))
         {
            this.request.setDateFrom(DateFrom);
            DateToJTextField.setEnabled(true); 
         }

      }
      catch(DateTimeParseException e)
      {
         DateToJTextField.setEnabled(false);
      }
   }//GEN-LAST:event_DateFromJTextFieldCaretUpdate

   private void DateToJTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_DateToJTextFieldCaretUpdate
      SaveRequestJButton.setEnabled(false);
      try
      {
         LocalDate DateTo = LocalDate.parse(DateToJTextField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
         if(DateTo.isAfter(this.request.getDateFrom()))
         {
            this.request.setDateTo(DateTo);
            SaveRequestJButton.setEnabled(true);
         }

      }
      catch(DateTimeParseException e)
      {
         SaveRequestJButton.setEnabled(false);
      }
   }//GEN-LAST:event_DateToJTextFieldCaretUpdate

   private void SaveRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveRequestJButtonActionPerformed
      boolean saveSuccess = request.saveAppointmentRequest();
      if(saveSuccess == true)
      {
         JOptionPane.showMessageDialog(null, "Your request has been saved", "Request Sent", JOptionPane.INFORMATION_MESSAGE);
         this.dispose();
      }
      else
      {
         JOptionPane.showMessageDialog(null, "Something went wrong. Please try again", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
   }//GEN-LAST:event_SaveRequestJButtonActionPerformed

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
         java.util.logging.Logger.getLogger(RequestAppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(RequestAppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(RequestAppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(RequestAppointmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
           // new RequestAppointmentWindow().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField DateFromJTextField;
   private javax.swing.JTextField DateToJTextField;
   private javax.swing.JList<String> DoctorsJList;
   private javax.swing.JButton SaveRequestJButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
