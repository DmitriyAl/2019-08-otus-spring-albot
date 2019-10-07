package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookRepo;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;

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
public class CommentAddingServiceImpl implements CommentAddingService {
    private BookRepo bookRepo;

    @Override
    @Transactional
    public Book addCommentToBook(long bookId, String textComment) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        if (!bookOptional.isPresent()) {
            return null;
        }
        Book book = bookOptional.get();
        Comment comment = new Comment();
        comment.setComment(textComment);
//        comment.setBook(book);
        book.getComments().add(comment);
        return bookRepo.saveAndFlush(book);
    }
}
