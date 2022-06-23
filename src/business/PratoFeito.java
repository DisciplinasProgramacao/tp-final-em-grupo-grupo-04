package business;

public class PratoFeito extends Comida{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final double PRECO_PRATO_FEITO=15;
	public PratoFeito() {
		this.setPrecoBase(this.getPrecoBase()+PratoFeito.PRECO_PRATO_FEITO);
	}
	@Override
	public String toString() {
		return "PratoFeito com carne de capivara";
	}
	
  

}