package models;

/**
 * Esta es la clase pila dinamica en java
 * 
 * @author Rodrigo Oliveira - 29.655.609
 */
public class Stack<T> {

    private Node<T> top;
    private int size;

    /**
     * Constructor por defecto de la pila
     */
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    
    /**
     * Metodo que retorna la longitud de la pila
     * 
     * @return size la longitud de la pila 
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Metodo que verifica si la pila esta vacia
     * 
     * @return true si la pila esta vacia, false si la pila no esta vacia 
     */
    public Boolean isEmpty() {
        return (this.top == null);
    }
    
    /**
     * Metodo que inserta en la cima un nodo
     * 
     * @param v El valor del nuevo nodo a la pila 
     */
    public void push(T v) {
        Node<T> newNode = new Node(v, this.top);
        this.top = newNode;
        this.size++;
    }
    
    /**
     * Metodo muestra la cima y la elimina de la pila
     *  
     * @return null si la pila esta vacia, sino el valor contenido en la cima
     */
    public T pop() {
        T aux;
        if (isEmpty()) {
            return null;
        } else {
            aux = this.top.getValue();
            this.top = this.top.getNext();
            this.size--;
            return aux;
        }
    }
    
    /**
     * Metodo muestra la cima sin elimilarla
     *
     * @return null si la pila esta vacia, el valor contenido en la cima
     */
    public Object peek() {
        if (isEmpty()) {
            return null;
        } else {
            return this.top.getValue();
        }
    }
}
