package business;

import java.time.LocalDateTime;
import java.util.List;

public class FidelidadeFnV implements IFidelizavel {

	public static final double DESCONTO = 0.2;
	public static final int MIN_PEDIDOS = FidelidadePreto.MAX_PEDIDOS;
	public static final int MIN_GASTOS = FidelidadePreto.MAX_GASTOS;
	private int numPedidosUltimoMes;
	private double gastosUltimoMes;

	public FidelidadeFnV(List<Pedido> pedidos) {
		this.numPedidosUltimoMes = getNumPedidosUltimoMes(pedidos);
		this.gastosUltimoMes = getGastoUltimoMes(pedidos);
		this.validarFidelidade(pedidos);
	}

	@Override
	public IFidelizavel validarFidelidade(List<Pedido> pedidos) {
		if (this.numPedidosUltimoMes >= MIN_PEDIDOS || this.gastosUltimoMes >= MIN_GASTOS) {
			return new FidelidadeFnV(pedidos);
		} else {
			return new FidelidadePreto(pedidos);
		}
	}

	@Override
	public double getDesconto() {
		return DESCONTO;
	}

	@Override
	public int getNumPedidosUltimoMes(List<Pedido> pedidos) {
		int mesAtual = LocalDateTime.now().getMonthValue();
		int numPedidos = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getDataRealizacao().getMonthValue() == mesAtual - 1)
				numPedidos++;
		}
		return numPedidos;
	}

	@Override
	public double getGastoUltimoMes(List<Pedido> pedidos) {
		int mesAtual = LocalDateTime.now().getMonthValue();
		double gastos = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i).getDataRealizacao().getMonthValue() == mesAtual - 1)
				gastos += pedidos.get(i).getValorPago();
		}
		return gastos;
	}
}
