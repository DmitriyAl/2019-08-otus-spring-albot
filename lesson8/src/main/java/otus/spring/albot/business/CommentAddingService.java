package otus.spring.albot.business;

import otus.spring.albot.entity.Book;

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
public interface CommentAddingService {
    Book addCommentToBook(long bookId, String comment);
}
