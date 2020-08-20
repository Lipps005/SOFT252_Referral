/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents.Listable;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.DefaultListModel;

/**
 *
 * removing succeeding appointments means to remove all appointments after a certain date.
 * to do this, we will define an empty model. for each object in our model argument, if the 
 * models date is before the upper bound date, we will include it. 
 */
public class FilterRemoveSucceedingDate implements IFilterByDateTimeBehaviour{
   @Override
   public DefaultListModel filterByDateTime(DefaultListModel model, LocalDateTime dateTime) {
      DefaultListModel returnmodel = new DefaultListModel();
      for(int i = 0; i <model.getSize(); i++)
      {
         ListableByDateTime listable = (ListableByDateTime)model.getElementAt(i);
         //if the date is after or equal to the upper bound add to our return model.
         if(listable.getSearchDateTime().toLocalDate().isBefore(dateTime.toLocalDate()) 
            || listable.getSearchDateTime().toLocalDate().equals(dateTime.toLocalDate())
            && listable.getSearchDateTime().toLocalTime().isBefore(LocalTime.now()))
         {
            returnmodel.addElement(model.getElementAt(i));
         }
      }
      
      return returnmodel;
   }
}
