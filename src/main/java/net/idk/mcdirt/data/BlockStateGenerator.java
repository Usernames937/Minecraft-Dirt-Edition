package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
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

public class BlockStateGenerator extends BlockStateProvider {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mod_.ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (int i = 0; i < 25; i++) {
            dirt(B.DIRTS[i]);
        }
    }

    /**
     * Cube-All Simple Block
     * @param defB_1_ DeferredBlock of type ? (A Mod Block)
     */
    protected void m_1_(DeferredBlock<?> defB_1_, ResourceLocation l) {
        simpleBlockWithItem(defB_1_.get(), models().cubeAll(name(defB_1_.get()), l));
    }
    protected void dirt(DeferredBlock<?> defB_1_) {
        simpleBlockWithItem(defB_1_.get(), models().cubeAll(name(defB_1_.get()), ResourceLocation.withDefaultNamespace("block/dirt")));
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
