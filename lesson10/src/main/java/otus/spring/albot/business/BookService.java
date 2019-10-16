package otus.spring.albot.business;

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
public interface BookService {
    List<Book> findAllBooks();

    Book findByName(String name);

    Book findById(long id);
}
