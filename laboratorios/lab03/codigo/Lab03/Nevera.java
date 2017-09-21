
/**
 * Auxiliar class in Lab03
 * 
 * @author Felipe Cortes and Rafael Villegas.
 * @version 2017-2.
 */
public class Nevera {
   int id;
   String marca;
   
   /**
    * Class Constructor.
    * @param integer, String.
    */
   public Nevera(int id, String marca){
       this.id = id;
       this.marca = marca;
   }
   
   /**
    * gets the id of the fridge.
    * @return An integer.
    */
   public int getID(){
       return this.id;
   }
   
   /**
    * gets the brand of the fridge.
    * @return A String.
    */
   public String getMarca(){
       return this.marca;
   }
}
