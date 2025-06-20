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

    public static final DeferredBlock<?>[] DIRTS = {
            create("dirt1", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt2", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt3", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt4", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt5", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt6", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt7", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt8", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt9", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt10", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt11", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt12", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt13", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt14", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt15", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt16", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt17", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt18", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt19", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt20", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt21", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt22", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt23", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt24", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
            create("dirt25", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))),
    };
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
