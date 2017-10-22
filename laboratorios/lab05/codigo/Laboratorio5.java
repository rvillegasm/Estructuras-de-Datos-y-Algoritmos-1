
/**
 * Write a description of class Laboratorio5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Laboratorio5
{
     public static void dibujarArbol(BinaryTree a)
   {
       System.out.println("/* arbolito para http://www.webgraphviz.com/ */"); 
       System.out.println("digraph arbolito {");
       System.out.println("size=\"6,6\";");
       System.out.println("node [color=aquamarine, style=filled];");
       dibujarArbolAux(a.root);
       System.out.println("}");
   }
   
   public static void dibujarArbolAux(Node nodo)
   {
      if (nodo != null)
         //"x_\n__" -> "xo\n__";
         for(Node n: new Node[] {nodo.left, nodo.right} ){
            if (n != null)
               System.out.println("\"" + nodo.nombre + "\" -> \"" + n.nombre + "\";");
            dibujarArbolAux(n);
        }
   }
   
    public static void main(String[] args) {
    
        //Crea el árbol familiar
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("Rafael","hombre");
        tree.root.right = new Node ("Andres","hombre");
        tree.root.left = new Node ("Kathy","mujer");
        tree.root.left.left = new Node ("Feliza","mujer");
        tree.root.left.right = new Node ("Alberto","mujer");
        tree.root.right.left = new Node ("Angelica","mujer");
        tree.root.right.right = new Node ("Yosua","mujer");
        
        //Buscar
        System.out.println("Busqueda: Andres, Feliza, Carlo");
        System.out.println(tree.buscar("Andres"));
        System.out.println(tree.buscar("Feliza"));
        System.out.println(tree.buscar("Carlo"));
        System.out.println("-----------------------------------");
        
        //Tamaño del arbol
        System.out.println("Tamaño Arbol:");
        System.out.println(tree.maxheight());
        System.out.println("----------------");
        
        //Imprime el árbol familiar
        tree.recursivePrint();

        //Dibuja el árbol familiar
        dibujarArbol(tree);
        
        //Arbol Wilkenson (Punto 1.3)
        BinaryTree treeW = new BinaryTree();
        treeW.root = new Node("Wilkenson","hombre");
        treeW.root.right = new Node("Sufranio","hombre");
        treeW.root.left = new Node("Joaquina","mujer");
        treeW.root.right.right = new Node("Piolin","hombre");
        treeW.root.right.left = new Node("Piolina","mujer");
        treeW.root.right.right.right = new Node("Usnavy","hombre");
        treeW.root.right.left.left = new Node("Wilberta","mujer");
        treeW.root.left.right = new Node("Eustaquio","hombre");
        treeW.root.left.left = new Node("Eustaquia","mujer");
        treeW.root.left.right.right = new Node("Jovin","hombre");
        treeW.root.left.left.left = new Node("Florinda","mujer");
        
        //Buscar abuela materna
        System.out.println("Abuela de Wilkenson:");
        System.out.println(treeW.getGrandMothersName("Wilkenson"));
    }
}


