package its.development.dagger;

import its.development.bots.LongPollingBot;
import dagger.Component;
import its.development.wrapper.TelegramBotWrapper;

import javax.inject.Singleton;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(TelegramBotWrapper telegramBotWrapper);
    void inject(LongPollingBot telegramBotWrapper);

}
