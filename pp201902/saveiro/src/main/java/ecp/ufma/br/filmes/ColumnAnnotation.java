package ecp.ufma.br.filmes;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface ColumnAnnotation {
	String nome();
	int posicao();

}