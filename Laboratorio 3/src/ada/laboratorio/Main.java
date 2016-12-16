/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.laboratorio;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author tineo
 */
public class Main {

    public static int binarySearch(int a[], int num) {
        if (num > a[a.length - 1] || num < a[0]) {
            return -1;
        }
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        while (a[mid] != num) {
            if (num < mid) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }
        return mid;
    }

    private static int[] mergeSort(int[] input) {

        if (input.length == 1) {
            return input;
        }

        int middle = (int) Math.ceil((double) input.length / 2);
        int[] left = new int[middle];

        int rightLength = 0;
        if (input.length % 2 == 0) {
            rightLength = middle;
        } else {
            rightLength = middle - 1;
        }
        int[] right = new int[rightLength];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < input.length; i++) {
            if (i < middle) {
                left[leftIndex] = input[i];
                leftIndex++;
            } else {
                right[rightIndex] = input[i];
                rightIndex++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    result[resultIndex] = left[leftIndex];
                    leftIndex++;
                    resultIndex++;
                } else {
                    result[resultIndex] = right[rightIndex];
                    rightIndex++;
                    resultIndex++;
                }
            } else if (leftIndex < left.length) {
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = left[leftIndex];
                    leftIndex++;
                }
            } else if (rightIndex < right.length) {
                for (int i = resultIndex; i < result.length; i++) {
                    result[i] = right[rightIndex];
                    rightIndex++;
                }
            }
        }

        return result;
    }
    /*public void insertar(int data) {
        raiz = insertar(raiz, data);
    }


    private Nodo insertar(Nodo nodo, int data) {

        if(nodo == null)
            nodo = new Nodo(data);

        else {
            if(data <= nodo.data)
                nodo.izq = insertar(nodo.izq, data);
            else
                nodo.der = insertar(nodo.der, data);
        }

        return nodo;
    }*/
    
    static DefaultMutableTreeNode agregarNodo(DefaultMutableTreeNode nodo, int valor){
        
        
        
        
        /*if(nodo.){
            nodo = new DefaultMutableTreeNode(valor);
        }else{
            if(valor <= Integer.parseInt(nodo.getUserObject().toString())){
                nodo.add( agregarNodo(nodo, valor));
            
            }else{
                nodo.add( agregarNodo(nodo, valor));
            }
            
        
        }*/
        
        return nodo;
 
    }
    

    public static void main(String[] args) {

        int ar[] = {90, 20, 30, 40, 50, 80};

        ar = mergeSort(ar);

        System.out.println(binarySearch(ar, 40));

        ArbolBinario arbolbinario = new ArbolBinario();
        /*arbolbinario.insertar(10);
        arbolbinario.insertar(20);
        arbolbinario.insertar(5);
        arbolbinario.insertar(8);
        arbolbinario.insertar(9);
        arbolbinario.insertar(30);
        arbolbinario.insertar(4);
        arbolbinario.insertar(1);*/

        for (int x = 0; x < ar.length; x++) {
            arbolbinario.insertar(ar[x]);
            System.out.println("val: " + ar[x]);
        }

        System.out.println("tam:" + arbolbinario.tam());

        //System.out.println(arbolbinario.maxValor());
        MyVentana ven = new MyVentana();
        DefaultTreeModel tm = (DefaultTreeModel) ven.getArbol().getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tm.getRoot();

        System.out.println(root.isLeaf());
        System.out.println(root.getChildCount());
        //MutableTreeNode c = (MutableTreeNode) root.getChildAt(1);
        root.remove(0);
        root.remove(0);
        root.remove(0);

        //root.setUserObject("e");
        DefaultMutableTreeNode aux = root;
        aux.setUserObject(String.valueOf(ar[0]));

        
        for (int i = 1; i < arbolbinario.tam(); i++) {

            DefaultMutableTreeNode node = new DefaultMutableTreeNode();
            node.setUserObject(String.valueOf(ar[i]));

            if (aux.isRoot()) {
                System.out.println("root");
                aux.add(node);
                aux = (DefaultMutableTreeNode) aux.getChildAt(0);
            }
            System.out.println("childs: " + aux.getParent().getChildCount());
            if (aux.getParent().getChildCount() == 1) {

                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) aux.getParent();
                parent.add(node);
                aux = (DefaultMutableTreeNode) parent.getFirstChild();

                /*
                //System.out.println(aux.getParent().getChildAt(1).getChildCount());
                DefaultMutableTreeNode parent =  (DefaultMutableTreeNode) aux.getParent();
                parent.add(node);
                
                if (aux.getParent().getChildCount() > 1) {
                    //aux = (DefaultMutableTreeNode) aux.getChildAt(0);
                } else {
                    //aux = (DefaultMutableTreeNode) aux.getChildAt(1);
                }*/
            } else {

                aux.add(node);
                aux = (DefaultMutableTreeNode) aux.getFirstChild();

                System.out.println("der");

            }

        }

        tm.reload();

        //tm.insertNodeInto(new DefaultMutableTreeNode("test"), root , 2);
        ven.setVisible(true);
    }

}
