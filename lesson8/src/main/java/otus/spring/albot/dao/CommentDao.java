package otus.spring.albot.dao;

import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;

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

    List<Comment> getCommentsForBook(Book book);

    void addNewComment(Comment comment);

    Comment getCommentById(long id);

    void removeCommentById(long id);
}
