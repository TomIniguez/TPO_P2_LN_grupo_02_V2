package org.uade.algo2.ejercicio6.item5;


import org.uade.algo2.Dictionary;
import org.uade.algo2.IDictionary;
import org.uade.algo2.ISet;

public class ProbabilityGraph implements IGraph {

    private static final int MAX_NODES = 15;

    private final double[][] adjacencyMatrix;
    private final IDictionary dictionary;
    private int totalNodes;

    public ProbabilityGraph() {
        this.adjacencyMatrix = new double[MAX_NODES][MAX_NODES];
        this.dictionary = new Dictionary(); // Asumo que el límite es mayor a MAX_NODES
        this.totalNodes = 0;
    }

    @Override
    public void addNode(int node) {
        if(this.totalNodes == 0) { // Greedy: para evitar la complejidad computacional cuando no hay nodos
            this.dictionary.add(node, this.totalNodes);
            this.totalNodes++;
            return;
        }

        ISet nodes = this.dictionary.getKeys();
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(current == node) {
                throw new RuntimeException("El nodo ya existe");
            }
            nodes.remove(current);
        }

        this.dictionary.add(node, this.totalNodes);
        this.totalNodes++;
    }

    @Override
    public void removeNode(int node) { //eliminar un nodo implica eliminar todas sus aristas
        if(this.totalNodes == 0) { // Greedy
            throw new RuntimeException("El nodo no existe");
        }

        // Esto se puede colocar dentro de un condicional this.totalNodes != 0
        int before = this.totalNodes;
        ISet nodes = this.dictionary.getKeys();
        int index = this.dictionary.getValue(node);
        int last = -1;
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(this.dictionary.getValue(current) == before - 1) {
                last = current;
            }
            if(current == node) {
                this.dictionary.remove(node, index);
                this.totalNodes--;
            }
            nodes.remove(current);
        }
        int after = this.totalNodes;

        if(before != after) { // Evito complejidad cúbica
            for(int i = 0; i < before; i++) {
                this.adjacencyMatrix[i][index] = this.adjacencyMatrix[i][after];
                this.adjacencyMatrix[index][i] = this.adjacencyMatrix[after][i];
            }

            this.dictionary.remove(last, this.dictionary.getValue(last));
            this.dictionary.add(last, index);
            return;
        }
        throw new RuntimeException("El nodo no existe");
    }

    @Override
    public ISet nodes() {
        return this.dictionary.getKeys();
    }


    @Override
    public void addEdge(int from, int to, double probability) {
        if(this.notIn(from) || this.notIn(to)) {
            throw new RuntimeException("No existe alguno de los nodos");
        }

        if(!(probability>0 && probability <= 1)){
            throw new RuntimeException("La probabilidad debe estar en el rango (0, 1]");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        if(this.adjacencyMatrix[indexFrom][indexTo] != 0) {
            throw new RuntimeException("Ya existe la arista");
        }

        this.adjacencyMatrix[indexFrom][indexTo] = probability;
    }

    private boolean notIn(int node) {
        ISet nodes = this.dictionary.getKeys();
        while(!nodes.isEmpty()) {
            int current = nodes.choose();
            if(current == node) {
                return false;
            }
            nodes.remove(current);
        }
        return true;
    }

    @Override
    public void removeEdge(int from, int to) {
        if(!this.edgeExists(from, to)) {
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        this.adjacencyMatrix[indexFrom][indexTo] = 0;
    }

    @Override
    public boolean edgeExists(int from, int to) {
        if(this.notIn(from) || this.notIn(to)) {
            return false;
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo] != 0;
    }

    @Override
    public double probability(int from, int to) {
        if(!this.edgeExists(from, to)) {
            throw new RuntimeException("No existe la arista");
        }

        int indexFrom = this.dictionary.getValue(from);
        int indexTo = this.dictionary.getValue(to);

        return this.adjacencyMatrix[indexFrom][indexTo];
    }
}
