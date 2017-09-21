
/**
 * Main Class in Lab03.
 * 
 * @author Mauricio Toro, Felipe Cortes and Rafael Villegas. 
 * @version 2017-2.
 */

import java.util.*;

public class Laboratory3 {
    /**
     * Returns the product of the numbers in the list. 
     * @param list - List of integers.
     * @return An integer.
     */
    public static int multiply(List<Integer> list) {
        int mult = 1;
        for(int i = 0; i < list.size(); i++){
            mult = mult*list.get(i);
        }
        return mult;
    }
    
    /**
     * Adds a new element to the array. If it is already in the array, it is ignored. But if not, it is added.
     * @param list - List of Integers, dato - integer.
     * @return A List of Integers(Modified).
     */
    public static List<Integer> smartInsert(List<Integer> list, int dato) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == dato){
                return list;
            }
        }
        list.add(dato);
        return list;
    }
    
    /**
     * Looks for a spot in a list in which the left side of it is equal, or almost equal, to it's rigth side.
     * @param list - List of Integers.
     * @return An integer.
     */
    public static int pivot(List<Integer>list){
        int sizq = 0;
        int sder = 0;
        int diferencia = 10000;
        int ubicacion = 0;
        for(int i=0;i<list.size();i++){
            sizq = sizq + list.get(i);
            for(int j=i+1;j<list.size();j++){
                sder = sder + list.get(j);
            }
            if(Math.abs(sizq-sder)<diferencia){
                diferencia = Math.abs(sizq-sder);
                ubicacion = i;  
            }
            sder = 0;
        }
        return ubicacion;
    }
    
    /**
     * Shows the fridges assigned to every single request.
     * @param list - List of Neveras, list - List of solicitudes.
     */
    public static void ejercicio4(List<Nevera> almacen, List<Solicitud> solicitudes){
            System.out.print("[");
            for(int i = solicitudes.size()-1;i>=0;i--){
                int num = solicitudes.get(i).getNum();
                System.out.print("(\'"+solicitudes.get(i).getLugar()+"\', [");
                int remover = almacen.size()-num;
                for(int j = almacen.size()-1;j>=(almacen.size()-num);j--){
                   if(j<0){
                     break;
                   }
                   System.out.print("("+almacen.get(j).getID()+", "+almacen.get(j).getMarca()+"),");  
                }   
                if(almacen.size()-num>=0){
                  for(int k = almacen.size()-1;k>=remover;k--){
                    almacen.remove(k);
                  }
                }    
                System.out.print("])\n");
            }
            System.out.print("]");
    }
    
    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));
        
        LinkedList<Integer> bara1 = new LinkedList<>();
        bara1.addAll(Arrays.asList(new Integer[] {10, 20, 5, 3, 20, 10}));
        
        ArrayList<Integer> bara2 = new ArrayList<>();
        bara2.addAll(Arrays.asList(new Integer[] {10, 2, 4, 8}));
        
        LinkedList<Nevera> almacen = new LinkedList<>();
        almacen.addAll(Arrays.asList(new Nevera(1,"haceb"),new Nevera(2,"lg"),new Nevera(3,"ibm"),new Nevera(4,"haceb"),new Nevera(5,"lg")
        ,new Nevera(6,"ibm"),new Nevera(7,"haceb"), new Nevera(8,"lg"), new Nevera(9,"ibm"), new Nevera(8,"lg"),new Nevera(9,"ibm")));
        
        LinkedList<Solicitud> solicitudes = new LinkedList<>();
        solicitudes.addAll(Arrays.asList(new Solicitud("eafit", 10), new Solicitud("la14", 2), new Solicitud("olimpica", 4)
        ,new Solicitud("exito", 1)));
             
        System.out.println(multiply(linked));
        System.out.println(multiply(array));
        
        System.out.println(smartInsert(linked, 7));
        System.out.println(smartInsert(linked, 2));
        System.out.println(smartInsert(array, 7));
        System.out.println(smartInsert(array, 2));
        
        System.out.println("El mejor pivote para la bara es en: "+pivot(bara1));
        System.out.println("El mejor pivote para la bara es en: "+pivot(bara2));
        
        ejercicio4(almacen,solicitudes);
    }
}
