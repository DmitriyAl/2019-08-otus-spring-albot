package otus.spring.albot.util.message;

import java.util.Locale;

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
public interface IMessageHandler {
    String getMessage(String key, String... params);

    void setLocale(Locale locale);
}