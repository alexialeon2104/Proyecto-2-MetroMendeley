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
public class HashTable<K, V> {
    
    private LinkedList<HashNode<K, V>> bucketArray;
    private int capacity;
    private int size;
    
    public HashTable(int capacity) {
        this.bucketArray = new LinkedList();
        this.capacity = capacity;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray.addLast(null);
        }
    }
    
    public HashTable() {
        this.bucketArray = new LinkedList();
        this.capacity = 50;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray.addLast(null);
        }
    }
    
    public int hashFunction(long key){
        double R = 0.618034;
        double d;
        int v;
        d = R * key - Math.floor(R * key); // parte decimal
        int index = (int) (this.capacity * d);
        return index;
    }
    
    public void add(Summary summary) {
        String key = summary.getTitle();
        int hashCode = (int) summary.transformTitle();
        int bucketIndex = hashFunction(hashCode);
        
        HashNode<K, V> head = getBucketArray().getElement(bucketIndex);
        
        while(head != null) {
            if (head.getKey().equals(key) && head.getHashCode() == hashCode) {
                System.out.println("Ya el item esta agregado");
                return;
            }
            head.getNext();
        }
        
        size++;
        head = getBucketArray().getElement(bucketIndex);
        
        HashNode<K, V> newNode = new HashNode<K, V>( (K) key, (V) summary, hashCode);
        newNode.setNext(head);
        
        bucketArray.setElement(bucketIndex, newNode);
        
        
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    //Getters and Setters
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LinkedList<HashNode<K, V>> getBucketArray() {
        return bucketArray;
    }

    public void setBucketArray(LinkedList<HashNode<K, V>> bucketArray) {
        this.bucketArray = bucketArray;
    }
    
    
    
}
