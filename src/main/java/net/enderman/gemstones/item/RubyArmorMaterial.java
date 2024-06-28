package net.enderman.gemstones.item;


import net.enderman.gemstones.EndermansGemstones;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class RubyArmorMaterial {
    public static final RegistryEntry<ArmorMaterial> INSTANCE;

    public RubyArmorMaterial() {
    }
    private static RegistryEntry<ArmorMaterial> register(EnumMap<ArmorItem.Type, Integer> defense, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier(EndermansGemstones.MOD_ID, "ruby")));
        return register("ruby", defense, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, new Identifier(EndermansGemstones.MOD_ID, id), new ArmorMaterial(enumMap, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, repairIngredient, layers, (float) 3.2, (float) 0.1));
    }
    static {

        INSTANCE = register(Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 6);
        }), () -> Ingredient.ofItems(ModItems.RUBY));
    }
}