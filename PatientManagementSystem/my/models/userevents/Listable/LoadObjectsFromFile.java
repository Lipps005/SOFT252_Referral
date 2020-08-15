/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents.Listable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author samue
 */
public class LoadObjectsFromFile implements ILoadAllBehaviour{

   @Override
   public DefaultListModel LoadAll(ListableDirectory directory) {
      DefaultListModel returnmodel = new DefaultListModel();
      try
        {    

            // Reading the object from a file 
            File folder = new File(directory.GetDirectory());
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) 
            {
               if (file.isFile()) 
               {
                  FileInputStream inFile = new FileInputStream(file); 
                  ObjectInputStream in = new ObjectInputStream(inFile); 
                 returnmodel.addElement(in.readObject());
                  in.close(); 
                  inFile.close(); 
               }
            }
        } 
          
        catch(IOException | ClassNotFoundException ex) 
        { 
           System.out.println(ex);
        } 
      return returnmodel;
   }
   
}
