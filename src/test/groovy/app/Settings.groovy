package app

class Settings {

    private static String APP_URL = "http://localhost:3000";
    private static String COOKIE = "";
    private static int OPERATION_TIMEOUT_IN_SEC = 30;

    static String getAppUrl() {
        return APP_URL
    }

    static String getCOOKIE() {
        return COOKIE
    }

    static int getOpTimeout() {
        return OPERATION_TIMEOUT_IN_SEC
    }

}
