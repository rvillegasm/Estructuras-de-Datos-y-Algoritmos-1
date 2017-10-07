
/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Banco
{
   public static void cajero1(LinkedList<String> fila) {
       System.out.println("Cajero 1 Atendiendo a "+fila.peek());
       fila.remove();
   }
   
   public static void cajero2(LinkedList<String> fila) {
       System.out.println("Cajero 2 Atendiendo a "+fila.peek());
       fila.remove();
   }
   
   public static void main(String[] args) {
       LinkedList<String> fila1 = new LinkedList<String>();
       fila1.add("Juan");
       //fila1.add("Maria");
       //fila1.add("Felipe");
       
       LinkedList<String> fila2 = new LinkedList<String>();
       fila2.add("Manuel");
       //fila2.add("Pedro");
       
       LinkedList<String> fila3 = new LinkedList<String>();
       fila3.add("Luis");
       fila3.add("Ariana");
       fila3.add("Selena");
       
       LinkedList<String> fila4 = new LinkedList<String>();
       fila4.add("Pachooon");
       
       Queue<LinkedList<String>> filas = 
        new LinkedList<LinkedList<String>>();
        
       filas.add(fila1);
       filas.add(fila2);
       filas.add(fila3);
       filas.add(fila4);
       
       while(filas.peek()!=null) {
           if(filas.peek().peekFirst()==null) {
               filas.poll();
           }else{
               cajero1(filas.peek());
               filas.add(filas.poll());
           
               if(filas.peek()==null) {
                   break;
                }
           
               if(filas.peek().peekFirst()==null) {
                   filas.poll();
               }else {
                   cajero2(filas.peek());
                   filas.add(filas.poll());
               }
            }
    }
   }
}
