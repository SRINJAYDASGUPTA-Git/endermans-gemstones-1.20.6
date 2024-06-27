package net.enderman.gemstones.block;

import net.enderman.gemstones.EndermansGemstones;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK)));

    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(AbstractBlock.Settings.copy(Blocks.LAPIS_BLOCK)));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(2f)));

    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(4f)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(4f)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.NETHERRACK).strength(1.5f)));
    public static final Block ENDSTONE_RUBY_ORE = registerBlock("endstone_ruby_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 7),
                    AbstractBlock.Settings.copy(Blocks.END_STONE).strength(2.5f)));
    //Stairs and Slabs:
    //TODO: Implement the SLABS, STAIRS, BUTTON, PRESSURE PLATE, FENCE, FENCE GATE, WALL, DOOR and TRAPDOORS for Ruby and Sapphire
    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block RUBY_WALL = registerBlock("ruby_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));

    public static final Block SAPPHIRE_STAIRS = registerBlock("sapphire_stairs",
            new StairsBlock(ModBlocks.SAPPHIRE_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block SAPPHIRE_SLAB = registerBlock("sapphire_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block SAPPHIRE_BUTTON = registerBlock("sapphire_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block SAPPHIRE_FENCE = registerBlock("sapphire_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block SAPPHIRE_WALL = registerBlock("sapphire_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block SAPPHIRE_DOOR = registerBlock("sapphire_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

    public static final Block SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EndermansGemstones.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(EndermansGemstones.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        EndermansGemstones.LOGGER.info("Registering Mod Blocks for " + EndermansGemstones.MOD_ID);
    }
}
