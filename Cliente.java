package trab3POO;

public class Cliente extends Pessoa{
	private static int avaliacaoCliente;
	private static float valorTotalGasto = 0;
	
	public Cliente() throws Exception{
	}
	
	public static int getAvaliacaoCliente() {
		return avaliacaoCliente;
	}
	public void setAvaliacaoCliente(int avaliacaoCliente) {
		Cliente.avaliacaoCliente = avaliacaoCliente;
	}
	public static float getValorTotalGasto() {
		return valorTotalGasto;
	}
	public void setValorTotalGasto(float valorTotalGasto) {
		Cliente.valorTotalGasto = valorTotalGasto;
	}
	
	public void comprar(float val) {
		setValorTotalGasto(Cliente.getValorTotalGasto() + val);
	}
		
}
