package teht.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import teht.Bookstore.domain.Book;
import teht.Bookstore.domain.BookRepository;
import teht.Bookstore.domain.CategoryRepository;

@RestController
public class BookRestController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public List<Book> bookListRest() {	
        return (List<Book>) bookRepository.findAll();
    }    

    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return bookRepository.findById(bookId);
    }    
}
