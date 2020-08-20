/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import my.AppointmentWindow;

/**
 *
 * @author samue
 */
public class SetPropertiesAsDoctor implements IEventPropertiesBehaviour{

   @Override
   public void setPropertyRights(AppointmentWindow UEvent) 
   {
      UEvent.setTreatmentVisibility(true);
      UEvent.setTreatmentEditability(true);
   }



   
   
}
