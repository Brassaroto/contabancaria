package conta;

import java.util.Scanner;
import conta.util.Cores;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;


public class Menu {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int opcao;

            while (true) {
                System.out.println(Cores.TEXT_CYAN_BOLD + "\n*****************************************************");
                System.out.println("                 BANCO DO BRAZIL       ");
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

                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Opção 1: Criar Conta");
                        break;
                    case 2:
                        System.out.println("Opção 2: Listar todas as Contas");
                        break;
                    case 3:
                        System.out.println("Opção 3: Buscar Conta por Numero");
                        break;
                    case 4:
                        System.out.println("Opção 4: Atualizar Dados da Conta");
                        break;
                    case 5:
                        System.out.println("Opção 5: Apagar Conta");
                        break;
                    case 6:
                        System.out.println("Opção 6: Sacar");
                        break;
                    case 7:
                        System.out.println("Opção 7: Depositar");
                        break;
                    case 8:
                        System.out.println("Opção 8: Transferir valores entre Contas");
                        break;
                    case 9:
                        System.out.println(Cores.TEXT_YELLOW_BOLD + "\nBanco do Brazil com Z – O seu Futuro começa aqui!");
                        System.out.println("*****************************************************");
                        System.out.println("Projeto Desenvolvido por: Gustavo Brassaroto Lira");
                        System.out.println("https://github.com/Brassaroto/contabancaria.git");
                        System.out.println("Generation Brasil – generation@generation.org");
                        System.out.println("*****************************************************" + Cores.TEXT_RESET);
                        System.exit(0);
                        break;
                    default:
                        System.out.println(Cores.TEXT_RED + "\nOpção inválida! Tente novamente." + Cores.TEXT_RESET);
                }
            }
        }
    }
}
