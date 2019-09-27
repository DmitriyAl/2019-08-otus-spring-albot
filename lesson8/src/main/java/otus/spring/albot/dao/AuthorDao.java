package otus.spring.albot.dao;

import otus.spring.albot.entity.Author;

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
public interface AuthorDao {
    List<Author> findAllAuthors();

    List<Author> findAuthorByName(String template);
}
