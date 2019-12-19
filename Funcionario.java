/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  Funcionario, class             *
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
