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

        // Contas pré-cadastradas
        System.out.println("\nCriar Contas\n");

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
        contas.cadastrar(cp2);

        contas.listarTodas();

        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite, valor;

        while (true) {
            System.out.println(Cores.TEXT_CYAN_BOLD + "\n*****************************************************");
            System.out.println("                 BANCO DO BRAZIL COM Z               ");
            System.out.println("*****************************************************");
            System.out.println("                1 - Criar Conta                      ");
            System.out.println("                2 - Listar todas as Contas           ");
            System.out.println("                3 - Buscar Conta por Numero          ");
            System.out.println("                4 - Atualizar Dados da Conta         ");
            System.out.println("                5 - Apagar Conta                     ");
            System.out.println("                6 - Sacar                            ");
            System.out.println("                7 - Depositar                        ");
            System.out.println("                8 - Transferir valores entre Contas  ");
            System.out.println("                9 - Consultar Contas por Titular     ");
            System.out.println("               10 - Sair                             ");
            System.out.print("Entre com a opção desejada: " + Cores.TEXT_RESET);

            opcao = leia.nextInt();

            if (opcao == 10) {
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
                    leia.nextLine();

                    System.out.print("Digite o nome do titular: ");
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
                    System.out.print("Digite o número da conta: ");
                    numero = leia.nextInt();

                    var conta = contas.buscarNaCollection(numero);

                    if (conta.isPresent()) {
                        tipo = conta.get().getTipo();

                        System.out.print("Digite o número da agência: ");
                        agencia = leia.nextInt();
                        leia.nextLine();

                        System.out.print("Digite o nome do titular: ");
                        titular = leia.nextLine();

                        System.out.print("Digite o saldo da conta: ");
                        saldo = leia.nextFloat();

                        switch (tipo) {
                            case 1 -> {
                                System.out.print("Digite o limite da conta: ");
                                limite = leia.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                            }
                            case 2 -> {
                                System.out.print("Digite o dia do aniversário da conta: ");
                                aniversario = leia.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                            }
                        }
                    } else {
                        System.out.println("A conta não foi encontrada!");
                    }
                    keyPress();
                    break;

                case 5:
                    System.out.println(Cores.TEXT_WHITE + "\n5 -> Apagar Conta\n");
                    System.out.print("Digite o número da conta: ");
                    numero = leia.nextInt();
                    contas.deletar(numero);
                    keyPress();
                    break;

                case 6:
                    System.out.println(Cores.TEXT_WHITE + "\n6 -> Sacar\n");
                    System.out.print("Digite o número da conta: ");
                    numero = leia.nextInt();

                    System.out.print("Digite o valor do saque: ");
                    valor = leia.nextFloat();

                    contas.sacar(numero, valor);
                    keyPress();
                    break;

                case 7:
                    System.out.println(Cores.TEXT_WHITE + "\n7 -> Depositar\n");
                    System.out.print("Digite o número da conta: ");
                    numero = leia.nextInt();

                    System.out.print("Digite o valor do depósito: ");
                    valor = leia.nextFloat();

                    contas.depositar(numero, valor);
                    keyPress();
                    break;

                case 8:
                    System.out.println(Cores.TEXT_WHITE + "\n8 -> Transferir valores entre Contas\n");
                    System.out.print("Digite o número da conta de origem: ");
                    int numeroOrigem = leia.nextInt();

                    System.out.print("Digite o número da conta de destino: ");
                    int numeroDestino = leia.nextInt();

                    System.out.print("Digite o valor da transferência: ");
                    valor = leia.nextFloat();

                    contas.transferir(numeroOrigem, numeroDestino, valor);
                    keyPress();
                    break;

                case 9:
                    System.out.println(Cores.TEXT_WHITE + "Consultar Contas por Titular\n\n");

                    System.out.println("Digite o nome do titular: ");
                    leia.skip("\\R");
                    titular = leia.nextLine();

                    contas.listarPorTitular(titular);

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
            System.in.read();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar ler o teclado");
        }
    }
}
