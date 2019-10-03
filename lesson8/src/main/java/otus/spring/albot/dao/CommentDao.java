package otus.spring.albot.dao;

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

public interface CommentDao {

    List<String> getCommentsForBook(long bookId);
}
