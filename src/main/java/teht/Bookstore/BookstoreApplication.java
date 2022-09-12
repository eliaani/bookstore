package teht.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teht.Bookstore.domain.Book;
import teht.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookStuff(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("kirja1", "Lovemore Chidi", "657-22-65432-32-1" ,1999, 25));
			repository.save(new Book("kirja2", "Viola Ismene", "217-97-8364-97-6" , 2000, 20));
		};
	}
}