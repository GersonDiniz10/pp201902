package ecp.ufma.br.filmes;

import java.util.List;

public interface AbstractDAO<T> {
	void create(T obj);

	List<T> read();
}