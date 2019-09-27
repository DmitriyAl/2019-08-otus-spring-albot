package otus.spring.albot.dao;

import org.springframework.stereotype.Repository;
import otus.spring.albot.entity.Author;

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
public class AuthorDaoImpl implements AuthorDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> findAllAuthors() {
        return em.createQuery("select a from Author a").getResultList();
    }

    @Override
    public List<Author> findAuthorByName(String template) {
        return em.createQuery("select a from Author a where a.name like :template")
                .setParameter("template", "%" + template + "%").getResultList();
    }
}
