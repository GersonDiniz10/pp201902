package ecp.ufma.br.filmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmesDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/Filmes?user=root&password=7355608&useTimezone=true&serverTimezone=UTC";
	
	public FilmesDAO() {
		try {
			// Conectando com o banco
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desconectaBanco() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}// fecha conexao com o banco
	}

	public void salvaNoBanco(Filmes filmes) {
		try {
			String sql = "insert into filmes (nome, genero, codigo) values (?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filmes.getNome());
			stmt.setString(2, filmes.getGenero());
			stmt.setInt(3, filmes.getCodigo());
			stmt.execute();
			System.out.println("Adicionado com sucesso!");
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Filmes> readFilmes() {
		List<Filmes> filmes = new ArrayList<Filmes>();
		String sql = "select * from filmes";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				filmes.add(new Filmes(rs.getString("nome"), rs.getString("genero"), rs.getInt("codigo")));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmes;
	}
	
	public List<Filmes> recuperarFilmes() {
		try {
			List<Filmes> result = new ArrayList<Filmes>();
			String sql = "select * from filme";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Filmes(rs.getString("nome"), rs.getString("genero"), rs.getInt("codigo")));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public void update(Filmes filmes) {
		String sql = "update livros set nome = ?, autor = ? where codigo = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filmes.getNome());
			stmt.setString(2, filmes.getGenero());
			stmt.setLong(3, filmes.getCodigo());
			stmt.execute();
			System.out.println("Atualizado com sucesso!");
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
}
}