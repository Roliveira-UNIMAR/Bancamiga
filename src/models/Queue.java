package models;

/**
 *
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Queue<T> {
    private Node<T> top, tail;
    private int size;

    /**
     * Constructor por defecto de la cola
     */
    public Queue() {
        top = tail = null;
        size = 0;
    }
    
    /**
     * Metodo que retorna la longitud de la cola
     * 
     * @return La longitud de la cola 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Metodo que verifica si la cola esta vacia
     * 
     * @return true si la cola esta vacia, false si la cola no esta vacia 
     */
    public Boolean isEmpty() {
        return (top == null);
    }
    
     /**
     * Metodo que retorna el frente de la cola
     * 
     * @return null si la cola esta vacia, sino el valor contenido en el frente
     */
    public T front() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getValue();
        }
    }
    
    /**
     * Metodo que inserta al final de la cola
     * 
     * @param v El nuevo nodo de la cola 
     */
    public void enqueue(T v) {
        Node<T> newNode = new Node(v, null);
        if (isEmpty()) {
            top = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
    
     /**
     * Metodo que remueve al principio de la cola
     * 
     * @return El valor contenido en el frente de la cola
     */
    public T dequeue() {
        T aux;
        if (isEmpty()) {
            aux = null;
        } else {
            aux = top.getValue();
            top = top.getNext();
            size--;
            if (isEmpty()){
                tail = null;
            }
        }
        return aux;
    }

}