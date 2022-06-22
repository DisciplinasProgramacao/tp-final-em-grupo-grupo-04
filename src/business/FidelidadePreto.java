package business;

public class FidelidadePreto implements IFidelizavel {
	public static final double DESCONTO = 0.1;
	public static final int MIN_PEDIDOS = FidelidadePrata.MAX_PEDIDOS;
	public static final int MIN_GASTOS = FidelidadePrata.MAX_GASTOS;
	public static final int MAX_PEDIDOS = 50;
	public static final int MAX_GASTOS = 600;

	public FidelidadePreto(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}

	@Override
	public IFidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if ((pedidosUltimoMes >= MIN_PEDIDOS && pedidosUltimoMes < MAX_PEDIDOS)
				|| (gastoUltimoMes >= MIN_GASTOS && gastoUltimoMes < MAX_GASTOS)) {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		} else if (pedidosUltimoMes < MIN_PEDIDOS || gastoUltimoMes < MIN_GASTOS) {
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadeFnV(pedidosUltimoMes, gastoUltimoMes);
		}
	}
	
	@Override
	public double getDesconto() {
		return DESCONTO;
	}
}
