package its.development.wrapper;

import static its.development.wrapper.EnvironmentConstants.BuildType.DEBUG;

public class EnvironmentConstants {

    public static final BuildType BUILD_TYPE = DEBUG;

    public enum BuildType {
        PRODUCTION, DEBUG
    }
}
