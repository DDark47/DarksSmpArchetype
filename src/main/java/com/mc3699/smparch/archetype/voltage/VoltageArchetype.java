package com.mc3699.smparch.archetype.voltage;

import com.mc3699.smparch.SMPArch;
import com.mc3699.smparch.registry.SMPAbilities;
import net.mc3699.provenance.ability.foundation.AmbientAbility;
import net.mc3699.provenance.archetype.foundation.BaseArchetype;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Set;

public class VoltageArchetype extends BaseArchetype {
    @Override
    public Component getName() {
        return Component.literal("Voltage");
    }
    
    @Override
    public List<Component> getDescription() {
        return List.of();
    }
    
    @Override
    public Set<ResourceLocation> getGrantedAbilities() {
        return Set.of(
            SMPArch.path("integrity_fireball"),
            SMPArch.path("voltage_jumpscare"),
            SMPArch.path("voltage_chase"),
            SMPArch.path("voltage_flee"),
            SMPArch.path("survival_mode"),
            SMPArch.path("spectator_mode")
        );
    }
    
    @Override
    public List<AmbientAbility> getAmbientAbilities() {
        return List.of(
            SMPAbilities.VOLTAGE_AMBIENT.get(),
            SMPAbilities.IS_CHILL_WITH_ENTITIES.get()
        );
    }
}