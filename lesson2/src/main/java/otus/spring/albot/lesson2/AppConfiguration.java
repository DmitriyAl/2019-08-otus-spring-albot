package otus.spring.albot.lesson2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import otus.spring.albot.lesson2.game.GameManager;
import otus.spring.albot.lesson2.game.IGameManager;
import otus.spring.albot.lesson2.questionHandler.IQuestionHandlerFactory;
import otus.spring.albot.lesson2.questionHandler.QuestionHandlerFactory;
import otus.spring.albot.lesson2.util.message.IMessageHandler;
import otus.spring.albot.lesson2.util.message.MessageHandler;
import otus.spring.albot.lesson2.util.question.IQuestionLocalizer;
import otus.spring.albot.lesson2.util.question.IQuestionsPreparer;
import otus.spring.albot.lesson2.util.question.IQuizParser;
import otus.spring.albot.lesson2.util.question.QuestionLocalizer;
import otus.spring.albot.lesson2.util.question.QuestionsPreparer;
import otus.spring.albot.lesson2.util.question.QuizParser;

import java.util.Locale;

/**
 * @author Dmitrii Albot
 */

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan
public class AppConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public IQuestionHandlerFactory questionHandlerFactory() {
        return new QuestionHandlerFactory();
    }

    @Bean
    public IQuestionsPreparer questionsPreparer() {
        return new QuestionsPreparer();
    }

    @Bean
    public IQuizParser csvParser(@Value("${path.questions}") String path) {
        return new QuizParser(path);
    }

    @Bean
    public IGameManager gameManager(
            IQuestionHandlerFactory factory, IMessageHandler messageHandler, @Value("${game.greeting}") String greeting,
            @Value("${game.rules}") String rules, @Value("${game.amount}") int amount,
            @Value("${game.result}") String result) {
        return new GameManager(factory, messageHandler, greeting, rules, result, amount);
    }

    @Bean
    public IQuestionLocalizer getLocalizer(
            IMessageHandler handler, @Value("${pattern.open}") String open, @Value("${pattern.close}") String close) {
        return new QuestionLocalizer(handler, open, close);
    }

    @Bean
    public MessageSource messageSource(
            @Value("${path.localization}") String path, @Value("${encoding}") String encoding) {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename(path);
        source.setDefaultEncoding(encoding);
        return source;
    }

    @Bean
    public IMessageHandler messageHandler(
            MessageSource messageSource, @Value("${localization.language}") String languageTag) {
        return new MessageHandler(messageSource, Locale.forLanguageTag(languageTag));
    }
}
