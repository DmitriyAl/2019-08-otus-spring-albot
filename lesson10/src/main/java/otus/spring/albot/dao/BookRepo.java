package otus.spring.albot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.entity.Book;

import java.util.List;
import java.util.Optional;

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
public interface BookRepo extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
}
