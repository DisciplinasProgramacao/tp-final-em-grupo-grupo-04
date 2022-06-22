package business;

public class Cpf_Invalido extends Exception{

	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public Cpf_Invalido(String cpf) {
		this.cpf=cpf;
	}
	
	public String getMassege() {
		return ("O CPF " + cpf + " nao pode ser cadastrado. Favor inserir pontos e tracos.");
		
	}

}
