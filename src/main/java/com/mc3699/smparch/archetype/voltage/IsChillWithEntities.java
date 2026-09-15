package com.mc3699.smparch.archetype.voltage;

import net.mc3699.provenance.ProvenanceDataHandler;
import net.mc3699.provenance.ability.foundation.AmbientAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class IsChillWithEntities extends AmbientAbility {
    @Override
    public void tick(ServerPlayer player) { }
    @Override
    public Component getName() {
        return Component.literal("Are YOU chill with entities?");
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return true;
    }
    public static boolean isChillWithEntities(Player player) {
        return ProvenanceDataHandler.getAmbientAbilities(player).stream().anyMatch(ability -> ability instanceof IsChillWithEntities);
    }
    
}
