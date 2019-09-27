package otus.spring.albot.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import otus.spring.albot.dao.AuthorDao;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.dao.GenreDao;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

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
    private AuthorDao authorDao;
    private BookDao bookDao;
    private GenreDao genreDao;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "gaa"})
    public List<String> getAllAuthors() {
        return authorDao.findAllAuthors().stream().map(Author::getName).collect(Collectors.toList());
    }

    @ShellMethod(value = "Get authors matching template", key = {"get-authors-by-template", "gat"})
    public List<String> getAuthorsByTemplate(@ShellOption(defaultValue = "") String template) {
        return authorDao.findAuthorByName(template).stream().map(Author::getName).collect(Collectors.toList());
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public List<String> getAllBooks() {
        return bookDao.findAllBooks().stream().map(Book::getName).collect(Collectors.toList());
    }

    @ShellMethod(value = "Get books matching template", key = {"get-books-by-template", "gbt"})
    public List<String> getBooksByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookDao.findBookByName(template).stream().map(Book::getName).collect(Collectors.toList());
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genres", "gag"})
    public List<String> getAllGenres() {
        return genreDao.findAllGenres().stream().map(Genre::getName).collect(Collectors.toList());
    }

    @ShellMethod(value = "Get gentes matching template", key = {"get-genres-by-template", "ggt"})
    public List<String> getGenresByTemplate(@ShellOption(defaultValue = "") String template) {
        return genreDao.findAllGenresByName(template).stream().map(Genre::getName).collect(Collectors.toList());
    }
}
