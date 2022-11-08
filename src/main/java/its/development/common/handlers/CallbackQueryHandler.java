package its.development.common.handlers;

import its.development.base.BaseHandler;
import its.development.utils.TelegramUIFactory;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static its.development.utils.TelegramUIConstants.*;

@SuppressWarnings("ALL")
public class CallbackQueryHandler extends BaseHandler {

    private final int DELAY_FIVE_SECONDS = 5000;

    private final String SEND_PUSH_STRING = "отправить push";
    private final String SHOW_ALL_DEMOS = "к другим образцам";

    @Override
    public void execute(DefaultAbsSender sender, Update update) {

        switch (update.getCallbackQuery().getData().toLowerCase(Locale.ROOT))
        {
            case SEND_PUSH_STRING:
            {
                executeSendPush(sender, update);
                break;
            }
            case SHOW_ALL_DEMOS:
            {
                executeShowAllDemos(sender, update);
                break;
            }
            default:
            {
                executeUnknownCommand(sender, update);
            }
        }

    }

    private void executeUnknownCommand(DefaultAbsSender sender, Update update) {

        SendMessage message = TelegramUIFactory.simpleTextMessage(
                "Упс... Я Вас не понимаю.",
                update.getCallbackQuery().getMessage().getChatId());

        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeShowAllDemos(DefaultAbsSender sender, Update update)
    {
        SendMessage message = TelegramUIFactory.simpleTextMessage(
                "Демонстрационные варианты Telegram Web Apps для различных отраслей",
                update.getCallbackQuery().getMessage().getChatId()
        );

        InlineKeyboardMarkup keyboardMarkup = TelegramUIFactory.createInlineKeyboard(1,
                "Электронная коммерция","Food tech","Сфера услуг","Корпоративные приложения","Образование");

        List<List<InlineKeyboardButton>>  keyboard = keyboardMarkup.getKeyboard();

        keyboard.get(KEYBOARD_FIRST_ROW).get(ROW_FIRST_BUTTON).setWebApp(new WebAppInfo("https://t.me/its_demo_shop_bot"));
        keyboard.get(KEYBOARD_FIRST_ROW).get(ROW_FIRST_BUTTON).setCallbackData(null);

        keyboard.get(KEYBOARD_SECOND_ROW).get(ROW_SECOND_BUTTON).setWebApp(new WebAppInfo("https://t.me/its_demo_food_bot"));
        keyboard.get(KEYBOARD_SECOND_ROW).get(ROW_SECOND_BUTTON).setCallbackData(null);

        keyboard.get(KEYBOARD_THIRD_ROW).get(ROW_THIRD_BUTTON).setWebApp(new WebAppInfo("https://t.me/its_demo_services_bot"));
        keyboard.get(KEYBOARD_THIRD_ROW).get(ROW_THIRD_BUTTON).setCallbackData(null);

        keyboard.get(KEYBOARD_FOURTH_ROW).get(ROW_FOURTH_BUTTON).setWebApp(new WebAppInfo("https://t.me/its_demo_route_bot"));
        keyboard.get(KEYBOARD_FOURTH_ROW).get(ROW_FOURTH_BUTTON).setCallbackData(null);

        keyboard.get(KEYBOARD_FIFTH_ROW).get(ROW_FIFTH_BUTTON).setWebApp(new WebAppInfo("https://t.me/its_demo_education_bot"));
        keyboard.get(KEYBOARD_FIFTH_ROW).get(ROW_FIFTH_BUTTON).setCallbackData(null);

        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeSendPush(DefaultAbsSender sender, Update update)
    {
        if (update.getCallbackQuery().getData().equalsIgnoreCase(SEND_PUSH_STRING))
        {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        sender.execute(TelegramUIFactory.simpleTextMessage(
                                "Вы получили PUSH уведомление с крайне выгодным предложением!",
                                update.getCallbackQuery().getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

            Timer pushTimer = new Timer();
            pushTimer.schedule(timerTask, DELAY_FIVE_SECONDS);
        }
    }
}
