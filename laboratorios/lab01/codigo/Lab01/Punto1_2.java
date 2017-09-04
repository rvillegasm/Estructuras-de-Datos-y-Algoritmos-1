
/**
 * Punto 1.2 del Laboratorio 1 de Datos1
 * 
 * @author Mauricio Toro, Modificado por Rafael Villegas & Felipe Cortés
 * @version 1
 * Este programa permite calcular el tiempo de procesamiento, de la suma de arreglos, creados de forma aleatoria por uno de sus metodos.
 */

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class Punto1_2
{
  /**
   * Método que se encarga de calcular el numero mayor de los elementos de un arreglo.
   */
    public static int ArrayMax(int[] A, int n)
   {
      int max;
      if (n == 0)
        max = A[0];
      else {
        max = Math.max(A[n],ArrayMax(A, n-1));
        try{
           TimeUnit.MILLISECONDS.sleep(500);
         }
         catch(Exception e)
         {
         }
    }
      return max;
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
   * Método que se encarga de tomar el tiempo que se demora ArrayMax en cada arreglo.
   */
  public static long tomarTiempo(int n){
      int[] A = generarArregloDeTamanoN(n);
      long startTime = System.currentTimeMillis();
      ArrayMax(A, A.length - 1);
      long estimatedTime = System.currentTimeMillis() - startTime;
      return estimatedTime;
  }
}
