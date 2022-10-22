package its.development.dagger;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import its.development.bots.LongPollingBot;
import its.development.bots.LongPollingBot_MembersInjector;
import its.development.handlers.BaseHandler;
import its.development.wrapper.TelegramMultibotWrapper;
import its.development.wrapper.TelegramBotWrapper_MembersInjector;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMainComponent {
  private DaggerMainComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static MainComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private MainModule mainModule;

    private Builder() {
    }

    public Builder mainModule(MainModule mainModule) {
      this.mainModule = Preconditions.checkNotNull(mainModule);
      return this;
    }

    public MainComponent build() {
      if (mainModule == null) {
        this.mainModule = new MainModule();
      }
      return new MainComponentImpl(mainModule);
    }
  }

  private static final class MainComponentImpl implements MainComponent {
    private final MainModule mainModule;

    private final MainComponentImpl mainComponentImpl = this;

    private Provider<TelegramBotsApi> providesTelegramBotsApiProvider;

    private Provider<Set<IBotCommand>> providesBotCommandsProvider;

    private MainComponentImpl(MainModule mainModuleParam) {
      this.mainModule = mainModuleParam;
      initialize(mainModuleParam);

    }

    private Set<IBotCommand> setOfIBotCommand() {
      return ImmutableSet.<IBotCommand>copyOf(providesBotCommandsProvider.get());
    }

    private Map<LongPollingBot.HandlerType, BaseHandler> mapOfHandlerTypeAndBaseHandler() {
      return ImmutableMap.<LongPollingBot.HandlerType, BaseHandler>of(LongPollingBot.HandlerType.TEXT, MainModule_ProvideTextHandlerFactory.provideTextHandler(mainModule), LongPollingBot.HandlerType.PRECHECKOUT_QUERY, MainModule_ProvidePreCheckoutHandlerFactory.providePreCheckoutHandler(mainModule), LongPollingBot.HandlerType.CALLBACK_QUERY, MainModule_ProvideCallbackQueryHandlerFactory.provideCallbackQueryHandler(mainModule));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final MainModule mainModuleParam) {
      this.providesTelegramBotsApiProvider = DoubleCheck.provider(MainModule_ProvidesTelegramBotsApiFactory.create(mainModuleParam));
      this.providesBotCommandsProvider = DoubleCheck.provider(MainModule_ProvidesBotCommandsFactory.create(mainModuleParam));
    }

    @Override
    public void inject(TelegramMultibotWrapper telegramMultibotWrapper) {
      injectTelegramBotWrapper(telegramMultibotWrapper);
    }

    @Override
    public void inject(LongPollingBot telegramBotWrapper) {
      injectLongPollingBot(telegramBotWrapper);
    }

    @CanIgnoreReturnValue
    private TelegramMultibotWrapper injectTelegramBotWrapper(TelegramMultibotWrapper instance) {
      TelegramBotWrapper_MembersInjector.injectTelegramBotsApi(instance, providesTelegramBotsApiProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private LongPollingBot injectLongPollingBot(LongPollingBot instance) {
      LongPollingBot_MembersInjector.injectActiveCommands(instance, setOfIBotCommand());
      LongPollingBot_MembersInjector.injectActiveHandlers(instance, mapOfHandlerTypeAndBaseHandler());
      return instance;
    }
  }
}
