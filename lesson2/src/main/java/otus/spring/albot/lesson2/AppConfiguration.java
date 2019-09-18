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
import otus.spring.albot.lesson2.questionHandler.QuestionHandlerFactory;
import otus.spring.albot.lesson2.util.MessageHandler;
import otus.spring.albot.lesson2.util.QuestionLocalizer;
import otus.spring.albot.lesson2.util.QuestionsPreparer;
import otus.spring.albot.lesson2.util.QuizParser;

import java.util.Locale;

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
    public GameManager gameManager(
            QuestionHandlerFactory factory, MessageHandler messageHandler, @Value("${game.greeting}") String greeting,
            @Value("${game.rules}") String rules, @Value("${game.amount}") int amount,
            @Value("${game.result}") String result) {
        return new GameManager(factory, messageHandler, greeting, rules, result, amount);
    }

    @Bean
    public QuestionLocalizer getLocalizer(
            MessageHandler handler, @Value("${pattern.open}") String open, @Value("${pattern.close}") String close) {
        return new QuestionLocalizer(handler, open, close);
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
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
    public MessageHandler messageHandler(
            MessageSource messageSource, @Value("${localization.language}") String languageTag) {
        return new MessageHandler(messageSource, Locale.forLanguageTag(languageTag));
    }
}
