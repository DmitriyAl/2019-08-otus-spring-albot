package otus.spring.albot.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import otus.spring.albot.lesson2.game.GameManager;
import otus.spring.albot.lesson2.game.GameManagerImpl;
import otus.spring.albot.lesson2.model.ParsedLine;
import otus.spring.albot.lesson2.util.question.QuestionLocalizer;
import otus.spring.albot.lesson2.util.question.QuestionLocalizerImpl;
import otus.spring.albot.lesson2.util.question.QuestionsPreparer;
import otus.spring.albot.lesson2.util.question.QuestionsPreparerImpl;
import otus.spring.albot.lesson2.util.question.QuizParserImpl;

import java.util.List;

/**
 * @author Dmitrii Albot
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        QuizParserImpl quizParser = context.getBean(QuizParserImpl.class);
        QuestionsPreparer questionsPreparer = context.getBean(QuestionsPreparerImpl.class);
        GameManager gameManager = context.getBean(GameManagerImpl.class);
        QuestionLocalizer questionLocalizer = context.getBean(QuestionLocalizerImpl.class);

        List<ParsedLine> lines = quizParser.parse();
        lines = questionsPreparer.prepareQuestions(lines);
        questionLocalizer.localizeQuestions(lines);
        gameManager.startGame(lines);
    }
}
