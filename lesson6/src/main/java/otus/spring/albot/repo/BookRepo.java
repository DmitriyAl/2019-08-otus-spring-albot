package otus.spring.albot.repo;

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
public interface BookRepo {
    List<Book> findAllBooks();
    List<Book> findBookByName(String name);
    int saveBook(String name);
    int deleteBook(long id);
}
