package trab3POO;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Pessoa implements Interface {
	private static String nome;
	private static int idade;
	private static int ID = 0;
	private static PrintWriter out;
	private static File nomeArquivoOut;
	static ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
	private static String dados = "";
	static String cadastros;
	private static int qtdImpressao = 0;
	
	/* * * * * * * *
	 * CONSTRUTOR  *
	 * * * * * * * */
	public Pessoa() throws Exception{
//		System.out.println(f);
		ID = ID+1;
		File f = new File(nomeArquivoOut.toString());	//caminho para arquivo de saida
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
		int qtdTotalImpressao = 1;
		try {
			out.append(getDados());
			qtdImpressao += 1;
			if(getQtdImpressao() > qtdTotalImpressao) {
				JOptionPane.showMessageDialog(null, "Quantidade de impressoes permitidas: " + qtdTotalImpressao, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}catch (Exception e) {
			throw new Exception("\nErro na impressao do arquivo\n" + e);
		}
		out.close();
	}
	
	public static void closeBuffer() {
		try {
			out.close();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "\nErro no fechamento do arquivo", "Erro Escrita", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
}
