package otus.spring.albot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import otus.spring.albot.game.GameManager;
import otus.spring.albot.game.IGameManager;
import otus.spring.albot.model.ParsedLine;
import otus.spring.albot.util.question.IQuestionLocalizer;
import otus.spring.albot.util.question.IQuestionsPreparer;
import otus.spring.albot.util.question.IQuizParser;
import otus.spring.albot.util.question.QuestionLocalizer;
import otus.spring.albot.util.question.QuestionsPreparer;
import otus.spring.albot.util.question.QuizParser;

import java.util.List;

@SpringBootApplication
public class Lesson4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lesson4Application.class, args);
		IQuizParser quizParser = context.getBean(QuizParser.class);
		IQuestionsPreparer questionsPreparer = context.getBean(QuestionsPreparer.class);
		IGameManager gameManager = context.getBean(GameManager.class);
		IQuestionLocalizer questionLocalizer = context.getBean(QuestionLocalizer.class);

		List<ParsedLine> lines = quizParser.parse();
		lines = questionsPreparer.prepareQuestions(lines);
		questionLocalizer.localizeQuestions(lines);
		gameManager.startGame(lines);
	}
}
