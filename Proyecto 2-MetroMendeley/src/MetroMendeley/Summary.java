/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetroMendeley;

/**
 *
 * @author Rolando
 */



public class Summary {
    
    private String title;
    private LinkedList<Author> authors;
    private String body;
    private LinkedList<String> keywords;
    private long key;

    /**
     * Constructor
     * @param title
     * @param authors
     * @param body
     * @param keywords 
     */
    public Summary(String title, LinkedList authors, String body, LinkedList keywords) {
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.keywords = keywords;
    }
    
    /**
     * Arma un String con lo requerido en el análisis del Resumen
     * @return String con el formato del análisis
     */
    public String displayAnalysis() {
        String display = "";
        
        display += getTitle() + "\n\n";
        display += "Autores: ";
        
        for (int i = 0; i < authors.getSize(); i++) {
            display += authors.getElement(i).getName() + ", ";
        }
        display += "\n\n";
        
        for (int i = 0; i < keywords.getSize(); i++) {
            display += keywords.getElement(i) + ": " + Integer.toString(keywordFrequency(keywords.getElement(i))) + " veces\n";
        }
        
        return display;    
    }
    
    /**
     * Arma un String con los detalles de un Resumen
     * @return String con la información del Resumen
     */
    public String displayDetails() {
        String display = "";
        
        display += getTitle() + "\n\n";
        display += "Autores: ";
        
        for (int i = 0; i < authors.getSize(); i++) {
            display += authors.getElement(i).getName() + ", ";
        }
        display += "\n\n";
        
        display += "Resumen: \n" + getBody() + "\n\n";
        
        display += "Palabras Claves: ";
        for (int i = 0; i < keywords.getSize(); i++) {
            display += keywords.getElement(i) + ", ";
        }
        
        return display;  
    }
    
    /**
     * Determina la frecuencia de cada palabra clave en un Resumen
     * @param keyword
     * @return El número de veces que aparece la palabra clave en el cuerpo del Resumen
     */
    public int keywordFrequency(String keyword) {
        int frequency = 0;
        
        String[] bodySplit = getBody().split("\n");
        
        for (int i = 0; i < bodySplit.length; i++) {
            if (bodySplit[i].toLowerCase().contains(keyword.toLowerCase())) {
                frequency++;
            }
        }
        
        return frequency;
    }
   
    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList getAuthors() {
        return authors;
    }

    public void setAuthors(LinkedList authors) {
        this.authors = authors;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LinkedList getKeywords() {
        return keywords;
    }

    public void setKeywords(LinkedList keywords) {
        this.keywords = keywords;
    }
    
    
}
