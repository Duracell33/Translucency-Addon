package net.fabricmc.translucency.mixin;

import btw.community.translucency.TranslucencyColorController;
import net.minecraft.src.GuiMerchant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMerchant.class)
public class GuiMerchantMixin {

    @Inject(method = "drawGuiContainerForegroundLayer(II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/FontRenderer;drawString(Ljava/lang/String;III)I", ordinal = 2))
    private void disableAfterTitles(int par1, int par2, CallbackInfo ci) {
        TranslucencyColorController.disableWhiteText();
    }

    @Inject(method = "drawGuiContainerForegroundLayer(II)V", at = @At("RETURN"))
    private void enableAtReturn(int par1, int par2, CallbackInfo ci) {
        TranslucencyColorController.enableWhiteText();
    }
}
