package otus.spring.albot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import otus.spring.albot.entity.Genre;

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
public interface GenreRepo extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
}
