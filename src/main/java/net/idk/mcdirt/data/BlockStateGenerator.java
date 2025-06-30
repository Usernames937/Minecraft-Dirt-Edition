package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.data.$.BlockModelProviderExtra;
import net.idk.mcdirt.data.$.BlockStateProviderExtra;
import net.idk.mcdirt.e.B;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateGenerator extends BlockStateProviderExtra {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mod_.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (int i = 0; i < 25; i++) {
            dirt(B.DIRTS[i]);
        }
        cube(B.BLOCK_ENTITIES[0],
                ResourceLocation.withDefaultNamespace("block/cobblestone"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_top"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_front"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_front"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_side"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_side"),
                ResourceLocation.withDefaultNamespace("block/cobblestone_crafting_table_front")
        );
    }

    protected void m_1_(DeferredBlock<?> defB_1_, ResourceLocation l) {
        simpleBlockWithItem(defB_1_.get(), models().cubeAll(name(defB_1_.get()), l));
    }
    protected void m_2_(DeferredBlock<?> defB,
                        ResourceLocation down,
                        ResourceLocation up,
                        ResourceLocation north,
                        ResourceLocation south,
                        ResourceLocation east,
                        ResourceLocation west
                        ) {
        simpleBlockWithItem(defB.get(), models().cube(name(defB.get()),
                down,
                up,
                north,
                south,
                east,
                west));
    }
    protected void dirt(DeferredBlock<?> defB_1_) {
        simpleBlockWithItem(defB_1_.get(), models().cubeAll(name(defB_1_.get()), ResourceLocation.withDefaultNamespace("block/dirt")));
    }

    protected void cube(DeferredBlock<?> defB,
                        ResourceLocation down,
                        ResourceLocation up,
                        ResourceLocation north,
                        ResourceLocation south,
                        ResourceLocation east,
                        ResourceLocation west,
                        ResourceLocation p
    ) {
        simpleBlockWithItem(defB.get(), e(name(defB.get()),
                down,
                up,
                north,
                south,
                east,
                west,
                p
        ));
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    protected void m_3_(DeferredBlock<?> b_3_, BooleanProperty value, String id, String name$1, String name$2, String name$item) {
        getVariantBuilder(b_3_.get()).forAllStates(state -> {
            if (state.getValue(value)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name$1,
                        ResourceLocation.fromNamespaceAndPath(id, "block/" + name$1)))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name$2,
                        ResourceLocation.fromNamespaceAndPath(id, "block/" + name$2)))};
            }
        });
        simpleBlockItem(b_3_.get(), models().cubeAll(name$item,
                ResourceLocation.fromNamespaceAndPath(id, "block/" + name$item)));
    }
}
