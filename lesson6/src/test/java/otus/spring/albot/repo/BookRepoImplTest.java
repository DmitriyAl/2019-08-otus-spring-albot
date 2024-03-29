package otus.spring.albot.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import otus.spring.albot.entity.Book;

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
@JdbcTest
@RunWith(SpringRunner.class)
@Import(BookRepoImpl.class)
public class BookRepoImplTest {
    @Autowired
    private BookRepo bookRepo;

    @Test
    public void findBookByName() throws Exception {
        assertThat(bookRepo.findBookByName("fish")).hasSize(1)
                .containsOnly(new Book(3, "The story about the fisherman and the golden fish"));
    }

    @Test
    public void findAllBooks() throws Exception {
        assertThat(bookRepo.findAllBooks()).hasSize(4).allMatch(book -> book.getName() != null)
                .allMatch(book -> book.getId() != 0);
    }

}