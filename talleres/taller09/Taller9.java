
/**
 * Pedrito Ejercicios
 * 
 * @author Felipe Cortes Jaramillo & Rafael Villegas Michel 
 * @version 2017/10
 */
import java.util.HashMap;

public class Taller9{
	
    //pedrito 1
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key,value);
    }
    
    //pedrito 2
    public static void buscar(HashMap empresas,String key){
        System.out.println(empresas.get(key));
    }
    //pedrito 3
    public static boolean contienekey(HashMap empresas,String key){
        return empresas.containsKey(key);
    } 
    
    public static void main(String[]args){
        HashMap<String,String> empresas = new HashMap<String,String>();
        agregar(empresas,"EstadosUnidos","Google");
        agregar(empresas,"Colombia","Locura");
        agregar(empresas,"Finlandia","Nokia");
        buscar(empresas,"EstadosUnidos");
        System.out.println(contienekey(empresas,"India"));
        System.out.println(contienekey(empresas,"Colombia"));
    }
}
