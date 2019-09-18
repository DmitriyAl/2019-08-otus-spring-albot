package otus.spring.albot.lesson2.util;

import org.springframework.context.MessageSource;
import otus.spring.albot.lesson2.model.ParsedLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Dmitrii Albot
 */
public class QuestionLocalizer {
    private MessageHandler messageHandler;
    private String open;
    private String close;

    public QuestionLocalizer(MessageHandler messageHandler, String open, String close) {
        this.messageHandler = messageHandler;
        this.open = open;
        this.close = close;
    }

    public void localizeQuestions(List<ParsedLine> parsedLines) {
        for (ParsedLine parsedLine : parsedLines) {
            String answer = parsedLine.getAnswer();
            if (isKey(answer)) {
                parsedLine.setAnswer(localize(answer));
            }
            String question = parsedLine.getQuestion();
            if (isKey(question)) {
                parsedLine.setQuestion(localize(question));
            }
            List<String> choices = parsedLine.getChoices();
            if (choices != null) {
                List<String> localizedChoices = new ArrayList<>();
                for (String choice : choices) {
                    if (isKey(choice)) {
                        choice = localize(choice);
                    }
                    localizedChoices.add(choice);
                }
                parsedLine.setChoices(localizedChoices);
            }
        }
    }

    private boolean isKey(String word) {
        return word.contains(open) && word.contains(close);
    }

    private String localize(String key) {
        key = key.substring(open.length(), key.length() - close.length());
        return messageHandler.getMessage(key);
    }
}
