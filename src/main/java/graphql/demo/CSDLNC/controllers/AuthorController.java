package graphql.demo.CSDLNC.controllers;

import graphql.demo.CSDLNC.entities.Author;
import graphql.demo.CSDLNC.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    private final IAuthorRepository authorRepository;

    @Autowired
    public AuthorController(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    Iterable<Author> authors() {
        return authorRepository.findAll();
    }
}
