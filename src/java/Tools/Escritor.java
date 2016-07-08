/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author daniel
 */
public class Escritor {
    
    
    
    public void escribir(String ruta, String texto){
        try{
        
            File file = new File(ruta);
            // creates the file
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file); 
            // Writes the content to the file
            writer.write(texto); 
            writer.flush();
            writer.close();
        }catch(Exception e){
            System.out.println("No se pudo escribir el archivo");
        }
    }
}
