package ecp.ufma.br.filmes;

public class Filmes{
	//@ColumnAnnotation(nome = "Nome", posicao = 0)
	private String nome;
	//@ColumnAnnotation(nome = "Gênero", posicao = 1)
	private String genero;
	//@ColumnAnnotation(nome = "Código", posicao = 2)
	private int codigo;
	
	public Filmes(String nome, String genero, int codigo) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.codigo = codigo;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return " [nome=" + this.getNome() + ", genero=" + this.getGenero() + ", codigo=" + this.getCodigo() + "]";
	}

}