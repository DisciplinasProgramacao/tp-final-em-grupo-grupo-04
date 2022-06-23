package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import business.Cliente;
import business.Comida;
import business.Cpf_Invalido;
import business.FidelidadeBranco;
import business.FidelidadePrata;
import business.Hamburguer;
import business.LimiteDeItens;
import business.Pedido;
import business.PratoFeito;
import business.Produto;
import business.TipoDeAcrescimo;

public class main {
	static String nomeDoArquivoCliente = "Cliente.bin";
	static String nomeDoArquivoProduto = "Produto.bin";
	static List<Cliente> clientes = new ArrayList<>();
	static List<Produto> produtos = new ArrayList<>();

	public static void main(String[] args) throws LimiteDeItens, IOException {
		Hamburguer h = new Hamburguer(true);
		PratoFeito pf = new PratoFeito();
		h.inserirAdicionais(TipoDeAcrescimo.bacon);
		Cliente c = null;
		try {
			c = new Cliente("pedro", "111.111.111-11");
		} catch (Cpf_Invalido e) {
			System.out.println(e);
		}
		Pedido p = new Pedido(c);
		p.addItem(h);
		p.addItem(pf);
		System.out.println(p.gerarNotaDeCompra());
		clientes = carregarDadosCliente();
		produtos = carregarDadosProduto();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		System.out.println();
		clientes.add(c);
		produtos.add(h);
		h.inserirAdicionais(TipoDeAcrescimo.bacon);

		gravarDadosCliente();
		gravarDadosProduto();
	}

	public static void cabecalho() {
		limparTela();
		System.out.println("CARNE DE CAPIVARA");
		System.out.println("==========================");
	}

	public static void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void gravarDadosCliente() throws IOException {
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(nomeDoArquivoCliente));
		for (Cliente cliente : clientes) {
			obj.writeObject(cliente);
		}
		obj.close();
	}

	public static void gravarDadosProduto() throws IOException {
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(nomeDoArquivoProduto));
		for (Produto produto : produtos) {
			obj.writeObject(produto);
		}
		obj.close();
	}

	public static List<Cliente> carregarDadosCliente() {
		List<Cliente> todos = new ArrayList<>();
		try (FileInputStream dados = new FileInputStream(nomeDoArquivoCliente)) {
			ObjectInputStream obj = new ObjectInputStream(dados);
			while (dados.available() != 0) {
				Cliente novo = (Cliente) obj.readObject();
				todos.add(novo);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException ex) {

		} catch (ClassNotFoundException cex) {

		}

		return todos;
	}

	public static List<Produto> carregarDadosProduto() {
		FileInputStream dados;
		List<Produto> todos = new ArrayList<>();

		try {
			dados = new FileInputStream(nomeDoArquivoProduto);
			ObjectInputStream obj = new ObjectInputStream(dados);
			while (dados.available() != 0) {
				Produto novo = (Produto) obj.readObject();
				todos.add(novo);
			}
			obj.close();
		} catch (FileNotFoundException e) {

		} catch (IOException ex) {

		} catch (ClassNotFoundException cex) {

		}

		return todos;
	}
}
