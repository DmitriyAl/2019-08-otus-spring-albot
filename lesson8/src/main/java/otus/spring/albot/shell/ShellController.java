package otus.spring.albot.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import otus.spring.albot.business.BookCommentPreparer;
import otus.spring.albot.business.BookService;
import otus.spring.albot.business.CommentService;
import otus.spring.albot.dao.AuthorDao;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.dao.GenreDao;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
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
    private BookCommentPreparer bookCommentPreparer;
    private CommentService commentService;
    private BookService bookService;
    private AuthorDao authorDao;
    private BookDao bookDao;
    private GenreDao genreDao;

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "gaa"})
    public List<Author> getAllAuthors() {
        return authorDao.findAllAuthors();
    }

    @ShellMethod(value = "Get authors matching template", key = {"get-authors-by-template", "gat"})
    public List<Author> getAuthorsByTemplate(@ShellOption(defaultValue = "") String template) {
        return authorDao.findAuthorByName(template);
    }

    @ShellMethod(value = "Add a new author", key = {"add-new-author", "ana"})
    public String addNewAuthor(@ShellOption String name) {
        authorDao.addNewAuthor(name);
        return "The new author was added";
    }

    @ShellMethod(value = "Remove the author", key = {"delete-author", "da"})
    public String deleteAuthor(@ShellOption long id) {
        authorDao.deleteAuthor(id);
        return "The author was removed";
    }

    @ShellMethod(value = "Change author name. Parameters id and the new name", key = {"change-author-name", "can"})
    public String changeAuthorName(@ShellOption long id, String newName) {
        Author author = authorDao.changeAuthorName(id, newName);
        return "Author was changed, new author is " + author.toString();
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public List<Book> getAllBooks() {
        return bookDao.findAllBooks();
    }

    @ShellMethod(value = "Get books matching template", key = {"get-books-by-template", "gbt"})
    public List<Book> getBooksByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookDao.findBookByName(template);
    }

    @ShellMethod(value = "Get book by id", key = {"get-book-by-id", "gbbi"})
    public Book getBookById(@ShellOption long id) {
        return bookDao.findBookById(id);
    }

    @ShellMethod(value = "Add a new book", key = {"add-new-book", "anb"})
    public String addNewBook(@ShellOption String name, @ShellOption long authorId, @ShellOption long genreId) {
        bookService.addNewBook(name, authorId, genreId);
        return "The new book was added";
    }

    @ShellMethod(value = "Remove the book", key = {"delete-book", "db"})
    public String deleteBook(long id) {
        bookDao.deleteBook(id);
        return "The book was removed";
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genres", "gag"})
    public List<Genre> getAllGenres() {
        return genreDao.findAllGenres();
    }

    @ShellMethod(value = "Get gentes matching template", key = {"get-genres-by-template", "ggt"})
    public List<Genre> getGenresByTemplate(@ShellOption(defaultValue = "") String template) {
        return genreDao.findAllGenresByName(template);
    }

    @ShellMethod(value = "Add a new genre", key = {"add-new-genre", "ang"})
    public String addNewGenre(@ShellOption String name) {
        genreDao.addNewGenre(name);
        return "The new genre was added";
    }

    @ShellMethod(value = "Remove the genre", key = {"delete-genre", "dg"})
    public String deleteGenre(@ShellOption long id) {
        genreDao.deleteGenre(id);
        return "The genre was removed";
    }

    @ShellMethod(value = "Get all comments for the book by template", key = {"get-all-comments-for-the-book-by-template", "gacbbt"})
    public List<BookComments> getAllCommentsForBookByTemplate(@ShellOption(defaultValue = "") String template) {
        return bookCommentPreparer.extractAllCommentsForBookByTemplate(template);
    }

    @ShellMethod(value = "Get all comments for the book by id", key = {"get-all-comments-for-the-book-by-id", "gacbbi"})
    public BookComments getAllCommentsForBookById(@ShellOption long id) {
        return bookCommentPreparer.extractAllCommentsForBookById(id);
    }

    @ShellMethod(value = "Add comment to the book with id", key = {"book-add-comment", "bac"})
    public Comment addCommentToBook(@ShellOption long id, @ShellOption String comment) {
        return commentService.addCommentToBook(id, comment);
    }

    @ShellMethod(value = "Remove comment for the book by comment id", key = {"remove-comment-id", "rci"})
    public String removeCommentFromBookById(@ShellOption long id) {
        commentService.removeComment(id);
        return "The comment was removed";
    }
}
