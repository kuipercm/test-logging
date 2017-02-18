package nl.bldn.projects.applesandoranges;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import nl.bldn.projects.applesandoranges.model.FruityMessage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import static nl.bldn.projects.applesandoranges.FruitLogger.INSTANCE;
import static nl.bldn.projects.applesandoranges.FruitLogger.log;
import static org.assertj.core.api.Assertions.assertThat;

public class FruitLoggerTest {

    private static Logger fruityLogger;
    private static ListAppender<ILoggingEvent> fruityLoggerAppender;

    @BeforeClass
    public static void setupBeforeClass() {
        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
        fruityLogger = context.getLogger(log.getName());
        fruityLoggerAppender = new ListAppender<>();
        fruityLoggerAppender.start();
        fruityLogger.addAppender(fruityLoggerAppender);
    }

    @Before
    public void setup() {
        fruityLogger.setLevel(Level.ALL);
        fruityLoggerAppender.clearAllFilters();
        fruityLoggerAppender.list.clear();
    }

    @Test
    public void verify_that_the_fruity_message_content_is_logged_at_info_level() {
        assertThat(fruityLoggerAppender.list).hasSize(0);

        FruityMessage fruityMessage = new FruityMessage("apples", "oranges");
        INSTANCE.logAllFruitMessages(fruityMessage);

        assertThat(fruityLoggerAppender.list).hasSize(1);

        ILoggingEvent loggedEvent = fruityLoggerAppender.list.get(0);
        assertThat(loggedEvent.getLevel()).isEqualTo(Level.INFO);
        assertThat(loggedEvent.getFormattedMessage()).contains("body");
        assertThat(loggedEvent.getFormattedMessage()).contains("oranges");
    }

}