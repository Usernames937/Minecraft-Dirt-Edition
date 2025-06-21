package net.idk.mcdirt.e;

import net.idk.mcdirt.Mod_;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class I {
    public static final DeferredRegister.Items ITEM =
            DeferredRegister.createItems(Mod_.ID);
    public static DeferredItem<?>[] getPackages() {
        String[] registerNames = {
                "tool_package",//1
                "armor_package",//2
                "totem_package",//3
                "food_package1",//4
                "food_package2",//5
                "pearl_package",//6
                "material_package",//7, stone, iron, gold, diamond, wood
                "flying_package",//8
        };
        DeferredItem<?>[] items = new DeferredItem[registerNames.length];
        for (int i = 0; i < registerNames.length; i++) {
            items[i] = r(registerNames[i], () -> new Item(new Item.Properties().stacksTo(16).rarity(Rarity.EPIC)));
        }
        return items;
    }

    public static final DeferredItem<Item> TOTEM_OF_COMPELETION = r("compeletion_totem",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final DeferredItem<?>[] PACKAGES = getPackages();

    public static class Arrays {
        public static ItemStack[] pack0 = {
                new ItemStack(Items.NETHERITE_PICKAXE),
                new ItemStack(Items.NETHERITE_AXE),
                new ItemStack(Items.NETHERITE_SHOVEL),
                new ItemStack(Items.NETHERITE_SWORD),
                new ItemStack(Items.NETHERITE_HOE),
        };
        public static ItemStack[] pack1 = {
                new ItemStack(Items.NETHERITE_HELMET),
                new ItemStack(Items.NETHERITE_LEGGINGS),
                new ItemStack(Items.NETHERITE_CHESTPLATE),
                new ItemStack(Items.NETHERITE_BOOTS),
        };
        public static ItemStack[] pack2 = {
                new ItemStack(Items.TOTEM_OF_UNDYING, 32),
        };
        public static void setData_p2() {
            pack2[0].set(DataComponents.MAX_STACK_SIZE, 32);
        }
        public static ItemStack[] pack3 = {
                new ItemStack(Items.GOLDEN_CARROT, 64),
                new ItemStack(Items.GOLDEN_CARROT, 64),
        };
        public static ItemStack[] pack4 = {
                new ItemStack(Items.COOKED_BEEF, 64),
                new ItemStack(Items.COOKED_BEEF, 64),
        };
        public static ItemStack[] pack5 = {
                new ItemStack(Items.ENDER_PEARL, 16),
                new ItemStack(Items.ENDER_PEARL, 16),
        };
        public static ItemStack[] pack6 = {
                new ItemStack(Items.COBBLESTONE, 64),
                new ItemStack(Items.IRON_INGOT, 64),
                new ItemStack(Items.GOLD_INGOT, 64),
                new ItemStack(Items.DIAMOND, 32),
                new ItemStack(Items.OAK_LOG, 64),
        };
        public static ItemStack[] pack7 = {
                new ItemStack(Items.ELYTRA),
                new ItemStack(Items.FIREWORK_ROCKET, 64),
                new ItemStack(Items.FIREWORK_ROCKET, 64),
                new ItemStack(Items.FIREWORK_ROCKET, 64),
        };
        public static ItemStack[][] packs = {
                pack0, pack1, pack2, pack3, pack4, pack5, pack6, pack7,
        };
    }
    public static <T extends Item> DeferredItem<T> r(String n, Supplier<T> s) {
        return ITEM.register(n, s);
    }
    public static void register(IEventBus e) {
        ITEM.register(e);
    }
}
