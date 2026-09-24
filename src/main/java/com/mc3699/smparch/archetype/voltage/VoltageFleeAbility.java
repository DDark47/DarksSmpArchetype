package com.mc3699.smparch.archetype.voltage;

import com.mc3699.smparch.SMPArch;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.GameType;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.registry.TBSSounds;

import java.util.List;

public class VoltageFleeAbility extends BaseAbility {
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
        return Component.literal("Voltage Flee");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/particle/eyes.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        ServerLevel level = player.serverLevel();
        
        level.playSound(null, player.blockPosition(), TBSSounds.TEXT_MADNESS_1.invoke(), SoundSource.PLAYERS, 3F, 1F);
        level.getEntitiesOfClass(ServerPlayer.class, player.getBoundingBox().inflate(20)).forEach(target -> {
            target.displayClientMessage(
                Component.literal("<✸>").withStyle(ChatFormatting.BOLD, ChatFormatting.BLACK), true
            );
            PlayerUtil.trySendOverlay(target,ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/screens/tbe_curious.png"),15L);
        });
        player.setGameMode(GameType.SPECTATOR);
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return !(player.gameMode.getGameModeForPlayer().equals(GameType.SPECTATOR));
    }
    
}
