package aula_02;

import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaração das variáveis do tipo float
        float salario, abono, novoSalario;

        // Entrada de dados
        System.out.print("Digite o salário: ");
        salario = input.nextFloat();

        System.out.print("Digite o abono: ");
        abono = input.nextFloat();

        // Cálculo do novo salário
        novoSalario = salario + abono;

        // Saída do resultado
        System.out.printf("Novo Salário: %.2f\n", novoSalario);

        input.close();
    }
}
