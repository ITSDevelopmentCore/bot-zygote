package its.development.bots;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import its.development.handlers.BaseHandler;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LongPollingBot_MembersInjector implements MembersInjector<LongPollingBot> {
  private final Provider<Set<IBotCommand>> activeCommandsProvider;

  private final Provider<Map<LongPollingBot.HandlerType, BaseHandler>> activeHandlersProvider;

  public LongPollingBot_MembersInjector(Provider<Set<IBotCommand>> activeCommandsProvider,
      Provider<Map<LongPollingBot.HandlerType, BaseHandler>> activeHandlersProvider) {
    this.activeCommandsProvider = activeCommandsProvider;
    this.activeHandlersProvider = activeHandlersProvider;
  }

  public static MembersInjector<LongPollingBot> create(
      Provider<Set<IBotCommand>> activeCommandsProvider,
      Provider<Map<LongPollingBot.HandlerType, BaseHandler>> activeHandlersProvider) {
    return new LongPollingBot_MembersInjector(activeCommandsProvider, activeHandlersProvider);
  }

  @Override
  public void injectMembers(LongPollingBot instance) {
    injectActiveCommands(instance, activeCommandsProvider.get());
    injectActiveHandlers(instance, activeHandlersProvider.get());
  }

  @InjectedFieldSignature("its.development.bots.LongPollingBot.activeCommands")
  public static void injectActiveCommands(LongPollingBot instance,
      Set<IBotCommand> activeCommands) {
    instance.activeCommands = activeCommands;
  }

  @InjectedFieldSignature("its.development.bots.LongPollingBot.activeHandlers")
  public static void injectActiveHandlers(LongPollingBot instance,
      Map<LongPollingBot.HandlerType, BaseHandler> activeHandlers) {
    instance.activeHandlers = activeHandlers;
  }
}
