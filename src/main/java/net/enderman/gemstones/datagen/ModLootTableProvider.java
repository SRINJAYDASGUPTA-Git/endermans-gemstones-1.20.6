package net.enderman.gemstones.datagen;

import net.enderman.gemstones.block.ModBlocks;
import net.enderman.gemstones.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE,
                copperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY, 3.0f, 6.0f));
        addDrop(ModBlocks.ENDSTONE_RUBY_ORE,
                copperLikeOreDrops(ModBlocks.ENDSTONE_RUBY_ORE, ModItems.RUBY, 3.0f, 7.0f));
        addDrop(ModBlocks.NETHER_RUBY_ORE, copperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY, 4.0f, 7.0f));

        addDrop(ModBlocks.SAPPHIRE_ORE, copperLikeOreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE,
                copperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.SAPPHIRE, 2.0f, 5.0f));

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_TRAPDOOR);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));

        addDrop(ModBlocks.SAPPHIRE_FENCE);
        addDrop(ModBlocks.SAPPHIRE_FENCE_GATE);
        addDrop(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        addDrop(ModBlocks.SAPPHIRE_BUTTON);
        addDrop(ModBlocks.SAPPHIRE_SLAB);
        addDrop(ModBlocks.SAPPHIRE_STAIRS);
        addDrop(ModBlocks.SAPPHIRE_WALL);
        addDrop(ModBlocks.SAPPHIRE_TRAPDOOR);

        addDrop(ModBlocks.SAPPHIRE_DOOR, doorDrops(ModBlocks.SAPPHIRE_DOOR));
        addDrop(ModBlocks.SAPPHIRE_SLAB, slabDrops(ModBlocks.SAPPHIRE_SLAB));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
