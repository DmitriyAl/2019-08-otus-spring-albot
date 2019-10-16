package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.dao.CommentDao;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
import otus.spring.albot.model.BookComments;

import java.util.ArrayList;
import java.util.Collections;
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
@Service
@AllArgsConstructor
public class BookCommentPreparerImpl implements BookCommentPreparer {
    private BookDao bookDao;
    private CommentDao commentDao;

    @Override
    @Transactional
    public BookComments extractAllCommentsForBookById(long id) {
        Book book = bookDao.findBookById(id);
        List<Comment> commentsForBook = commentDao.getCommentsForBook(book);
        return fillInBookComments(book, commentsForBook);
    }

    @Override
    @Transactional
    public List<BookComments> extractAllCommentsForBookByTemplate(String template) {
        List<Book> books = bookDao.findBookByName(template);
        if (books.isEmpty()) {
            return Collections.emptyList();
        }
        List<BookComments> bookComments = new ArrayList<>();
        for (Book book : books) {
            bookComments.add(extractAllCommentsForBookById(book.getId()));
        }
        return bookComments;
    }

    private BookComments fillInBookComments(Book book, List<Comment> comments) {
        return new BookComments(book.getName(), comments);
    }
}
