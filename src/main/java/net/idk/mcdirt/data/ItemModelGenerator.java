package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.I;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Mod_.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem_(I.TOTEM_OF_COMPELETION.asItem(), ResourceLocation.withDefaultNamespace("totem_of_undying"));
    }

    public ItemModelBuilder basicItem_(Item item, ResourceLocation location) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "item/" + location.getPath()));
    }
    public ItemModelBuilder _basicItem(Item item, ResourceLocation location) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "block/" + location.getPath()));
    }
}
