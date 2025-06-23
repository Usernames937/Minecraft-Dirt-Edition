package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.T;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TagGenerator {
    public static class ItemT extends ItemTagsProvider {
        public ItemT(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockTags, Mod_.ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(T.I.COMMAND_BLOCKS)
                    .add(Items.COMMAND_BLOCK)
                    .add(Items.REPEATING_COMMAND_BLOCK)
                    .add(Items.CHAIN_COMMAND_BLOCK);
        }
    }
    public static class BlockT extends BlockTagsProvider {
        public BlockT(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Mod_.ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
        }
    }
}
