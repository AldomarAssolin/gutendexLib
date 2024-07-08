package com.aldomarassolin.GutendexLib.principal;

import com.aldomarassolin.GutendexLib.model.Book;
import com.aldomarassolin.GutendexLib.model.DadosBooks;
import com.aldomarassolin.GutendexLib.model.Person;
import com.aldomarassolin.GutendexLib.repository.BookRepository;
import com.aldomarassolin.GutendexLib.service.BookService;
import com.aldomarassolin.GutendexLib.service.ConsumoAPI;
import com.aldomarassolin.GutendexLib.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);

    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/";


    @Autowired
    private BookRepository repositorio;

    @Autowired
    private final BookService bookService;

    private List<Book> books = new ArrayList<>();

    private final ApplicationContext context;

    public Principal(BookRepository repositorio, BookService bookService, ApplicationContext context) {
        this.repositorio = repositorio;
        this.bookService = bookService;
        this.context = context;
    }

    public void showMenu() {
        int opcao = -1;

        while (opcao != 0) {
            var menu = """
                    \n**********MENU PRINCIPAL*************
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em determinado idioma
                    0 - Sair
                    *********###############**************
                   """;

            System.out.printf(menu);
            System.out.printf("Digite uma opcao: ");
            try {
                opcao = leitura.nextInt();
                leitura.nextLine();

                switch (opcao) {
                    case 1:
                        buscarLivroWeb();
                        break;
                    case 2:
                        listarTodosLivros();
                        break;
                    case 3:
                        listarAutores();
                        break;
                    case 4:
                        listarAutorNascidoDeterminadoAno();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        SpringApplication.exit(context, () -> 0);
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.printf("\n*******Digite uma opção válida.");
                leitura.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    private void buscarLivroWeb() {
        try {
            DadosBooks dados = buscarLivro();
            if (dados == null || dados.getBooks() == null || dados.getBooks().isEmpty()) {
                System.out.println("Nenhum livro encontrado.");
                return;
            }

            List<Book> books = dados.getBooks();

            System.out.println("Livros: " + books);

//            var tituloLivro = book.getTitle();
//            System.out.println("titulo Livro: " + tituloLivro);
//            books = repositorio.findAll();
//
//            Optional<Book> novoLivro = books.stream()
//                    .filter(s -> s.getTitle().toLowerCase().contains(tituloLivro.toLowerCase()))
//                    .findFirst();
//
//            System.out.println("Novo livro: " + novoLivro);
//
//            if(novoLivro.isPresent()){
//                System.out.printf("\n*****Livro já existe*****");
//            }else{
//                repositorio.save(book);
//            }



            System.out.println(books);

            for (Book book : books) {
                System.out.println("Título: " + book.getTitle());
                System.out.println("Autores: " + book.getAuthors());
                System.out.println("Assuntos: " + book.getSubjects());
                System.out.println("Idiomas: " + book.getLanguages());
                System.out.println("Formatos: " + book.getFormats());
                System.out.println("Generos: " + book.getBookshelves());
                System.out.println("Downloads: " + book.getDownloadCount());
                System.out.println("-----------------------");

                // Salvar no repositório se necessário
                repositorio.save(book);
                System.out.println(book);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar o livro: " + e.getMessage());
            e.printStackTrace(); // Para obter mais detalhes do erro
        }
    }



    private DadosBooks buscarLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();

        var endereco = ENDERECO + "?search=" + nomeLivro.replace(" ", "%20");
        System.out.println("Chamando URL: " + endereco); // Log da URL sendo chamada
        var json = consumo.obterDados(endereco);

        if (json == null || json.trim().isEmpty()) {
            throw new RuntimeException("Resposta da API está vazia");
        }

        System.out.println("JSON recebido: " + json); // Log da resposta JSON
        return conversor.obterDados(json, DadosBooks.class);
    }

    private List<Book> listarTodosLivros(){
        List<Book> dadosBooks = repositorio.findAll();
        dadosBooks.forEach(System.out::println);
        return null;
    }

    private List<Person> listarAutores(){

        List<Person> autores = bookService.listarAutores();
        System.out.println("Autores retorno: " + autores);
        autores.forEach(System.out::println);

        return null;
    }

    private DadosBooks pesquisarAutoresNascDeterminadoAno(){
        System.out.println("Digite o ano inicial da busca: ");
        var anoInicial = leitura.nextInt();
        System.out.println("Digite o ano final da busca: ");
        var anoFinal = leitura.nextInt();

        var endereco = ENDERECO + "/?author_year_start=" + anoInicial + "&author_year_end=" + anoFinal;
        var json = consumo.obterDados(endereco);

        return conversor.obterDados(json, DadosBooks.class);
    }

    private DadosBooks listarAutorNascidoDeterminadoAno(){
        DadosBooks dados = pesquisarAutoresNascDeterminadoAno();

        List<Book> books = dados.getBooks();

        for (Book book : books) {
            System.out.println("Livro: " + book.getTitle());
            System.out.println("Autores: " + book.getAuthors());
            System.out.println("-----------------------");

            // Salvar no repositório se necessário
            repositorio.save(book);
            //System.out.println(book);
        }

        return null;

    }


}

