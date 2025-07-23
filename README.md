# 📚 Biblioteca - Loja de Livros (Java)

Este é um projeto simples em Java que simula uma **loja de livros** no terminal. Ele permite ao usuário navegar por gêneros literários, visualizar livros disponíveis, adicionar ao carrinho e finalizar a compra.

## 🚀 Funcionalidades

- 📖 Catálogo de livros organizados por **gêneros**:
  - Romance
  - Ficção
  - Literatura Clássica
  - Drama
- 🛒 Adição de livros ao **carrinho de compras**
- 💰 Cálculo automático do valor total da compra
- Interface por linha de comando interativa com o usuário

## 🧱 Estrutura do Projeto

O projeto está organizado dentro do pacote `Biblioteca`, contendo as seguintes classes:

- `Main`: Classe principal que inicia a aplicação.
- `ArraysLoja`: Gerencia o catálogo, carrinho e a interação com o usuário.
- `Livro`: Representa os livros com título, preço e gênero.

## 📦 Como compilar e executar

### ✅ Pré-requisitos:
- Java JDK (versão 8 ou superior) instalado
- Terminal ou IDE como IntelliJ ou Eclipse

### 🛠️ Compilando via terminal:
 Clone o repositório:
```bash
git clone https://github.com/pedro-de-paula/Biblioteca.git

### 📁 Acesse a pasta do projeto:
cd Biblioteca

### 🪛  Compile os arquivos:
javac src/Biblioteca/*.java

### ▶️ Executando via terminal:
java -cp src Biblioteca.Main

###💻 Exemplo de uso:
Gêneros disponíveis:
0 - Romance
1 - Ficção
2 - Literatura Clássica
3 - Drama
Escolha o número do gênero: 1

Livros de Ficção:
0 - A Revolução Dos Bichos - George Orwell - R$20.66 (Ficção)
1 - 1984 - George Orwell - R$21.00 (Ficção)
...

Escolha o número do livro que deseja comprar: 0
Livro adicionado ao carrinho: A Revolução Dos Bichos - George Orwell

Deseja comprar outro livro? (s/n): n

--- Compra finalizada ---
Livros no carrinho:
- A Revolução Dos Bichos - George Orwell - R$20.66 (Ficção)
Total: R$20.66

###🛠️ Tecnologias utilizadas
Java puro
Programação orientada a objetos (POO)
Entrada e saída via Scanner no terminal

###👨‍💻 Autor
Desenvolvido por Pedro de Paula
Veja mais em: https://github.com/pedro-de-paula
