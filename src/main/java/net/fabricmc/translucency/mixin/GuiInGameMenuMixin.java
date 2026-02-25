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
    private void adjustToDoListButton(CallbackInfo ci) {
        for (Object obj : this.buttonList) {
            if (obj instanceof GuiButton) {
                GuiButton button = (GuiButton) obj;
                // Broaden detection: check ID 14 or if the string contains the text.
                // Priority 3000 ensures we run after the ToDoList addon's @Inject(at = RETURN).
                if (button.id == 14 || (button.displayString != null && button.displayString.contains("To Do List"))) {
                    button.yPosition += 24;
                }
            }
        }
    }
}
