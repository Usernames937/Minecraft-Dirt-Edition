package net.idk.mcdirt.data;

import net.idk.mcdirt.Mod_;
import net.idk.mcdirt.e.B;
import net.idk.mcdirt.e.I;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        dirt(output, Blocks.DIRT, B.DIRTS[0], 9999999);
        for (int i = 0; i < 25 - 1; i++) {
            dirt(output, B.DIRTS[i], B.DIRTS[i + 1], i);
        }
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, I.TOTEM_OF_COMPELETION)
                .define('e', B.DIRTS[24])
                .pattern("eee")
                .pattern("eee")
                .pattern("eee")
                .unlockedBy("dirt25-i3nfnj2t4kt2nt", has(B.DIRTS[24]))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SHULKER_SHELL)
                .define('t', B.DIRTS[4])
                .pattern("ttt")
                .pattern("t t")
                .unlockedBy(Mod_.ID + ":shulkershell-d5i3nfinm1fj", has(B.DIRTS[4]))
                .save(output, Mod_.ID + ":shulkershell-d5i3nfinm1fj");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, B.BLOCK_ENTITIES[0])
                .define('e', Blocks.COBBLESTONE)
                .pattern("ee")
                .pattern("ee")
                .unlockedBy(Mod_.ID_C + "cobblestonecraftingtable-4cien1mcsk", has(Blocks.COBBLESTONE))
                .save(output, Mod_.ID_C + "cobblestonecraftingtable-4cien1mcsk");
        for (int i = 0; i < I.PACKAGES.length; i++) {
            stonecutting(output, RecipeCategory.COMBAT, B.DIRTS[24], I.PACKAGES[i], 1);
        }
    }

    protected static void smelting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        cookin(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }
    protected static void blasting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        cookin(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }
    protected static void smoking(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        cookin(
                recipeOutput,
                RecipeSerializer.SMOKING_RECIPE,
                SmokingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smoking"
        );
    }
    protected static <T extends AbstractCookingRecipe> void cookin(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Mod_.ID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }
    protected static void smithing(RecipeOutput recipeOutput, Item template, Item ingredient, Item addition, RecipeCategory category, Item result, String unlockKey, Item unlockBy) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(template), Ingredient.of(ingredient), Ingredient.of(addition), category, result
                )
                .unlocks(unlockKey, has(unlockBy))
                .save(recipeOutput, Mod_.ID + ":" + getItemName(result) + "_smithing");
    }
    protected static void stonecutting(RecipeOutput output, RecipeCategory category, ItemLike material, ItemLike result, int count) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, count)
                .unlockedBy(getHasName(material), has(material))
                .save(output, Mod_.ID_C + getConversionRecipeName(result, material) + "_stonecutting");
    }
    //if anyone want to modify, create a different method.
    private static void dirt(RecipeOutput o, ItemLike mt, ItemLike re, int i) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, re)
                .define('q', mt)
                .pattern("qqq")
                .pattern("qqq")
                .pattern("qqq")
                .unlockedBy("has-84k1h4h5unur1b", has(mt))
                .save(o, Mod_.ID + ":" + getItemName(re) + "_dirtc4mgo1mrigmrtjg2nd" + i);
    }
}
