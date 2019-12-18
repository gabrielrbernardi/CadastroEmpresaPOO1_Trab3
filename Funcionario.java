package trab3POO;
public class Funcionario extends Pessoa{
	private static float valSalario;
	
	public Funcionario() throws Exception{
	}
	
	public static float getValSalario() {
		return valSalario;
	}
	public void setValSalario(float valSalario) {
		Funcionario.valSalario = valSalario;
	}
	
	void aumentoSalario(float valAumento) {
		this.setValSalario(Funcionario.getValSalario() * valAumento); 						//aumento de 10%
	}
}
