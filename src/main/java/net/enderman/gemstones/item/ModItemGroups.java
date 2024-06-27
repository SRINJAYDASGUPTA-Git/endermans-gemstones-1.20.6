package net.enderman.gemstones.item;

import net.enderman.gemstones.EndermansGemstones;
import net.enderman.gemstones.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup GEMSTONE_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(EndermansGemstones.MOD_ID, "gemstone"),
            FabricItemGroup.
                    builder().
                    displayName(Text.translatable("itemgroup.gemstone"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        //Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.ALEXANDRITE);
                        entries.add(ModItems.VALUABLE_DETECTOR);
                        entries.add(ModItems.RUBY_STAFF);

//                        entries.add(ModItems.RUBY_PICKAXE);
//                        entries.add(ModItems.RUBY_AXE);
//                        entries.add(ModItems.RUBY_HOE);
//                        entries.add(ModItems.RUBY_SHOVEL);
//                        entries.add(ModItems.RUBY_SWORD);

                        //Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.ENDSTONE_RUBY_ORE);

                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_WALL);

                        entries.add(ModBlocks.SAPPHIRE_BUTTON);
                        entries.add(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
                        entries.add(ModBlocks.SAPPHIRE_DOOR);
                        entries.add(ModBlocks.SAPPHIRE_TRAPDOOR);
                        entries.add(ModBlocks.SAPPHIRE_FENCE);
                        entries.add(ModBlocks.SAPPHIRE_FENCE_GATE);
                        entries.add(ModBlocks.SAPPHIRE_STAIRS);
                        entries.add(ModBlocks.SAPPHIRE_SLAB);
                        entries.add(ModBlocks.SAPPHIRE_WALL);


                    }).build());

    public static void registerItemGroups() {
        EndermansGemstones.LOGGER.info("Registering Mod ItemGroups");

    }
}
