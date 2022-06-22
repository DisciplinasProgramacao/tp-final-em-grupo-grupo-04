package business;

import java.util.ArrayList;
import java.util.List;

public abstract class Produto {
	
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
