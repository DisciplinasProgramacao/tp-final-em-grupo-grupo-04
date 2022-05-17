package business;

public class FidelidadeBranco implements Fidelizavel {

	public static final double DESCONTO = 0;

	public FidelidadeBranco(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public Fidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if (pedidosUltimoMes < 4 || gastoUltimoMes < 100) {
			return new FidelidadeBranco(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		}
	}

}
