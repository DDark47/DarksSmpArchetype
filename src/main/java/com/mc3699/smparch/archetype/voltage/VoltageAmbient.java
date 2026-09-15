package com.mc3699.smparch.archetype.voltage;

import kotlin.Unit;
import net.mc3699.provenance.ability.foundation.AmbientAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.api.ext.PlayerExt;

public class VoltageAmbient extends AmbientAbility {
    @Override
    public void tick(ServerPlayer player) {
        PlayerExt.INSTANCE.updateVars(player, (PlayerVariable) -> {
            PlayerVariable.setSkipFallDamage(true);
            return Unit.INSTANCE;
        });
        player.clearFire();
        player.setArrowCount(0);
    }
        @Override
    public Component getName() {
        return Component.literal("Voltage ambient stuff");
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return true;
    }
    
}
