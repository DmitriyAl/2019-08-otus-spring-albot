package otus.spring.albot.lesson2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import otus.spring.albot.lesson2.game.GameManager;
import otus.spring.albot.lesson2.handler.QuestionHandlerFactory;
import otus.spring.albot.lesson2.util.QuestionsPreparer;
import otus.spring.albot.lesson2.util.QuizParser;

/**
 * @author Dmitrii Albot
 */

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan
public class AppConfiguration {
    @Bean
    public QuestionHandlerFactory questionHandlerFactory() {
        return new QuestionHandlerFactory();
    }

    @Bean
    public QuestionsPreparer questionsPreparer() {
        return new QuestionsPreparer();
    }

    @Bean
    public QuizParser csvParser(@Value("${path.questions}") String path) {
        return new QuizParser(path);
    }

    @Bean
    public GameManager gameManager() {
        return new GameManager(questionHandlerFactory());
    }
}
