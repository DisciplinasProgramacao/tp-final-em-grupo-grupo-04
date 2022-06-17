package Business;

public abstract class Bebida extends Produto{

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
