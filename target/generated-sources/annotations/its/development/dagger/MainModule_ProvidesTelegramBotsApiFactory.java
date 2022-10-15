package its.development.dagger;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.Generated;
import org.telegram.telegrambots.meta.TelegramBotsApi;

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
public final class MainModule_ProvidesTelegramBotsApiFactory implements Factory<TelegramBotsApi> {
  private final MainModule module;

  public MainModule_ProvidesTelegramBotsApiFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public TelegramBotsApi get() {
    return providesTelegramBotsApi(module);
  }

  public static MainModule_ProvidesTelegramBotsApiFactory create(MainModule module) {
    return new MainModule_ProvidesTelegramBotsApiFactory(module);
  }

  public static TelegramBotsApi providesTelegramBotsApi(MainModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesTelegramBotsApi());
  }
}
