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
    
    private LinkedList<HashNode<K, V>>[] bucketArray;
    private int capacity;
    private int size;
    
    public HashTable(int capacity) {
        this.bucketArray = new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray[i] = new LinkedList();
        }
    }
    
    public HashTable() {
        this.bucketArray = new LinkedList[50];
        this.capacity = 50;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray[i] = new LinkedList();
        }
    }
    
    public int getBucketIndex(long key){
        double R = 0.618034;
        double d;
        int index;
        d = R * key - Math.floor(R * key); // parte decimal
        index = (int) (this.capacity * d);
        return index;
        
    }    


    
    public long generateHashCode(String summaryTitle){
        long key;
        key = 0; 
        for (int j = 0; j < Math.min(10, summaryTitle.length()); j++){
            key = key * 27 + (int) summaryTitle.charAt(j);
        }
        if (key<0)
            key = -key;
        return key;
        
    }
    public Summary get(String summaryTitle) {
        long hashCode = generateHashCode(summaryTitle);
        int bucketIndex = getBucketIndex(hashCode);
        
        for (int i = 0; i < bucketArray[bucketIndex].getSize(); i++) {
            if (bucketArray[bucketIndex].getElement(i).getHashCode() == hashCode && bucketArray[bucketIndex].getElement(i).getKey() == summaryTitle) {
                Summary summary = (Summary) bucketArray[bucketIndex].getElement(i).getValue();
                return summary;
            }
        }
        return null;
    }
    public void add(Summary summary) {
        String key = summary.getTitle();
        long hashCode = generateHashCode(key);
        int bucketIndex = getBucketIndex(hashCode);
        
        if (getBucketArray()[bucketIndex].getHead() != null) {
            Nodo<HashNode<K,V>> head = getBucketArray()[bucketIndex].getHead();
            while(head != null) {
                if (head.getData().getKey().equals(key) && head.getData().getHashCode() == hashCode) {
                 System.out.println("Ya el item esta agregado");
                    return;
                }
            head = head.getNext();
            }

        }
        
        size++;

        HashNode<K, V> newNode = new HashNode<K, V>( (K) key, (V) summary, hashCode);
        getBucketArray()[bucketIndex].addLast(newNode);   
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

    public LinkedList[] getBucketArray() {
        return bucketArray;
    }

    public void setBucketArray(LinkedList[] bucketArray) {
        this.bucketArray = bucketArray;
    }
    
    
    
}
