package guru.springframework.spring5webapp.booststrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorsRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //manage this as a spring framework component
public class BoostStrapData implements CommandLineRunner {

    private final AuthorsRepository authorsRepository;
    private final BookRepository bookRepository;


    public BoostStrapData(AuthorsRepository authorsRepository, BookRepository bookRepository) {
        this.authorsRepository = authorsRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("eric", "business");
        Book bookEca = new Book("Design Patters", "1234567");

        eric.getBooks().add(bookEca);
        bookEca.getAuthors().add(eric);

        authorsRepository.save(eric);
        bookRepository.save(bookEca);

        Author author2 = new Author("name2", "surname2");
        Book book2 = new Book("bookName2", "23456");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorsRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started Bootstrap... ");

        System.out.println("Number of books: " + bookRepository.count());

    }
}
