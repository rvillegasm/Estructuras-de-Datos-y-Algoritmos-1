
/**
 * Write a description of class BynarySearchTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarySearchTree {
 Node root ;
 public BinarySearchTree () {
     root = null ;
 }
 
 public void insertar(int n) {
     root=insertar(root,n);
 }
 
 public boolean buscar(int n) {
    return buscar(root,n);
 }
 
 public void borrar(int n){
    root=borrar(root,n);
 }
 
 private boolean buscar(Node nodo, int n){ //Auxiliar Buscar
    if(nodo ==null){
        return false;
    }
    if(n==nodo.data){
        return true;
    }
    if(nodo.data<=n){
        return buscar(nodo.right,n);
    }else{
        return buscar(nodo.left,n); 
    }
}

private Node insertar(Node nodo, int n){ //Auxiliar Insertar
    if(nodo == null){
        Node nodo1 = new Node(n);
        nodo = nodo1;
        return nodo;
    }
    if(nodo.data<=n){
            nodo.right = insertar(nodo.right,n);
            return nodo;
    }else{
            nodo.left = insertar(nodo.left,n);
            return nodo;
        }
}

private Node borrar(Node nodo, int n){
    if(nodo.data == n){
        Node nodoMaxDer = maxDer(nodo.left);
        nodoMaxDer.right = nodo.right;
        nodo = nodo.left;
        return nodo;
    }else{
        if(nodo.data<=n){
            nodo.right = borrar(nodo.right,n);
            return nodo;
        }else{
            nodo.left = borrar(nodo.left,n);
            return nodo;
        }
    }
}

private Node maxDer(Node nodo){
    if(nodo.right == null){
        return nodo;
    }else{
        return maxDer(nodo.right);
    }
}

}

