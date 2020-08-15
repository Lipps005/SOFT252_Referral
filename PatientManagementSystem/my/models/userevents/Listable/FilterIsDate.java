/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents.Listable;

import java.time.LocalDateTime;
import javax.swing.DefaultListModel;

/**
 *
 * @author samue
 */
public class FilterIsDate implements IFilterByDateTimeBehaviour{
   @Override
   public DefaultListModel filterByDateTime(DefaultListModel model, LocalDateTime dateTime) {
      DefaultListModel returnmodel = new DefaultListModel();
      for(int i = 0; i <model.getSize(); i++)
      {
         ListableByDateTime listable = (ListableByDateTime)model.getElementAt(i);
         //if the date is equal to the incoming date keep.
         if(listable.getSearchDateTime().toLocalDate().equals(dateTime.toLocalDate()))
         {
            returnmodel.addElement(model.getElementAt(i));
         }
      }
      return returnmodel;
   }
}
