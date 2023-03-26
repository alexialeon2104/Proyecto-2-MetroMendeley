/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetroMendeley;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando Sorrentino
 */
public class ReadFile {
   
    /**
     * Sobreescribe el archivo de texto dentro del proyecto
     * @param txt (String que contiene la información del archivo de texto leído)
     */
    public void printTxt(String txt) {
        try {
            File file = new File("test\\summarys.txt");
            PrintWriter pw = new PrintWriter("test\\summarys.txt");
            pw.print(txt);
            JOptionPane.showMessageDialog(null, "Se ha agregado esta información a la base de datos!");
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }
    
    /**
     * Agrega información al archivo de texto del proyecto
     * @param txt 
     */
    public void appendTxt(String txt) {
        try {
            File file = new File("test\\summarys.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.append(txt);
            pw.close();
            JOptionPane.showMessageDialog(null, "Se ha agregado esta información a la base de datos!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + e);
        }
    }
       
    
    /**
     * Lee un archivo de texto línea por línea y lo convierte en un string
     * @param path (Dirección donde se encuentra el archivo de texto a leer)
     * @return String que contiene la información del archivo de texto
     */
    public String readTxt(String path) {
        String line;
        String txt = "";
        File file = new File(path);
        ReadFile nfile = new ReadFile();
        try {
           if (!file.exists()) {
                file.createNewFile(); 
                
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                       if (line.contains("Autores") || line.contains("Resumen")) {
                            txt += "~" + "\n";
                       
                        } else {
                            txt += line + "\n";
                        }
                    } else {
                        txt += "\n";
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
                return txt; 
            }
 
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e);
        }
        return null;
    }
    
    public Summary readSummary(String txt) {
        
        String[] split = txt.split("~");
        //Título
        String title = split[0];
        
        String[] splitAuthors = split[1].split("\n");
        //Autores
        String[] authors = new String[splitAuthors.length - 1];
        
        int counter = 0;
        for (int i = 1; i < splitAuthors.length; i++) {
            authors[counter] = splitAuthors[i];
            counter++;
        }
        
        String[] bodySplit = split[2].split("\n\n");
        //Body
        String body = bodySplit[0];
        
        String keywordsSplit = bodySplit[1];
        
        if (keywordsSplit.contains("Palabras Claves: ")) {
            keywordsSplit = keywordsSplit.replace("Palabras Claves: ", "");
        } else {
            keywordsSplit = keywordsSplit.replace("Palabras claves: ", "");
        }
        
        //Keywords
        String[] keywords = keywordsSplit.split(", ");

        Summary summary = new Summary(title, authors, body, keywords);
        
        return summary;
    }
   
}
