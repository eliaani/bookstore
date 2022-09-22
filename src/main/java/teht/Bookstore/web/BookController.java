package teht.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("Books", bookRepository.findAll());
		return "booklist";
	}
	
	@GetMapping("add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @PostMapping("save")
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	bookRepository.deleteById(id);
        return "redirect:../booklist";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", bookRepository.findById(id));
        return "editbook";
    }   
}