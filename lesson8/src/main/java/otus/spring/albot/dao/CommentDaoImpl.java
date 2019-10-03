package otus.spring.albot.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

@Repository
@AllArgsConstructor
public class CommentDaoImpl implements CommentDao {
    @PersistenceContext
    private EntityManager em;
    private BookDao bookDao;

    @Override
    @Transactional
    public List<String> getCommentsForBook(long bookId) {
        Book book = bookDao.findBookById(bookId);
        if (book != null) {
            return book.getComments().stream().map(Comment::getComment).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
