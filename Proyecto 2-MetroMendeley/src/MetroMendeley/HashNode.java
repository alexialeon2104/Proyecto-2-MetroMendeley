/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetroMendeley;

/**
 *
 * @author Rolando
 * @param <K>
 * @param <V>
 */
public class HashNode<K, V>{
    
    private K key; // Codigo a partir del Titulo del resumen
    private V value; // Objeto resumen
    private final long hashCode;
    private HashNode<K, V> next;
    
    public HashNode(K key, V value, long hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = null;
    }
    
    
    //Getters and Setters
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    public long getHashCode() {
        return hashCode;
    }
    
    
}
