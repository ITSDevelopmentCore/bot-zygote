package its.development.dagger;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
import javax.annotation.Generated;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;

@ScopeMetadata("javax.inject.Singleton")
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
public final class MainModule_ProvidesBotCommandsFactory implements Factory<Set<IBotCommand>> {
  private final MainModule module;

  public MainModule_ProvidesBotCommandsFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public Set<IBotCommand> get() {
    return providesBotCommands(module);
  }

  public static MainModule_ProvidesBotCommandsFactory create(MainModule module) {
    return new MainModule_ProvidesBotCommandsFactory(module);
  }

  public static Set<IBotCommand> providesBotCommands(MainModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesBotCommands());
  }
}
