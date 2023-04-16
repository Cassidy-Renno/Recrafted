package net.cassidy.recrafted.datagen;

import net.cassidy.recrafted.block.ModBlocks;
import net.cassidy.recrafted.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModItems.FORGED_IRON_INGOT.get(), RecipeCategory.MISC, ModBlocks.FORGED_IRON_BLOCK.get());
        twoByTwoPacker(consumer, RecipeCategory.MISC, Blocks.GRASS_BLOCK, ModBlocks.GRASS_TURF.get());
    }
}
