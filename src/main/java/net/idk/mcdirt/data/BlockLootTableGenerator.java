package net.idk.mcdirt.data;

import net.idk.mcdirt.e.B;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class BlockLootTableGenerator extends BlockLootSubProvider {
    protected BlockLootTableGenerator(HolderLookup.Provider reg_1_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), reg_1_);
    }

    @Override
    protected void generate() {
        for (int i = 0; i < 25; i++) {
            dropSelf(B.DIRTS[i].get());
        }
    }

    protected LootTable.Builder m_1_(Block b_1_, Item i_1_, int int_1_, int int_2_) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                b_1_, this.applyExplosionDecay(
                        b_1_, LootItem.lootTableItem(i_1_)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(int_1_, int_2_)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return B.BLOCK.getEntries().stream().map(Holder::value)::iterator;
    }
}
