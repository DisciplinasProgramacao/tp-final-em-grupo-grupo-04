package business;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private IFidelizavel nivelFidelidade;
	private List<Integer> pedidos = new LinkedList<Integer>();
	
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

	public IFidelizavel getNivelFidelidade() {
		return nivelFidelidade;
	}

	public void setNivelFidelidade(IFidelizavel nivelFidelidade) {
		this.nivelFidelidade = nivelFidelidade;
	}
	
	public void addPedido(int pedido) {
		pedidos.add(pedido);
	}
}
