package net.enderman.gemstones.util;

import net.enderman.gemstones.EndermansGemstones;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> VALUABLE_DETECTOR_DETECTABLE_BLOCKS = createTag("valuable_detector_detectable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EndermansGemstones.MOD_ID, name));
        }
    }

    public static class Items {
        @SuppressWarnings("unused")
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(EndermansGemstones.MOD_ID, name));
        }
    }
}
