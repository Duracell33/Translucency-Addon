package net.fabricmc.translucency.mixin;

import btw.community.translucency.TranslucencyColorController;
import com.prupe.mcpatcher.mal.resource.TexturePackAPI;
import net.minecraft.src.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = FontRenderer.class, priority = 2000)
public class FontRendererMixin {

    @ModifyVariable(method = "drawString(Ljava/lang/String;III)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColor(int color) {
        if (!TranslucencyColorController.shouldForceWhite())
            return color;

        int rgb = color & 0xFFFFFF;
        if (rgb == 4210752) { // Only force dark gray (titles) to white, leave subtext alone
            return 0xFFFFFFFF;
        }
        return color;
    }

    @ModifyVariable(method = "drawStringWithShadow(Ljava/lang/String;III)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColorShadow(int color) {
        if (!TranslucencyColorController.shouldForceWhite())
            return color;

        int rgb = color & 0xFFFFFF;
        if (rgb == 4210752) { // Only force dark gray (titles) to white, leave subtext alone
            return 0xFFFFFFFF;
        }
        return color;
    }

    @ModifyVariable(method = "drawString(Ljava/lang/String;IIIZ)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColorWorker(int color) {
        if (!TranslucencyColorController.shouldForceWhite())
            return color;

        int rgb = color & 0xFFFFFF;
        if (rgb == 4210752) { // Only force dark gray (titles) to white, leave subtext alone
            return 0xFFFFFFFF;
        }
        return color;
    }

    @ModifyVariable(method = "renderString(Ljava/lang/String;IIIZ)I", at = @At("HEAD"), argsOnly = true, ordinal = 2, require = 0)
    private int modifyColorRender(int color) {
        if (!TranslucencyColorController.shouldForceWhite())
            return color;

        int rgb = color & 0xFFFFFF;
        if (rgb == 4210752) { // Only force dark gray (titles) to white, leave subtext alone
            return 0xFFFFFFFF;
        }
        return color;
    }
}
