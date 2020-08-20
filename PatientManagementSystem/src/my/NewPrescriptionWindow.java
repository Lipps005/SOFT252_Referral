/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import my.models.Appointment;
import my.models.Medicine;
import my.models.Prescription;
import my.models.userevents.Listable.FilterByString;
import my.models.userevents.Listable.ILoadAllBehaviour;
import my.models.userevents.Listable.ListableDirectory;
import my.models.userevents.Listable.LoadObjectsFromFile;
import my.models.userevents.SubFrameModelAddListener;

/**
 *
 * @author samue
 */
public class NewPrescriptionWindow extends javax.swing.JFrame implements SubFrameModelAddListener{
   
   
   //this is the appointment window thats listening for a new prescription
   private SubFrameModelAddListener listener;
   private DefaultListModel allMedicinesModel;
   private Prescription prescription;
   private FilterByString stringFilter;
   private ListableDirectory directory;
   private ILoadAllBehaviour loadBehaviour;
   
   public NewPrescriptionWindow() {
      initComponents();
      this.prescription = new Prescription();
      this.loadBehaviour = new LoadObjectsFromFile();
      this.directory = new ListableDirectory.ListableTemplateBuilder().AddTopLevelFolder("medicines").Build();
      this.allMedicinesModel = loadBehaviour.LoadAll(directory);
      this.AllMedicinesJList.setModel(this.allMedicinesModel);
      this.CreateMedicineJButton.setEnabled(false);
      SavePrescriptionJButton.setEnabled(false);
      this.MedicinePrescriptionAmountJSpinner.setEnabled(false);
      this.PrescriptionDoseJTextField.setEditable(false);
      this.setVisible(true);
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      AllMedicinesJList = new javax.swing.JList<>();
      SavePrescriptionJButton = new javax.swing.JButton();
      MedicineSearchJTextField = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      CreateMedicineJButton = new javax.swing.JButton();
      MedicinePrescriptionAmountJSpinner = new javax.swing.JSpinner();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      PrescriptionDoseJTextField = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      AllMedicinesJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      AllMedicinesJList.setToolTipText("");
      AllMedicinesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
         public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            AllMedicinesJListValueChanged(evt);
         }
      });
      jScrollPane1.setViewportView(AllMedicinesJList);

      SavePrescriptionJButton.setText("Save");
      SavePrescriptionJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            SavePrescriptionJButtonActionPerformed(evt);
         }
      });

      MedicineSearchJTextField.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            MedicineSearchJTextFieldCaretUpdate(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel1.setText("Dose:");

      CreateMedicineJButton.setText("Create Medicine");
      CreateMedicineJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            CreateMedicineJButtonActionPerformed(evt);
         }
      });

      MedicinePrescriptionAmountJSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
      MedicinePrescriptionAmountJSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
         public void stateChanged(javax.swing.event.ChangeEvent evt) {
            MedicinePrescriptionAmountJSpinnerStateChanged(evt);
         }
      });

      jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel2.setText("Search Medicine:");

      jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
      jLabel3.setText("Prescription Quantity:");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addComponent(MedicineSearchJTextField)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(SavePrescriptionJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(23, 23, 23))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CreateMedicineJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrescriptionDoseJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addGap(255, 255, 255)
                  .addComponent(MedicinePrescriptionAmountJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(20, 20, 20)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(715, Short.MAX_VALUE)))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
               .addContainerGap(408, Short.MAX_VALUE)
               .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(402, 402, 402)))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(76, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(CreateMedicineJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
               .addComponent(MedicineSearchJTextField))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(92, 92, 92)
                  .addComponent(MedicinePrescriptionAmountJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(PrescriptionDoseJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(266, 266, 266)
                  .addComponent(SavePrescriptionJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(45, 45, 45)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(516, Short.MAX_VALUE)))
         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
               .addGap(208, 208, 208)
               .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(353, Short.MAX_VALUE)))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void SavePrescriptionJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePrescriptionJButtonActionPerformed
      MedicinePrescriptionAmountJSpinnerStateChanged(null);
      this.listener.onSubFrameNewModel(this.prescription);
      this.prescription = new Prescription();
      this.SavePrescriptionJButton.setEnabled(false);
      this.AllMedicinesJList.clearSelection();
   }//GEN-LAST:event_SavePrescriptionJButtonActionPerformed

   private void MedicineSearchJTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_MedicineSearchJTextFieldCaretUpdate
      if(!allMedicinesModel.isEmpty())
      {
         this.stringFilter = new FilterByString();
         DefaultListModel model = stringFilter.filterByString(allMedicinesModel, MedicineSearchJTextField.getText());
         AllMedicinesJList.setModel(model);
         if(model.isEmpty())
         {
            this.CreateMedicineJButton.setEnabled(true);
         }
         else
         {
            this.CreateMedicineJButton.setEnabled(false);
         }
      }
      else
      {
         this.CreateMedicineJButton.setEnabled(true);
      }
   }//GEN-LAST:event_MedicineSearchJTextFieldCaretUpdate

   private void CreateMedicineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateMedicineJButtonActionPerformed

      Medicine newMedicine = new Medicine(MedicineSearchJTextField.getText());
      MedicineWindow medicineWindow = new MedicineWindow(newMedicine);
      medicineWindow.SubFrameModelAddListener(this);
      
   }//GEN-LAST:event_CreateMedicineJButtonActionPerformed

   private void MedicinePrescriptionAmountJSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MedicinePrescriptionAmountJSpinnerStateChanged
      this.SavePrescriptionJButton.setEnabled(false);
      try {
         MedicinePrescriptionAmountJSpinner.commitEdit();
         int amount = (int) MedicinePrescriptionAmountJSpinner.getValue();
         if(amount > 0)
         {
            this.prescription.setPrescriptionQuantity(amount);
            this.SavePrescriptionJButton.setEnabled(true);
         }
      } catch (ParseException ex) {
         
      }
      
   }//GEN-LAST:event_MedicinePrescriptionAmountJSpinnerStateChanged

   private void AllMedicinesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_AllMedicinesJListValueChanged
      this.MedicinePrescriptionAmountJSpinner.setEnabled(false);
      this.PrescriptionDoseJTextField.setEditable(false);
      if(AllMedicinesJList.isSelectionEmpty())
      {
         return;
      }
      if(!this.allMedicinesModel.isEmpty() && !evt.getValueIsAdjusting())
      {
         
         Medicine medicine = (Medicine)allMedicinesModel.getElementAt(AllMedicinesJList.getSelectedIndex());
         this.prescription.setMedicine(medicine.getSearchString());
         this.MedicinePrescriptionAmountJSpinner.setEnabled(true);
         this.PrescriptionDoseJTextField.setEditable(true);
      }
            

   }//GEN-LAST:event_AllMedicinesJListValueChanged

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
         java.util.logging.Logger.getLogger(NewPrescriptionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(NewPrescriptionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(NewPrescriptionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(NewPrescriptionWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new NewPrescriptionWindow().setVisible(true);
         }
      });
   }

   public void SubFrameModelAddListener (SubFrameModelAddListener listener) {
    this.listener = listener;
   }
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JList<String> AllMedicinesJList;
   private javax.swing.JButton CreateMedicineJButton;
   private javax.swing.JSpinner MedicinePrescriptionAmountJSpinner;
   private javax.swing.JTextField MedicineSearchJTextField;
   private javax.swing.JTextField PrescriptionDoseJTextField;
   private javax.swing.JButton SavePrescriptionJButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables

   @Override
   /*called when a new medicine is created 
   (or more specifically, when a medicine is saved.
   But since only clicking the create new medicine button
   raises a medicine window, and only a medicine window
   //will trigger this event, we can assume that this
   //event means a new medicine has been created
   */
   public void onSubFrameNewModel(Object o) {
      this.allMedicinesModel.addElement(o);
      AllMedicinesJList.setModel(this.allMedicinesModel);
      AllMedicinesJList.setSelectedIndex(0);
   }
}