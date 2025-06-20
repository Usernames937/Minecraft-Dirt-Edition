package net.idk.mcdirt.e;

import net.idk.mcdirt.Mod_;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class I {
    public static final DeferredRegister.Items ITEM =
            DeferredRegister.createItems(Mod_.ID);

    public static final DeferredItem<Item> TOTEM_OF_COMPELETION = r("compeletion_totem",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static <T extends Item> DeferredItem<T> r(String n, Supplier<T> s) {
        return ITEM.register(n, s);
    }
    public static void register(IEventBus e) {
        ITEM.register(e);
    }
}
