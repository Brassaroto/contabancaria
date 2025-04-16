package helloworld;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaração das variáveis
        float numero1, numero2, numero3, numero4, diferenca;

        // Entrada de dados
        System.out.print("Digite o número 1: ");
        numero1 = input.nextFloat();

        System.out.print("Digite o número 2: ");
        numero2 = input.nextFloat();

        System.out.print("Digite o número 3: ");
        numero3 = input.nextFloat();

        System.out.print("Digite o número 4: ");
        numero4 = input.nextFloat();

        // Cálculo da diferença do produto
        diferenca = (numero1 * numero2) - (numero3 * numero4);

        // Saída do resultado
        System.out.printf("Diferença: %.1f\n", diferenca);

        // Fechamento do Scanner
        input.close();
    }
}