package otus.spring.albot.entity.binding;

import lombok.AllArgsConstructor;
import lombok.Data;

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
@Data
@AllArgsConstructor
public class BookGenreBinding {
    private long bookId;
    private long genreId;
}
