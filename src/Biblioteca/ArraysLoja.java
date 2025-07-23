package Biblioteca;

import java.util.Scanner;

// Classe principal responsável por gerenciar a loja de livros
public class ArraysLoja {
    private Livro[][] catalogo;      // Matriz que armazena os livros, separados por gênero
    private String[] generos;        // Array que armazena os nomes dos gêneros
    private Livro[] carrinho;        // Array para armazenar os livros adicionados ao carrinho
    private int carrinhoIndex;       // Índice que controla a posição atual do carrinho
    private Scanner scanner;         // Scanner para entrada de dados do usuário

    // Construtor da classe
    public ArraysLoja() {
        scanner = new Scanner(System.in);     // Inicializa o scanner
        inicializarCatalogo();                // Chama método para preencher o catálogo com os livros
        carrinho = new Livro[20];             // Inicializa o carrinho com capacidade para 20 livros
        carrinhoIndex = 0;                    // Começa com o carrinho vazio
    }

    // Método que inicializa os livros no catálogo, separados por gênero
    private void inicializarCatalogo() {
        generos = new String[] { "Romance", "Ficção", "Literatura Clássica", "Drama" }; // Lista de gêneros
        catalogo = new Livro[4][]; // Cada linha representa um gênero

        // Adiciona os livros de Romance
        catalogo[0] = new Livro[] {
                new Livro("Gente Pobre - Dostoiévski", 18.08, "Romance"),
                new Livro("P.S. Eu Te Amo - Cecelia Ahern", 16.33, "Romance"),
                new Livro("A Biblioteca da Meia-Noite - Matt Haig", 36.80, "Romance"),
                new Livro("A Hipótese do Amor - Ali Hazelwood", 44.90, "Romance"),
                new Livro("Como Eu Era Antes de Você - Jojo Moyes", 38.50, "Romance")
        };

        // Adiciona os livros de Ficção
        catalogo[1] = new Livro[] {
                new Livro("A Revolução Dos Bichos - George Orwell", 20.66, "Ficção"),
                new Livro("1984 - George Orwell", 21.00, "Ficção"),
                new Livro("Fahrenheit 451 - Ray Bradbury", 38.13, "Ficção"),
                new Livro("O Sol é para todos - Harper Lee", 44.90, "Ficção"),
                new Livro("Admirável Mundo Novo - Aldous Leonard Huxley", 32.00, "Ficção")
        };

        // Adiciona os livros de Literatura Clássica
        catalogo[2] = new Livro[] {
                new Livro("Cartas de um diabo a seu aprendiz - C.S. Lewis", 37.90, "Literatura Clássica"),
                new Livro("Cem Anos de Solidão - Gabriel García Márquez", 59.90, "Literatura Clássica"),
                new Livro("Memórias do Subsolo - Fiódor Dostoiévski", 29.50, "Literatura Clássica"),
                new Livro("O Pequeno Príncipe - Antoine de Saint-Exupéry", 34.90, "Literatura Clássica"),
                new Livro("Noites Brancas - Dostoiévski", 27.80, "Literatura Clássica")
        };

        // Adiciona os livros de Drama
        catalogo[3] = new Livro[] {
                new Livro("A Insustentável Leveza do Ser - Milan Kundera", 54.00, "Drama"),
                new Livro("As Horas - Michael Cunningham", 45.90, "Drama"),
                new Livro("O Deus das Pequenas Coisas - Arundhati Roy", 48.70, "Drama"),
                new Livro("Ensaio Sobre a Cegueira - José Saramago", 52.30, "Drama"),
                new Livro("O Sol é Para Todos - Harper Lee", 46.80, "Drama")
        };
    }

    // Método principal para iniciar a compra
    public void iniciarCompra() {
        boolean continuarComprando = true;

        while (continuarComprando) {
            mostrarGeneros();                       // Mostra a lista de gêneros
            int generoEscolhido = escolherGenero(); // Pede para o usuário escolher um gênero

            mostrarLivrosDoGenero(generoEscolhido);         // Mostra os livros disponíveis no gênero escolhido
            int livroEscolhido = escolherLivro(generoEscolhido); // Usuário escolhe o livro

            adicionarAoCarrinho(catalogo[generoEscolhido][livroEscolhido]); // Adiciona o livro ao carrinho

            continuarComprando = perguntarSeContinua(); // Pergunta se deseja continuar
        }

        finalizarCompra(); // Exibe o resumo da compra
    }

    // Mostra todos os gêneros disponíveis
    private void mostrarGeneros() {
        System.out.println("\nGêneros disponíveis:");
        for (int i = 0; i < generos.length; i++) {
            System.out.println(i + " - " + generos[i]);
        }
    }

    // Lê a escolha do gênero e valida a entrada
    private int escolherGenero() {
        System.out.print("Escolha o número do gênero: ");
        int escolha = scanner.nextInt();
        while (escolha < 0 || escolha >= generos.length) {
            System.out.print("Gênero inválido. Escolha novamente: ");
            escolha = scanner.nextInt();
        }
        return escolha;
    }

    // Mostra os livros do gênero escolhido
    private void mostrarLivrosDoGenero(int generoIndex) {
        System.out.println("\nLivros de " + generos[generoIndex] + ":");
        Livro[] livros = catalogo[generoIndex];
        for (int i = 0; i < livros.length; i++) {
            System.out.println(i + " - " + livros[i]);
        }
    }

    // Lê a escolha do livro e valida a entrada
    private int escolherLivro(int generoIndex) {
        System.out.print("Escolha o número do livro que deseja comprar: ");
        int escolha = scanner.nextInt();
        while (escolha < 0 || escolha >= catalogo[generoIndex].length) {
            System.out.print("Livro inválido. Escolha novamente: ");
            escolha = scanner.nextInt();
        }
        return escolha;
    }

    // Adiciona o livro selecionado ao carrinho
    private void adicionarAoCarrinho(Livro livro) {
        if (carrinhoIndex < carrinho.length) {
            carrinho[carrinhoIndex++] = livro;
            System.out.println("Livro adicionado ao carrinho: " + livro.titulo);
        } else {
            System.out.println("Carrinho cheio! Não é possível adicionar mais livros.");
        }
    }

    // Pergunta ao usuário se deseja continuar comprando
    private boolean perguntarSeContinua() {
        System.out.print("\nDeseja comprar outro livro? (s/n): ");
        String resposta = scanner.next().toLowerCase();
        return resposta.equals("s"); // Retorna true se a resposta for "s"
    }

    // Exibe os livros comprados e o valor total
    private void finalizarCompra() {
        System.out.println("\n--- Compra finalizada ---");
        double total = 0.0;
        System.out.println("Livros no carrinho:");
        for (int i = 0; i < carrinhoIndex; i++) {
            System.out.println("- " + carrinho[i]); // Usa toString() do Livro
            total += carrinho[i].preco;
        }
        System.out.printf("Total: R$%.2f\n", total);
    }
}
