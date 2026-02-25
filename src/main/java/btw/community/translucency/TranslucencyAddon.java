package btw.community.translucency;

import api.AddonHandler;
import api.BTWAddon;

public class TranslucencyAddon extends BTWAddon {
    private static TranslucencyAddon instance;

    public TranslucencyAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}
