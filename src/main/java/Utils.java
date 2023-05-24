public class Utils {
    public static float calculateReadjustment(float oldValue, float newValue) {
        float difference = newValue - oldValue;
        float readjustment = (difference * 100)/oldValue;

        return readjustment;
    }
}
