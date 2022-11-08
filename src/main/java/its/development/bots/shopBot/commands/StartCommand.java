package its.development.bots.shopBot.commands;

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

import static its.development.utils.TelegramUIConstants.*;

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
                .createInlineKeyboard(1, "Открыть приложение", "Отправить PUSH");


        List<List<InlineKeyboardButton>> inlineKeyboard = replyKeyboard.getKeyboard();

        inlineKeyboard
                .get(KEYBOARD_FIRST_ROW)
                .get(ROW_FIRST_BUTTON)
                .setWebApp(new WebAppInfo("https://635d4c86686fae79d284aaac--clever-starlight-079bec.netlify.app/"));

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
        return "С нашими решениями продажи в Telegram вышли на не виданный ранее уровень. В пару кликов пользователь может в удобном формате собрать и оформить заказ " +
                "в вашем магазине, пользуясь ботом, или же шустрым приложением внутри него. Круче всего то, что Ваш магазин уже установлен в смартфоне пользователя, ведь Telegram" +
                "есть у каждого.";
    }
}