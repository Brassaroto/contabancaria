package helloworld;

import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaração das variáveis do tipo float
        float salarioBruto, adicionalNoturno, horasExtras, descontos, salarioLiquido;

        // Entrada de dados
        System.out.print("Digite o Salário Bruto: ");
        salarioBruto = input.nextFloat();

        System.out.print("Digite o Adicional Noturno: ");
        adicionalNoturno = input.nextFloat();

        System.out.print("Digite as Horas Extras: ");
        horasExtras = input.nextFloat();

        System.out.print("Digite os Descontos: ");
        descontos = input.nextFloat();

        // Cálculo do Salário Líquido
        salarioLiquido = salarioBruto + adicionalNoturno + (horasExtras * 5) - descontos;

        // Exibe o resultado
        System.out.printf("Salário Líquido: %.2f\n", salarioLiquido);

        input.close();
    }
}
