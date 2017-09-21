/**
 * Lab03 - excersice 2
 *
 * @author Felipe Cortes and Rafael Villegas.
 * @version 2017-2.
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Punto02 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Esriba su texto");
        String texto = input.readLine();
        LinkedList<Character> lista = organizar(texto);
        System.out.println("Usted escribio: \n"+arreglar(lista));
    }

    public static LinkedList<Character> organizar(String texto){
        LinkedList<Character> lista = new LinkedList<>();
        for(int i=0;i<texto.length();i++){
            lista.add(texto.charAt(i));
        }
        return lista;
    }

    public static String arreglar(LinkedList<Character> lista){
        String texto = "";
        for(int i=0;i<lista.size();i++){
            if(lista.get()=='['){
                String antes ="";
                for(int j = i+1;j<lista.size();j++){
                    if(lista.get(j)=='['||lista.get(j)==']'){
                        i=j;
                        break;
                    }else{
                        antes = antes+lista.get(j);
                    }
                }
                texto = antes+texto;
            }else if(lista.get(i)==']'){
                String despues = "";
                for(int k = i+1;k<lista.size();k++){
                    if(lista.get(k)=='['||lista.get(k)==']'){
                        i=k;
                        break;
                    }else{
                        despues = despues+lista.get(k);
                    }
                }
                texto = texto+despues;
            }else{
                texto = texto+lista.get(i);
            }
        }
        return texto;
    }
}
