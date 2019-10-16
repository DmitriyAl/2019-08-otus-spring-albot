package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookRepo;
import otus.spring.albot.dao.CommentRepo;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
import otus.spring.albot.model.BookComments;

import java.util.List;
import java.util.Optional;

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
@Service
@AllArgsConstructor
public class BookCommentPreparerImpl implements BookCommentPreparer {
    private BookRepo bookRepo;
    private CommentRepo commentRepo;

    @Override
    @Transactional
    public BookComments extractAllCommentsForBookById(long id) {
        Optional<Book> optional = bookRepo.findById(id);
        return getBookComments(optional.orElse(null));
    }

    @Override
    @Transactional
    public BookComments extractAllCommentsForBookByName(String name) {
        Optional<Book> optional = bookRepo.findByName(name);
        return getBookComments(optional.orElse(null));
    }

    private BookComments getBookComments(Book book) {
        if (book == null) {
            return null;
        }
        List<Comment> commentsForBook = commentRepo.findByBook(book);
        return fillInBookComments(book, commentsForBook);
    }

    private BookComments fillInBookComments(Book book, List<Comment> comments) {
        return new BookComments(book.getName(), comments);
    }
}
