package business;

public class FidelidadeFnV implements IFidelizavel {

	public static final double DESCONTO = 0.2;
	public static final int MIN_PEDIDOS = FidelidadePreto.MAX_PEDIDOS;
	public static final int MIN_GASTOS = FidelidadePreto.MAX_GASTOS;

	public FidelidadeFnV(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}

	@Override
	public IFidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if (pedidosUltimoMes >= MIN_PEDIDOS || gastoUltimoMes >= MIN_GASTOS) {
			return new FidelidadeFnV(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		}
	}
}
