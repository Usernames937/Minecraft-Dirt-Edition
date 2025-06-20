package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Mod_.ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void m_1_(GatherDataEvent gde_1_) {
        DataGenerator daG_1_ = gde_1_.getGenerator();
        PackOutput out_1_ = daG_1_.getPackOutput();
        ExistingFileHelper efile_1_ = gde_1_.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup_1_ = gde_1_.getLookupProvider();

        daG_1_.addProvider(gde_1_.includeServer(), new LootTableProvider(out_1_, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BlockLootTableGenerator::new, LootContextParamSets.BLOCK)), lookup_1_));
        daG_1_.addProvider(gde_1_.includeServer(), new RecipeGenerator(out_1_, lookup_1_));
        daG_1_.addProvider(gde_1_.includeClient(), new TranslationGenerator.en_us(out_1_, "en_us"));
        daG_1_.addProvider(gde_1_.includeClient(), new ItemModelGenerator(out_1_, efile_1_));
        daG_1_.addProvider(gde_1_.includeClient(), new BlockStateGenerator(out_1_, efile_1_));
    }
}
