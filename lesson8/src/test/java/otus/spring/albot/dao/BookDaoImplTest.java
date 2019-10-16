package otus.spring.albot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

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
@Import(BookDaoImpl.class)
public class BookDaoImplTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void findAllBooks() throws Exception {
        assertThat(bookDao.findAllBooks()).hasSize(4).allMatch(book -> book.getName() != null)
                .allMatch(book -> book.getId() != 0);
    }

    @Test
    public void findBookByName() throws Exception {
        assertThat(bookDao.findBookByName("War")).hasSize(1).allMatch(book -> book.getName() != null)
                .allMatch(book -> book.getName().equals("War and peace"));
    }
}