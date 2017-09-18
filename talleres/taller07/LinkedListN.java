
/**
 * Write a description of class LinkedList here.
 * 
 * @author Rafael Villegas Michel & Felipe Cortes Jaramillo
 * @version (a version number or a date)
 */
import java.lang.IndexOutOfBoundsException; 

public class LinkedListN
{
    public Node first;
    private int size;
    public LinkedListN(){
        size = 0;
        first = null;
    }
    
    //Retorna si el nodo esta en la lista enlazada (posicion)
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    //Retorna el contenido del nodo
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }
    
    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
            if(index == 0){
                Node nuevo = new Node(data);
                nuevo.next = first;
                first = nuevo;
                size++;
            }else{
            if(index >= 0 && index <= size){
                Node temp = first;
                for(int i = 1; i < index; i++){
                    temp  = temp.next;
                }
                Node nuevo = new Node(data);
                nuevo.next = temp.next;
                temp.next = nuevo;
                size++;  //Agrega Uno nuevo
            }else{
                throw new IndexOutOfBoundsException();            
            }
        }
    }

    // Borra el dato en la posición index
    public void remove(int index) throws IndexOutOfBoundsException
    {
        if(index == 0){
            Node nuevaposicion = first.next;
            first = nuevaposicion;
            first.next = nuevaposicion.next;
            size--;
        }else{    
        if(index >= 0 && index <= size){
            Node temp = first;
            for(int i = 1; i < index; i++){
                temp = temp.next;
            }
            Node refSiguiente = temp.next;
            temp.next = refSiguiente.next;
            size--;  //Remove un elemento
        }else{
            throw new IndexOutOfBoundsException();            
        }
    }
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node temp = first;
        for(int i = 0; i <= size - 1; i++){
            if(temp.data==data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    //Compara si dos listas enlazadoas son iguales en tamaño y contenido
    public boolean equals (LinkedListN list2){
        if(size != list2.size()){
            return false;
        }else{
            Node n1 = first;
            Node n2 = list2.first;
            for(int i=0; i < size ; i++){
                if(n1.data != n2.data){
                    return false;
                }
                n1 = n1.next;
                n2 = n2.next;
            }
            return true;
        }
    }
}

