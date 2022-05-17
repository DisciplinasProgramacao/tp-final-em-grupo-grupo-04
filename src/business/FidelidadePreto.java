package business;

public class FidelidadePreto implements Fidelizavel{
	public static final double DESCONTO=0.1;
	
	public FidelidadePreto(int pedidosUltimoMes, double gastoUltimoMes) {
		this.validarFidelidade(pedidosUltimoMes, gastoUltimoMes);
	}
	
	@Override
	public Fidelizavel validarFidelidade(int pedidosUltimoMes, double gastoUltimoMes) {
		if ((pedidosUltimoMes >= 10 && pedidosUltimoMes<50)|| (gastoUltimoMes >= 250 && gastoUltimoMes<600)) {
			return new FidelidadePreto(pedidosUltimoMes, gastoUltimoMes);
		} else if((pedidosUltimoMes >= 4 && pedidosUltimoMes < 10) || (gastoUltimoMes >= 100 && gastoUltimoMes < 250)){
			return new FidelidadePrata(pedidosUltimoMes, gastoUltimoMes);
		} else {
			return new FidelidadeFnV(pedidosUltimoMes, gastoUltimoMes);
		}
	}
}
