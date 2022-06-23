package business;

public abstract class Bebida extends Produto{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Bebida (TipoDeBebida tipoDeBebida)
{
	realizarPedidoDaBebida(tipoDeBebida);
}
private void realizarPedidoDaBebida(TipoDeBebida tipoDeBebida)
{
	this.setPrecoBase(tipoDeBebida.preco+this.getPrecoBase());
	this.extrato.add(tipoDeBebida.toString());
	
}
@Override
public String toString() {
	return "Bebida [" + extrato + "]";
}

}