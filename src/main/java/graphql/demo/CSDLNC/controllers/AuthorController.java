package graphql.demo.CSDLNC.controllers;

import graphql.demo.CSDLNC.dtos.AuthorInput;
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
public class AuthorController {
    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;

    @Autowired
    public AuthorController(IAuthorRepository authorRepository, IBookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository =  bookRepository;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    Author authorById(@Argument Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Author is not found"));
    }

    @MutationMapping
    Author addAuthor(@Argument(name = "author") AuthorInput authorInput) {
        Author author = new Author(authorInput.authorName());
        authorRepository.save(author);
        return author;
    }
}
