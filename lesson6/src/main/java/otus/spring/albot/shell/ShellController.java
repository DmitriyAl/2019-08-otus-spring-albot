package otus.spring.albot.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Genre;
import otus.spring.albot.repo.AuthorRepo;
import otus.spring.albot.repo.BookRepo;
import otus.spring.albot.repo.GenreRepo;

import java.util.List;

/**
 * <pre>
 * $Id: $
 * $LastChangedBy: $
 * $LastChangedRevision: $
 * $LastChangedDate: $
 * </pre>
 *
 * @author Dmitrii Albot
 */
@ShellComponent
@AllArgsConstructor
public class ShellController {
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private GenreRepo genreRepo;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "gaa"})
    public List<Author> getAllAuthors() {
        return authorRepo.findAllAuthors();
    }

    @ShellMethod(value = "Get authors matching template", key = {"get-authors-by-template", "gat"})
    public List<Author> getAuthorsByTemplate(@ShellOption(defaultValue = "") String template) {
        return authorRepo.findAuthorByName(template);
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public List<Book> getAllBooks() {
        return bookRepo.findAllBooks();
    }

    @ShellMethod(value = "Get books matching template", key = {"get-books-by-template", "gbt"})
    public List<Book> getBooksByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookRepo.findBookByName(template);
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genres", "gag"})
    public List<Genre> getAllGenres() {
        return genreRepo.findAllGenres();
    }

    @ShellMethod(value = "Get gentes matching template", key = {"get-genres-by-template", "ggt"})
    public List<Genre> getGenresByTemplate(@ShellOption(defaultValue = "") String template) {
        return genreRepo.findAllGenresByName(template);
    }
}
