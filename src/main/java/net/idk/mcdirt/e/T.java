package net.idk.mcdirt.e;

import net.idk.mcdirt.Mod_;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class T {
    public static class I {
        public static TagKey<Item> COMMAND_BLOCKS = createVanilla("command_blocks");

        private static TagKey<Item> create(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Mod_.ID, name));
        }
        private static TagKey<Item> createVanilla(String name) {
            return ItemTags.create(ResourceLocation.withDefaultNamespace(name));
        }
    }
    public static class B {
        private static TagKey<Block> create(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Mod_.ID, name));
        }
        private static TagKey<Block> createVanilla(String name) {
            return BlockTags.create(ResourceLocation.withDefaultNamespace(name));
        }
    }
}
