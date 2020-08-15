/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents.Listable;

import javax.swing.DefaultListModel;

/**
 *
 * @author samue
 */
public class FilterNameIsString implements IFilterByStringBehaviour {

   @Override
   public DefaultListModel filterByString(DefaultListModel model, String filterString) {
      DefaultListModel returnmodel = new DefaultListModel();
      
      for(int i = 0; i < model.getSize(); i++ )
      {
         ListableByString listable = (ListableByString) model.getElementAt(i);
         if(listable.getSearchString().equals(filterString))
         {
            returnmodel.addElement(model.getElementAt(i));
         }
      }
      
     return returnmodel;
   }
   
}