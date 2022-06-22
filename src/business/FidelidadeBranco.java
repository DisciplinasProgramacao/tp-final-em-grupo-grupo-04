package business;

public class FidelidadeBranco implements IFidelizavel {

	public static final double DESCONTO = 0;
	public static final int MAX_PEDIDOS = 4;
	public static final int MAX_GASTOS = 100;

	public FidelidadeBranco(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public IFidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if (pedidosUltimoMes < MAX_PEDIDOS || gastoUltimoMes < MAX_PEDIDOS) {
			return new FidelidadeBranco(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		}
	}
	
	@Override
	public double getDesconto() {
		return DESCONTO;
	}

}
