package net.fabricmc.translucency.mixin;

import btw.community.translucency.TranslucencyColorController;
import net.minecraft.src.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiIngameMixin {
    @Inject(method = "renderGameOverlay(FZII)V", at = @At("HEAD"))
    private void preRenderOverlay(CallbackInfo ci) {
        TranslucencyColorController.disableWhiteText();
    }

    @Inject(method = "renderGameOverlay(FZII)V", at = @At("RETURN"))
    private void postRenderOverlay(CallbackInfo ci) {
        TranslucencyColorController.enableWhiteText();
    }
}
