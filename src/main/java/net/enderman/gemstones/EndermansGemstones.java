package net.enderman.gemstones;

import net.enderman.gemstones.block.ModBlocks;
import net.enderman.gemstones.item.ModItemGroups;
import net.enderman.gemstones.item.ModItems;
import net.enderman.gemstones.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndermansGemstones implements ModInitializer {
    public static final String MOD_ID = "gemstones";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerBlocks();

        ModLootTableModifiers.modifyLootTables();
        LOGGER.info("Hello Fabric world!");
    }
}