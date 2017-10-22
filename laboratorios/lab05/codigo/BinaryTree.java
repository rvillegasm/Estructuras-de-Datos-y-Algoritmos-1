
/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryTree
{
    Node root ;
 public BinaryTree () {
     root = null ;
 }
  
 public boolean buscar(String nombre) {
    if(buscar(root,nombre)==null){
        return false;
    }else{
        return true;
    }
}
 
 public Node buscar(Node nodo, String nombre){ //Auxiliar Buscar
    if(nodo ==null){
        return nodo;
    }else{
        if(nodo.nombre.equals(nombre)){
            return nodo;
        }
        Node derecha = buscar(nodo.right,nombre);
        if(derecha != null){
            return nodo;
        }else{
            return buscar(nodo.left,nombre);
        }
}
}

public String getGrandMothersName(String name){
    Node son = buscar(root,name);
    if(son.left.left != null){
        return son.left.left.nombre;
    }else{
        return "";
    }
}

private int max2(int i, int j)
	{
		if (i > j)
			return i;
		return j;
	}
	
	private int maxheightAUX(Node node)
	{
		if (node == null)
				return 0;
		else 
				return max2(maxheightAUX(node.left), maxheightAUX(node.right))+1;
	}
	
	public int maxheight()
	{
	   return maxheightAUX(root);
	}

	private void recursivePrintAUX(Node node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.left);
			recursivePrintAUX(node.right);
			System.out.println(node.nombre);
		}
		
		
	}
	public void recursivePrint()
	{
		recursivePrintAUX(root);
	}

}
