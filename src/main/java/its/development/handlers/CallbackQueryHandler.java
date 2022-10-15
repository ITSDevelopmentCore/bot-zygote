package its.development.handlers;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CallbackQueryHandler extends BaseHandler{

    @Override
    public void execute(DefaultAbsSender sender, Update update) {
        System.out.println(1);
    }
}
