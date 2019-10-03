package otus.spring.albot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
@Getter
@AllArgsConstructor
public class BookComments {
    private String book;
    private List<String> comments;

    @Override
    public String toString() {
        return "The book \"" + book + "\" has the next list of comments: " + comments;
    }
}
