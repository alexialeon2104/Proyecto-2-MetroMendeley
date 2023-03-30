/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetroMendeley;

import javax.swing.JOptionPane;

/**
 *
 * @author Rolando Sorrentino
 * @param <T>
 */
public class LinkedList<T> {

    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    //Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    public LinkedList(Nodo<T> node) {
        this.head = this.tail = node;
        size++;
    }
    
    /**
     * 
     * @return Booleano; "true" si la lista está vacía, "false" si posee al menos un elemento
     */
    public boolean isEmpty() {
        return head == null;
    }

    public Nodo<T> addFirst(T element) {
        Nodo<T> node = new Nodo(element);

        if (isEmpty()) {
            setHead(node);
            setTail(node);

        } else {
            node.setNext(head);
            setHead(node);

        }
        size++;
        return node;
    }

    public Nodo<T> addLast(T element) {
        Nodo<T> node = new Nodo(element);

        if (isEmpty()) {
            setHead(node);
            setTail(node);

        } else {
            getTail().setNext(node);
            setTail(node);

        }
        size++;
        return node;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }

    public Nodo<T> addInIndex(int index, T element) {
        Nodo<T> node = new Nodo(element);

        if (isEmpty()) {
            setHead(node);

        } else {

            if (index >= getSize()) {
                JOptionPane.showMessageDialog(null, "The index is out of bounds. The element will be added on the last index.");
                return addLast(element);
            } else if (index == getSize() - 1) {
                return addLast(element);
            } else if (index == 0) {
                return addFirst(element);
            } else {
                Nodo<T> pointer = getHead();
                int counter = 0;
                while ((counter < (index - 1)) && pointer.getNext() != null) {
                    pointer = pointer.getNext();
                    counter++;

                }
                node.setNext(pointer.getNext());
                pointer.setNext(node);

            }
        }
        size++;
        return node;
    }

    public Nodo<T> deleteFirst() {

        if (!isEmpty()) {
            Nodo<T> pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Your list is empty");

        }
        return null;
    }

    public Nodo<T> deleteLast() {

        if (!isEmpty()) {
            Nodo<T> pointer = getHead();

            if (getSize() == 1) {
                setHead(null);
                setTail(null);
                size--;

            } else {
                while (pointer.getNext() != null && pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                }
                Nodo<T> nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                size--;
                return nodeReturn;

            }

        } else {
            JOptionPane.showMessageDialog(null, "Your list is empty");

        }

        return null;

    }

    public Nodo<T> deleteInIndex(int index) {
        if (!isEmpty()) {
            
            if (index >= getSize()) {
                JOptionPane.showMessageDialog(null, "The index is out of bounds. Instead, the last element will be deleted.");
                return deleteLast();

            } else if (index == getSize() - 1) {
                return deleteLast();
            } else if (index == 0) {
                return deleteFirst();
            } else {
                Nodo pointer = getHead();
                int counter = 0;
                while (counter < (index - 1) && pointer.getNext() != null) {
                    pointer = pointer.getNext();
                    counter++;

                }
               Nodo<T> aux = pointer.getNext();
                pointer.setNext(aux.getNext());
                aux.setNext(null);
                size--; 
            }
            
        }
        return null;

    }
    
    
    public String printList() {
        String sList = "";
        
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Your list is empty");

        } else {
            sList = "[ ";

            for (int i = 0; i < getSize(); i++) {

                if (i == getSize() - 1) {
                    sList += getElement(i);
                } else {
                    sList += getElement(i) + ", ";
                }
            }
            sList += " ]";
        }
        return sList;
    }
    
    public T searchElement(T element) {
        if (isEmpty()) {
            
            return null;

        } else {
            Nodo<T> pointer = getHead();
            
            while (pointer != null) {
                if(pointer.getData() == element) {
                    return pointer.getData();

                }
                pointer = pointer.getNext();
            }
        }
        return null;
    }
    
    public void setElement(int index, T element) {
        Nodo<T> node = new Nodo(element);
        if(isEmpty() || index == 0) {
            setHead(node);
            
        } else if (index == getSize() - 1) {
            setTail(node);
        } else if (index > getSize() - 1) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar en esa posición");
        } else {
            Nodo<T> aux = getHead();
            int counter = 0;
            
            while(counter < index - 1) {
                aux = aux.getNext();
                counter++;
            }
            
            Nodo<T> toReplace = aux.getNext();
            
            node.setNext(toReplace.getNext());
            aux.setNext(node);
            toReplace.setNext(null);
        }
    }
    
    public Author searchAuthor(String authorName) {
        if (isEmpty()) {
            
            return null;

        } else {
            Nodo<Author> pointer = getHead();
            
            while (pointer != null) {
                if(pointer.getData().getName().equals(authorName)) {
                    return pointer.getData();

                }
                pointer = pointer.getNext();
            }
        }
        return null;    
    }
    
    public T getElement(int index) {
        if (isEmpty()) {
            return null;

        } else {
            Nodo<T> pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer.getData();

        }
    }

   
    //Getters and Setters
    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
