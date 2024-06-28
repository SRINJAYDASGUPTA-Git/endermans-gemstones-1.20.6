package net.enderman.gemstones.item.custom;

import com.google.common.collect.ImmutableMap;
import net.enderman.gemstones.item.RubyArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(RubyArmorMaterial.INSTANCE.value(), new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 1, false, false, true)).build();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (!world.isClient ) {
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry: MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effect = entry.getValue();

            if(hasCorrectArmorOn(material, player)){
                addStatusEffectForMaterial(player, material, effect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial material, StatusEffectInstance effect) {
        boolean hasEffect = player.hasStatusEffect(effect.getEffectType());

        if(hasCorrectArmorOn(material, player) && !hasEffect) {
            player.addStatusEffect(new StatusEffectInstance(effect));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
       for(ItemStack armorStack: player.getInventory().armor){
           if(!(armorStack.getItem() instanceof ArmorItem)){
               return false;
           }
       }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return boots.getMaterial().value() == material && leggings.getMaterial().value() == material && chestplate.getMaterial().value() == material && helmet.getMaterial().value() == material;
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
