package business;

import java.io.Serializable;
import java.util.List;
//herança serializable
public interface IFidelizavel extends Serializable{

	public IFidelizavel validarFidelidade(List<Pedido> pedidos);

	public double getDesconto();
	
	public int getNumPedidosUltimoMes(List<Pedido> pedidos);
	
	public double getGastoUltimoMes(List<Pedido> pedidos);
}