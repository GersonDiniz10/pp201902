package ecp.ufma.br.filmes;

public class Filmes{
	private String nome;
	private String genero;
	private String codigo;
	
	public Filmes(String nome, String genero, String codigo) {
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return " [nome=" + this.getNome() + ", genero=" + this.getGenero() + ", codigo=" + this.getCodigo() + "]";
	}

}