package its.development.bots.educationBot.commands;

import its.development.common.commands.BotCommandTextProvider;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import its.development.utils.TelegramUIFactory;

import java.util.List;

import static its.development.utils.TelegramUIConstants.KEYBOARD_FIRST_ROW;
import static its.development.utils.TelegramUIConstants.ROW_FIRST_BUTTON;

public class StartCommand extends BotCommand implements BotCommandTextProvider {

    private static final String COMMAND_IDENTIFIER = "start";
    private static final String DESCRIPTION = "ITS Web Apps";

    public StartCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {


        SendMessage sendMessage = TelegramUIFactory.simpleTextMessage(getCommandText(), chat.getId());

        InlineKeyboardMarkup replyKeyboard = TelegramUIFactory
                .createInlineKeyboard(1, "Открыть приложение", "Отправить PUSH", "К другим образцам");

        List<List<InlineKeyboardButton>> inlineKeyboard = replyKeyboard.getKeyboard();

        inlineKeyboard
                .get(KEYBOARD_FIRST_ROW)
                .get(ROW_FIRST_BUTTON)
                .setWebApp(new WebAppInfo("https://fir-web-app-education.firebaseapp.com"));

        inlineKeyboard
                .get(KEYBOARD_FIRST_ROW)
                .get(ROW_FIRST_BUTTON)
                .setCallbackData(null);

        sendMessage.setReplyMarkup(replyKeyboard);

        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getCommandText() {
        return "Наши боты с приложениями могут служить самым разным целям. Повысить вовлеченность, автоматизировать процессы и снизить затраты в любой сфере. " +
                "К примеру рассмотрим сервис по быстрому подбору репетитора в Telegram. Приложения и стандартный функционал ботов могут дополнять друг друга.";
    }
}