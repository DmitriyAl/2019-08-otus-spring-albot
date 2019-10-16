package otus.spring.albot.business;

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
public interface CommentService {
    Comment addCommentToBook(long bookId, String comment);

    void removeComment(long id);
}
