package trab3POO;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;

public abstract class Pessoa implements Interface {
	private static String nome;
	private static int idade;
	private static int ID = 0;
	private static PrintWriter out;
	private static File nomeArquivoOut;
	static ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
	String line;

	public Pessoa() throws Exception{
//		System.out.println(f);
		ID = ID+1;
		File f = new File(nomeArquivoOut.toString());	//caminho para arquivo de saida
		out = new PrintWriter(System.out);
//		if(ID > 1) {
//			JOptionPane.showMessageDialog(null, "No momento, a quantidade de cadastros esta limitada a: 1\n" +  
//												"Para mais informacoes, contate o adminstrador do sistema",
//												"Error", JOptionPane.ERROR_MESSAGE);
//			System.exit(2);
//		}
	}

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
	
	public void aniversario() {
		Pessoa.setIdade(Pessoa.getIdade() + 1);
	}
	
//	public static void main(String args[]) throws Exception {		
//		out = new PrintWriter(f);
//	}
	
	
	public static void armazenaBuffer() throws Exception{	
		try {
			cadastro.forEach(val->{if (val instanceof Fornecedor) {
				out.append("3" + ";" +
						Fornecedor.getID() + ";" + 
						Fornecedor.getNome() + ";" + 
						Fornecedor.getIdade() + ";" + 
						Fornecedor.getIndiceQualidade());
			}else if(val instanceof Funcionario) {
				out.append("2" + ";"+ 
						Funcionario.getID() + ";" +
						Funcionario.getNome() + ";" + 
						Funcionario.getIdade() + ";" + 
						Funcionario.getValSalario());
			}else if(val instanceof Cliente) {
				out.append("1" + ";" + 
						Cliente.getID() + ";" + 
						Cliente.getNome() + ";" + 
						Cliente.getIdade() + ";" + 
						Cliente.getAvaliacaoCliente() + ";" +
						Cliente.getValorTotalGasto());
			}
			out.append("\n");
			});
			}catch (Exception e) {
				throw new Exception("Erro na impressao do arquivo" + e);
			}
		out.close();
	}
	public static void closeBuffer() {
		try {
			out.close();
//			FileReader fr = new FileReader(getNomeArquivoOut());
//			BufferedReader in = new BufferedReader(fr);
//			String line = in.readLine();
//			File f1 = new File("/home/gabriel/UFU/3 periodo/POO/Trab3POO/src/out1.txt");
//			PrintWriter pw = new PrintWriter(f1);
//			line += "teste";
//			pw.println(line);
//			pw.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "\nErro no fechamento do arquivo", "Erro Escrita", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
