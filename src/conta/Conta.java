package conta;

public class Conta {
	//declaraçao de atributos
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	private boolean ativa;
	
	//metodo construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo, boolean ativa) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
		this.ativa = ativa;
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
	
	public boolean getAtiva() {
		return ativa;
	}
	
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void visualizar() {
	    System.out.println("Detalhes da Conta Bancária:");
	    System.out.println("----------------------------");
	    System.out.printf("Número da Conta: "+ this.numero);
	    System.out.printf("\nAgência: "+ this.agencia);
	    System.out.printf("\nTipo de Conta: "+ tipo);
	    System.out.printf("\nTitular: "+ this.titular);
	    System.out.printf("\nSaldo Atual: R$ %.2f", this.saldo);
	    System.out.println("\nConta ativa? "+ this.ativa);
	    
	    System.out.println("----------------------------");
	}
}
