
/**
 * HashSearch - Clase que se encarga de organizar un conjunto de directorios y encontrar el directorio buscado.
 *
 * @author Felipe Cortes Jaramillo & Rafael Villegas Michel
 * @version 30/2017
 * @colaboradores https://stackoverflow.com/users/3526330/saikumarm
 * @colaboradores https://stackoverflow.com/users/992484/madprogrammer
 *
 */
import java.util.*;
import java.io.*;

/**
 * Clase que se encarga de organizar un conjunto de directorios y encuentra el directorio buscado
 */
public class HashSearch {


  //Hash Map para utilizar durante que organizara los directorios (ArrayLists) y sus respectivas llaves
  public static HashMap<String, ArrayList<String>> dirFiles = new HashMap<String, ArrayList<String>>();

  /**
   * Método que se encarga de ingresar todo el arbol de directorios en la HashTable, ingresa arraylists con direcciones en Strings
   * @param File folder - directorio padre
   * @Throws IOException posible NullPointer Exception
   */
  public static void listFilesForFolder(File folder)
            throws IOException {
           ArrayList<String> fileNames = new ArrayList<String>();

           if(folder.isDirectory()) {
                File[] files = folder.listFiles();  //Arreglo Parcial para evitar Hidden y System Directories--
                if(files != null){
                    for (File fileEntry : files) {
                        //System.out.println(fileEntry.toString());
                        if (fileEntry.isDirectory()) {
                            System.out.println(fileEntry.toString()); //Muestra ficheros durante ejecucion
                            fileNames.add(fileEntry.getPath());
                            listFilesForFolder(fileEntry);
                        } else {
                            String fileName = (fileEntry.getPath()).toString();
                            fileNames.add(fileEntry.getPath());
                        }
                    }
                    dirFiles.put(folder.getName(), fileNames);  //Adiciona el ArrayList en el HashMap
                }
           }
  }

  /**
   * Metodo principal. Ejecuta metodo listFilesForFolder()
   * @param String[] args
   * @Throws IOException posible NullPointerException
   */
   public static void main(String[] args) throws IOException {
        // Autogenera el hashmap con la ruta de directorios indicada

       long startTime = System.currentTimeMillis();

       listFilesForFolder(new File("C:/Users/rafav"));

       long estimatedTime = System.currentTimeMillis() - startTime;
       System.out.println("El tiempo de creacion es: "+estimatedTime+" milisegundos");
       System.out.println("Ingrese el nombre de la carpeta que desea buscar");

        //Buffered Reader para buscar el directorio (llave)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        //Valor END terminar
        while(!input.equals("END")){
            long startTime2 = System.currentTimeMillis();
            for(Map.Entry<String, ArrayList<String>> foldername : dirFiles.entrySet())
            {
                if(input.equals(foldername.getKey())){
                    System.out.println(foldername.getValue());
                }
            }
            long estimatedTime2 = System.currentTimeMillis() - startTime2;
            System.out.println("El tiempo de busqueda es de: "+estimatedTime2+" milisegundos");
            System.out.println("Ingrese el nombre de la carpeta que desea buscar");
            input = reader.readLine();
        }
        System.out.println("**Programa Terminado**");
        reader.close();
  }
}
