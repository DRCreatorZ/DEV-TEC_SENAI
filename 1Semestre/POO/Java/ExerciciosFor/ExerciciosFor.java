package ExerciciosFor;

import java.util.Scanner;

public class ExerciciosFor {
    Scanner sc=new Scanner(System.in);

    public void exercicio4() {
        //Ler 10 caracteres determinar se é Consoante;
        String letras[] = new String[]{"A","B","C","D","E","F","G","H","J","K"};
        //Ler o Vetor letra por letra e verificar se é consoante e "Contar";
        int contConsoante=0;
        for (int i = 0; i < letras.length; i++) {
            if (letras[i]=="A" ||letras[i]=="E" ||letras[i]=="I" ||letras[i]=="O" ||letras[i]=="U" ) {
                System.out.println(letras[i]+" É Vogal");
            } else{
                System.out.println(letras[i]+" É Consoante");
                contConsoante++;
            }
        }
        System.out.println("O nº de Consoantes é "+contConsoante);
    }

    public void exercicio4Ex() {
        //Contando as  Consoantes de uma palavra;
        System.out.println("Digite uma palavra: ");
        String letras = sc.next();
        letras = letras.toUpperCase();
        //Ler a Palavra letra por letra e verificar se é consoante e "Contar";
        int contConsoante=0;
        for (int i = 0; i < letras.length(); i++) {
            char c = letras.charAt(i);

            if (c=='A' || c=='E' ||c=='I' ||c=='O' ||c=='U') {
                System.out.println(c +" É Vogal");
            } else{
                System.out.println(c +" É Consoante");
                contConsoante++;
            }
        }
        System.out.println("O nº de Consoantes é "+contConsoante);
    }

    public void exercicio6() {
        double vetorMedia[]= new double[10];
        for (int i = 0; i < vetorMedia.length; i++) {
            double notas = 0;
            for(int j=0; j<4; j++){
                System.out.print("Nota "+(j+1)+ "_Aluno " + (i+1)+": ");
                notas+=sc.nextDouble();
            }
            notas/=4;
            vetorMedia[i]=notas;
        }
        for (int i = 0; i < vetorMedia.length; i++) {
            if (vetorMedia[i]>=7) {
                System.out.println("A Média do Aluno "+(i+1)+" é: "+vetorMedia[i]);
            }
        }
    }

    public void exercicio7() {
        double vetor[]= new double[5];
        double resultadoMulti =1;
        double resultadoSoma =0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Insira um número: ");
            vetor[i]=sc.nextDouble();
            resultadoMulti*=vetor[i];
            resultadoSoma+=vetor[i];
            }
            System.out.println("A Multiplicação dos números é: " +resultadoMulti +" E a Soma dos números é: " +resultadoSoma);
    }

    public void exercicio8() {
        double vetorIdade[]= new double[5];
        double vetorAltura[]= new double[5];

        for (int i = 0; i < vetorIdade.length; i++) {
            System.out.print("Insira a Idade da "+(i+1)+"ª pessoa: ");
            vetorIdade[i]+=sc.nextDouble();
            System.out.print("Insira a Altura da "+(i+1)+"ª pessoa: ");
            vetorAltura[i]+=sc.nextDouble();
            }
        for (int i = 4; i >=0; i--) {
                System.out.println("Pessoa "+(i+1)+": "+vetorIdade[i]+" _ Pessoa "+(i+1)+": "+vetorAltura[i]);
            }
    }
    public void exercicio9() {
        int vetorA[]= new int[]{1,2,3,4,5,6,7,8,9,10};

        double quadrado =0;
        for (int i = 0; i < vetorA.length; i++) {
          quadrado+=vetorA[i]*vetorA[i];
            }
            System.out.println("A soma do quadrado dos números é: "+quadrado );
    }

    public void exercicio5() {
        int vetor[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int par =0;
        int impar =0;
        //int vetorPar[] = new int[par];
        //int vetorImpar[] = new int[impar];
        
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Número do Vetor principal: " + vetor[i]);
           // if (vetor[i] %2 ==0) {
           //    System.out.println("Numeros pares"+vetor[i]);
          // } else {
            //    System.out.println("Números ímpares"+vetor[i]);
           // }
        }
         int vetorPar[] = new int[par];
        int vetorImpar[] = new int[impar];
        for (int i = 0; i < vetor.length; i++) {
           // System.out.println("Os Números do Vetor são: " + vetor[i]);
            if (vetor[i] %2 ==0) {
                vetorPar[i]= vetor[i];
              //System.out.println(vetor[i]+"É par");
           } else {
            vetorImpar[i]= vetor[i];
                //System.out.println(vetor[i]+"É ímpar");
            }
        }
         //imprimir Vetor vetor
         for (int i = 0; i < vetor.length; i++) {
            System.out.println("Vetor Principal ["+i+"]="+vetor[i]);
        }
         //imprimir Vetor Par
         for (int i = 0; i < vetorPar.length; i++) {
            System.out.println("Vetor Par ["+i+"]="+vetorPar[i]);
        }
         //imprimir Vetor vetor Impar
         for (int i = 0; i < vetorImpar.length; i++) {
            System.out.println("Vetor Ímpar ["+i+"]="+vetorImpar[i]);
    }
}
    public void exercicio5p() {
        int vetor[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int par =0;
        int impar =0;
        
        //Contar o nº de Pares e Ímpartes no vetor numeros
        for (int i = 0; i < vetor.length; i++) {
           if (vetor[i] %2 ==0) {
            par++;
           } else{
            impar++;
           }
        }
        //Crias os Vetores Par e Ímpar
        int vetorPar[] = new int[par];
        int vetorImpar[] = new int[impar];

        //Preencher os vetores Par e  Ímpar
        par=0;
        impar=0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] %2 ==0) {
                vetorPar[par]=vetor[i];
                par++; //atribui elementos do vetor a posição diferente no vetor par
               } else {
                vetorImpar[impar]=vetor[i];
                impar++;
               }
            }
            //imprimir Vetor vetor
            for (int i = 0; i < vetor.length; i++) {
                System.out.println("Vetor Principal ["+i+"]="+vetor[i]);
            }
             //imprimir Vetor Par
             for (int i = 0; i < vetorPar.length; i++) {
                System.out.println("Vetor Par ["+i+"]="+vetorPar[i]);
            }
             //imprimir Vetor vetor Impar
             for (int i = 0; i < vetorImpar.length; i++) {
                System.out.println("Vetor Ímpar ["+i+"]="+vetorImpar[i]);
            }
        }
    
    
}
