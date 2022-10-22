package its.development.base;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class BaseHandler {

    public abstract void execute(DefaultAbsSender sender, Update update) throws TelegramApiException;

}
