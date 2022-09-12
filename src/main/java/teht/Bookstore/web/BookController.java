package teht.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import teht.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@RequestMapping("index")
	@ResponseBody
	public String showIndex() {
		return "This is the main page";
	}
	
	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("Books", bookRepository.findAll());
		return "booklist";
	}
}