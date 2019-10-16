package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.albot.dao.GenreDao;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private GenreDao genreDao;

    @Override
    public boolean removeGenreById(long id) {
        try {
            genreDao.deleteGenre(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
