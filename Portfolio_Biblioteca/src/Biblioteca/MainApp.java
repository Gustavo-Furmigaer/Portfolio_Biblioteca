package Biblioteca;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        LivroService livroService = new LivroService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: 1 - Cadastrar Livro, 2 - Consultar Livro, 3 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                if (opcao == 1) {
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de Publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    Livro livro = new Livro(0, isbn, titulo, autor, ano, categoria, true);
                    livroService.cadastrarLivro(livro);
                    System.out.println("Livro cadastrado com sucesso!");

                } else if (opcao == 2) {
                    System.out.print("Digite o ISBN para consulta: ");
                    String isbn = scanner.nextLine();
                    Livro livro = livroService.consultarLivroPorISBN(isbn);
                    if (livro != null) {
                        System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                } else if (opcao == 3) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

