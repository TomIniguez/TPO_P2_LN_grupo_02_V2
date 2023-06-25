import org.uade.algo2.Set;
import org.uade.algo2.ejercicio6.item3.DoubleLinkedQueue;
import org.uade.algo2.ejercicio7.Ejercicio7;

import java.util.List;

public class App {

    public static void main(String[] args) {
//        DoubleLinkedQueue queue = new DoubleLinkedQueue();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println();
//        queue.remove();
//        System.out.println();
        int[][] matrix = {{0,0,1,1,0},
                        {1,0,0,0,0},
                        {0,1,0,0,0},
                        {0,0,0,0,1},
                        {0,0,0,0,0}};
        List<Set> res = Ejercicio7.grafosFuertementeConexos(matrix);
        System.out.println("-");
    }
}
