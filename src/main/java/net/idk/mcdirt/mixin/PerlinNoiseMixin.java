package net.idk.mcdirt.mixin;

import net.idk.mcdirt.config.Config;
import net.idk.mcdirt.config.FarlandsOption;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PerlinNoise.class)
public class PerlinNoiseMixin {
    @Inject(method = "wrap", at = @At("RETURN"), cancellable = true)
    private static void modify(double value, CallbackInfoReturnable<Double> cir) {
        if (Config.server.FARLANDS.get().equals(FarlandsOption.generateFarlands)) {
            cir.setReturnValue(value);
        } else {
            cir.cancel();
        }
    }
}
