package otus.spring.albot.dao;

import otus.spring.albot.entity.Book;

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
public interface BookDao {
    List<Book> findAllBooks();

    List<Book> findBookByName(String template);
}
