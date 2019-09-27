package otus.spring.albot.dao;

import org.springframework.stereotype.Repository;
import otus.spring.albot.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Repository
public class GenreDaoImpl implements GenreDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genre> findAllGenres() {
        return em.createQuery("select g from Genre g").getResultList();
    }

    @Override
    public List<Genre> findAllGenresByName(String template) {
        return em.createQuery("select g from Genre g where g.name like :template")
                .setParameter("template", "%" + template + "%").getResultList();
    }
}