package Biblioteca;

import java.time.LocalDate;

public class LivroService {
    private LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro) throws Exception {
        if (livro.getIsbn() == null || livro.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("ISBN é obrigatório.");
        }
        if (livroDAO.buscarPorISBN(livro.getIsbn()) != null) {
            throw new Exception("O ISBN já está cadastrado.");
        }
        if (livro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Ano de publicação não pode ser no futuro.");
        }
        livroDAO.adicionarLivro(livro);
    }

    public Livro consultarLivroPorISBN(String isbn) {
        throw new UnsupportedOperationException("Unimplemented method 'consultarLivroPorISBN'");
    }
    
}

