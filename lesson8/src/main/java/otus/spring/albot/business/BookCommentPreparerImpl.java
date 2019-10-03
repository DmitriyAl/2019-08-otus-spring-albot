package otus.spring.albot.business;

import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.spring.albot.dao.BookDao;
import otus.spring.albot.entity.Book;
import otus.spring.albot.entity.Comment;
import otus.spring.albot.model.BookComments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class BookCommentPreparerImpl implements BookCommentPreparer {
    private BookDao bookDao;

    @Override
    @Transactional
    public List<BookComments> extractAllCommentsForBookById(long id) {
        Book book = bookDao.findBookById(id);
        return fillInBooksComment(Collections.singletonList(book));
    }

    @Override
    @Transactional
    public List<BookComments> extractAllCommentsForBookByTemplate(String template) {
        List<Book> books = bookDao.findBookByName(template);
        return fillInBooksComment(books);
    }

    private List<BookComments> fillInBooksComment(@Nullable List<Book> books) {
        List<BookComments> bookComments;
        if (books != null && !books.isEmpty()) {
            bookComments = new ArrayList<>();
            for (Book book : books) {
                BookComments bookComment = fillInBookComment(book);
                bookComments.add(bookComment);
            }
        } else {
            bookComments = Collections.emptyList();
        }
        return bookComments;
    }

    private BookComments fillInBookComment(Book book) {
        return new BookComments(book.getName(),
                                book.getComments().stream().map(Comment::getComment).collect(Collectors.toList()));
    }
}
