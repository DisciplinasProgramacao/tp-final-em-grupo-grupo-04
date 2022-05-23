package business;

public class FidelidadeFnV implements Fidelizavel{
	
	public static final double DESCONTO=0.2;
	
	public FidelidadeFnV(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public Fidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if (pedidosUltimoMes >= 50 || gastoUltimoMes >= 600) {
			return new FidelidadeFnV(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		}
	}
}
