package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;

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
public class CommentAddingServiceImpl implements CommentAddingService {
    private BookDao bookDao;

    @Override
    @Transactional
    public Book addCommentToBook(long bookId, String textComment) {
        Book toReturn = null;
        Book book = bookDao.findBookById(bookId);
        if (book != null) {
            Comment comment = new Comment();
            comment.setComment(textComment);
            comment.setBook(book);
            book.getComments().add(comment);
            toReturn = bookDao.updateBook(book);
        }
        return toReturn;
    }
}
