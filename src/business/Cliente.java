package business;

public class Cliente {
	private String nome;
	private String cpf;
	private Fidelizavel nivelFidelidade;
	//private Pedido[] pedidos;
	//associar com a classe pedidos
	
	/*GETTERS E SETTERS*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		//validar cpf
		this.cpf = cpf;
	}

	public Fidelizavel getNivelFidelidade() {
		return nivelFidelidade;
	}

	public void setNivelFidelidade(Fidelizavel nivelFidelidade) {
		this.nivelFidelidade = nivelFidelidade;
	}
}
