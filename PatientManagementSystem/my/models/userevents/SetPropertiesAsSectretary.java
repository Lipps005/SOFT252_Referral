/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents;

import my.AppointmentWindow;

/**
 *
 * @author samue
 */
public class SetPropertiesAsSectretary implements IEventPropertiesBehaviour{

   @Override
   public void setPropertyRights(AppointmentWindow UEvent)
   { 
      UEvent.setTreatmentVisibility(false);
      UEvent.setTreatmentEditability(false);
   }


   
}