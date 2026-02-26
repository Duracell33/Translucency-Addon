package net.fabricmc.translucency.mixin;

import btw.community.translucency.TranslucencyColorController;
import net.minecraft.src.GuiSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiSlot.class)
public class GuiSlotMixin {
    @Inject(method = "drawScreen(IIF)V", at = @At("HEAD"))
    private void preDrawScreen(CallbackInfo ci) {
        TranslucencyColorController.disableWhiteText();
    }

    @Inject(method = "drawScreen(IIF)V", at = @At("RETURN"))
    private void postDrawScreen(CallbackInfo ci) {
        TranslucencyColorController.enableWhiteText();
    }
}
