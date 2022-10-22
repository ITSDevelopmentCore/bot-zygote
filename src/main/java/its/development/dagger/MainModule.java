package its.development.dagger;

import its.development.bots.LongPollingBot;
import its.development.commands.InlineKeyboardCommand;
import its.development.commands.OfferCommand;
import its.development.commands.StartCommand;
import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoMap;
import its.development.handlers.BaseHandler;
import its.development.handlers.CallbackQueryHandler;
import its.development.handlers.PreCheckoutQueryHandler;
import its.development.handlers.TextHandler;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.inject.Singleton;
import java.util.*;

@Module
public class MainModule {

    @Singleton
    @Provides
    public TelegramBotsApi providesTelegramBotsApi(){
        try {
            return new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Provides
    @ElementsIntoSet
    @Singleton
    public Set<IBotCommand> providesBotCommands()
    {
        Set<IBotCommand> botCommands = new HashSet<>();

        botCommands.add(new InlineKeyboardCommand());
        botCommands.add(new OfferCommand());
        botCommands.add(new StartCommand());

        return botCommands;
    }

    @MapKey
    @interface HandlerTypeKey {
        LongPollingBot.HandlerType value();
    }

    @Provides @IntoMap
    @HandlerTypeKey(LongPollingBot.HandlerType.TEXT)
    public BaseHandler provideTextHandler() {
        return new TextHandler();
    }

    @Provides @IntoMap
    @HandlerTypeKey(LongPollingBot.HandlerType.PRECHECKOUT_QUERY)
    public BaseHandler providePreCheckoutHandler() {
        return new PreCheckoutQueryHandler();
    }

    @Provides @IntoMap
    @HandlerTypeKey(LongPollingBot.HandlerType.CALLBACK_QUERY)
    public BaseHandler provideCallbackQueryHandler() {
        return new CallbackQueryHandler();
    }
}
