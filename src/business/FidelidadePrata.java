package business;

public class FidelidadePrata implements IFidelizavel {
	public static final double DESCONTO = 0.05;
	public static final int MIN_PEDIDOS = FidelidadeBranco.MAX_PEDIDOS;
	public static final int MIN_GASTOS = FidelidadeBranco.MAX_GASTOS;
	public static final int MAX_PEDIDOS = 10;
	public static final int MAX_GASTOS = 250;

	public FidelidadePrata(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public IFidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if ((pedidosUltimoMes >= MIN_PEDIDOS && pedidosUltimoMes < MAX_PEDIDOS) || (gastoUltimoMes >= MIN_GASTOS && gastoUltimoMes < MAX_GASTOS)) {
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		}else if (pedidosUltimoMes < MAX_PEDIDOS || gastoUltimoMes < MIN_GASTOS) {
			return new FidelidadeBranco(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		}
	}
}
