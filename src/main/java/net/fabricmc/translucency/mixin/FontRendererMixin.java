package net.fabricmc.translucency.mixin;

import net.minecraft.src.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = FontRenderer.class, priority = 2000)
public class FontRendererMixin {

    @ModifyVariable(method = "drawString(Ljava/lang/String;III)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColor(int color) {
        return 0xFFFFFFFF;
    }

    @ModifyVariable(method = "drawStringWithShadow(Ljava/lang/String;III)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColorShadow(int color) {
        return 0xFFFFFFFF;
    }

    @ModifyVariable(method = "drawString(Ljava/lang/String;IIIZ)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColorWorker(int color) {
        return 0xFFFFFFFF;
    }
}
