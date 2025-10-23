/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.DiaDeSpa;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DAIAN
 */
public class DiaDeSpaData {
    
    private List<DiaDeSpa> listaspa = new ArrayList<>();

    
    
    
    public void Crear (DiaDeSpa diadespa){
//faltan cosas
       listaspa.add(diadespa);
        System.out.println("Se creo un dia de spa" + diadespa.getCodPack());
       
        
    }
    
     public void AsociarSesiones (DiaDeSpa diadespa){
        
   
    }
    
      public void CalcularMonto (DiaDeSpa diadespa){
        
   
    }
    
       public void ListarDias (DiaDeSpa diadespa){
//faltan cosas
           System.out.println("Dias de spa");
           if (listaspa.isEmpty()) {
               System.out.println("Aun no hay dias de spa registrados. ");
return;
               
           }
           for (DiaDeSpa diaDeSpa : listaspa) {
               System.out.println("Codigo: "+ diaDeSpa.);
//faltan cosas
               
           }
               
           }
           
        
   
    }
    
        public void MostrarDetalle (DiaDeSpa diadespa){
        
   
    }
    
    
}
