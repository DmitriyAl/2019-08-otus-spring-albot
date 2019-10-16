package otus.spring.albot.business;

import otus.spring.albot.model.BookComments;

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
public interface BookCommentPreparer {
    BookComments extractAllCommentsForBookById(long id);
    BookComments extractAllCommentsForBookByName(String template);
}
