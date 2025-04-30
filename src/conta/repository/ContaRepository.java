package conta.repository;

public interface ContaRepository {
	
	// Métodos do CRUD (Create, Read, Update e Delete)
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	// Métodos Bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void(int numeroOrigem, int numeroDestino, float valor);
}
