package its.development.common.commands;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class InlineKeyboardCommand extends BotCommand {

    private static final String COMMAND_IDENTIFIER = "icecream";
    private static final String DESCRIPTION = "pogpogpog";


    public InlineKeyboardCommand() {
        super(COMMAND_IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

    }
}
