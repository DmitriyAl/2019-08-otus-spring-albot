package otus.spring.albot.game;

import otus.spring.albot.model.ParsedLine;

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
public interface IGameManager {
    void startGame(List<ParsedLine> questions);
}
