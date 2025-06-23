package net.idk.mcdirt.e;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.adv.PackageItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class I {
    public static final DeferredRegister.Items ITEM =
            DeferredRegister.createItems(Mod_.ID);
    public static DeferredItem<?>[] getPackages() {
        String[] registerNames = {
                "tool_package",//0
                "armor_package",//1
                "totem_package",//2
                "food_package1",//3
                "food_package2",//4
                "pearl_package",//5
                "material_package",//6, stone, iron, gold, diamond, wood
                "flying_package",//7
                "admin_package",//8
        };
        DeferredItem<?>[] items = new DeferredItem[registerNames.length];
        for (int i = 0; i < registerNames.length; i++) {
            items[i] = r(registerNames[i], () -> new PackageItem(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)));
        }
        return items;
    }

    public static final DeferredItem<Item> TOTEM_OF_COMPELETION = r("compeletion_totem",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final DeferredItem<?>[] PACKAGES = getPackages();

    public static <T extends Item> DeferredItem<T> r(String n, Supplier<T> s) {
        return ITEM.register(n, s);
    }
    public static void register(IEventBus e) {
        ITEM.register(e);
    }
}
