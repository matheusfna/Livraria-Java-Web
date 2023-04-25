package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import livraria.model.Livro;



public class LivroDAO {

	private Connection conn = null;

	public LivroDAO() {
		this.iniciarConexao();
	}

	public void iniciarConexao() {
		
		try {			

			this.conn = ConnectionFactory.getConnection();

			if (conn != null) {
				System.out.println("Conexão realizada com sucesso!");
			} else {
				System.out.println("Falha ao criar conexão");
			}

		} catch (Exception e) {
			System.out.println("Exception Erro: " + e.getMessage());
			throw new RuntimeException(e);
		
		}

	}	
	
	public void checarConexao() {		
		try {
			if (conn.isClosed())
				this.iniciarConexao();
		} catch (SQLException e) {			
			System.out.println("SQLException Erro: " + e.getMessage());
			throw new RuntimeException(e);
		}			
		
	}
	
	public void inserir(Livro livro) {

		String sql = "insert into livro (titulo, isbn, autor, editora) values (?, ?, ?, ?) ";

		Connection conn = null;
		PreparedStatement stm = null;

		try {		
			
			this.checarConexao();

			conn = this.conn;

			stm = conn.prepareStatement(sql);

			stm.setString(1, livro.getTitulo());
			stm.setString(2, livro.getIsbn());
			stm.setString(3, livro.getAutor());
			stm.setString(4, livro.getEditora());

			stm.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}
	}
	
	public List<Livro> listar() {

		String sql = "SELECT * FROM livro";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		int id;
		String titulo, isbn, autor, editora;

		try {
			
			this.checarConexao();

			conn = this.conn;

			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();

			List<Livro> livros = new ArrayList<Livro>();

			while (rs.next()) {

				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				isbn = rs.getString("isbn");
				autor = rs.getString("autor");
				editora = rs.getString("editora");

				livros.add(new Livro(id, titulo, isbn, autor, editora));

			}

			System.out.println("Lista de livros criada com sucesso!");

			return livros;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm, rs);
		}

	}
	
	public void alterar(Livro livro) {

		String sql = "uptade livro set titulo= ?, isbn= ?, autor= ?, editora= ? where id= ?";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			
			this.checarConexao();

			conn = this.conn;
			stm = conn.prepareStatement(sql);

			stm.setString(1, livro.getTitulo());
			stm.setString(2, livro.getIsbn());
			stm.setString(3, livro.getAutor());
			stm.setString(4, livro.getEditora());
			stm.setInt(4, livro.getId());

			stm.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}

	}
	
	public void excluir(Livro livro) {

		String sql = "delete from livro where id = ? ";

		Connection conn = null;
		PreparedStatement stm = null;

		try {
			
			this.checarConexao();

			conn = this.conn;
			stm = conn.prepareStatement(sql);

			stm.setInt(1, livro.getId());
			
			stm.executeUpdate();
			
			System.out.println(livro.toString());

			System.out.println("Remoção realizada com sucesso!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}

	}
	
	public Livro pesquisar(Livro livro) {

		String sql = "select * from livro where titulo = ? ";
		
		int id;
		String titulo, isbn, autor, editora;

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			
			this.checarConexao();

			conn = this.conn;
			stm = conn.prepareStatement(sql);

			stm.setString(1, livro.getTitulo());

			rs = stm.executeQuery();

			if (!rs.next())
				return null;
			
			id = rs.getInt("id");
			titulo = rs.getString("titulo");
			isbn = rs.getString("isbn");
			autor = rs.getString("autor");
			editora = rs.getString("editora");
			
			return new Livro(id, titulo, isbn, autor, editora);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(conn, stm);
		}

	}

}
