package otus.spring.albot.repo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import otus.spring.albot.entity.Author;
import otus.spring.albot.repo.mapper.AuthorMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@AllArgsConstructor
public class AuthorRepoImpl implements AuthorRepo {
    private NamedParameterJdbcOperations jdbc;

    @Override
    public List<Author> findAllAuthors() {
        return jdbc.query("SELECT a.id, a.name FROM authors a", new AuthorMapper());
    }

    @Override
    public List<Author> findAuthorByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "%" + name + "%");
        return jdbc.query("SELECT a.id, a.name FROM authors a WHERE a.name LIKE :name", params, new AuthorMapper());
    }
}
