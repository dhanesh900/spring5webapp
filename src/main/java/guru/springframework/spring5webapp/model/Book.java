package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String name;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "book_author",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<Author>();

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public guru.springframework.spring5webapp.model.publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(guru.springframework.spring5webapp.model.publisher publisher) {
        this.publisher = publisher;
    }

    @ManyToOne
    private publisher publisher;

    public Book() {
    }

    public Book(String name, String isbn) {
        this.name = name;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
