package its.development;

import its.development.wrapper.TelegramMultibotWrapper;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    public static void main(String[] args) throws TelegramApiException {
        TelegramMultibotWrapper telegramMultibotWrapper = new TelegramMultibotWrapper();
        telegramMultibotWrapper.run();
    }

}
