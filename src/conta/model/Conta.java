package conta.model;

import conta.util.Cores;

public abstract class Conta {
	//declaraçao de atributos
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	//metodo construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	//metodo construtor vazio
	public Conta() {
	}


	//encapsulamento
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	//metodo sacar
	public boolean sacar(float valor) { 
		
		if(this.getSaldo() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
			
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	//metodo depositar
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	
	//metodo visualizar
	public void visualizar() {
		
		//tipo de conta
		String tipo ="";
		
		switch(this.tipo) {
		case 1:
			tipo = "Conta corrente";
			break;
		case 2:
			tipo = "Conta poupança";
			break;
		}
		System.out.println(Cores.TEXT_YELLOW +"\n----------------------------"+Cores.RESET);
	    System.out.println("Detalhes da Conta Bancária:");
	    System.out.println(Cores.TEXT_YELLOW +"----------------------------"+Cores.RESET);
	    System.out.printf("Número da Conta: "+ this.numero);
	    System.out.printf("\nAgência: "+ this.agencia);
	    System.out.printf("\nTipo de Conta: "+ tipo);
	    System.out.printf("\nTitular: "+ this.titular);
	    System.out.printf("\nSaldo Atual: R$ %.2f", this.saldo);
	    System.out.println(Cores.TEXT_YELLOW+"\n----------------------------\n"+Cores.RESET);
	}
	

}
