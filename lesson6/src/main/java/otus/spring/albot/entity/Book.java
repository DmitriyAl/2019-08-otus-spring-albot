package otus.spring.albot.entity;

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
public class Book {
    private long id;
    private String name;
}
