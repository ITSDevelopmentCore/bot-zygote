package its.development;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import its.development.wrapper.TelegramBotWrapper;

public class Main {

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotWrapper telegramBotWrapper = new TelegramBotWrapper();
        telegramBotWrapper.run();
    }

}
