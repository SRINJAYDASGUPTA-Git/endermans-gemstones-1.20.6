package net.enderman.gemstones.item;

import net.enderman.gemstones.EndermansGemstones;
import net.enderman.gemstones.item.custom.ValuableDetectorItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VALUABLE_DETECTOR = registerItem("valuable_detector",
            new ValuableDetectorItem(new Item.Settings().maxDamage(64).maxCount(1)));
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
    //public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings()));

    public static final Item ALEXANDRITE = registerItem("alexandrite", new Item(new Item.Settings()));

    public static final Item RUBY_STAFF = registerItem("ruby_staff", new Item(new Item.Settings().maxCount(1)));

//    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.RUBY, 2.0f, 2.0f))));
//    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.RUBY,3.0f, 2.0f))));
//    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.RUBY, 0f, 0f))));
//    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.RUBY, 0.0f, 0.0f))));
//    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.RUBY, 5, 2.0f))));

//    public static final Item RAW_ALEXANDRITE = registerItem("raw_alexandrite", new Item(new Item.Settings()));
//
//    public static final Item BENITOITE = registerItem("benitoite", new Item(new Item.Settings()));
//    public static final Item RAW_BENITOITE = registerItem("raw_benitoite", new Item(new Item.Settings()));
//
//    public static final Item CHAROITE = registerItem("charoite", new Item(new Item.Settings()));
//    public static final Item RAW_CHAROITE = registerItem("raw_charoite", new Item(new Item.Settings()));
//
//    public static final Item MOLDAVITE = registerItem("moldavite", new Item(new Item.Settings()));
//    public static final Item RAW_MOLDAVITE = registerItem("raw_moldavite", new Item(new Item.Settings()));
//
//    public static final Item PARAIBA_TOURMALINE = registerItem("paraiba_tourmaline", new Item(new Item.Settings()));
//    public static final Item RAW_PARAIBA_TOURMALINE = registerItem("raw_paraiba_tourmaline",
//            new Item(new Item.Settings()));
//
//    public static final Item OPAL = registerItem("opal", new Item(new Item.Settings()));
//    public static final Item RAW_OPAL = registerItem("raw_opal", new Item(new Item.Settings()));
//
//    public static final Item FIRE_OPAL = registerItem("fire_opal", new Item(new Item.Settings()));
//    public static final Item RAW_FIRE_OPAL = registerItem("raw_fire_opal", new Item(new Item.Settings()));
//
//    public static final Item IOLITE = registerItem("iolite", new Item(new Item.Settings()));
//    public static final Item RAW_IOLITE = registerItem("raw_iolite", new Item(new Item.Settings()));
//
//    public static final Item SPHENE = registerItem("sphene", new Item(new Item.Settings()));
//    public static final Item RAW_SPHENE = registerItem("raw_sphene", new Item(new Item.Settings()));
//
//    public static final Item DEMANTOID_GARNET = registerItem("demantoid_garnet", new Item(new Item.Settings()));
//    public static final Item RAW_DEMANTOID_GARNET = registerItem("raw_demantoid_garnet", new Item(new Item.Settings()));
//
//    public static final Item XENOCRYST_GEM = registerItem("xenocryst_gem", new Item(new Item.Settings()));
//    public static final Item RAW_XENOCRYST = registerItem("raw_xenocryst", new Item(new Item.Settings()));

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(SAPPHIRE);
        //entries.add(RAW_SAPPHIRE);
        entries.add(ALEXANDRITE);
//        entries.add(RAW_ALEXANDRITE);
//        entries.add(BENITOITE);
//        entries.add(RAW_BENITOITE);
//        entries.add(CHAROITE);
//        entries.add(RAW_CHAROITE);
//        entries.add(MOLDAVITE);
//        entries.add(RAW_MOLDAVITE);
//        entries.add(PARAIBA_TOURMALINE);
//        entries.add(RAW_PARAIBA_TOURMALINE);
//        entries.add(OPAL);
//        entries.add(RAW_OPAL);
//        entries.add(FIRE_OPAL);
//        entries.add(RAW_FIRE_OPAL);
//        entries.add(IOLITE);
//        entries.add(RAW_IOLITE);
//        entries.add(SPHENE);
//        entries.add(RAW_SPHENE);
//        entries.add(DEMANTOID_GARNET);
//        entries.add(RAW_DEMANTOID_GARNET);
//        entries.add(XENOCRYST_GEM);
//        entries.add(RAW_XENOCRYST);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EndermansGemstones.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EndermansGemstones.LOGGER.info("Registering Mod Items for " + EndermansGemstones.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
