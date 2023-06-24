package org.uade.algo2.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class ejercicio7 {

    public static double[][] trasponerMatriz(double [][] matriz){
        double[][] res = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[0].length; j++)
                res[j][i] = matriz[i][j];
        return res;
    }

}
