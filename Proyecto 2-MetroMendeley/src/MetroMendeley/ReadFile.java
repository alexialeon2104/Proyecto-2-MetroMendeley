/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetroMendeley;

import static UserInterface.MainUI.authorsList;
import static UserInterface.MainUI.summarysList;
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
                        } else if (line.contains("Palabras claves:")) {
                            txt += line.replace("Palabras claves:", "Palabras Claves:") + "\n";
                        } else {
                            txt += line + "\n";
                        }
                    } else {
                        txt += "\n";
                    }
                }
                br.close();
                
                return txt; 
            }
 
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e);
        }
        return null;
    }
    
    public Summary readSummary(String txt) {
        
        String[] split = txt.split("~");
        
        if (split[0].contains("\n")) {
            split[0] = split[0].replace("\n", "");
        }
        //Título
        String title = split[0];
        
        for (int i = 0; i < summarysList.getSize(); i++) {
            if(title.equals(summarysList.getElement(i).getTitle())) {
                JOptionPane.showMessageDialog(null, "Ese resumen ya ha sido agregado previamente");
                return null;
            }
        }
        
        String[] splitAuthors = split[1].split("\n");
        //Autores
        LinkedList authors = new LinkedList();
        
        for (int i = 0; i < splitAuthors.length; i++) {
            if (!splitAuthors[i].equals("")) {
                Author author = new Author(splitAuthors[i]);
                authors.addLast(author);
            }
        }
        
        String[] bodySplit = null;
        
        
        if (split[2].contains("\n\n")) {
            bodySplit = split[2].split("\n\n");
        
        } else if (split[2].contains("\n\n\n")) {
            bodySplit = split[2].split("\n\n\n");
        } else {
            String[] lineSplit = split[2].split("\n");
            String bodyDefSplit = "";
            for (int j = 0; j < lineSplit.length; j++) {
                if (lineSplit[j].contains("Palabras")) {
                    lineSplit[j] = lineSplit[j].replace("Palabras", "\n\nPalabras");
                    
                } 
                bodyDefSplit += lineSplit[j];
            }
            bodySplit = bodyDefSplit.split("\n\n");
                
        }

        //Body
        String body = bodySplit[0];

        String keywordsSplit = bodySplit[1];

        
        if (keywordsSplit.contains("Palabras Claves: ")) {
            keywordsSplit = keywordsSplit.replace("Palabras Claves: ", "");
        } else {
            keywordsSplit = keywordsSplit.replace("Palabras claves: ", "");
        }
        
        //Keywords
        LinkedList keywords = new LinkedList();
        
        String[] keywordsSplitted = keywordsSplit.split(", ");

        for (int i = 0; i < keywordsSplitted.length; i++) {
            if (!keywordsSplitted[i].equals("") || !keywordsSplitted[i].equals("\n")) {
                if (keywordsSplitted[i].contains("\n")) {
                    keywordsSplitted[i] = keywordsSplitted[i].replace("\n", "");
                }
                keywords.addLast(keywordsSplitted[i]);
            }  
        }

        Summary summary = new Summary(title, authors, body, keywords);
        
        summarysList.addLast(summary);
        
        for (int i = 0; i < summary.getAuthors().getSize(); i++) {
            Author author = (Author) summary.getAuthors().getElement(i);
            
            if (authorsList.searchAuthor(author.getName()) == null) {
               authorsList.addLast(author);
            } else {
              Author authorExisting = authorsList.searchAuthor(author.getName());
              authorExisting.addArticle(summary.getTitle());
            }
            
            if (author.getArticles().searchElement(summary.getTitle()) == null) {
                author.addArticle(summary.getTitle());
            }    
        }   
        return summary;
    }
   
}
