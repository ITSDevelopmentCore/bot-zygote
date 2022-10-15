package its.development.handlers.utils;

import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class MessageFactory {

    public static SendMessage simpleTextMessage(
                    @Nonnull String text,
                    @Nonnull Long chatId) {

        return SendMessage
                .builder()
                .chatId(String.valueOf(chatId))
                .text(text)
                .build();
    }

    /**
     * @param buttonsPerRow - Amount of buttons in every row.
     * @param context - Context String data for every button.
     * @return configured Inline Keyboard Markup
     */
    public static ReplyKeyboard inlineKeyboardMarkup(int buttonsPerRow, String... context)
    {
        LinkedBlockingQueue<InlineKeyboardButton> buttons = transformStringsToButtons(context);

        InlineKeyboardMarkup.InlineKeyboardMarkupBuilder builder = InlineKeyboardMarkup.builder();

        do {
            List<InlineKeyboardButton> row = buttons
                    .stream()
                    .limit(buttonsPerRow)
                    .collect(Collectors.toList());

            for (int i = 0; i < buttonsPerRow; i++) {
                buttons.poll();
            }

            builder.keyboardRow(row);
        } while (buttons.size() > 0);

        return builder.build();

    }

    private static LinkedBlockingQueue<InlineKeyboardButton> transformStringsToButtons(String... source)
    {
        return Arrays.stream(source)
                .map(name -> InlineKeyboardButton.builder()
                        .text(name)
                        .callbackData(name)
                        .build())
                .collect(Collectors.toCollection(LinkedBlockingQueue::new));
    }


}
