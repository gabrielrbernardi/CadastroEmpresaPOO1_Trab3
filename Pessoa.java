package trab3POO;
public abstract class Pessoa implements Interface{
	private String nome;
	private int idade;
	private static int ID = 0;
	
	public Pessoa() {
		ID = ID+1;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public static int getID() {
		return ID;
	}
	
	public void aniversario() {
		this.setIdade(this.getIdade() + 1);
	}
	
}
