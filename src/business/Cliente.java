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

	public void setCpf(String cpf) throws Cpf_Invalido{
		if (cpf.length()==14) {
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
	
	public void fazerPedido(int pedido) {
		pedidos.add(pedido);
	}
	
	public void avaliarUltimoPedido(int avaliacao) {
		//pega o ultimo pedido adicionado
		//pedido.setAvaliacao(avaliacao);
	}
	
	public void getAvaliacaoMedia() {
		//preciso de pedidos pra fazer
	}
	
	public String extratoResumido() {
		return this.pedidos.toString();
	}
	
	public String extratoDetalhado(int pedido) {
		return  ""+pedido;//aqui é só chamar to string do pedido
	}
}
