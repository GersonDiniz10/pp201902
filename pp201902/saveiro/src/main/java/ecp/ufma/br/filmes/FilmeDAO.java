package ecp.ufma.br.filmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private final String url = "jdbc:mysql://localhost/Filmes?user=root&password=1234&useTimezone=true&serverTimezone=UTC";

	public FilmeDAO() {
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso ao banco!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desconectaBanco() {
		try {
			conn.close();
			System.out.println("O aplicativo foi desconectado ao banco!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvaNoBanco(Filme filme) {
		try {
			String sql = "insert into filmes (nome, genero, codigo) values (?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filme.getNome());
			stmt.setString(2, filme.getGenero());
			stmt.setLong(3, filme.getCodigo());
			stmt.execute();
			System.out.println("Adicionado com sucesso!");
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Filme> readFilmes() {
		List<Filme> filme = new ArrayList<Filme>();
		String sql = "select * from filmes";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Filme.add(new Filme(rs.getString("nome"), rs.getString("genero"), rs.getInt("codigo")));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filme;
	}
	
	public void update(Filme filme) {
		String sql = "update filmes set nome = ?, genero = ? where codigo = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filme.getNome());
			stmt.setString(2, filme.getGenero());
			stmt.setLong(3, filme.getCodigo());
			stmt.execute();
			System.out.println("Atualizado com sucesso!");
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}