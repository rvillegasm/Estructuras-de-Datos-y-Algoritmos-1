
/**
 * Write a description of class MiArrayList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class MiArrayList
{
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];
    
    //Inicializa el arreglo con capacidad de 10, pero no tiene ningun elemento
   public MiArrayList(){
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
   }
    
   //Retorna la cantidad de elementos del arreglo
   public int size(){
        return size;
   }
    
   //Agrega un elemento en la ultima posicion libre del arreglo
  public void add(int e){
        if(size<elements.length){
            elements[size]=e;
            size++;
        }else{
            copiarArreglo(elements);
            elements[size]=e;
            size++;
        }
   }
  
  //Retorna el valor en la posicion del arreglo indicada
  public int get(int i){
            return elements[i];
   }
    
  //Agrega un elemento en la posicion del elemento deseada
   public void add(int index,int e){
       if(index<size){
        if(size<elements.length){
            mover(elements,index);
            elements[index]=e;
            size++;
        }else{
            copiarArreglo(elements);
            mover(elements,index);
            elements[index]=e;
            size++;
        }
       }
      else{
          System.out.println("No existe el index indicado");
        }
  }
   
  //Mueve el arreglo a la derecha. Mueve todos los elementos para dejar una posicion disponible en el indice buscado
  private void mover(int[] a,int index) {
        for(int i=size-1;i>=index;i--){
            a[i+1]=a[i];
        }
        elements=a;
   }
  
  //Copia dos arreglos para dejar los mismos elementos en una arreglo con mas espacios disponibles
  private int[] copiarArreglo(int[]elements){
        int[]n = new int[elements.length*2];
        for(int i=0;i<elements.length;i++){
            n[i]=elements[i];
        }
        this.elements=n;
        return elements;
    }
}
