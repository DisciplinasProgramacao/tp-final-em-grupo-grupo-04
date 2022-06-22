package business;

import java.util.List;

public interface IFidelizavel {

	public IFidelizavel validarFidelidade(List<Pedido> pedidos);

	public double getDesconto();
	
	public int getNumPedidosUltimoMes(List<Pedido> pedidos);
	
	public double getGastoUltimoMes(List<Pedido> pedidos);
}
