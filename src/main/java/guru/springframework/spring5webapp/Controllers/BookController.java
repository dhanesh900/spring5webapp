package guru.springframework.spring5webapp.Controllers;

import guru.springframework.spring5webapp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public  String getBooks(Model model)
    {
        model.addAttribute("books",bookRepository.findAll());
        return "Books/list";
    }
}
