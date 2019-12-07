package trab3POO;
public class Funcionario extends Pessoa{
	private float valSalario;

	public Funcionario() {
	}
	
	public float getValSalario() {
		return valSalario;
	}
	public void setValSalario(float valSalario) {
		this.valSalario = valSalario;
	}
	
	void aumentoSalario(float valAumento) {
		this.setValSalario(this.getValSalario() * valAumento); 						//aumento de 10%
	}
}
