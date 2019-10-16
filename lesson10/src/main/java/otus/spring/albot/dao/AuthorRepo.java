package otus.spring.albot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.entity.Author;

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
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
