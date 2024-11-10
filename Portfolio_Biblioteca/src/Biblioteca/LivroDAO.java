package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {
    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (isbn, titulo, autor, ano_publicacao, categoria, disponivel) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());
            stmt.setInt(4, livro.getAnoPublicacao());
            stmt.setString(5, livro.getCategoria());
            stmt.setBoolean(6, livro.isDisponivel());
            stmt.executeUpdate();
        }
    }

    public Livro buscarPorISBN(String isbn) throws SQLException {
        String sql = "SELECT * FROM livros WHERE isbn = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, isbn);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Livro(rs.getInt("id"), rs.getString("isbn"), rs.getString("titulo"),
                            rs.getString("autor"), rs.getInt("ano_publicacao"), rs.getString("categoria"),
                            rs.getBoolean("disponivel"));
                }
            }
        }
        return null;
    }

}
