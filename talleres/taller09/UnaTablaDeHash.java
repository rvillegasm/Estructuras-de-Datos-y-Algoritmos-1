
/**
 * Implementacion de HashTable
 * 
 * @author Felipe Cortes Jaramillo & Rafael Villegas Michel
 * @version 2017/10
 */
import java.util.*;
//Una tabla de hash donde la llave es un String y el valor un int.
public class UnaTablaDeHash
{
   // Ojo, esta tabla definida así no permite manejar las colisiones
   private ArrayList<LinkedList<String>> tabla;

  public UnaTablaDeHash(){
      tabla = new ArrayList<LinkedList<String>>(10);
      for(int i=0;i<10;i++){
          tabla.add(new LinkedList<String>());
      }
        
  }

   // Ojo, esta función hash es muy ingenua
  private int funcionHash(String k){
       return ((int) k.charAt(0)) % 10;
  }

   // Ojo con las colisiones
   public int geT(String k){
       if(tabla.get(funcionHash(k))!=null){
           for(int i=0;i<=tabla.get(funcionHash(k)).size();i++){
               if(k.equals(tabla.get(funcionHash(k)).get(i).substring(0,k.length()))){
                   return Integer.parseInt(tabla.get(funcionHash(k)).get(i).substring(k.length()));
        }
    }
   }
   return -1;
  }

   // Ojo con las colisiones
   public void put(String k, int v){
   tabla.get(funcionHash(k)).add(k+v);
  }
}
