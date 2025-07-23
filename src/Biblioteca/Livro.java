package Biblioteca;  // Define o pacote ao qual essa classe pertence

// Classe que representa um livro
public class Livro {
    public String titulo;  // Título do livro
    public double preco;   // Preço do livro
    public String genero;  // Gênero do livro

    // Construtor da classe Livro, que inicializa os atributos
    public Livro(String titulo, double preco, String genero) {
        this.titulo = titulo;
        this.preco = preco;
        this.genero = genero;
    }

    // Método sobrescrito que retorna uma representação em string do objeto Livro
    @Override
    public String toString() {
        return titulo + " - R$" + String.format("%.2f", preco) + " (" + genero + ")";
    }
}
