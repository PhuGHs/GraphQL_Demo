package graphql.demo.CSDLNC.controllers;

import graphql.demo.CSDLNC.dtos.BookInput;
import graphql.demo.CSDLNC.entities.Author;
import graphql.demo.CSDLNC.entities.Book;
import graphql.demo.CSDLNC.repositories.IAuthorRepository;
import graphql.demo.CSDLNC.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;

    @Autowired
    public BookController(IBookRepository bookRepository, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public Iterable<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book bookByItsId(@Argument Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cant find book with the id provided"));
    }

    @MutationMapping
    Book addBook(@Argument(name = "book") BookInput bookInput) {
        Author author = authorRepository.findById(bookInput.authorId()).orElseThrow(() -> new IllegalArgumentException("author is not found"));
        Book b = new Book(bookInput.bookName(), bookInput.publisher(), author);
        bookRepository.save(b);
        return b;
    }
}
