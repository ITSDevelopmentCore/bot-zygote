package its.development.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import its.development.handlers.utils.MessageFactory;

public class StartCommand extends BotCommand implements BotCommandTextProvider {

    private static final String COMMAND_IDENTIFIER = "start";
    private static final String DESCRIPTION = "ITS Web Apps";

    public StartCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage sendMessage = MessageFactory.simpleTextMessage(getCommandText(), chat.getId());
        InlineKeyboardMarkup replyKeyboard = (InlineKeyboardMarkup) MessageFactory.inlineKeyboardMarkup(1, "Подобрать репетитора", "Отправить PUSH");

        replyKeyboard.getKeyboard().get(0).get(0).setWebApp(new WebAppInfo("https://fir-web-app-education.firebaseapp.com"));
        replyKeyboard.getKeyboard().get(0).get(0).setCallbackData(null);

        sendMessage.setReplyMarkup(replyKeyboard);

        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getCommandText() {
        return "Это демонстрационный бот с приложением для подбора репетитора. " +
                "Для открытия приложения нажмите на соответствующую кнопку ниже, либо на кнопку меню." +
                "Для проверки PUSH-уведомлений нажмите соответствующую кнопку ниже и сверните/закройте Telegram";
    }
}