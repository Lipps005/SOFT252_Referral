/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.models.userevents.Listable;

/**
 *
 * @author samue
 */
public class ListableDirectory {
   private String ToplevelFolder; //e.g, /user or /medicine
   private String FolderUID; //e.g, /P10201
   private String SubFolder; //e.g, /appointments or /prescriptions or //appointmentrequests
   
   public static class ListableTemplateBuilder
   {
      private String ToplevelFolder = ""; //e.g, /user or /medicine
      private String FolderUID = ""; //e.g, /P10201
      private String SubFolder = ""; //e.g, /appointments or /prescriptions or //appointmentrequests
      public ListableTemplateBuilder()
      {
         
      }
      
      public ListableTemplateBuilder AddTopLevelFolder(String TopLevel)
      {
         this.ToplevelFolder = TopLevel+"/";
         return this;
      }
      public ListableTemplateBuilder AddFolderUID(String FolderUID)
      {
         this.FolderUID = FolderUID+"/";
         return this;
      }
      public ListableTemplateBuilder AddSubFolder(String SubFolder)
      {
         this.SubFolder = SubFolder+"/";
         return this;
      }
      
      public ListableDirectory Build()
      {
         return new ListableDirectory(this);
      }
   }
   
   private ListableDirectory(ListableTemplateBuilder builder)
   {
      ToplevelFolder = builder.ToplevelFolder;
      FolderUID = builder.FolderUID;
      SubFolder = builder.SubFolder;
   }
   
   public String GetDirectory()
   {
      return ToplevelFolder+FolderUID+SubFolder;
   }
   
   public void setTopLevelFolder(String toplevel)
   {
      this.ToplevelFolder = toplevel;
   }
   
   public void setFolderUID(String folderUID)
   {
      this.FolderUID = folderUID;
   }
   
   public void setSubFolder(String subfolder)
   {
      this.SubFolder = subfolder;
   }
}
