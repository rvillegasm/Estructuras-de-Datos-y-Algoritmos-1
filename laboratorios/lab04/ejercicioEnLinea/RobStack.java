
/**
 * A class that simulates a robot arm that moves blocks
 * 
 * @author Rafael Villegas Michel & Felipe Cortes Jaramillo
 * @version 10/2017
 */
import java.util.*;
import java.io.*;
public class RobStack
{
    public static void moveOnto(int a, int b, ArrayList<Stack<Integer>> bloques){
        Stack<Integer> auxa = new Stack<Integer>();
        Stack<Integer> auxb = new Stack<Integer>();
        for(int i=0;i<bloques.size();i++){
            while(!bloques.get(i).empty()){
                if(bloques.get(i).peek()!=a){
                    auxa.push(bloques.get(i).pop());
                }
                else{
                    for(int k=0;k<bloques.size();k++){
                        while(!bloques.get(k).empty()){
                            if(bloques.get(k).peek()!=b){
                                auxb.push(bloques.get(k).pop());
                            }else{
                                bloques.get(k).push(bloques.get(i).pop());
                                break;
                            }
                        }
                        while(!auxb.empty()){
                            bloques.get(k).push(auxb.pop());
                        }
                    }
                    break;
                }
            }
            while(!auxa.empty()){
                bloques.get(i).push(auxa.pop());
            }
        }
    }
    
    public static void moveOver(int a, int b, ArrayList<Stack<Integer>> bloques){
        Stack<Integer> auxa = new Stack<Integer>();
        Stack<Integer> auxb = new Stack<Integer>();
        for(int i=0;i<bloques.size();i++){
            while(!bloques.get(i).empty()){
                if(bloques.get(i).peek()!=a){
                    auxa.push(bloques.get(i).pop());
                }
                else{
                    for(int k=0;k<bloques.size();k++){
                        while(!bloques.get(k).empty()){
                            if(bloques.get(k).peek()!=b){
                                auxb.push(bloques.get(k).pop());
                            }else{
                                while(!auxb.empty()){
                                    bloques.get(k).push(auxb.pop());
                                }
                                bloques.get(k).push(bloques.get(i).pop());
                                break;
                            }
                        }
                        while(!auxb.empty()){
                            bloques.get(k).push(auxb.pop());
                        }
                    }
                    break;
                }
            }
            while(!auxa.empty()){
                bloques.get(i).push(auxa.pop());
            }
        }
    }
    
    public static void pileOnto(int a, int b, ArrayList<Stack<Integer>> bloques){
        Stack<Integer> auxa = new Stack<Integer>();
        Stack<Integer> auxb = new Stack<Integer>();
        for(int i=0;i<bloques.size();i++){
            while(!bloques.get(i).empty()){
                if(bloques.get(i).peek()!=a){
                    auxa.push(bloques.get(i).pop());
                }
                else{
                    auxa.push(bloques.get(i).pop());
                    for(int k=0;k<bloques.size();k++){
                        while(!bloques.get(k).empty()){
                            if(bloques.get(k).peek()!=b){
                                auxb.push(bloques.get(k).pop());
                            }else{
                                while(!auxa.empty()){
                                    bloques.get(k).push(auxa.pop());
                                }
                                break;
                            }
                        }
                        while(!auxb.empty()){
                            bloques.get(k).push(auxb.pop());
                        }
                    }
                    break;
                }
            }
            while(!auxa.empty()){
                bloques.get(i).push(auxa.pop());
            }
        }
    }
    
    public static void pileOver(int a, int b, ArrayList<Stack<Integer>> bloques){
        Stack<Integer> auxa = new Stack<Integer>();
        Stack<Integer> auxb = new Stack<Integer>();
        for(int i=0;i<bloques.size();i++){
            while(!bloques.get(i).empty()){
                if(bloques.get(i).peek()!=a){
                    auxa.push(bloques.get(i).pop());
                }
                else{
                    auxa.push(bloques.get(i).pop());
                    for(int k=0;k<bloques.size();k++){
                        while(!bloques.get(k).empty()){
                            if(bloques.get(k).peek()!=b){
                                auxb.push(bloques.get(k).pop());
                            }else{
                                while(!auxb.empty()){
                                    bloques.get(k).push(auxb.pop());
                                }
                                while(!auxa.empty()){
                                    bloques.get(k).push(auxa.pop());
                                }
                                break;
                            }
                        }
                        while(!auxb.empty()){
                            bloques.get(k).push(auxb.pop());
                        }
                    }
                    break;
                }
            }
            while(!auxa.empty()){
                bloques.get(i).push(auxa.pop());
            }
        }
    }
    
    public static void printer(ArrayList<Stack<Integer>> bloques){
        System.out.println("Impresion");
        Stack<Integer> aux = new Stack<Integer>();
        for(int i=0;i<bloques.size();i++){
            System.out.print(i+": ");
            while(!bloques.get(i).empty()){
                aux.push(bloques.get(i).pop());
            }
            while(!aux.empty()){
                System.out.print(aux.peek()+" ");
                bloques.get(i).push(aux.pop());
            }
            System.out.println();
        }
    }
    
    public static void main(String[]args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int siz = Integer.parseInt(input.readLine());
        ArrayList<Stack<Integer>> bloques = new ArrayList<Stack<Integer>>();
        
        for(int k=0;k<siz;k++){
            bloques.add(new Stack<Integer>());
        }
        
        for(int i=0;i<bloques.size();i++){
            bloques.get(i).push(i);
        }
        
        String com = input.readLine();
        
        while(!com.equals("quit")){
            String[] command = com.split(" ");
            
            if(command[0].equals("move")){
                if(command[2].equals("onto")){
                    moveOnto(Integer.parseInt(command[1]),Integer.parseInt(command[3]),bloques);
                }else{
                    moveOver(Integer.parseInt(command[1]),Integer.parseInt(command[3]),bloques);
                }
            }else{
                if(command[2].equals("onto")){
                    pileOnto(Integer.parseInt(command[1]),Integer.parseInt(command[3]),bloques);
                }else{
                    pileOver(Integer.parseInt(command[1]),Integer.parseInt(command[3]),bloques);
                }
            }
            
            com = input.readLine();
        }
        
        printer(bloques);
    }
}
