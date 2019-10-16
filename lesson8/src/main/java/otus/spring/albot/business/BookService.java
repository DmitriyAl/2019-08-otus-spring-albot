package otus.spring.albot.business;

public interface BookService {
    void addNewBook(String name, long authorId, long genreId);
}
