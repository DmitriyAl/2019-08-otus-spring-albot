package otus.spring.albot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

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
@Data
@AllArgsConstructor
public class Author {
    private long id;
    private String name;
}
