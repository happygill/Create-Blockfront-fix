package com.happysg.cb.mixin;

import com.simibubi.create.foundation.utility.WorldHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.atomic.AtomicReference;

@Mixin(WorldHelper.class)
public abstract class WorldHelperMixin {

    @Inject(method = "getDimensionID", at = @At("HEAD"), cancellable = true, remap = false)
    private static void getDimensionID(LevelAccessor world, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation dimId = world.registryAccess().registry(Registries.DIMENSION_TYPE)
                .map(dimensionTypeRegistry -> dimensionTypeRegistry.getKey(world.dimensionType()))
                .orElse(new ResourceLocation("create_blockfront:fix"));
        cir.setReturnValue(dimId);
        cir.cancel();
    }
}
