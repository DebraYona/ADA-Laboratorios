/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ada.laboratorio;

/**
 *
 * @author tineo
 */
public class ArbolBinario {
    
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    private static class Nodo {
        Nodo izq;
        Nodo der;
        int data;

        Nodo(int data) {
            izq = null;
            der = null;
            this.data = data;
        }
    }

    public boolean buscar(int data) {
        return buscar(raiz, data);
    }


    private boolean buscar(Nodo nodo, int data) {

        if(nodo == null)
            return false;

        if(data == nodo.data)
            return true;

        else if(data < nodo.data)
            return buscar(nodo.izq, data);

        else
            return buscar(nodo.der, data);
    }

    public void insertar(int data) {
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
    }


    public int tam() {
        return tam(raiz);
    }

    private int tam(Nodo nodo) {
        if(nodo == null)
            return 0;
        else
            return tam(nodo.izq) + 1 + tam(nodo.der);
    }

    public int maxProfundidad() {
        return maxProfundidad(raiz);
    }

    private int maxProfundidad(Nodo nodo) {
        if(nodo == null)
            return 0;
        else {
            int izqProfundidad = maxProfundidad(nodo.izq);
            int derProfundidad = maxProfundidad(nodo.der);

            return izqProfundidad > derProfundidad ? izqProfundidad + 1 : derProfundidad + 1;
        }
    }

    public int minValor() {
        return minValor(raiz);
    }

    private int minValor(Nodo nodo) {
        if(nodo.izq == null)
            return nodo.data;
        else
            return minValor(nodo.izq);
    }

    public int maxValor() {
        return maxValor(raiz);
    }

    private int maxValor(Nodo nodo) {
        if(nodo.der == null)
            return nodo.data;
        else
            return maxValor(nodo.der);
    }

    public static void main(String[] args) {
        ArbolBinario binaryTree = new ArbolBinario();
        binaryTree.insertar(10);
        binaryTree.insertar(20);
        binaryTree.insertar(5);
        binaryTree.insertar(8);
        binaryTree.insertar(9);
        binaryTree.insertar(30);
        binaryTree.insertar(4);
        binaryTree.insertar(1);
        System.out.println(binaryTree.maxValor());
    }
    
}
