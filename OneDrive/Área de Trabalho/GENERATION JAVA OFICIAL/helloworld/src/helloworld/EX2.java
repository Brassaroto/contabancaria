package helloworld;

import java.util.Scanner;

public class EX2 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaração das variáveis do tipo float
        float nota1, nota2, nota3, nota4, media;

        // Entrada das 4 notas
        System.out.print("Digite a Nota 1: ");
        nota1 = input.nextFloat();

        System.out.print("Digite a Nota 2: ");
        nota2 = input.nextFloat();

        System.out.print("Digite a Nota 3: ");
        nota3 = input.nextFloat();

        System.out.print("Digite a Nota 4: ");
        nota4 = input.nextFloat();

        // Cálculo da média
        media = (nota1 + nota2 + nota3 + nota4) / 4;

        // Exibe a média final com uma casa decimal
        System.out.printf("Média final: %.1f\n", media);

        input.close();
    }
}
