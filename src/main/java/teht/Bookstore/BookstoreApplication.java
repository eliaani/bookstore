package teht.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teht.Bookstore.domain.Book;
import teht.Bookstore.domain.BookRepository;
import teht.Bookstore.domain.Category;
import teht.Bookstore.domain.CategoryRepository;
import teht.Bookstore.domain.ApplicationUser;
import teht.Bookstore.domain.ApplicationUserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookStuff(BookRepository bookrepository, CategoryRepository categoryrepository, ApplicationUserRepository applicationUserRepository) {
		return (args) -> {
			log.info("Add some books to the database");
			categoryrepository.save(new Category("Fantasy"));
			categoryrepository.save(new Category("Sci-fi"));
			categoryrepository.save(new Category("Romance"));
			bookrepository.save(new Book("kirja1", "Lovemore Chidi", "657-22-65432-32-1" ,1999, 25, categoryrepository.findByname("Fantasy").get(0)));
			bookrepository.save(new Book("kirja2", "Viola Ismene", "217-97-8364-97-6" , 2000, 20, categoryrepository.findByname("Sci-fi").get(0)));
			applicationUserRepository.save(new ApplicationUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			applicationUserRepository.save(new ApplicationUser("user", "$2a$10$hss2sI4wBehMqUWVJslFleDQxOs9txWVFW7bvwtrchiuwvEAgnx1.", "USER"));
			

		};
	}
}