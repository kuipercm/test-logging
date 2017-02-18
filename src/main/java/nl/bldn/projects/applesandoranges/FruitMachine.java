package nl.bldn.projects.applesandoranges;

import nl.bldn.projects.applesandoranges.model.FruityMessage;

public class FruitMachine {
    private final FruitLogger logger = FruitLogger.INSTANCE;

    private final String remoteUrl;

    public FruitMachine(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public void sendMessage(FruityMessage message) {
        logger.logAllFruitMessages(message);
        //do some remote call
    }

}
