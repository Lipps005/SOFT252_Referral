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
public interface IFilterByDateTimeBehaviour {
   public DefaultListModel filterByDateTime(DefaultListModel model, LocalDateTime dateTime);
}
