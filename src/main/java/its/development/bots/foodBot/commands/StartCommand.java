package its.development.bots.foodBot.commands;

import its.development.common.commands.BotCommandTextProvider;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import its.development.utils.MessageFactory;

public class StartCommand extends BotCommand implements BotCommandTextProvider {

    private static final String COMMAND_IDENTIFIER = "start";
    private static final String DESCRIPTION = "ITS Web Apps";

    public StartCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage sendMessage = MessageFactory.simpleTextMessage(getCommandText(), chat.getId());
        InlineKeyboardMarkup replyKeyboard = (InlineKeyboardMarkup) MessageFactory.inlineKeyboardMarkup(1, "Открыть приложение", "Отправить PUSH");

        replyKeyboard.getKeyboard().get(0).get(0).setWebApp(new WebAppInfo("https://fir-web-app-food-5edce.firebaseapp.com/"));
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
        return "Наши боты позволят колоссально снизить затраты на возвращение клиента и превращение его в постоянного. Мы автоматизируем процесс повторных конверсий " +
                "для малого и среднего бизнеса путем добавления в Telegram всех Ваших клиентов наших ботов с приложениями. Имея уже готовое решение всегда под рукой - клиент " +
                "даже не будет думать о заказе у Ваших конкурентов.";
    }
}