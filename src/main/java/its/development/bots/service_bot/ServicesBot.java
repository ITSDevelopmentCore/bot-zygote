package its.development.bots.service_bot;

import its.development.bots.BotConstants;
import its.development.bots.LongPollingBot;
import its.development.bots.service_bot.commands.StartCommand;
import its.development.handlers.BaseHandler;
import its.development.handlers.CallbackQueryHandler;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;
import java.util.function.BiConsumer;

public class ServicesBot extends TelegramLongPollingCommandBot {

    public Set<IBotCommand> activeCommands = new HashSet<>();

    public Map<LongPollingBot.HandlerType, BaseHandler> activeHandlers = new HashMap<>();

    @Override
    public void processNonCommandUpdate(Update update) {
        try {
            if (update.hasPreCheckoutQuery())
                activeHandlers.get(LongPollingBot.HandlerType.PRECHECKOUT_QUERY).execute(this, update);
            else if (update.hasCallbackQuery())
                activeHandlers.get(LongPollingBot.HandlerType.CALLBACK_QUERY)   .execute(this, update);
            else
                activeHandlers.get(LongPollingBot.HandlerType.TEXT)             .execute(this, update);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_SERVICES_NAME;
    }

    @Override
    public String getBotToken() {
        return BotConstants.BOT_SERVICES_TOKEN;
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onRegister() {
        activeCommands.add(new StartCommand());
        activeCommands.forEach(this::register);

        activeHandlers.put(LongPollingBot.HandlerType.CALLBACK_QUERY, new CallbackQueryHandler());
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