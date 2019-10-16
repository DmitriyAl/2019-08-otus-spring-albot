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
    Book findBookById(long id);

    List<Book> findAllBooks();

    List<Book> findBookByName(String template);

    void addNewBook(Book book);

    void deleteBook(long id);
}
