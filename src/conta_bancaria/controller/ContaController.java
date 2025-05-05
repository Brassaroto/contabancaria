package conta_bancaria.controller;

import conta.model.Conta;
import conta.repository.ContaRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<>();
    private int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);
        conta.ifPresentOrElse(
            Conta::visualizar,
            () -> System.out.printf("\nA Conta número %d não foi encontrada\n", numero)
        );
    }

    @Override
    public void listarTodas() {
        if (listaContas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
        } else {
            for (var conta : listaContas) {
                conta.visualizar();
            }
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("\nA Conta foi criada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

        if (buscaConta.isPresent()) {
            listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
            System.out.println("\nA Conta foi atualizada com sucesso!");
        } else {
            System.out.println("\nA Conta não foi encontrada!");
        }
    }

    @Override
    public void deletar(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            listaContas.remove(conta.get());
            System.out.println("\nA Conta foi deletada com sucesso!");
        } else {
            System.out.println("\nA Conta não foi encontrada!");
        }
    }

    @Override
    public void sacar(int numero, float valor) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            if (conta.get().sacar(valor)) {
                System.out.println("\nSaque efetuado com sucesso!");
            } else {
                System.out.println("\nSaldo insuficiente!");
            }
        } else {
            System.out.println("\nConta não encontrada!");
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            conta.get().depositar(valor);
            System.out.println("\nDepósito efetuado com sucesso!");
        } else {
            System.out.println("\nConta não encontrada!");
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
        Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            if (contaOrigem.get().sacar(valor)) {
                contaDestino.get().depositar(valor);
                System.out.println("\nTransferência realizada com sucesso!");
            } else {
                System.out.println("\nSaldo insuficiente para transferir!");
            }
        } else {
            System.out.println("\nConta de origem ou destino não encontrada!");
        }
    }

    // Métodos auxiliares

    public int gerarNumero() {
        return ++numero;
    }

    public Optional<Conta> buscarNaCollection(int numero) {
        return listaContas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst();
    }

    // Getters e Setters

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }
}
