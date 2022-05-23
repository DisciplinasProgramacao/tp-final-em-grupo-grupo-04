package business;

public class FidelidadePrata implements Fidelizavel {
	public static final double DESCONTO = 0.05;

	public FidelidadePrata(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public Fidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if ((pedidosUltimoMes >= 4 && pedidosUltimoMes < 10) || (gastoUltimoMes >= 100 && gastoUltimoMes < 250)) {
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		}else if (pedidosUltimoMes < 4 || gastoUltimoMes < 100) {
			return new FidelidadeBranco(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		}
	}
}