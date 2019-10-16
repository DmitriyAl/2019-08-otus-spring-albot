package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.albot.dao.AuthorRepo;
import otus.spring.albot.entity.Author;

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
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepo authorRepo;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author save(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepo.save(author);
    }

    @Override
    public Author findByName(String name) {
        return authorRepo.findByName(name).orElse(null);
    }
}
