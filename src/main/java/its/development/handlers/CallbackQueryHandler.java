package its.development.handlers;

import its.development.handlers.utils.MessageFactory;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("ALL")
public class CallbackQueryHandler extends BaseHandler{

    private final int DELAY_FIVE_SECONDS = 5000;

    private final String SEND_PUSH_STRING = "Отправить PUSH";
    @Override
    public void execute(DefaultAbsSender sender, Update update) {
        if (update.getCallbackQuery().getData().equalsIgnoreCase(SEND_PUSH_STRING))
        {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        sender.execute(MessageFactory.simpleTextMessage(
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
