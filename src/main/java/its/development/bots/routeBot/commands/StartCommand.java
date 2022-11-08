package its.development.bots.routeBot.commands;

import its.development.common.commands.BotCommandTextProvider;
import its.development.utils.TelegramUIFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static its.development.utils.TelegramUIConstants.KEYBOARD_FIRST_ROW;
import static its.development.utils.TelegramUIConstants.ROW_FIRST_BUTTON;

public class StartCommand extends BotCommand implements BotCommandTextProvider {

    private static final String COMMAND_IDENTIFIER = "start";
    private static final String DESCRIPTION = "ITS Demo web app Route";

    public StartCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage sendMessage = TelegramUIFactory.simpleTextMessage(getCommandText(), chat.getId());

        InlineKeyboardMarkup replyKeyboard = TelegramUIFactory
                .createInlineKeyboard(1, "Открыть приложение", "Отправить PUSH");


        List<List<InlineKeyboardButton>> inlineKeyboard = replyKeyboard.getKeyboard();

        inlineKeyboard
                .get(KEYBOARD_FIRST_ROW)
                .get(ROW_FIRST_BUTTON)
                .setWebApp(new WebAppInfo("https://fir-web-app-ro.web.app/"));

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
        return "Современные телеграм боты являются лучшим и самым быстрым решением для внутренних корпоративных процессов. Давайте посмотрим на демонстрационный вариант " +
                "приложение для курьера доставки новой пиццерии, или чего либо еще. Наши боты выполнят любую прихоть заказчика, будь то взаимодействие с картами, постоянно меняющимися данными, или " +
                "наличие нескольких экранов.";
    }
}