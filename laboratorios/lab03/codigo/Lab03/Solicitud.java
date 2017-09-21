
/**
 * Auxiliar class in Lab03
 * 
 * @author Felipe Cortes and Rafael Villegas. 
 * @version 2017-2.
 */
public class Solicitud {
   int num;
   String lugar;
   
   /**
    * Class Constructor.
    * @param String, integer.
    */
   public Solicitud(String lugar, int num){
       this.num = num;
       this.lugar = lugar;
   }
   
   /**
    * gets the number of the request.
    * @return An integer.
    */
   public int getNum(){
       return this.num;
   }
   
   /**
    * gets the name of the store.
    * @return A String.
    */
   public String getLugar(){
       return this.lugar;
   }
}
