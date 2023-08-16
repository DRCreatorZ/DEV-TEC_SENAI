public class CustoViagem {
    public static void main(String[] args) {
        int distanciaViagem = 400;
        double precoCombustivel = 5;
        double mediaConsumo = 5;
        double CustoViagem = distanciaViagem / mediaConsumo * precoCombustivel;
        System.out.println("O custo da viagem é de R$ " + CustoViagem);
    }

}