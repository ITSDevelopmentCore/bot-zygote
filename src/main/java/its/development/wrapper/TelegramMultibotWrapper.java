package its.development.wrapper;

import its.development.bots.educationBot.EducationBotLongPolling;
import its.development.bots.serviceBot.ServicesBotLongPolling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TelegramMultibotWrapper {

    private List<AbsSender> activeBots;
    TelegramBotsApi telegramBotsApi;

    public TelegramMultibotWrapper() throws TelegramApiException {
        telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        initialize();
    }

    private void initialize()
    {
        activeBots = new ArrayList<>();
        activeBots.add(new EducationBotLongPolling());
        activeBots.add(new ServicesBotLongPolling());
    }

    public void run(){
        activeBots.forEach(bot -> {
            try {
                telegramBotsApi.registerBot((LongPollingBot) bot);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
