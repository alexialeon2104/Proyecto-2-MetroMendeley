/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MetroMendeley;

/**
 *
 * @author alexi
 */
public class Proyecto2MetroMendeley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] autores = new String[2];
        autores[0]= "Alexia";
        autores[1] = "Rolando";
        HashTable hasht = new HashTable();
        
        Summary resumen = new Summary("Ejemplo de Titulo", autores, "cuerpo del libro", autores);
        System.out.println(resumen.transformTitle());
        System.out.println(hasht.hashFunction(resumen.transformTitle()));
        
    }
    
}
