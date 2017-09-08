
/**
 * Write a description of class MergeSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class MergeSort
{
    // Sorts an array using Merge Sort
    // Taken from www.cs.cmu.edu/
    public static void mergeS(int [ ] a)
    {
        int[] tmp = new int[a.length];
        mergeSAux(a, tmp,  0,  a.length - 1);
    }


    private static void mergeSAux(int [ ] a, int [ ] tmp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSAux(a, tmp, left, center);
            mergeSAux(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
        
        try{
           TimeUnit.MILLISECONDS.sleep(10);
         }
         catch(Exception e)
         {
         }
    }
    
    
  /**
   * Metodo que genera un arreglo de tamaño aleatorio, con elementos aleatorios.
   */
  public static int[] generarArregloDeTamanoN(int n){
      int max = 5000;
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
      for(int i = 1; i <= 400; i = i + 10)
        System.out.println(i+" "+tomarTiempo(i));
  }
  
  /**
   * Método que se encarga de tomar el tiempo que se demora ArraySum para cada arreglo.
   */
  public static long tomarTiempo(int n){
      int[] A = generarArregloDeTamanoN(n);
       long startTime = System.currentTimeMillis();
       mergeS(A);
       long estimatedTime = System.currentTimeMillis() - startTime;
       return estimatedTime;
  }
}
