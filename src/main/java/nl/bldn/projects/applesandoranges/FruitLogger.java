package nl.bldn.projects.applesandoranges;

import nl.bldn.projects.applesandoranges.model.FruityMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FruitLogger {
    public static final FruitLogger INSTANCE = new FruitLogger();

    static final Logger log = LoggerFactory.getLogger(FruitLogger.class);

    private FruitLogger() {
        //don't instatiate outside this class
    }

    public void logAllFruitMessages(FruityMessage message) {
        if (message != null) {
            log.info("Outgoing message body: {}", message.getBody());
        }
    }
}
