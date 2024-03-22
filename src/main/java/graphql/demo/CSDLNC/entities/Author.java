package graphql.demo.CSDLNC.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Author(String authorName) {
        this.authorName = authorName;
    }
}
