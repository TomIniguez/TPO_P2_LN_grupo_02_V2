package org.uade.algo2.ejercicio7;

import org.uade.algo2.Set;
import org.uade.algo2.Stack;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio7 {

    public static List<Set> grafosFuertementeConexos(int[][]matriz){
        Stack stack = new Stack();
        int cantNodos = matriz.length;
        boolean[] visitados = new boolean[cantNodos];
        for (int i = 0; i < cantNodos; i++) {
            if(!visitados[i]){
                busquedaEnProfundidad(i, visitados, stack, matriz);
            }
        }
        int[][] traspuesta = trasponerMatriz(matriz);
        visitados = new boolean[cantNodos];
        List<Set> res = new ArrayList<>();
        while(!stack.isEmpty()){
            int vertice = stack.getTop();
            stack.remove();
            if(!visitados[vertice]){
                Set subgrafo = new Set();
                busquedaEnProfundidadTraspuesta(vertice, visitados,subgrafo, traspuesta);
                res.add(subgrafo);
            }
        }
        return res;
    }
    
    private static void busquedaEnProfundidad(int vertice, boolean[] visitados, Stack stack, int[][]matriz){
        visitados[vertice] = true;
        for (int vecino: matriz[vertice]) {
            if(!visitados[vecino])
                busquedaEnProfundidad(vecino, visitados, stack, matriz);
        }
        stack.add(vertice);
    }

    private static void busquedaEnProfundidadTraspuesta(int vertice, boolean[] visitados, Set subgrafo, int[][] matriz){
        visitados[vertice] = true;
        subgrafo.add(vertice);
        for(int vecino : matriz[vertice]){
            if(!visitados[vecino]){
                busquedaEnProfundidadTraspuesta(vecino, visitados, subgrafo, matriz);
            }
        }
    }


//para matriz cuadrada
    public static int[][] trasponerMatriz(int [][] matriz){
        int[][] res = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz.length; j++)
                res[j][i] = matriz[i][j];
        return res;
    }

}
