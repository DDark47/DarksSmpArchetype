package com.mc3699.smparch.archetype.voltage;

import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class VoltageBaseAbility extends BaseAbility {
    @Override
    public float getUseCost() {
        return 0;
    }
    
    @Override
    public int getCooldown() {
        return 0;
    }
    
    @Override
    public Component getName() {
        return Component.literal("Voltage ");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("minecraft","textures/item/ender_eye.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return true;
    }
    
}
