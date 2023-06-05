package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.dynamic.node.BinaryTreeNode;

public class BinaryTree implements IBinaryTree {

    private BinaryTreeNode root;

    @Override
    public void create(int value) {
        this.root = new BinaryTreeNode(value, null, null);
    }

    @Override
    public Integer getValue() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void addLeft(int value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setLeft(binaryTree);
    }

    @Override
    public void addRight(int value) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(value);
        this.root.setRight(binaryTree);
    }

    @Override
    public void removeLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    @Override
    public void removeRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    @Override
    public BinaryTree getLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    @Override
    public BinaryTree getRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }

    //Funciones para el entregable 2
    //Buscar la hoja con el menor valor
    public int minLeaf(BinaryTree node){
        if(node == null)
            return Integer.MAX_VALUE;
        if(node.getLeft() == null && node.getRight() == null)
            return node.getValue();

        int minLeft = minLeaf(node.getLeft());
        int minRight = minLeaf(node.getRight());

        return Math.min(minLeft, minRight);
    }

    //Sumar Nodos Internos
    public int nodeSum(BinaryTree node){
        if(node == null || (node.getLeft() == null && node.getRight() == null))
            return 0;

        return node.getValue() + nodeSum(node.getLeft()) + nodeSum(node.getRight());
    }

    //multiplicar la suma de todos los nodos internos por la hoja con el menor valor
    public int ejercicio1(){
        int minLeaf = minLeaf(BinaryTree.this);
        int nodeSum = nodeSum(BinaryTree.this);

        return nodeSum * minLeaf;
    }
    //-------------------------------------------------------------------
    //Ejercicio 2
    public BinaryTree getSubtreeOfMaxHeightAsBST() {
        BinaryTree[] result = new BinaryTree[1];
        int[] maxHeight = new int[1];
        maxHeight[0] = 0;

        findMaxHeightSubtree(BinaryTree.this, result, maxHeight);

        return result[0];
    }

    private int findMaxHeightSubtree(BinaryTree node, BinaryTree[] result, int[] maxHeight) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findMaxHeightSubtree(node.getLeft(), result, maxHeight);
        int rightHeight = findMaxHeightSubtree(node.getRight(), result, maxHeight);

        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        if (currentHeight > maxHeight[0]) {
            if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                maxHeight[0] = currentHeight;
                result[0] = node;
            }
        }

        return currentHeight;
    }

    private boolean isBST(BinaryTree node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.getValue() < min || node.getValue() > max) {
            return false;
        }

        return isBST(node.getLeft(), min, node.getValue() - 1) && isBST(node.getRight(), node.getValue() + 1, max);
    }
//Entregable 3 Ejer 2
    public boolean isABB() {
        return isABBUtil(BinaryTree.this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isABBUtil(BinaryTree node, int min, int max) {
        // Caso base: el nodo actual es nulo
        if (node == null)
            return true;

        // Verificar si el valor del nodo está dentro de los límites establecidos
        if (node.getValue() < min || node.getValue() > max)
            return false;

        // Verificar recursivamente si los subárboles también cumplen las condiciones
        return (isABBUtil(node.getLeft(), min, node.getValue() - 1) &&
                isABBUtil(node.getRight(), node.getValue() + 1, max));
    }
}
