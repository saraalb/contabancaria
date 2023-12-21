package conta.controller;

import java.util.ArrayList;

import conta.Repository.ContaRepository;
import conta.model.Conta;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) conta.visualizar();
		else System.out.println("A conta número: "+numero+" não foi encontrada!");

	}

	@Override
	public void listarTodas() {
		if (!listaContas.isEmpty()) {
			for (var c: listaContas) {
				c.visualizar();
			} 
		} else {
			System.out.println("Não há contas a serem exibidas.");
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número "+ conta.getNumero() + " foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
	        int index = listaContas.indexOf(buscaConta);
	        System.out.println("Índice da conta na lista: " + index);
	        
	        listaContas.set(index, conta);
	        System.out.println("\nA conta número " + conta.getNumero() + " foi atualizada com sucesso!");
	    } else {
	        System.out.println("\nA conta número: " + conta.getNumero() + " não foi encontrada!");
	    }
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		boolean removida = listaContas.remove(conta);
		
		
        if (removida) {
            System.out.println("\nA conta número: " + numero + " foi deletada com sucesso!");
        } else if (!removida) {
        	System.out.println("\nA conta numero: "+numero+" nao foi encontrada!");
    }
}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

	    if (conta != null) {
	        if (conta.sacar(valor)) {
	            System.out.println("\nO saque na conta número: " + numero + " foi efetuado com sucesso!");
	        } else {
	            System.out.println("\nSaldo insuficiente para realizar o saque na conta número: " + numero);
	        }
	    } else {
	        System.out.println("\nA conta número: " + numero + " não foi encontrada!");
	    }
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
	    if (conta != null) {
	        conta.depositar(valor);
	            System.out.println("\nO deposito na conta número: " + numero + " foi efetuado com sucesso!");
	    } else {
	        	System.out.println("\nA conta número: " + numero + " não foi encontrada ou a conta destino é uma Conta Corrente!");
	        }
	    }

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			
			if (contaOrigem.sacar(valor)) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		} else {
			System.out.println("\nA conta de origem e/ou destino não foram encontradas.");
		}
		
	}
	
	public int gerarNumero() {
		return ++numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta: listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

}
