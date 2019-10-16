package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.albot.dao.BookRepo;
import otus.spring.albot.entity.Book;

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
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book findByName(String name) {
        return bookRepo.findByName(name).orElse(null);
    }

    @Override
    public Book findById(long id) {
        return bookRepo.findById(id).orElse(null);
    }
}
