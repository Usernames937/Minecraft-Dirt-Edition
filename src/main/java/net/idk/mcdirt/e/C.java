package net.idk.mcdirt.e;

import net.idk.mcdirt.Config;
import net.idk.mcdirt.Mod_;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class C {
    public static final DeferredRegister<CreativeModeTab> CMT =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mod_.ID);

    public static final Supplier<CreativeModeTab> DIRTS = build("dirts",
            () -> CreativeModeTab.builder()
                    .displayItems((p, _p) -> {
                        if (Config.common.ENABLE_DIRT_MINECRAFT.get()) {
                            for (int i = 0; i < 25; i++) {
                                _p.accept(B.DIRTS[i]);
                            }
                        }
                    })
                    .withSearchBar()
                    .icon(() -> new ItemStack(Items.DIRT))
                    .title(Component.literal("Dirts"))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(Mod_.ID, "common"))
                    .build());
    public static final Supplier<CreativeModeTab> COMMON = build("common",
            () -> CreativeModeTab.builder()
                    .displayItems((p, _p) -> {
                        if (Config.common.ENABLE_DIRT_MINECRAFT.get()) {
                            _p.accept(I.TOTEM_OF_COMPELETION);
                        }
                    })
                    .icon(() -> new ItemStack(Items.END_CRYSTAL))
                    .title(Component.literal("Common"))
                    .build());

    public static Supplier<CreativeModeTab> build(String n, Supplier<CreativeModeTab> s) {
        return CMT.register(n, s);
    }
    public static void register(IEventBus e) {
        CMT.register(e);
    }
}
