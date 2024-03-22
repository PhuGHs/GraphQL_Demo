package graphql.demo.CSDLNC.repositories;

import graphql.demo.CSDLNC.entities.Author;
import graphql.demo.CSDLNC.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {
}
