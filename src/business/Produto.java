package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//implementei serializable para o produto
public abstract class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double precoBase;
	private int id;
	private static int cont = 0;
	protected List<String> extrato = new ArrayList<>();

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCont() {
		return cont;
	}

	public List<String> getExtrato() {
		return extrato;
	}

	public Produto() {
		this.id = ++cont;
	}
	

}