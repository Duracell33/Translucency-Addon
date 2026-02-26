package net.fabricmc.translucency.mixin;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiIngameMenu.class, priority = 3000)
public abstract class GuiInGameMenuMixin extends GuiScreen {

    @Inject(method = "initGui", at = @At("RETURN"))
    private void adjustToDoListAndShiftButtons(CallbackInfo ci) {
        // We want to shift the ToDoList button and anything below it down
        // to make space for the "Mods" button added by Fabric/BTW.

        // Threshold: anything at or below the position where ToDoList adds its button.
        int thresholdY = this.height / 4 + 24 + 32;
        int shiftAmount = 24;

        for (Object obj : this.buttonList) {
            if (obj instanceof GuiButton) {
                GuiButton button = (GuiButton) obj;

                // If it's the ToDoList button or anything else already at/below that level,
                // shift it down. We exclude the "Mods" button itself if it was the one
                // causing the initial overlap (usually ID 111 or similar, but let's check
                // text).

                if (button.displayString != null && button.displayString.equals("Mods")) {
                    // Keep the Mods button where it is
                    continue;
                }

                if (button.yPosition >= thresholdY - 4) { // Small buffer for positioning
                    button.yPosition += shiftAmount;
                }
            }
        }
    }
}
