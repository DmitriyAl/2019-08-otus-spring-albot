package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.AuthorDao;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.dao.CommentDao;
import otus.spring.albot.dao.GenreDao;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
import otus.spring.albot.entity.Genre;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private GenreDao genreDao;
    private CommentDao commentDao;

    @Override
    public void addNewBook(String name, long authorId, long genreId) {
        Author author = authorDao.findById(authorId);
        Genre genre = genreDao.findById(genreId);
        Book book = new Book(name, author, genre);
        bookDao.addNewBook(book);
    }

    @Override
    @Transactional
    public void removeBookById(long id) {
        Book book = bookDao.findBookById(id);
        List<Comment> commentsForBook = commentDao.getCommentsForBook(book);
        for (Comment comment : commentsForBook) {
            commentDao.removeCommentById(comment.getId());
        }
        bookDao.deleteBook(id);
    }
}
