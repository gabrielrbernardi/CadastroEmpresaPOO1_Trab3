/*****************************************************************
 * Nome do projeto: 			  Trab3POO                       *
 * Nome, tipo de aquivo:		  Pessoa, abstract class         *
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

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Desktop;

public abstract class Pessoa implements Interface {
	private static String nome;
	private static int idade;
	private static int ID = 0;
	private static File nomeArquivoOut;
	static ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
	private static String dados = "";
	static String cadastros;
	private static int qtdImpressao = 0;
	private static PrintWriter out;
	private static File f;
	
	/* * * * * * * *
	 * CONSTRUTOR  *
	 * * * * * * * */
	public Pessoa() throws Exception{
//		System.out.println(f);
		ID = ID+1;//caminho para arquivo de saida
		f = new File(nomeArquivoOut.toString());
		out = new PrintWriter(f);
//		if(ID > 1) {
//			JOptionPane.showMessageDialog(null, "No momento, a quantidade de cadastros esta limitada a: 1\n" +  
//												"Para mais informacoes, contate o adminstrador do sistema",
//												"Error", JOptionPane.ERROR_MESSAGE);
//			System.exit(2);
//		}
	}
	/* * * * * * * * * * * * *
	 * GETTERS AND SETTERS   *
	 * * * * * * * * * * * * */
	public static File getNomeArquivoOut() {
		return nomeArquivoOut;
	}
	public static void setNomeArquivoOut(File file) {
		Pessoa.nomeArquivoOut = file;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Pessoa.nome = nome;
	}
	public static int getIdade() {
		return idade;
	}
	public static void setIdade(int idade) {
		Pessoa.idade = idade;
	}
	public static int getID() {
		return ID;
	}
	public static String getCadastros() {
		return cadastros;
	}
	public static void setCadastros(String cadastros) {
		Pessoa.cadastros = cadastros;
	}
	public static String getDados() {
		return dados;
	}
	public void setDados(String dados) {
		Pessoa.dados = Pessoa.getDados() + getID() + ";" + dados + "\n";
	}
	public static int getQtdImpressao() {
		return qtdImpressao;
	}
	
	/* * * * * * * * * * * * * * 
	 * METODOS PERSONALIZADOS  *
	 * * * * * * * * * * * * * */
	public void aniversario() {
		Pessoa.setIdade(Pessoa.getIdade() + 1);
	}
	
	public static void armazenaBuffer() throws Exception{
		int qtdTotalImpressao = 1;												// Quantidade permitida de impressoes no arquivo de saida
		try {
			out.append(getDados());
			qtdImpressao += 1;
			if(getQtdImpressao() > qtdTotalImpressao) {
				JOptionPane.showMessageDialog(null, "Quantidade de impressoes permitidas: " + qtdTotalImpressao, "Error", JOptionPane.ERROR_MESSAGE);
			}
			out.close();														// Encerrando a Stream para saida no arquivo
			int res = JOptionPane.showConfirmDialog(null, "Deseja abrir o arquivo de saida?");
			if(res == JOptionPane.OK_OPTION) {
				Desktop desktop = Desktop.getDesktop();
				if(f.exists()) {
					desktop.open(f);											// Apos a impressao, o arquivo sera aberto, se escolhido pelo usuario
				}else {
					JOptionPane.showMessageDialog(null, "Arquivo nao encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na impressao do arquivo\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
}
