package graphql.demo.CSDLNC;

import graphql.demo.CSDLNC.entities.Author;
import graphql.demo.CSDLNC.entities.Book;
import graphql.demo.CSDLNC.repositories.IAuthorRepository;
import graphql.demo.CSDLNC.repositories.IBookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class CsdlncApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsdlncApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(IAuthorRepository authorRepository, IBookRepository bookRepository) {
		return args -> {
			Author dale = new Author("Dale Carnegie");
			Author mitchell = new Author("Margaret Mitchell");
			Author coelho = new Author("Paulo Coelho");

			Book book1 = new Book("Đắc Nhân Tâm", "Publisher A", dale);
			Book book2 = new Book("Cuốn theo chiều gió", "Publisher A", mitchell);
			Book book3 = new Book("Nhà giả kim", "Publisher A", coelho);
			Book book4 = new Book("The Alchemist", "Publisher A", coelho);
			Book book5 = new Book("Điệp viên", "Publisher A", coelho);

			dale.getBooks().add(book1);
			mitchell.getBooks().add(book2);
			coelho.getBooks().add(book3);
			coelho.getBooks().add(book4);
			coelho.getBooks().add(book5);

			authorRepository.save(dale);
			authorRepository.save(mitchell);
			authorRepository.save(coelho);

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
			bookRepository.save(book5);
		};
	}
}
