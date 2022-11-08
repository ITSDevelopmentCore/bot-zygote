package its.development.bots;

import its.development.wrapper.EnvironmentConstants;

import static its.development.wrapper.EnvironmentConstants.BuildType.DEBUG;

public class BotConstants {
    /**
     * Telegram BOT_TOKEN, received by BotFather in Telegram client app.
     */
    public static final String BOT_EDUCATION_TOKEN = "5770323383:AAFc123Gv0RDN6EzzBle-DBEn-BXOdQRQk0";
    public static final String BOT_SERVICES_TOKEN = "5449239733:AAGt9fkJHD6YaPbKnCK7p8020JEpkE5QmPM";
    public static final String BOT_FOOD_TOKEN = "5326438889:AAHhkmGNZJ48OgvaeRbcKxIi_8YRCBoW49w";
    public static final String BOT_ROUTE_TOKEN = "5422662507:AAGDv3oUKBt9N3Ar5P8a62yxK0HA-EaRfhc";
    public static final String BOT_SHOP_TOKEN = "5743331029:AAFN-yhwa50fJ94rCoxdPwE3jNPN4P2Ex9w";
    public static final String BOT_TEST_TOKEN = "5193116716:AAHtN93_Ul67hVJnPAvmPPancKs7P3Utr1M";


    /**
     * Names
     */
    public static final String BOT_EDUCATION_NAME = "ITS Demo education";
    public static final String BOT_SERVICES_NAME = "ITS Demo services";
    public static final String BOT_ROUTE_NAME = "ITS Demo route";
    public static final String BOT_FOOD_NAME = "ITS Demo food";
    public static final String BOT_SHOP_NAME = "ITS Demo shop";


    /**
     * Types of common project bot handlers
     */
    public enum HandlerType {
        TEXT, CALLBACK_QUERY, PRECHECKOUT_QUERY
    }

}
