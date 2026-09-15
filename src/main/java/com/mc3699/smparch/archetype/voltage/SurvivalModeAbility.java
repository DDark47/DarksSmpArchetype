package com.mc3699.smparch.archetype.voltage;

import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;

public class SurvivalModeAbility extends BaseAbility {
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
        return Component.literal("Survival Mode");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("minecraft","textures/item/iron_sword.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        player.setGameMode(GameType.SURVIVAL);
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return !(player.gameMode.getGameModeForPlayer().equals(GameType.SURVIVAL));
    }
    
}
