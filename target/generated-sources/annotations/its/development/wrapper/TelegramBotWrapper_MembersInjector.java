package its.development.wrapper;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.telegram.telegrambots.meta.TelegramBotsApi;

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
public final class TelegramBotWrapper_MembersInjector implements MembersInjector<TelegramMultibotWrapper> {
  private final Provider<TelegramBotsApi> telegramBotsApiProvider;

  public TelegramBotWrapper_MembersInjector(Provider<TelegramBotsApi> telegramBotsApiProvider) {
    this.telegramBotsApiProvider = telegramBotsApiProvider;
  }

  public static MembersInjector<TelegramMultibotWrapper> create(
      Provider<TelegramBotsApi> telegramBotsApiProvider) {
    return new TelegramBotWrapper_MembersInjector(telegramBotsApiProvider);
  }

  @Override
  public void injectMembers(TelegramMultibotWrapper instance) {
    injectTelegramBotsApi(instance, telegramBotsApiProvider.get());
  }

  @InjectedFieldSignature("its.development.wrapper.TelegramBotWrapper.telegramBotsApi")
  public static void injectTelegramBotsApi(TelegramMultibotWrapper instance,
                                           TelegramBotsApi telegramBotsApi) {
    instance.telegramBotsApi = telegramBotsApi;
  }
}
