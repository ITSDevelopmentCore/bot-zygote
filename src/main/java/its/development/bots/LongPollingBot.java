package its.development.bots;

import its.development.dagger.DaggerMainComponent;
import its.development.dagger.MainComponent;
import its.development.handlers.BaseHandler;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;
import java.util.*;
import java.util.function.BiConsumer;

public class LongPollingBot extends TelegramLongPollingCommandBot {
    private MainComponent component;
    @Inject
    public Set<IBotCommand>              activeCommands = new HashSet<>();
    @Inject
    public Map<HandlerType, BaseHandler> activeHandlers = new HashMap<>();

    @Override
    public void processNonCommandUpdate(Update update) {
        try {
            if (update.hasPreCheckoutQuery())
                activeHandlers.get(HandlerType.PRECHECKOUT_QUERY).execute(this, update);
            else if (update.hasCallbackQuery())
                activeHandlers.get(HandlerType.CALLBACK_QUERY)   .execute(this, update);
            else
                activeHandlers.get(HandlerType.TEXT)             .execute(this, update);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BotConstants.BOT_TOKEN;
    }
    
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onRegister() {
        component = DaggerMainComponent
                .builder()
                .build();

        component.inject(this);
        activeCommands.forEach(this::register);
    }

    @Override
    public void onClosing() {
        activeCommands.forEach(this::deregister);
        activeCommands.clear();
        activeHandlers.clear();
        super.onClosing();
    }

    @Override
    public void registerDefaultAction(BiConsumer<AbsSender, Message> defaultConsumer) {
        super.registerDefaultAction(defaultConsumer);
    }

    public enum HandlerType {
        TEXT, CALLBACK_QUERY, PRECHECKOUT_QUERY
    }
}
