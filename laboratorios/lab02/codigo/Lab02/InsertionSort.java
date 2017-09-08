
/**
 * Write a description of class InsertionSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class InsertionSort
{
  //ToDo revisar el tiempo  
   public static void insertionS(int[] A)
  {
       int temp,j;
       
       for (int i = 0; i < A.length; i++)
       {
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
       try{
           TimeUnit.MILLISECONDS.sleep(500);
         }
         catch(Exception e)
         {
         }
  }
    
   /**
   * Metodo que genera un arreglo de tamaño aleatorio, con elementos aleatorios.
   */
  public static int[] generarArregloDeTamanoN(int n){
      int max = 1000000;
      int[] array = new int[n];
      Random generator = new Random();
      for (int i =0; i<n; i++)
      array[i] = generator.nextInt(max);
      return array;
  }
  
  /**
   * Método que se encarga de ejecutar el programa con arreglos diferentes.
   */
  public static void main(String[] args){
      for(int i = 1; i <= 1000; i = i + 10)
        System.out.println(i+" "+tomarTiempo(i));
  }
  
  /**
   * Método que se encarga de tomar el tiempo que se demora ArraySum para cada arreglo.
   */
  public static long tomarTiempo(int n){
      int[] A = generarArregloDeTamanoN(n);
       long startTime = System.currentTimeMillis();
       insertionS(A);
       long estimatedTime = System.currentTimeMillis() - startTime;
       return estimatedTime;
  }
}
