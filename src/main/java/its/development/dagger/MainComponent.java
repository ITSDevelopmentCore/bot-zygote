package its.development.dagger;

import its.development.bots.LongPollingBot;
import dagger.Component;
import its.development.wrapper.TelegramMultibotWrapper;

import javax.inject.Singleton;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(TelegramMultibotWrapper telegramMultibotWrapper);
    void inject(LongPollingBot telegramBotWrapper);

}
