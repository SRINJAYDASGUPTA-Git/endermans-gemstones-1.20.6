package net.enderman.gemstones.datagen;

import net.enderman.gemstones.block.ModBlocks;
import net.enderman.gemstones.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLE = List.of(ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.ENDSTONE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.RUBY_ORE, ModItems.RAW_RUBY);

    private static final List<ItemConvertible> SAPPHIRE_SMELTABLE = List.of(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.SAPPHIRE_ORE);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);

    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        offerSmelting(exporter, SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.7f, 200, "sapphire");
        offerBlasting(exporter, SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.7f, 200, "sapphire");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_DOOR)));
        createDoorRecipe(ModBlocks.SAPPHIRE_DOOR, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_DOOR)));

        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_TRAPDOOR)));
        createTrapdoorRecipe(ModBlocks.SAPPHIRE_TRAPDOOR, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_TRAPDOOR)));

        createSlabRecipe(RecipeCategory.MISC, ModBlocks.RUBY_SLAB, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_SLAB)));
        createSlabRecipe(RecipeCategory.MISC, ModBlocks.SAPPHIRE_SLAB, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_SLAB)));

        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_STAIRS)));
        createStairsRecipe(ModBlocks.SAPPHIRE_STAIRS, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_STAIRS)));

        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.RUBY_WALL, ModItems.RUBY);
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.SAPPHIRE_WALL, ModItems.SAPPHIRE);

        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE)));
        createFenceRecipe(ModBlocks.SAPPHIRE_FENCE, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE)));

        offerPressurePlateRecipe(exporter, ModBlocks.RUBY_PRESSURE_PLATE, ModItems.RUBY);
        offerPressurePlateRecipe(exporter, ModBlocks.SAPPHIRE_PRESSURE_PLATE, ModItems.SAPPHIRE);

        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModItems.RUBY)).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));
        createFenceGateRecipe(ModBlocks.SAPPHIRE_FENCE_GATE, Ingredient.ofItems(ModItems.SAPPHIRE)).
                criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).
                offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE_GATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BUTTON).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .input(ModItems.RUBY)
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_BUTTON)));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BUTTON)
                .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                .input(ModItems.SAPPHIRE)
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_AXE, 1).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                pattern("XX").
                pattern("XS").
                pattern(" S").
                input('X', ModItems.RUBY).
                input('S', Ingredient.ofItems(Items.STICK)).
                offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_HOE, 1).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                pattern("XX").
                pattern(" S").
                pattern(" S").
                input('X', ModItems.RUBY).
                input('S', Ingredient.ofItems(Items.STICK)).
                offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE, 1).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                pattern("XXX").
                pattern(" S ").
                pattern(" S ").
                input('X', ModItems.RUBY).
                input('S', Ingredient.ofItems(Items.STICK)).
                offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL, 1).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                pattern("X").
                pattern("S").
                pattern("S").
                input('X', ModItems.RUBY).
                input('S', Ingredient.ofItems(Items.STICK)).
                offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.RUBY_SWORD, 1).
                criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).
                pattern("X").
                pattern("X").
                pattern("S").
                input('X', ModItems.RUBY).
                input('S', Ingredient.ofItems(Items.STICK)).
                offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SWORD)));
    }
}
