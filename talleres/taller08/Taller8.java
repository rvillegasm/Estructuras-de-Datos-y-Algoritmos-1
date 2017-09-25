
/**
 * Write a description of class Taller08 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Taller8
{
    public static Stack<Integer> inversa(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        int n = s1.size();
        for(int i=0;i<n;i++){
            s2.push(s1.pop());
        }
        s1 = s2;
        return s1;
    }
    
    public static void cola(Queue<String> q1){
        int n = q1.size();
        for(int i=0;i<n;i++){
            System.out.println("Atendiendo a: "+q1.poll());
        }
    }
    
    public static int polaca(String string){
            Stack<Integer> numeros = new Stack<Integer>();
            String[] s1 = string.split(" ");
            for(int i=0;i<s1.length;i++){
                switch(s1[i]){
                    case "+":
                            int s = numeros.pop()+numeros.pop();
                            numeros.push(s);
                            break;
                    case "-":
                            int restador=numeros.pop();
                            int arestar=numeros.pop();
                            int r=arestar-restador;
                            numeros.push(r);
                            break;
                    case "*":
                            int m=numeros.pop()*numeros.pop();
                            numeros.push(m);
                            break;
                    case "/":
                            int dividir=numeros.pop();
                            int adividir=numeros.pop();
                            int d=adividir/dividir;
                            numeros.push(d);
                            break;
                    default: 
                            int numero= Integer.parseInt(s1[i]);
                            numeros.push(numero);
                            break;
                }
            }
            return numeros.pop();
        }
    }
    
    
