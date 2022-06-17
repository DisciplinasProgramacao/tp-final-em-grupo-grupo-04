package Business;

public class Pizza extends Comida implements IAdicionavel{
private static final double VALOR_PRECO_BASE_PIZZA=25;
private static final double VALOR_BORDA_RECHEADA=8;
private boolean borda;
public Pizza(boolean borda) {
	super();
	this.setPrecoBase(VALOR_PRECO_BASE_PIZZA);
	this.setBorda(borda);
}
public static double getValorPrecoBasePizza() {
	return VALOR_PRECO_BASE_PIZZA;
}
public static double getValorBordaRecheada() {
	return VALOR_BORDA_RECHEADA;
}
public boolean isBorda() {
	return borda;
}
public void setBorda(boolean borda) {
	if (borda)
	{
		this.setPrecoBase(this.getPrecoBase()+VALOR_PRECO_BASE_PIZZA);
	}
	this.borda = borda;
}
@Override
public void inserirAdicionais(TipoDeAcrescimo tipoDeAcrescimo) {
	if (!tipoDeAcrescimo.equals(null))
	{
		this.setPrecoBase((tipoDeAcrescimo.preco*2)+this.getPrecoBase());
		this.extrato.add(tipoDeAcrescimo.toString());
	}
	else {
		//gera erro por ta apontado para nullo
	}
 	
}

@Override
public String toString() {
	return "("+this.getId()+") Pizza[" + this.getExtrato() + "]";
}
}
