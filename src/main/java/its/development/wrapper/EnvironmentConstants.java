package its.development.wrapper;

import static its.development.wrapper.EnvironmentConstants.BuildType.PRODUCTION;

public class EnvironmentConstants {

    public static final BuildType BUILD_TYPE = PRODUCTION;

    public enum BuildType {
        PRODUCTION, DEBUG
    }
}
