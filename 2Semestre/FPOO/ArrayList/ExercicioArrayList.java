package ArrayList;

import java.util.*;

public class ExercicioArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        Collections.sort(numeros);
        for (Integer i: numeros) {
            System.out.println(i);
        }
        Collections.reverse(numeros);
          for (Integer i: numeros) {
            System.out.println(i);
        }
    }
}
