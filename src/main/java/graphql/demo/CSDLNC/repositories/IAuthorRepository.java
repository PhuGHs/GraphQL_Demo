package graphql.demo.CSDLNC.repositories;

import graphql.demo.CSDLNC.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends CrudRepository<Author, Long> {
}
