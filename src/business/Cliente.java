package business;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//implemente serializable para o arquivo
public class Cliente implements Serializable {
	// implementei seriaversion id
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private IFidelizavel nivelFidelidade;
	private List<Pedido> pedidos;

	public Cliente(String nome, String cpf) throws Cpf_Invalido {
		this.nome = nome;
		this.setCpf(cpf);
		pedidos = new LinkedList<Pedido>();
		nivelFidelidade = new FidelidadeBranco(pedidos);
	}

	/* GETTERS E SETTERS */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws Cpf_Invalido {
		if (cpf.length() == 14) {
			this.cpf = cpf;
		} else {
			throw new Cpf_Invalido(cpf);
		}

	}

	public IFidelizavel getNivelFidelidade() {
		return nivelFidelidade;
	}

	public double getDesconto() {
		return nivelFidelidade.getDesconto();
	}

	public void setNivelFidelidade(IFidelizavel nivelFidelidade) {
		this.nivelFidelidade = nivelFidelidade;
	}

	public void fazerPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	public void avaliarPorPedido(Pedido pedido, int avaliacao) {
		avaliarPedidoPorId(pedidos.indexOf(pedido), avaliacao);
	}

	public void avaliarPedidoPorId(int id, int avaliacao) {
		if (id == -1) {
			// colocar excecao
		} else {
			this.pedidos.get(id).setAvaliacao(avaliacao);
		}

	}

	public double getAvaliacaoMedia() {
		double media = 0;
		for (Pedido pedido : pedidos) {
			media += pedido.getAvaliacao();
		}
		return media / pedidos.size();
	}

	public String extratoResumido() {
		String extrato = "";
		for (Pedido pedido : pedidos) {
			extrato += pedido.toString() + "/n";
		}
		return extrato;
	}

	public String extratoDetalhado(int id) {
		return pedidos.get(id).gerarNotaDeCompra();// aqui é só chamar to string do pedido
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " CPF: " + cpf;
	}
}