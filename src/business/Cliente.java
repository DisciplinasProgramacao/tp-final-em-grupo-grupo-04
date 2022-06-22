package business;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private IFidelizavel nivelFidelidade;
	private List<Pedido> pedidos;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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
		if (id==-1) {
			//colocar exceção
		}
		else {
			this.pedidos.get(id).setAvaliacao(avaliacao);
		}
		
	}

	public void getAvaliacaoMedia() {
		// preciso de pedidos pra fazer
	}

	public String extratoResumido() {
		String extrato = "";
		for (Pedido pedido : pedidos) {
			extrato+=pedido.toString()+"/n";
		}
		return extrato;
	}

	public String extratoDetalhado(int id) {
		return pedidos.get(id).gerarNotaDeCompra();// aqui é só chamar to string do pedido
	}
}
