package otus.spring.albot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;

import java.util.List;
import java.util.Optional;

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
@DataJpaTest
@RunWith(SpringRunner.class)
public class CommentRepoTest {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Test
    public void findByBook() throws Exception {
        Optional<Book> bookOptional = bookRepo.findById(1L);
        Book book = bookOptional.orElse(null);
        List<Comment> comments = book.getComments();
        Optional<Comment> commentOptional = commentRepo.findByBook(book);
        System.out.println(commentOptional.orElseThrow(() -> new NullPointerException("")));
    }
}