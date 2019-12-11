package trab3POO;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;;

public abstract class Pessoa implements Interface {
	private static String nome;
	private static int idade;
	private static int ID = 0;
	private static PrintWriter out;
	static ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();

	public Pessoa() throws Exception{
		File f = new File("/home/gabriel/UFU/3 periodo/POO/Trab3POO/src/out.txt");	//caminho para arquivo de saida
		out = new PrintWriter(f);
		ID = ID+1;
	}
	public static String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		Pessoa.nome = nome;
	}
	public static int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		Pessoa.idade = idade;
	}
	public static int getID() {
		return ID;
	}
	
	public void aniversario() {
		this.setIdade(Pessoa.getIdade() + 1);
	}
	
//	public static void main(String args[]) throws Exception {		
//		out = new PrintWriter(f);
//	}
	
	
	public static void armazenaBuffer() throws Exception{
		try {
			cadastro.forEach(val->{if (val instanceof Fornecedor) {
			out.println("3" + ";" +
						Pessoa.getID() + ";" + 
						Pessoa.getNome() + ";" + 
						Fornecedor.getIdade() + ";" + 
						Fornecedor.getIndiceQualidade() + "\n");

			}else if(val instanceof Funcionario) {
				out.append("2" + ";"+ 
						Pessoa.getID() + ";" +
						Pessoa.getNome() + ";" + 
						Pessoa.getIdade() + ";" + 
						Funcionario.getValSalario() + "\n");
			}else if(val instanceof Cliente) {
				out.append("1" + ";" + 
						Pessoa.getID() + ";" + 
						Pessoa.getNome() + ";" + 
						Pessoa.getIdade() + ";" + 
						Cliente.getAvaliacaoCliente() + ";" +
						Cliente.getValorTotalGasto() + "\n");
			}
			});
			}catch (Exception e) {
				throw new Exception("Erro na impressao do arquivo" + e);
			}
	}
	public static void closeBuffer() {
		try {
			out.close();			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + "\nErro no fechamento do arquivo", "Erro Escrita", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
