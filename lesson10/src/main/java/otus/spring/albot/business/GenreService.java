package otus.spring.albot.business;

import otus.spring.albot.entity.Genre;

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
public interface GenreService {
    List<Genre> findAllGenres();
    Genre findByName(String name);
}
