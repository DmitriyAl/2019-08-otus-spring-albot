package otus.spring.albot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import otus.spring.albot.entity.Author;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

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
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(AuthorDaoImpl.class)
public class AuthorDaoImplTest {
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void findAllAuthors() throws Exception {
        assertThat(authorDao.findAllAuthors()).hasSize(3).allMatch(author -> author.getName() != null)
                .allMatch(author -> author.getId() != 0);
    }

    @Test
    public void findAuthorByName() throws Exception {
        assertThat(authorDao.findAuthorByName("sh")).hasSize(1).allMatch(author -> author.getName() != null)
                .allMatch(author -> author.getName().equals("Alexander Pushkin"));
    }
}