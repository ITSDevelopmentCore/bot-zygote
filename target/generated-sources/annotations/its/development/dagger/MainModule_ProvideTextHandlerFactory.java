package its.development.dagger;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import its.development.handlers.BaseHandler;
import javax.annotation.Generated;

@ScopeMetadata
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
public final class MainModule_ProvideTextHandlerFactory implements Factory<BaseHandler> {
  private final MainModule module;

  public MainModule_ProvideTextHandlerFactory(MainModule module) {
    this.module = module;
  }

  @Override
  public BaseHandler get() {
    return provideTextHandler(module);
  }

  public static MainModule_ProvideTextHandlerFactory create(MainModule module) {
    return new MainModule_ProvideTextHandlerFactory(module);
  }

  public static BaseHandler provideTextHandler(MainModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideTextHandler());
  }
}
