package net.idk.mcdirt.data.$;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public abstract class BlockModelProviderExtra extends BlockModelProvider {
    public BlockModelProviderExtra(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Block Models: " + modid;
    }

    public BlockModelBuilder cube_(String name, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west, ResourceLocation p) {
        return withExistingParent(name, "cube")
                .texture("down", down)
                .texture("up", up)
                .texture("north", north)
                .texture("south", south)
                .texture("east", east)
                .texture("west", west)
                .texture("particle", p);
    }
}
