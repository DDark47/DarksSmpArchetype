package com.mc3699.smparch.archetype.voltage;

import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;

public class SpectatorModeAbility extends BaseAbility {
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
        return Component.literal("Spectator Mode");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("minecraft","textures/item/ender_eye.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        player.setGameMode(GameType.SPECTATOR);
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return !(player.gameMode.getGameModeForPlayer().equals(GameType.SPECTATOR));
    }
    
}
