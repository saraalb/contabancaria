package conta.Repository;

import conta.model.Conta;

public interface ContaRepository {
	
	//Metodos CRUD
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	//Metodos bancarios
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
	//gerarnumerodaconta
	//buscarconta
	//retornartipodeconta
}
