package business;

public class LimiteDeItens extends Exception{

	
	
	private static final long serialVersionUID = 1L;
	private Produto produtoBloqueado;
	
	public LimiteDeItens(Produto p) {
		this.produtoBloqueado=p;
	}
	
	public String getMassege() {
		return ("O item " + produtoBloqueado.toString() + " nao pode ser adicionado porque o pedido "
				+ "atingiu o número máximo de 10 itens.");
		
	}

}
