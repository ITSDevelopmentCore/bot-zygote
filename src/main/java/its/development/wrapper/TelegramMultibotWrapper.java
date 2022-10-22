package its.development.wrapper;

import its.development.bots.LongPollingBot;
import its.development.bots.service_bot.ServicesBot;
import its.development.dagger.DaggerMainComponent;
import its.development.dagger.MainComponent;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;

public class TelegramMultibotWrapper {

    private MainComponent component;

    @Inject
    TelegramBotsApi telegramBotsApi;

    public TelegramMultibotWrapper(){
        component = DaggerMainComponent.builder().build();

        component.inject(this);
    }

    public void run() throws TelegramApiException {
        LongPollingBot telegramBot = new LongPollingBot();
        ServicesBot servicesBot = new ServicesBot();
        telegramBotsApi.registerBot(servicesBot);
        telegramBotsApi.registerBot(telegramBot);
    }


}
