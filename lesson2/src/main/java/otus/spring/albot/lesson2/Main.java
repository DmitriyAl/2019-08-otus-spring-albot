package otus.spring.albot.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import otus.spring.albot.lesson2.game.GameManager;
import otus.spring.albot.lesson2.model.ParsedLine;
import otus.spring.albot.lesson2.util.QuestionLocalizer;
import otus.spring.albot.lesson2.util.QuestionsPreparer;
import otus.spring.albot.lesson2.util.QuizParser;

import java.util.List;

/**
 * @author Dmitrii Albot
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        QuizParser quizParser = context.getBean(QuizParser.class);
        QuestionsPreparer questionsPreparer = context.getBean(QuestionsPreparer.class);
        GameManager gameManager = context.getBean(GameManager.class);
        QuestionLocalizer questionLocalizer = context.getBean(QuestionLocalizer.class);

        List<ParsedLine> lines = quizParser.parse();
        lines = questionsPreparer.prepareQuestions(lines);
        questionLocalizer.localizeQuestions(lines);
        gameManager.startGame(lines);
    }
}
