package teht.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import teht.Bookstore.domain.Book;
import teht.Bookstore.domain.BookRepository;
import teht.Bookstore.domain.CategoryRepository;
import teht.Bookstore.domain.ApplicationUserRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ApplicationUserRepository userRepository;

	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("Books", bookRepository.findAll());
		return "booklist";
	}
	
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }
    
    @PostMapping("save")
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	bookRepository.deleteById(id);
        return "redirect:../booklist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", bookRepository.findById(id));
    	model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }   
}