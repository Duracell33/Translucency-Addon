package net.fabricmc.translucency.mixin;

import btw.community.translucency.TranslucencyColorController;
import net.minecraft.src.GuiMerchant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMerchant.class)
public class GuiMerchantMixin {

    @Inject(method = "drawScreen(IIF)V", at = @At("HEAD"))
    private void drawScreenHead(int par1, int par2, float par3, CallbackInfo ci) {
        TranslucencyColorController.disableWhiteText();
    }

    @Inject(method = "drawScreen(IIF)V", at = @At("RETURN"))
    private void drawScreenReturn(int par1, int par2, float par3, CallbackInfo ci) {
        TranslucencyColorController.enableWhiteText();
    }
}
