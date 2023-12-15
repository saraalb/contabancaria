package conta.model;

public class ContaCorrente extends Conta {
	
	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	

	//override?
	public ContaCorrente() {
		
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public float Sacar(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("Saldo ou limite insuficiente!");
			visualizar();
			return valor;
		}
		
		setSaldo(this.getSaldo()-valor);
		System.out.println("Valor sacado com sucesso!");
		visualizar();
		return valor;
	}

}
