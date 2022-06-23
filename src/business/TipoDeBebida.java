package business;

public enum TipoDeBebida {
	
	agua(2), suco(5), refrigerante(5), cerveja(8);

	double preco;

	TipoDeBebida(double preco) {
		this.preco = preco;
	}
}