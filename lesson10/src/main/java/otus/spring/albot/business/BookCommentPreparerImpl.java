package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookRepo;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
import otus.spring.albot.model.BookComments;

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
    private BookRepo bookDao;

    @Override
    @Transactional
    public BookComments extractAllCommentsForBookById(long id) {
        return fillInBookComment(bookDao.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public BookComments extractAllCommentsForBookByName(String name) {
        return fillInBookComment(bookDao.findByName(name).orElse(null));
    }

    private BookComments fillInBookComment(Book book) {
        if (book == null) {
            return null;
        }
        return new BookComments(book.getName(),
                                book.getComments().stream().map(Comment::getComment).collect(Collectors.toList()));
    }
}
