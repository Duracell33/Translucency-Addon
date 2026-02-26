package btw.community.translucency;

public class TranslucencyColorController {
    private static int disableCount = 0;

    public static boolean shouldForceWhite() {
        return disableCount == 0;
    }

    public static void disableWhiteText() {
        disableCount++;
    }

    public static void enableWhiteText() {
        disableCount--;
        if (disableCount < 0) {
            disableCount = 0;
        }
    }
}
