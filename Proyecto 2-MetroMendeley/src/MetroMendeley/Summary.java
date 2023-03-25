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
    private String[] authors;
    private String body;
    private String[] keywords;
    private long key;

    public Summary(String title, String[] authors, String body, String[] keywords) {
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.keywords = keywords;
    }
    
    public long transformTitle(){
        long key;
        key = 0; 
        for (int j = 0; j < Math.min(10,this.getTitle().length()); j++){
        key = key * 27 + (int) this.getTitle().charAt(j);
        }
        if (key<0)
            key = -key;
        return key;
        
    }
   
   
    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
    
    
}
