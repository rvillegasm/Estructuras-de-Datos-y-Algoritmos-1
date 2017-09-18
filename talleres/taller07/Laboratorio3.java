
/**
 * Write a description of class Laboratorio3 here.
 * 
 * @author Felipe Cortes Jaramillo & Rafael Villegas Michel 
 * @version 18/09/2017
 */
import java.lang.*;
    public class Laboratorio3 {
public static void main(String[] args)
{
    
    LinkedListN list = new LinkedListN();
    list.insert(5, 0);
    list.insert(4, 0);
    list.insert(3, 0);
    list.insert(2, 0);
    list.insert(1, 0);
    for (int i = 0; i < list.size(); i++)
    {
        System.out.println(list.get(i));
    }
    
    System.out.println(list.contains(3));
    list.remove(2);
    System.out.println(list.contains(3));
    for (int i = 0; i < list.size(); i++)
    {
        System.out.println(list.get(i));
    }
    
    System.out.println("El valor maximo de la lista enlazada es: "+maximo(list));
}

private static int maximoAux(Node nodo){
    if(nodo == null){
        return 0;
    }else{
        int maximo = nodo.data;
        return Math.max(maximoAux(nodo.next),maximo);
    }
}

public static int maximo(LinkedListN lista){
    return maximoAux(lista.first);
}
}
