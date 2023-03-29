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
public class Author {
    private String name;
    private LinkedList<String> articles;

    public Author(String name) {
        this.name = name;
        this.articles = new LinkedList();
    }
    
    public void addArticle(String summaryName) {
        getArticles().addLast(summaryName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList getArticles() {
        return articles;
    }

    public void setArticles(LinkedList articles) {
        this.articles = articles;
    }
    
    
}
