package otus.spring.albot.business;

import otus.spring.albot.model.BookComments;

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
public interface BookCommentPreparer {
    BookComments extractAllCommentsForBookById(long id);

    List<BookComments> extractAllCommentsForBookByTemplate(String template);
}
