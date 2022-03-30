package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repository.AuthorRepository;
import guru.springframework.spring5webapp.Repository.BookRepository;
import guru.springframework.spring5webapp.Repository.PublisherRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public bootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    publisher p=new publisher("IEEE","street no 13","Newyork","USA","69230");
    publisherRepository.save(p);
        Book b=new Book("java","12345");
        Author a=new Author("dhanesh","kumar");
        a.getBooks().add(b);
        b.getAuthors().add(a);
        b.setPublisher(p);
        p.getBooks().add(b);
        authorRepository.save(a);
        bookRepository.save(b);

        System.out.println("publisher Count" + publisherRepository.count());
        System.out.println("book Count" + bookRepository.count());
        System.out.println("author Count" + authorRepository.count());
    }
}
