/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  Cliente, class                 *
 * Autor(es): 					  Gabriel Ribeiro Bernardi,      *
 * 								  Guilherme Soares Correa,       *
 * 								  Antonio Pedro Rodrigues Santos *
 * Matricula: 					  11821BCC036                    *
 * 								  11821BCC026				     *
 * 								  11821BCC021		    	     *
 * Data de inicio: 				  06/12/2019				     *
 * Data final de desenvolvimento: 18/12/2019      		         *
 * Data da ultima modificacao: 	  18/12/2019				     *
 * Dias de desenvolvimento:       13                             *
 * Linguagem utilizada:			  Java						     *
 * Plataforma Java utilizada:     Java SE Development Kit 13     *
 ****************************************************************/

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
