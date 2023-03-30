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
public class HashTable<K, V> {
    
    private LinkedList<HashNode<K, V>>[] bucketArray;
    private int capacity;
    private int size;
    
    /**
     * Constructor
     * @param capacity 
     */
    public HashTable(int capacity) {
        this.bucketArray = new LinkedList[capacity];
        this.capacity = capacity;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray[i] = new LinkedList();
        }
    }
    /**
     * Constructor
     */
    public HashTable() {
        this.bucketArray = new LinkedList[50];
        this.capacity = 50;
        this.size = 0;
        
        for (int i = 0; i < capacity; i++) {
            bucketArray[i] = new LinkedList();
        }
    }
    
    /**
     * Calcula el índice en el que se debe insertar en el Bucket
     * @param key
     * @return Índice a insertar en el Bucket
     */
    public int getBucketIndex(long key){
        double R = 0.618034;
        double d;
        int index;
        d = R * key - Math.floor(R * key); // parte decimal
        index = (int) (this.capacity * d);
        return index;
        
    }    


    /**
     * Genera el HashCode de la llave que se le pasa
     * @param string
     * @return 
     */
    public long generateHashCode(String string){
        long key;
        key = 0; 
        for (int j = 0; j < Math.min(10, string.length()); j++){
            key = key * 27 + (int) string.charAt(j);
        }
        if (key<0)
            key = -key;
        return key;
        
    }
    
    /**
     * Busca dentro de la HashTable una Key dada
     * @param summaryTitle
     * @return El Value de la Key dada
     */
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
    
    /**
     * Crea una lista con los resúmenes en los que aparece una Palabra Clave dada
     * @param keyword
     * @return La lista con los resúmenes de la Palabra Clave dada
     */
     public LinkedList<V> filterByKeyword(String keyword){
        long hashCode = generateHashCode(keyword);
        int bucketIndex = getBucketIndex(hashCode);
        
        LinkedList<V> summaryList = new LinkedList<>();
        LinkedList <HashNode <K,V>> list = this.bucketArray[bucketIndex];
        Nodo <HashNode<K,V>> head = list.getHead();
        
        if(head == null){
            return null;
        }
        
        while(head != null){
            summaryList.addLast(head.getData().getValue());
            head = head.getNext();
        }
        return summaryList;
        
    }
    
    /**
     * Agrega un resumen a la Hash Table utilizando como Key el título del mismo
     * @param summary 
     */
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

        HashNode<K, V> newNode = new HashNode<>( (K) key, (V) summary, hashCode);
        getBucketArray()[bucketIndex].addLast(newNode);   
    }
    
    
    public void add2(Summary summary) {
        LinkedList<String> keys = summary.getKeywords();
        
        for (int i = 0; i > keys.getSize(); i++){
            
            String key = (keys.getElement(i));
            
            long hashCode = generateHashCode(key);
            int bucketIndex = getBucketIndex(hashCode);
        
       
            size++;

            HashNode<K, V> newNode = new HashNode<>( (K) key, (V) summary, hashCode);
            getBucketArray()[bucketIndex].addLast(newNode); 
        }
    }

    /**
     * Función que determina si la Hash Table esta vacía o no
     * @return Booleano que indica si esta vacío o no
     */
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
