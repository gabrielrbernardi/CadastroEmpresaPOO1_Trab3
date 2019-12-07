package trab3POO;
public class Cliente extends Pessoa{
	private int avaliacaoCliente;
	private float valorTotalGasto = 0;
	
	public Cliente() {
	}
	
	public int getAvaliacaoCliente() {
		return avaliacaoCliente;
	}
	public void setAvaliacaoCliente(int avaliacaoCliente) {
		this.avaliacaoCliente = avaliacaoCliente;
	}
	public float getValorTotalGasto() {
		return valorTotalGasto;
	}
	public void setValorTotalGasto(float valorTotalGasto) {
		this.valorTotalGasto = valorTotalGasto;
	}
	
	public void comprar(float val) {
		setValorTotalGasto(this.getValorTotalGasto() + val);
	}
		
}
