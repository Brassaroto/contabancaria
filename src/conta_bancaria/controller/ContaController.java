package conta_bancaria.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<>();
    private int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
        if (conta != null)
            conta.visualizar();
        else
            System.out.printf("\nA Conta número %d não foi encontrada\n", numero);
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("A Conta foi criada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());

        if (buscaConta != null) {
            listaContas.set(listaContas.indexOf(buscaConta), conta);
            System.out.println("A Conta foi atualizada com sucesso!");
        } else {
            System.out.println("A Conta não foi encontrada!");
        }
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);
        if (conta != null) {
            listaContas.remove(conta);
            System.out.println("A Conta foi deletada com sucesso!");
        } else {
            System.out.println("A Conta não foi encontrada!");
        }
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
        if (conta != null) {
            if (conta.sacar(valor))
                System.out.println("Saque efetuado com sucesso!");
            else
                System.out.println("Saldo insuficiente!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito efetuado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarNaCollection(numeroOrigem);
        var contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para transferir!");
            }
        } else {
            System.out.println("Conta de origem ou destino não encontrada!");
        }
    }

    // Getters e Setters
    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    // Método auxiliar para gerar número sequencial
    public int gerarNumero() {
        return ++numero;
    }

    // Método auxiliar para buscar conta na lista
    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero)
                return conta;
        }
        return null;
    }
}
