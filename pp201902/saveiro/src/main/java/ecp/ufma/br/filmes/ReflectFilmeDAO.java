package ecp.ufma.br.filmes;

import java.util.Arrays;
import java.util.List;

import ecp.ufma.br.filmes.Filme;

public class ReflectFilmeDAO implements AbstractDAO<Filme> {

	List<Filme> filmes = Arrays.asList(new Filme("Americão pai", "sei la pow", 325),
			new Filme("num sei meo", "casagrande", 453));

	public void create(Filme filme) {
	}

	public List<Filme> read() {
		return filmes;
	}

}
