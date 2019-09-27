package otus.spring.albot.dao;

import org.springframework.stereotype.Repository;
import otus.spring.albot.entity.Book;

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
public class BookDaoImpl implements BookDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Book> findAllBooks() {
        return em.createQuery("select b from Book b").getResultList();
    }

    @Override
    public List<Book> findBookByName(String template) {
        return em.createQuery("select b from Book b where b.name like :template")
                .setParameter("template", "%" + template + "%").getResultList();
    }
}
