package otus.spring.albot.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import otus.spring.albot.business.AuthorService;
import otus.spring.albot.business.BookCommentPreparer;
import otus.spring.albot.business.BookService;
import otus.spring.albot.business.CommentAddingService;
import otus.spring.albot.business.GenreService;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Genre;
import otus.spring.albot.model.BookComments;

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
    private AuthorService authorService;
    private BookService bookService;
    private GenreService genreService;
    private BookCommentPreparer bookCommentPreparer;
    private CommentAddingService commentAddingService;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "gaa"})
    public List<Author> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @ShellMethod(value = "Get authors matching template", key = {"get-authors-by-template", "gat"})
    public Author getAuthorsByTemplate(@ShellOption(defaultValue = "") String template) {
        return authorService.findByName(template);
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @ShellMethod(value = "Get books matching template", key = {"get-books-by-template", "gbt"})
    public Book getBooksByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookService.findByName(template);
    }

    @ShellMethod(value = "Get book by id", key = {"get-book-by-id", "gbbi"})
    public Book getBookById(@ShellOption long id) {
        return bookService.findById(id);
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genres", "gag"})
    public List<Genre> getAllGenres() {
        return genreService.findAllGenres();
    }

    @ShellMethod(value = "Get gentes matching template", key = {"get-genres-by-template", "ggt"})
    public Genre getGenresByTemplate(@ShellOption(defaultValue = "") String template) {
        return genreService.findByName(template);
    }

    @ShellMethod(value = "Get all comments for the book by template", key = {
            "get-all-comments-for-the-book-by-template", "gacbbt"})
    public BookComments getAllCommentsForBookByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookCommentPreparer.extractAllCommentsForBookByName(template);
    }

    @ShellMethod(value = "Get all comments for the book by id", key = {"get-all-comments-for-the-book-by-id", "gacbbi"})
    public BookComments getAllCommentsForBookById(@ShellOption long id) {
        return bookCommentPreparer.extractAllCommentsForBookById(id);
    }

    @ShellMethod(value = "Add comment to the book with id", key = {"bac", "book-add-comment"})
    public Book addCommentToBook(@ShellOption long id, @ShellOption String comment) {
        return commentAddingService.addCommentToBook(id, comment);
    }
}
