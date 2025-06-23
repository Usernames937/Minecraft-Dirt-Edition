package net.idk.mcdirt.e;

import net.idk.mcdirt.Mod_;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class B {
    public static final DeferredRegister.Blocks BLOCK =
            DeferredRegister.createBlocks(Mod_.ID);
    public static DeferredBlock<?>[] getDirts() {
        final int arraySize = 25;
        DeferredBlock<?>[] array = new DeferredBlock[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int v = i + 1;
            array[i] = create("dirt" + v, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
        }
        return array;
    }

    public static final DeferredBlock<?>[] DIRTS = getDirts();

    public static <T extends Block> DeferredBlock<T> create(String n, Supplier<T> b, Item.Properties p) {
        DeferredBlock<T> r = BLOCK.register(n, b);
        bItem(n, r, p);
        return r;
    }
    public static <T extends Block> DeferredBlock<T> create(String n, Supplier<T> b) {
        DeferredBlock<T> r = BLOCK.register(n, b);
        bItem(n, r, new Item.Properties());
        return r;
    }
    public static <T extends Block> DeferredBlock<T> c(String n, Supplier<T> b) {
        return BLOCK.register(n, b);
    }
    public static <T extends Block> void bItem(String n, DeferredBlock<T> b, Item.Properties p) {
        I.ITEM.register(n, () -> new BlockItem(b.get(), p));
    }
    public static void register(IEventBus e) {
        BLOCK.register(e);
    }
}
