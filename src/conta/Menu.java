package conta;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ContaController contas = new ContaController();

        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;

        while (true) {
            System.out.println(Cores.TEXT_CYAN_BOLD + "\n*****************************************************");
            System.out.println("                 BANCO DO BRAZIL COM Z               ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                1 - Criar Conta                      ");
            System.out.println("                2 - Listar todas as Contas           ");
            System.out.println("                3 - Buscar Conta por Numero          ");
            System.out.println("                4 - Atualizar Dados da Conta         ");
            System.out.println("                5 - Apagar Conta                     ");
            System.out.println("                6 - Sacar                            ");
            System.out.println("                7 - Depositar                        ");
            System.out.println("                8 - Transferir valores entre Contas  ");
            System.out.println("                9 - Sair                             ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada: " + Cores.TEXT_RESET);

            opcao = leia.nextInt();

            if (opcao == 9) {
                System.out.println(Cores.TEXT_YELLOW_BOLD + "\nBanco do Brazil com Z – O seu Futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_WHITE + "\n1 -> Criar Conta\n");
                    System.out.print("Digite o número da agência: ");
                    agencia = leia.nextInt();

                    System.out.print("Digite o nome do titular: ");
                    leia.skip("\\R");
                    titular = leia.nextLine();

                    System.out.print("Digite o tipo da conta (1 - Corrente | 2 - Poupança): ");
                    tipo = leia.nextInt();

                    System.out.print("Digite o saldo inicial da conta: ");
                    saldo = leia.nextFloat();

                    switch (tipo) {
                        case 1 -> {
                            System.out.print("Digite o limite da conta: ");
                            limite = leia.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                        }
                        case 2 -> {
                            System.out.print("Digite o dia do aniversário da conta: ");
                            aniversario = leia.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                        }
                        default -> System.out.println("Tipo de conta inválido!");
                    }
                    keyPress();
                    break;

                case 2:
                    System.out.println(Cores.TEXT_WHITE + "\n2 -> Listar todas as Contas\n");
                    contas.listarTodas();
                    keyPress();
                    break;

                case 3:
                    System.out.println(Cores.TEXT_WHITE + "\n3 -> Buscar Conta por Número\n");
                    System.out.print("Digite o número da conta: ");
                    numero = leia.nextInt();
                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;

                case 4:
                    System.out.println(Cores.TEXT_WHITE + "\n4 -> Atualizar Dados da Conta\n");
                    // Implementar depois
                    keyPress();
                    break;

                case 5:
                    System.out.println(Cores.TEXT_WHITE + "\n5 -> Apagar Conta\n");
                    // Implementar depois
                    keyPress();
                    break;

                case 6:
                    System.out.println(Cores.TEXT_WHITE + "\n6 -> Sacar\n");
                    // Implementar depois
                    keyPress();
                    break;

                case 7:
                    System.out.println(Cores.TEXT_WHITE + "\n7 -> Depositar\n");
                    // Implementar depois
                    keyPress();
                    break;

                case 8:
                    System.out.println(Cores.TEXT_WHITE + "\n8 -> Transferir valores entre Contas\n");
                    // Implementar depois
                    keyPress();
                    break;

                default:
                    System.out.println(Cores.TEXT_RED + "\nOpção inválida! Tente novamente." + Cores.TEXT_RESET);
                    keyPress();
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*****************************************************");
        System.out.println("Projeto Desenvolvido por: Gustavo Brassaroto Lira");
        System.out.println("https://github.com/Brassaroto/contabancaria.git");
        System.out.println("Generation Brasil – generation@generation.org");
        System.out.println("*****************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
            System.in.read(); // Consome o Enter após número
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar ler o teclado");
        }
    }
}
