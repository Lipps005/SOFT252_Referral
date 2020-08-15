/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author samue
 */
public class Doctor extends User{
   public Doctor(String UID)
   {
      this.UID = UID;
   }
   
//   public static DefaultListModel getAllDoctors()
//   {
//      DefaultListModel model = new DefaultListModel();
//      try
//        {    
//
//            // Reading the object from a file 
//            File folder = new File("users/");
//            File[] listOfFiles = folder.listFiles();
//
//            for (File file : listOfFiles) 
//            {
//               String filename = file.getName();
//               if (filename.contains("D")) 
//               {
//                  FileInputStream inFile = new FileInputStream("users/"+filename+"/"+filename+".ser"); 
//                  ObjectInputStream in = new ObjectInputStream(inFile); 
//                  Doctor doc = (Doctor) in.readObject(); 
//                  model.addElement(doc);
//       
//                  in.close(); 
//                  inFile.close(); 
//               }
//            }
//        } 
//          
//        catch(IOException | ClassNotFoundException ex) 
//        { 
//           System.out.println(ex);
//        } 
//      return model;
//   }

}
