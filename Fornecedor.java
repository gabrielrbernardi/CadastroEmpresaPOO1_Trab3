package trab3POO;
public class Fornecedor extends Pessoa{
	private static int indiceQualidade;

	public Fornecedor() throws Exception{
	}
	
	public static int getIndiceQualidade() {
		return indiceQualidade;
	}
	public void setIndiceQualidade(int indiceQualidade) {
		Fornecedor.indiceQualidade = indiceQualidade;
	}
	
}
