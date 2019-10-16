package otus.spring.albot.business;

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
public interface AuthorService {
    List<Author> findAllAuthors();

    Author save(String name);

    Author findByName(String name);
}
