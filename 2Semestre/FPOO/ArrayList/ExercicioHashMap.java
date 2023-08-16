package ArrayList;

import java.util.HashMap;

public class ExercicioHashMap {
    //criar um HashMap Cidades
    public static void main(String[] args) {
        HashMap <String,Integer> Pessoas = new HashMap<>();
        Pessoas.put("Zé", 20);
        Pessoas.put("Jão", 30);
        Pessoas.put("Ana",40);
        Pessoas.put("Bia",50);
        //Imprime valor correspondente a chave
        System.out.println(Pessoas.get("Ana"));
        //Imprime chave e valor
        System.out.println(Pessoas);
        //Imprime somente chave
        System.out.println(Pessoas.keySet());
        //imprimir somente valores
        for (String i : Pessoas.keySet()) {
            System.out.println(Pessoas.get(i));
        }

    }
}
