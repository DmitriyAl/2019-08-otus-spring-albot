package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import otus.spring.albot.dao.AuthorDao;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.dao.GenreDao;
import otus.spring.albot.entity.Author;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Genre;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private GenreDao genreDao;

    @Override
    public void addNewBook(String name, long authorId, long genreId) {
        Author author = authorDao.findById(authorId);
        Genre genre = genreDao.findById(genreId);
        Book book = new Book(name, author, genre);
        bookDao.addNewBook(book);
    }
}
