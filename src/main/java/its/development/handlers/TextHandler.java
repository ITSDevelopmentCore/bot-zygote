package its.development.handlers;

import its.development.handlers.utils.MessageFactory;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class TextHandler extends BaseHandler {

    private static final int DELAY_FIVE_SECONDS = 5000;

    private static final String SEND_PUSH_STRING = "отправить push";
    @Override
    public void execute(DefaultAbsSender sender, Update update) {

        if (update.getCallbackQuery().getData().equalsIgnoreCase("отправить push"))
        {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    try {
                        sender.execute(MessageFactory.simpleTextMessage(
                                "Вы получили PUSH уведомление с выгодным предложением!",
                                update.getMessage().getChatId()));
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
