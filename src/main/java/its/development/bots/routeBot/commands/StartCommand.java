package its.development.bots.routeBot.commands;

import its.development.common.commands.BotCommandTextProvider;
import its.development.utils.MessageFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BotCommand implements BotCommandTextProvider {

    private static final String COMMAND_IDENTIFIER = "start";
    private static final String DESCRIPTION = "ITS Demo web app Route";

    public StartCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage sendMessage = MessageFactory.simpleTextMessage(getCommandText(), chat.getId());
        InlineKeyboardMarkup replyKeyboard = (InlineKeyboardMarkup) MessageFactory.inlineKeyboardMarkup(1, "Открыть приложение", "Отправить PUSH");

        replyKeyboard.getKeyboard().get(0).get(0).setWebApp(new WebAppInfo("https://fir-web-app-ro.web.app/"));
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
        return "Современные телеграм боты являются лучшим и самым быстрым решением для внутренних корпоративных процессов. Давайте посмотрим на демонстрационный вариант " +
                "приложение для курьера доставки новой пиццерии, или чего либо еще. Наши боты выполнят любую прихоть заказчика, будь то взаимодействие с картами, постоянно меняющимися данными, или " +
                "наличие нескольких экранов.";
    }
}