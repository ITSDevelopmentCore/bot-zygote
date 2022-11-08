package its.development.bots.serviceBot.commands;

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
                .setWebApp(new WebAppInfo("https://fir-web-app-services.firebaseapp.com/"));

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
        return "Telegram уже давно есть в смартфоне каждого Россиянина. Он стал частью нашей жизни. А с новыми возможностями ботов вопрос дорогой цифровизации бизнеса " +
                "ушел в прошлое. Быстро и качественно мы создадим уникального бота с приложением для Вашего бизнеса. Например, для мгновенной записи ваших клиентов к мастерам Beauty-услуг. " +
                "Наши решения деляют из ваших клиентов - постоянных.";
    }
}