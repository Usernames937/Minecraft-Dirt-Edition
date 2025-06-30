package net.idk.mcdirt.data.$;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.VisibleForTesting;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class BlockStateProviderExtra extends BlockStateProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    @VisibleForTesting
    protected final Map<Block, IGeneratedBlockState> registeredBlocks = new LinkedHashMap<>();

    private final PackOutput output;
    private final String modid;
    private final BlockModelProviderExtra blockModels;
    private final ItemModelProvider itemModels;

    public BlockStateProviderExtra(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
        this.output = output;
        this.modid = modid;
        this.blockModels = new BlockModelProviderExtra(output, modid, exFileHelper) {
            @Override
            public CompletableFuture<?> run(CachedOutput cache) {
                return CompletableFuture.allOf();
            }

            @Override
            protected void registerModels() {}
        };
        this.itemModels = new ItemModelProvider(output, modid, this.blockModels.existingFileHelper) {
            @Override
            protected void registerModels() {}

            @Override
            public CompletableFuture<?> run(CachedOutput cache) {
                return CompletableFuture.allOf();
            }
        };
    }

    protected abstract void registerStatesAndModels();

    @Override
    public BlockModelProvider models() {
        return blockModels;
    }

    public BlockModelBuilder e(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west, ResourceLocation p) {
        return blockModels.cube_(name, down, up, north, south, east, west, p);
    }
}
